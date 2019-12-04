package net.oktaliem.librarytest.webactions;

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
    void uploadFile(WebElement element, String fileName);
    String getCurrentURL();
    String readFile(String filePath) throws IOException;
    void goToWeb(String url);

}
