package net.oktaliem.utils.driver;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import net.continuumsecurity.proxy.ScanningProxy;
import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;
import net.oktaliem.OdooERPSteps;
import net.oktaliem.OdooScanTest;
import net.oktaliem.web.drivers.DriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

public class Driver {

    public static final String ZAP_PROXYHOST = "localhost";
    public static final int ZAP_PROXYPORT = 8089;
    public static final String ZAP_APIKEY = null;
    public static final String MEDIUM = "MEDIUM";
    public static final String HIGH = "HIGH";
    public ScanningProxy zapScanner;
    public Spider zapSpider;
    public OdooERPSteps odoo;
    public int currentScanID;
    public static final String CHROME_DRIVER_PATH = "drivers/chromedriver-mac";
    public static Logger log = Logger.getLogger("GAUGE");

    public static WebDriver driver;

    // Initialize a webDriver instance of required browser
    // Since this does not have a significance in the application's business domain, the BeforeSuite hook is used to instantiate the webDriver
    @BeforeSuite
    public void initializeDriver(){
        //driver = DriverFactory.getDriver();
        driver = DriverFactory.createProxyDriver("chrome", createZapProxyConfigurationForWebDriver(), CHROME_DRIVER_PATH);
    }

    // Close the webDriver instance
    @AfterSuite
    public void closeDriver(){
        driver.quit();
    }


    public static Proxy createZapProxyConfigurationForWebDriver() {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
        proxy.setSslProxy(ZAP_PROXYHOST + ":" + ZAP_PROXYPORT);
        return proxy;
    }

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



}
