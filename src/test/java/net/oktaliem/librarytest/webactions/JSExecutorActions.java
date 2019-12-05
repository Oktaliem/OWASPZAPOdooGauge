package net.oktaliem.librarytest.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface JSExecutorActions {

    void clickViaJavascriptExecutor(WebElement element);
    void scrollToBottomPage();
    void scrollToTopPage();
    void scrollUntilViewElement(By el);
    void scrollUntilViewElement(WebElement element);
    void refreshPageViaJavaScriptExecutor();
    void handleJavascriptPopUp(String info);
    void openNewTab();
    Object executeJavascript(String javascript);

}
