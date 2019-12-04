package net.oktaliem.librarytest.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface VerificationActions {

    /** Verification - Page Factory **/
    void checkIfTextIsExpected(WebElement element, String expected);


    /** Verification - Page Object **/
    void checkIfTextIsExpected(By el, String expected);
}
