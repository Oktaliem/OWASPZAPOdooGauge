package net.oktaliem.librarytest;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasePage {
    public WebDriver driver ;
    public static Logger log = Logger.getLogger("Library Test");

    public BasePage(WebDriver driver){
        this.driver = driver;
    }


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
     * Verification - Page Factory
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
        log.info("Text is expected: "+ expected);
    }

    /**
     * Verification - Page Object
     */

    public void checkIfTextIsExpected(By el, String expected) {
        Assert.assertEquals(driver.findElement(el).getText(), expected);
        log.info("Text is expected: "+ expected);
    }


    /**
     * Wait actions
     */

    public void wait(int milisecond) {
        try {
            TimeUnit.MILLISECONDS.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("User waits for " + milisecond + " milliseconds");
    }

//    public void waitForElementActionable(WebElement element, int time) {
//        WebDriverWait wait = new WebDriverWait(driver, time);
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

}
