package net.oktaliem.librarytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;


public class BaseTest {
    public WebDriver driver ;
    public LoginPage loginPage;
    public HeaderComponent headerComponent;
    public SettingPage settingPage;

    @BeforeMethod
    public void initialization(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        System.out.println(System.getProperty("user.dir")+"/drivers/chromedriver-mac");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        headerComponent = new HeaderComponent(driver);
        settingPage = new SettingPage(driver);

    }

    @AfterMethod
    public void teardown () {
        driver.quit();
    }

}
