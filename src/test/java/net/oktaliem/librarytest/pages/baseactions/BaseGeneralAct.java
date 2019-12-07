package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.GeneralActions;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Author : Okta Liem
 */
public class BaseGeneralAct implements GeneralActions {

    public WebDriver driver;
    public static Logger log = Logger.getLogger("Library Test");


    public BaseGeneralAct (WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void refreshPage() {
        driver.navigate().refresh();
        log.info("Refresh Page");
    }

    @Override
    public void goToPreviousPage() {
        driver.navigate().back();
        log.info("Back to previous page");
    }

    @Override
    public void goToNextPage() {
        driver.navigate().forward();
        log.info("Go to next page");
    }

    @Override
    public void getHtmlSource(String fileName) throws IOException {
        String getActualFile = driver.getPageSource();
        File DestFile = new File(System.getProperty("user.dir") + "/src/main/resources/actualhtmltext/"
                + fileName + ".txt");
        FileUtils.writeStringToFile(DestFile, getActualFile);
        log.info("Get HTML resource succeed");
    }

    @Override
    public void switchToSecondBrowser() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Go to second tab");
    }

    @Override
    public void switchToFirstBrowser() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        log.info("Go to first tab");
    }

    @Override
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

    @Override
    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        log.info("Current URL is " + url);
        return driver.getCurrentUrl();
    }

    @Override
    public String readFile(String filePath) throws IOException {
        log.info("Read File from: " + filePath);
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }

    @Override
    public void goToWeb(String url) {
        driver.get(url);
        log.info("Landing to Login Page: " + url);
    }

    @Override
    public void switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        log.info("Switch to iframe by index: " + index);
    }

    @Override
    public void switchToIframeByIdOrName(WebElement element) {
        driver.switchTo().frame(element);
        log.info("Switch to iframe by id or name: " + element);
    }

    @Override
    public void switchIframeToDefaultContent() {
        driver.switchTo().defaultContent();
        log.info("Switch to default content - Back to main Page");
    }

    @Override
    public void switchIframeToParentFrame() {
        driver.switchTo().parentFrame();
        log.info("Switch to parent frame");
    }

    @Override
    public void performKeyboardAction(Keys key) {
        Actions builder = new Actions(driver);
        builder.sendKeys(key).build().perform();
        builder.release().perform();
        log.info("Keyboard Action: "+ key);
    }

    @Override
    public void performKeyboardInputAction(String text) {
        Actions builder = new Actions(driver);
        builder.sendKeys(text).build().perform();
        builder.release().perform();
        log.info("Keyboard Input Action: "+ text);
    }

}
