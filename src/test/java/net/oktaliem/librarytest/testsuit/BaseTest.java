package net.oktaliem.librarytest.testsuit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

/**
 * Author : Okta Liem
 */
public class BaseTest {
    public WebDriver driver ;
    public User user;


    @BeforeMethod
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        System.out.println(System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        user = new User(driver);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
