package net.oktaliem.librarytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver ;
    public LoginPage loginPage;

    @BeforeMethod
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        System.out.println(System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.get(LOGIN_PAGE_URL);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
