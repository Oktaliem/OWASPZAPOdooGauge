package net.oktaliem;

import edu.umass.cs.benchlab.har.HarRequest;
import net.continuumsecurity.proxy.ScanningProxy;
import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;
import net.oktaliem.web.drivers.DriverFactory;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.zaproxy.clientapi.core.Alert;

import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import static net.oktaliem.Path.LOGOUT_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ZapScannerBase {

    public static Logger log = Logger.getLogger(OdooScanTest.class.getName());
    public static final String ZAP_PROXYHOST = "localhost";
    public static final int ZAP_PROXYPORT = 8089;
    public static final String ZAP_APIKEY = null;


    public static final String CHROME_DRIVER_PATH = "drivers/chromedriver-mac"; // depends on your OS
    public static final String MEDIUM = "MEDIUM";
    public static final String HIGH = "HIGH";
    public ScanningProxy zapScanner;
    public Spider zapSpider;
    public WebDriver driver;
    public OdooERPSteps odoo;
    public int currentScanID;

    public static final String[] policyNames = {
            "directory-browsing",
            "cross-site-scripting",
            "sql-injection",
            "path-traversal",
            "remote-file-inclusion",
            "server-side-include",
            "script-active-scan-rules",
//                "server-side-code-injection",
            "remote-os-command-injection",
            "external-redirect",
            "crlf-injection",
//                "source-code-disclosure",
//                "shell-shock",
//                "remote-code-execution",
//                "dap-injection",
//                "xpath-injection",
//                "padding-oracle",
//                "el-injection",
//                "insecure-http-methods",
//                "parameter-pollution"
    };

    @BeforeMethod
    public void setup() {
        zapScanner = new ZAProxyScanner(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
        zapScanner.clear(); //Start a new session
        zapSpider = (Spider) zapScanner;
        log.info("Created client to ZAP API");
        driver = DriverFactory.createProxyDriver("chrome", createZapProxyConfigurationForWebDriver(), CHROME_DRIVER_PATH);
        odoo = new OdooERPSteps(driver);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }


    public void logAlerts(List<Alert> alerts) {
        for (Alert alert : alerts) {
            log.info("Alert: " + alert.getAlert() + " at URL: " + alert.getUrl() + " Parameter: " + alert.getParam() + " CWE ID: " + alert.getCweId());
        }
    }

    /*
        Remove false positives, filter based on risk and reliability
     */
    public List<Alert> filterAlerts(List<Alert> alerts) {
        List<Alert> filtered = new ArrayList<Alert>();
        for (Alert alert : alerts) {
            if (alert.getRisk().equals(Alert.Risk.High) && alert.getConfidence() != Alert.Confidence.Low)
                filtered.add(alert);
        }
        return filtered;
    }

    public void setAlertAndAttackStrength() {
        for (String policyName : policyNames) {
            String ids = enableZapPolicy(policyName);
            for (String id : ids.split(",")) {
                zapScanner.setScannerAlertThreshold(id, MEDIUM);
                zapScanner.setScannerAttackStrength(id, HIGH);
            }
        }
    }

    public void scanOdooWithZap(String url) {
        log.info("Scanning..." + url);
        zapScanner.scan(url);
        currentScanID = zapScanner.getLastScannerScanId();
        int complete = 0;
        while (complete < 100) {
            complete = zapScanner.getScanProgress(currentScanID);
            log.info("Scan is " + complete + "% complete.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Scanning done.");
    }

    public String enableZapPolicy(String policyName) {
        String scannerIds = null;
        switch (policyName.toLowerCase()) {
            case "directory-browsing":
                scannerIds = "0";
                break;
            case "cross-site-scripting":
                scannerIds = "40012,40014,40016,40017";
                break;
            case "sql-injection":
                scannerIds = "40018";
                break;
            case "path-traversal":
                scannerIds = "6";
                break;
            case "remote-file-inclusion":
                scannerIds = "7";
                break;
            case "server-side-include":
                scannerIds = "40009";
                break;
            case "script-active-scan-rules":
                scannerIds = "50000";
                break;
            case "server-side-code-injection":
                scannerIds = "90019";
                break;
            case "remote-os-command-injection":
                scannerIds = "90020";
                break;
            case "external-redirect":
                scannerIds = "20019";
                break;
            case "crlf-injection":
                scannerIds = "40003";
                break;
            case "source-code-disclosure":
                scannerIds = "42,10045,20017";
                break;
            case "shell-shock":
                scannerIds = "10048";
                break;
            case "remote-code-execution":
                scannerIds = "20018";
                break;
            case "ldap-injection":
                scannerIds = "40015";
                break;
            case "xpath-injection":
                scannerIds = "90021";
                break;
            case "xml-external-entity":
                scannerIds = "90023";
                break;
            case "padding-oracle":
                scannerIds = "90024";
                break;
            case "el-injection":
                scannerIds = "90025";
                break;
            case "insecure-http-methods":
                scannerIds = "90028";
                break;
            case "parameter-pollution":
                scannerIds = "20014";
                break;
            default:
                throw new RuntimeException("No policy found for: " + policyName);
        }
        if (scannerIds == null) throw new RuntimeException("No matching policy found for: " + policyName);
        zapScanner.setEnableScanners(scannerIds, true);
        return scannerIds;
    }

    public static Proxy createZapProxyConfigurationForWebDriver() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
        proxy.setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
        return proxy;
    }

    public void spiderOdooWithZap(String targetURL) {
        log.info("Spidering Odoo..." + targetURL);
        zapSpider.excludeFromSpider(LOGOUT_URL);
        zapSpider.setThreadCount(5); //default 5
        zapSpider.setMaxDepth(5); //default 5
        zapSpider.setPostForms(false); //default false
        zapSpider.spider(targetURL);
        int spiderID = zapSpider.getLastSpiderScanId();
        int complete = 0;
        while (complete < 100) {
            complete = zapSpider.getSpiderProgress(spiderID);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (String url : zapSpider.getSpiderResults(spiderID)) {
            log.info("Found URL: " + url);
        }
        log.info("Spider Odoo done.....");
    }


    public void writeHtmlReport(String fileName) throws IOException {
        byte[] html = zapScanner.getHtmlReport();
        Path pathToFile = Paths.get(System.getProperty("user.dir"));
        Files.createDirectories(Paths.get(pathToFile + "/target/html"));
        Files.write(Paths.get(pathToFile + "/target/html/" + fileName), html);
        log.info("HTML report is created");

    }

    public void removeFalsePositive() {
        List<Alert> alerts = filterAlerts(zapScanner.getAlerts());
        logAlerts(alerts);
        assertThat(alerts.size(), equalTo(0));
    }

    public void allZAPSpiderMethods(){
        zapSpider.spider(""); //used
        zapSpider.setThreadCount(1); //used
        zapSpider.setPostForms(true); //used
        zapSpider.setMaxDepth(2); //used
        zapSpider.getSpiderResults(1); //used
        zapSpider.getSpiderProgress(1); //used
        zapSpider.getLastSpiderScanId(); //used
        zapSpider.excludeFromSpider(""); //used
    }

    public void allZAPScannerMethods() throws UnknownHostException {
        zapScanner.setEnablePassiveScan(true);//used
        zapScanner.shutdown();
        zapScanner.setScannerAttackStrength("","");//used
        zapScanner.setScannerAlertThreshold("","");//used
        zapScanner.setEnableScanners("",true); //used
        zapScanner.getXmlReport();
        zapScanner.getScanProgress(2); //used
        zapScanner.getLastScannerScanId(); //used
        zapScanner.getAlerts(); //used
        zapScanner.getAlerts(1,1);
        zapScanner.getAlertsCount();
        zapScanner.getHtmlReport(); //used
        zapScanner.excludeFromScanner("");
        zapScanner.enableAllScanners();
        zapScanner.disableAllScanners();
        zapScanner.deleteAlerts();
        zapScanner.scan(""); //used
        zapScanner.clear();//used
        zapScanner.setEnableScanners("",true);//used
        zapScanner.findInRequestHistory("");
        zapScanner.findInResponseHistory("");
        zapScanner.getHistory();
        zapScanner.getHistoryCount();
        zapScanner.getSeleniumProxy();
        //zapScanner.makeRequest(HarRequest,true)
    }


}
