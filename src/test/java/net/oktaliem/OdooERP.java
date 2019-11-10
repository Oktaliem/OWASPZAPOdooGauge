package net.oktaliem;

import com.thoughtworks.gauge.Step;
import net.oktaliem.utils.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static net.oktaliem.Path.BASE_URL_ODOO;


public class OdooERP {
    WebDriver driver;

    public OdooERP(WebDriver driver) {
        this.driver = driver;
        this.driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void navigateToLoginPage(String url) {
        driver.get(url);
    }




    public void navigateToDatabaseManagerPage(String url) {
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
        navigateToLoginPage(url);
        driver.findElement(By.id("login")).sendKeys("user@example.com");
        driver.findElement(By.id("password")).sendKeys("bitnami");
        driver.findElement(By.className("btn-primary")).click();
        wait(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost/web#action=35&model=ir.module.module&view_type=kanban&cids=1&menu_id=5");
        String homePage = driver.getCurrentUrl();
        return homePage;
    }

}
