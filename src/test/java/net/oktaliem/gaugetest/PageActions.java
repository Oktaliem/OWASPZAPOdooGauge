/**
 * @Author Okta Liem
 */
package net.oktaliem.gaugetest;

import net.continuumsecurity.proxy.Spider;
import net.continuumsecurity.proxy.ZAProxyScanner;
import net.oktaliem.utils.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.zaproxy.clientapi.core.Alert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static net.oktaliem.Path.LOGOUT_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class PageActions extends Driver {

    /**
     * UI Elements consist of
     * - Button -> clickOn
     * - TextBox -> inputTextBox
     * - Drop Down List -> selectDropDownListByText, selectOnDropDownListByValue
     * - Radio Button -> selectRadioButtonByText,selectRadioButtonByValue
     * - Check Box -> selectCheckBox
     * - Text -> getTextFromElement
     */

    /**
     * Verification consist of
     *  - checkIfElementIsVisible
     *  - checkIfTextIsExpected
     */

    /**
     * Wait consist of
     * - Wait
     * - waitForElementActionable
     */

    /**
     * General Actions consist of
     * - refreshPage
     * - goBack
     * - goForward
     * - getHtmlSource
     * - clickViaJavascript
     * - openNewTab
     * - switchToSecondBrowserTab
     * - switchToFirstBrowserTab
     * - getValueWithRegex
     * - uploadFile
     * - getCurrentURL
     * - handleJavascriptPopUp
     */


    public PageActions() {
        super();
    }

    /**
     * Pure Page Object for Page Actions
     */

    public void clickOn(By el) {
        driver.findElement(el).click();
        log.info("User clicks On Element: " + el);
    }

    public void inputTextBox(By el, String value) {
        driver.findElement(el).sendKeys(value);
        log.info("User inputs field with element: " + el + " and value " + value);
    }

    public String getTextFromElement(By el) {
        String text = driver.findElement(el).getText();
        log.info("Get Text with value: " + text);
        return text;

    }

    public void selectOnDropDownListByText(By el, String text) {
        WebElement element = driver.findElement(el);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    public void selectOnDropDownListByValue(By el, String value) {
        WebElement element = driver.findElement(el);
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element);
    }


    public void selectOnRadioButtonByText(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getText().equals(text)) {
                element.click();
                log.info("Select radio button by text: " + text);
                break;
            }
        }
    }

    public void selectOnRadioButtonByValue(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                element.click();
                log.info("Select radio button by value: " + text);
                break;
            }
        }
    }

    public void selectCheckBox(By el, String status) {
        WebElement element = driver.findElement(el);
        if (status.equals("n")) {
            if (element.isSelected()) {
                element.click();
            } else {
                log.info("check box is disabled by default");
            }
        }
        if (status.equals("y")) {
            if (element.isSelected()) {
                log.info("check box is already enabled");
            } else {
                element.click();
            }
        }
    }



    /**
     * Page Factory for Page Actions
     */

    public void clickOn(WebElement element) {
        element.click();
        log.info("User clicks On Element: " + element);
    }

    public void inputTextBox(WebElement element, String value) {
        element.sendKeys(value);
        log.info("User inputs field with element: " + element + " and value " + value);
    }

    public String getTextFromElement(WebElement element) {
        String text = element.getText();
        log.info("Get Text with value: " + text);
        return text;

    }

    public void selectOnDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    public void selectOnDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    public void selectOnRadioButtonByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().trim().equals(text.trim())) {
                element.click();
                log.info("Select radio button by text: " + text);
                break;
            }
        }
    }

    public void selectOnRadioButtonByValue(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                element.click();
                log.info("Select radio button by value: " + text);
                break;
            }
        }
    }

    public void selectCheckBox(WebElement element, String status) {
        if (status.equals("n")) {
            if (element.isSelected()) {
                element.click();
            } else {
                log.info("check box is disabled by default");
            }
        }
        if (status.equals("y")) {
            if (element.isSelected()) {
                log.info("check box is already enabled");
            } else {
                element.click();
            }
        }
    }


    /**
     * Verification
     */

//    public boolean checkIfElementIsVisible(WebElement element, int inSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    public void checkIfTextIsExpected(WebElement element, String expected) {
        Assert.assertEquals(element.getText(), expected);
        log.info("Text is expected");
    }


    /**
     * Wait actions
     */

    public void waitInMilSec(int milisecond) {
        try {
            //Thread.sleep(milisecond);
            TimeUnit.MILLISECONDS.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("User waits for " + milisecond + " milliseconds");
    }

//    public void waitForElementActionable(WebElement element, int time) {
//        WebDriverWait wait = new WebDriverWait(driver, time);
//        //wait.until(ExpectedConditions.visibilityOf(element));
//        wait.until(ExpectedConditions.or(
//                ExpectedConditions.visibilityOf(element),
//                ExpectedConditions.elementToBeClickable(element),
//                ExpectedConditions.presenceOfElementLocated((By) element),
//                ExpectedConditions.elementToBeSelected(element)));
//    }


    /**
     * General Actions
     */

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void getHtmlSource(String fileName) throws IOException {
        String getActualFile = driver.getPageSource();
        File DestFile = new File(System.getProperty("user.dir") + "/src/main/resources/actualhtmltext/"
                + fileName + ".txt");
        FileUtils.writeStringToFile(DestFile, getActualFile);
        log.info("Get HTML resource succeed");
    }

    public void clickViaJavascript(WebElement el) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", el);
        log.info("click on " + el + " via javascript");
    }

    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        log.info("Open New Tab");
    }

    public void switchToSecondBrowserTab() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Go to second tab");
    }

    public void switchToFirstBrowserTab() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        log.info("Go to first tab");
    }

    public String getValueWithRegex(String regex, String text) {
        String regexPattern = regex;
        Pattern p = Pattern.compile(regexPattern);
        Matcher m = p.matcher(text);
        String validationCode = "";
        if (m.find()) {
            validationCode = m.group(0).trim();
        }
        log.info("Get Value with Regex " + regex + " and result: " + validationCode);
        return validationCode;
    }

    public void uploadFile(WebElement element, String fileName) {
        element.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        log.info("Choose file name: " + fileName);
    }

    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        log.info("Current URL is " + url);
        return url;
    }

    public void handleJavascriptPopUp(String info) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            if (alert.getText().equals(info)) {
                alert.accept();
            } else {
                alert.dismiss();
            }
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("window.confirm = function() { return true; }");
            ((JavascriptExecutor) driver).executeScript("window.alert = function() { return true; }");
            ((JavascriptExecutor) driver).executeScript("window.prompt = function() { return true; }");
        }
        log.info("accepting javascript Pop Up");

    }


    /**
     * OWASP ZAP Actions
     */


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

    private void zapSetSetUp() {
        zapScanner = new ZAProxyScanner(ZAP_PROXYHOST, ZAP_PROXYPORT, ZAP_APIKEY);
        zapScanner.clear(); //Start a new session
        zapSpider = (Spider) zapScanner;
        log.info("Created client to ZAP API");
    }

    public void setAlertAttackStrength() {
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

    protected void setEnablePassiveScanner(boolean status) {
        zapScanner.setEnablePassiveScan(status);
        log.info("Set Enable Passive Scanner ");
    }

    protected void scanAppWithZAP(String url) {
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


    protected void removeFalsePositive() {
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
