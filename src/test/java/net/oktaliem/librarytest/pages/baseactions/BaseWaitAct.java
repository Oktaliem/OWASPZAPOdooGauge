package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.WaitActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * Author : Okta Liem
 */
public class BaseWaitAct extends BaseAssertionAct implements WaitActions {

    public BaseWaitAct(WebDriver driver) {
        super(driver);
    }

//    public boolean checkIfElementIsVisible(WebElement element, int inSeconds) {
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, inSeconds);
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    /**
     * Wait actions
     */
    @Override
    public void wait(int miliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("User waits for " + miliseconds + " milliseconds");
    }

//    public void waitForElementActionable(WebElement element, int time) {
//        WebDriverWait wait = new WebDriverWait(driver, time);
//        wait.until(ExpectedConditions.or(
//                ExpectedConditions.visibilityOf(element),
//                ExpectedConditions.elementToBeClickable(element),
//                ExpectedConditions.presenceOfElementLocated((By) element),
//                ExpectedConditions.elementToBeSelected(element)));
//    }


    @Override
    public void waitWithJavascriptExecutor(int miliseconds) {
        long start = System.currentTimeMillis();
        ((JavascriptExecutor) driver).executeAsyncScript(
                "window.setTimeout(arguments[arguments.length - 1]," + miliseconds + ");");
        String time = String.valueOf(System.currentTimeMillis() - start);
        log.info("Elapsed time: " + time);
    }


    @Override
    public void robotWaitFor(int miliseconds) throws AWTException {
        Robot robot = new Robot();
        robot.delay(miliseconds);
        log.info("Wait with Robot class for "+miliseconds+" miliseconds");
    }




}
