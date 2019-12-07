package net.oktaliem.librarytest.pages.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface AssertionActions {

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);


    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
}
