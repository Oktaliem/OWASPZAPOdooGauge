package net.oktaliem.librarytest.webactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Author : Okta Liem
 */
public interface MouseAndKeyboardActions {

    /** Keyboard & Mouse Action - Page Object */
    void doubleClick(By el);
    void moveMousePointerTo(By el);
    void dragFromAndDropTo(By from,By to);

    /** Keyboard & Mouse Action - Page Factory */
    void doubleClick(WebElement element);
    void moveMousePointerTo(WebElement element);
    void dragFromAndDropTo(WebElement from,WebElement to);

}
