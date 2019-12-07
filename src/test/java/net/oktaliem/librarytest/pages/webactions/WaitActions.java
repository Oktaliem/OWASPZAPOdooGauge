package net.oktaliem.librarytest.pages.webactions;

import java.awt.*;

/**
 * Author : Okta Liem
 */
public interface WaitActions {

    void wait(int miliseconds);
    void waitWithJavascriptExecutor(int miliseconds);
    void robotWaitFor(int miliseconds) throws AWTException;
}
