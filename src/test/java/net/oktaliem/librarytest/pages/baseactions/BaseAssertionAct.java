package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.AssertionActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Author : Okta Liem
 */
public class BaseAssertionAct extends BaseGeneralAct implements AssertionActions {

    public BaseAssertionAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void checkIfTextIsExpected(WebElement element, String expected) {
        Assert.assertEquals(element.getText(), expected);
        log.info("Text is expected: " + expected);
    }

    @Override
    public void checkIfTextIsExpected(By el, String expected) {
        Assert.assertEquals(driver.findElement(el).getText(), expected);
        log.info("Text is expected: " + expected);
    }
}
