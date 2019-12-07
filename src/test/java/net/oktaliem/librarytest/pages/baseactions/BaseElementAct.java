package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;

import java.util.List;

/**
 * Author : Okta Liem
 */
public class BaseElementAct extends BaseJSExecutorAct implements ElementActions {

    public BaseElementAct(WebDriver driver) {
        super(driver);
    }

    /**
     * Pure Page Object for Page Actions
     */

    @Override
    public void clickOn(By el) {
        WebElement element = driver.findElement(el);
        if (element.isDisplayed()) {
            try {
                element.click();
                log.info("User clicks On Element: " + element);
            } catch (ElementClickInterceptedException e) {
                clickViaJavascriptExecutor(element);
            }
        } else {
            log.info(element + " is not displayed");
        }
    }

    @Override
    public void inputTextBox(By el, String value) {
        WebElement element = driver.findElement(el);
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(value);
            log.info("User inputs field with element: " + el + " and value " + value);
        } else {
            log.info(element + " is not displayed");
        }
    }

    @Override
    public String getTextFromElement(By el) {
        String text = driver.findElement(el).getText();
        log.info("Get Text with value: " + text);
        return text;
    }


    @Override
    public void selectOnDropDownListByText(By el, String text) {
        try {
            WebElement element = driver.findElement(el);
            Select select = new Select(element);
            select.selectByVisibleText(text);
            log.info("Select Drop down List Element by visible text : " + element);
        } catch (UnexpectedTagNameException e) {
            List<WebElement> elements = driver.findElements(el);
            for (WebElement element : elements) {
                if (element.getText().trim().equals(text.trim())) {
                    clickOn(element);
                    log.info("Select Drop down List Element by visible text : " + text);
                    break;
                }
            }
        }
    }

    @Override
    public void selectOnDropDownListByValue(By el, String value) {
        WebElement element = driver.findElement(el);
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    @Override
    public void selectOnRadioButtonByText(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getText().equals(text)) {
                clickOn(element);
                log.info("Select radio button by text: " + text);
                break;
            }
        }
    }

    @Override
    public void selectOnRadioButtonByValue(By els, String text) {
        for (WebElement element : driver.findElements(els)) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by value: " + text);
                break;
            }
        }
    }

    @Override
    public void selectCheckBox(By el, String status, int index) {
        WebElement element = driver.findElements(el).get(index);
        if (status.equals("n")) {
            if (element.isSelected()) {
                clickOn(element);
            } else {
                log.info("check box is disabled by default");
            }
        }
        if (status.equals("y")) {
            if (element.isSelected()) {
                log.info("check box is already enabled");
            } else {
                clickOn(element);
            }
        }
    }

    @Override
    public void uploadFile(By el, String fileName) {
        WebElement element = driver.findElement(el);
        element.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        log.info("Choose file name: " + fileName);
    }


    /**
     * Page Factory for Page Actions
     */
    @Override
    public void clickOn(WebElement element) {
        if (element.isDisplayed()) {
            try {
                element.click();
                log.info("User clicks On Element: " + element);
            } catch (ElementClickInterceptedException e) {
                clickViaJavascriptExecutor(element);
            }
        } else {
            log.info(element + " is not displayed");
        }
    }

    @Override
    public void inputTextBox(WebElement element, String value) {
        if (element.isDisplayed()) {
            element.clear();
            element.sendKeys(value);
            log.info("User inputs field with element: " + element + " and value " + value);
        } else {
            log.info(element + " is not displayed");
        }
    }

    @Override
    public String getTextFromElement(WebElement element) {
        String text = element.getText();
        log.info("Get Text with value: " + text);
        return text;

    }

    @Override
    public void selectOnDropDownListByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    @Override
    public void selectOnDropDownListByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getText().trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select Drop down List Element by visible text : " + text);
                break;
            }
        }
    }

    @Override
    public void selectOnDropDownListByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
        log.info("Select Drop down List Element by visible text : " + element);
    }

    @Override
    public void selectOnRadioButtonByText(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            System.out.println("Text: "+ element.getText());
            if (element.getText().trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by text: " + text);
                break;
            }
        }
    }

    @Override
    public void selectOnRadioButtonByValue(List<WebElement> elements, String text) {
        for (WebElement element : elements) {
            if (element.getAttribute("value").trim().equals(text.trim())) {
                clickOn(element);
                log.info("Select radio button by value: " + text);
                break;
            }
        }
    }

    @Override
    public void selectCheckBox(WebElement element, String status) {
        if (status.equals("n")) {
            if (element.isSelected()) {
                clickOn(element);
            } else {
                log.info("check box is disabled by default");
            }
        }
        if (status.equals("y")) {
            if (element.isSelected()) {
                log.info("check box is already enabled");
            } else {
                clickOn(element);
            }
        }
    }

    @Override
    public void uploadFile(WebElement element, String fileName) {
        element.sendKeys(System.getProperty("user.dir") + "/src/main/resources/" + fileName);
        log.info("Choose file name: " + fileName);
    }


}
