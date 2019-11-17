package net.oktaliem.gauge;

import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;
import net.oktaliem.utils.driver.Driver;
import org.openqa.selenium.By;
import org.zaproxy.clientapi.core.Alert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static net.oktaliem.Path.LOGOUT_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PageActions extends Driver {

    public PageActions() {
        super();
    }

    public void clickOn(By el) {
        driver.findElement(el).click();
        log.info("User clicks On Element: " + el);
    }

    public void inputTextBox(By el, String value) {
        driver.findElement(el).sendKeys(value);
        log.info("User inputs field with element: " + el + " and value " + value);
    }


    public void wait(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("User waits for " + milisecond + " milliseconds");
    }

    public void spiderWithZAP(String targetURL) {
        zapSetSetUp();
        log.info("Spidering Odoo...");
        zapSpider.excludeFromSpider(LOGOUT_URL);
        zapSpider.setThreadCount(5);
        zapSpider.setMaxDepth(5);
        zapSpider.setPostForms(false);
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

    private void zapSetSetUp(){
        zapScanner = new ZAProxyScanner(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
        zapScanner.clear(); //Start a new session
        zapSpider = (Spider) zapScanner;
        log.info("Created client to ZAP API");
    }

    public void setAlertAttackStrength(){
        for (String policyName : policyNames) {
            String ids = enableZapPolicy(policyName);
            for (String id : ids.split(",")) {
                zapScanner.setScannerAlertThreshold(id, MEDIUM);
                zapScanner.setScannerAttackStrength(id, HIGH);
            }
        }
        log.info("Set Alert and Attack Strength");
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

    protected void setEnablePassiveScanner(boolean status){
        zapScanner.setEnablePassiveScan(status);
        log.info("Set Enable Passive Scanner ");
    }

    protected void scanAppWithZAP(String url){
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


    public List<Alert> filterAlerts(List<Alert> alerts) {
        List<Alert> filtered = new ArrayList<Alert>();
        for (Alert alert : alerts) {
            if (alert.getRisk().equals(Alert.Risk.High) && alert.getConfidence() != Alert.Confidence.Low)
                filtered.add(alert);
        }
        return filtered;
    }

    public void logAlerts(List<Alert> alerts) {
        for (Alert alert : alerts) {
            log.info("Alert: " + alert.getAlert() + " at URL: " + alert.getUrl() + " Parameter: " + alert.getParam() + " CWE ID: " + alert.getCweId());
        }
    }


    protected  void removeFalsePositive(){
        List<Alert> alerts = filterAlerts(zapScanner.getAlerts());
        logAlerts(alerts);
        assertThat(alerts.size(), equalTo(0));
        log.info("Remove false positive");
    }


    protected void generateHTMLReport(String fileName) throws IOException {
        byte[] html = zapScanner.getHtmlReport();
        Path pathToFile = Paths.get(System.getProperty("user.dir"));
        Files.createDirectories(Paths.get(pathToFile + "/target/html"));
        Files.write(Paths.get(pathToFile + "/target/html/" + fileName), html);
        log.info("Generate HTML Report");
    }

}
