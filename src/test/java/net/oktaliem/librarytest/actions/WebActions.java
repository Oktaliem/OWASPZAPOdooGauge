package net.oktaliem.librarytest.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public interface WebActions {
    // Below is the list of webActions Keywords:
    // Inspired by Katalon Studio https://docs.katalon.com/katalon-studio/docs/webui-click.html#description

    /** Web Action - Page Object **/
    void clickOnWebButton(By el);
    void inputTextBox(By el, String value);
    String getTextFromElement(By el);
    void selectOnDropDownListByText(By el, String text);
    void selectOnDropDownListByValue(By el, String value);
    void selectOnRadioButtonByText(By els, String text);
    void selectOnRadioButtonByValue(By els, String text);
    void selectCheckBox(By el, String status);

    /** Web Action - Page Factory **/
    void clickOnWebButton(WebElement element);
    void inputTextBox(WebElement element, String value);
    String getTextFromElement(WebElement element);
    void selectOnDropDownListByText(WebElement element, String text);
    void selectOnDropDownListByText(List<WebElement> elements, String text);
    void selectOnDropDownListByValue(WebElement element, String value);
    void selectOnRadioButtonByText(List<WebElement> elements, String text);
    void selectOnRadioButtonByValue(List<WebElement> elements, String text);
    void selectCheckBox(WebElement element, String status);

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);


    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);

    /** Web Action - Wait **/
    void wait(int miliseconds);

    /** General Actions **/
    void refreshPage();
    void goBack();
    void goForward();
    void getHtmlSource(String fileName) throws IOException;
    void clickViaJavascriptExecutor(WebElement el);
    void openNewTab();
    void switchToSecondBrowser();
    void switchToFirstBrowser();
    String getValueWithRegex(String regex, String text);
    void uploadFile(WebElement element, String fileName);
    String getCurrentURL();
    void handleJavascriptPopUp(String info);
}
