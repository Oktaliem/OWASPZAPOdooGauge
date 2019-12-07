package net.oktaliem.librarytest.pages.baseactions;

import net.oktaliem.librarytest.pages.webactions.RobotActions;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Author : Okta Liem
 */
public class BaseRobotAct extends BaseWaitAct implements RobotActions {

    public BaseRobotAct(WebDriver driver) {
        super(driver);
    }

    @Override
    public void robotKeyPress(int keyEvent) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(keyEvent);
        log.info("Perform Key Even Action: " + keyEvent);
    }

    @Override
    public void robotMouseMove(int xCoordinate, int yCoordinate) throws AWTException {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinate, yCoordinate);
        log.info("Move mouse from: " + xCoordinate + " to: " + yCoordinate);

    }

    @Override
    public void robotLeftClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        log.info("Perform left click with robot class");
    }

    @Override
    public void robotRightClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.delay(1000);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        log.info("Perform right click with robot class");
    }

    @Override
    public void robotDoubleClick() throws AWTException {
        Robot robot = new Robot();
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        log.info("Perform double click with robot");
    }

    @Override
    public void robotPressEnter() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(1000);
        log.info("Perform Enter click with robot");
    }

    @Override
    public void robotPressTab() throws AWTException {
        Robot robot = new Robot();
        robot.delay(1000);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.delay(1000);
        log.info("Perform Tab with robot");
    }

    @Override
    public void robotSelectAll() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_A);
        log.info("Perform select all with robot");
    }

    @Override
    public void robotType(String keyboard) throws AWTException {
        Robot robot = new Robot();
        switch (keyboard) {
            case "alt": robot.keyPress(KeyEvent.VK_ALT); break;
            case "tab": robot.keyPress(KeyEvent.VK_TAB); break;
            case "enter": robot.keyPress(KeyEvent.VK_ENTER); break;
            case "shift": robot.keyPress(KeyEvent.VK_SHIFT); break;
            case "windows": robot.keyPress(KeyEvent.VK_WINDOWS); break;
            case "control": robot.keyPress(KeyEvent.VK_CONTROL); break;
            case "open_bracket": robot.keyPress(KeyEvent.VK_OPEN_BRACKET); break;
            case "escape": robot.keyPress(KeyEvent.VK_ESCAPE); break;
            case "a": robot.keyPress(KeyEvent.VK_A); break;
            case "b": robot.keyPress(KeyEvent.VK_B); break;
            case "c": robot.keyPress(KeyEvent.VK_C); break;
            case "d": robot.keyPress(KeyEvent.VK_D); break;
            case "e": robot.keyPress(KeyEvent.VK_E); break;
            case "f": robot.keyPress(KeyEvent.VK_F); break;
            case "g": robot.keyPress(KeyEvent.VK_G); break;
            case "h": robot.keyPress(KeyEvent.VK_H); break;
            case "i": robot.keyPress(KeyEvent.VK_I); break;
            case "j": robot.keyPress(KeyEvent.VK_J); break;
            case "k": robot.keyPress(KeyEvent.VK_K); break;
            case "l": robot.keyPress(KeyEvent.VK_L); break;
            case "m": robot.keyPress(KeyEvent.VK_M); break;
            case "n": robot.keyPress(KeyEvent.VK_N); break;
            case "o": robot.keyPress(KeyEvent.VK_O); break;
            case "p": robot.keyPress(KeyEvent.VK_P); break;
            case "q": robot.keyPress(KeyEvent.VK_Q); break;
            case "r": robot.keyPress(KeyEvent.VK_R); break;
            case "s": robot.keyPress(KeyEvent.VK_S); break;
            case "t": robot.keyPress(KeyEvent.VK_T); break;
            case "u": robot.keyPress(KeyEvent.VK_U); break;
            case "v": robot.keyPress(KeyEvent.VK_V); break;
            case "w": robot.keyPress(KeyEvent.VK_W); break;
            case "x": robot.keyPress(KeyEvent.VK_X); break;
            case "y": robot.keyPress(KeyEvent.VK_Y); break;
            case "z": robot.keyPress(KeyEvent.VK_Z); break;
            default:
                throw new IllegalArgumentException("Cannot type character " + keyboard);
        }
        log.info("Perform type: "+ keyboard);
    }


}
