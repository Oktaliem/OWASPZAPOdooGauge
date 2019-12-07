package net.oktaliem.librarytest.pages.webactions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Author : Okta Liem
 */
public interface GeneralActions {

    void refreshPage();
    void goToPreviousPage();
    void goToNextPage();
    void getHtmlSource(String fileName) throws IOException;
    void switchToSecondBrowser();
    void switchToFirstBrowser();
    String getValueWithRegex(String regex, String text);
    String getCurrentURL();
    String readFile(String filePath) throws IOException;
    void goToWeb(String url);
    void switchToIframeByIndex(int index);
    void switchToIframeByIdOrName(WebElement element);
    void switchIframeToDefaultContent();
    void switchIframeToParentFrame();
    void performKeyboardAction(Keys tab);
    void performKeyboardInputAction(String text);
}
