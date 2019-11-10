package net.oktaliem.utils;

import com.thoughtworks.gauge.Step;
import net.oktaliem.utils.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class FlashMessages {
    @Step("Show a message <message>")
    public void showAWelcomeMessage(String message) {
        WebDriver webDriver = Driver.webDriver;
        WebElement flashNoticeElement = webDriver.findElement(By.xpath(String.format("//div[@id = 'flash_notice' and text() = '%s']", message)));
        assertTrue(flashNoticeElement.isDisplayed());
    }
}
