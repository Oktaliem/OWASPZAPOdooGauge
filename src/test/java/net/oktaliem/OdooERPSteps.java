package net.oktaliem;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class OdooERPSteps {
    WebDriver driver;
    public static Logger log = Logger.getLogger(OdooScanTest.class.getName());

    public OdooERPSteps(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void navigateTo(String url) {
        driver.get(url);
    }

    public void wait(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public String loginToOdoo(String url) {
        navigateTo(url);
        driver.findElement(By.id("login")).sendKeys("user@example.com");
        driver.findElement(By.id("password")).sendKeys("bitnami");
        driver.findElement(By.className("btn-primary")).click();
        wait(5000); //wait to all page loaded
        String homePage = driver.getCurrentUrl();
        log.info("User has landing to: " + url);
        return homePage;
    }

}
