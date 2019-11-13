package net.oktaliem;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class OdooERP {
    WebDriver driver;

    public OdooERP(WebDriver driver) {
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
        wait(3000);
        String homePage = driver.getCurrentUrl();
        return homePage;
    }

}
