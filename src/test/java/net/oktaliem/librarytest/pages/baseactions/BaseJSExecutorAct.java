package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.JSExecutorActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public class BaseJSExecutorAct extends BaseMouseKeyboardAct implements JSExecutorActions {

    public BaseJSExecutorAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
        log.info("Open New Tab");
    }

    @Override
    public void handleJavascriptPopUp(String info) {
        try {
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
            if (alert.getText().equals(info)) {
                alert.accept();
            } else {
                alert.dismiss();
            }
        } catch (Exception e) {
//            ((JavascriptExecutor) driver).executeScript("window.confirm = function() { return true; }");
//            ((JavascriptExecutor) driver).executeScript("window.alert = function() { return true; }");
//            ((JavascriptExecutor) driver).executeScript("window.prompt = function() { return true; }");
        }
        log.info("accepting javascript Pop Up");
    }


    @Override
    public void scrollToBottomPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "window.scrollTo(0,document.body.scrollHeight);";
        jsExecutor.executeScript(query);
        log.info("Scroll to the buttom page");
    }

    @Override
    public void scrollToTopPage() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "window.scrollTo(0,-document.body.scrollHeight);";
        jsExecutor.executeScript(query);
        log.info("Scroll to the top page");
    }

    @Override
    public void scrollUntilViewElement(By el) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(el);
        String query = "arguments[0].scrollIntoView(true);";
        jsExecutor.executeScript(query, element);
        log.info("Scroll until element: " + element + " is displayed");
    }

    @Override
    public void scrollUntilViewElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String query = "arguments[0].scrollIntoView(true);";
        jsExecutor.executeScript(query, element);
        log.info("Scroll until element: " + element + " is displayed");
    }

    @Override
    public void refreshPageViaJavaScriptExecutor() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("history.go(0)");
        //or
        jsExecutor.executeScript("location.reload();");
        log.info("refresh Page Via JavaScriptExecutor");
    }

    @Override
    public Object executeJavascript(String javascript) {
        log.info("execute javascript: " + javascript);
        return ((JavascriptExecutor) driver).executeScript(javascript);
    }

    @Override
    public void clickViaJavascriptExecutor(WebElement element) {
        log.warn("Element is not clickable, try to click with Javascript");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        log.info("click on " + element + " via javascript succeed");
    }


}
