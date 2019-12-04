package net.oktaliem.librarytest.pages;

import org.openqa.selenium.WebDriver;

public class User {
    WebDriver driver;

    public User (WebDriver driver){
        this.driver = driver;
    }

    public LoginPage loginPage(){return new LoginPage(driver);}
    public SettingPage settingPage(){return new SettingPage(driver);}
    public SeleniumPage seleniumPage(){return new SeleniumPage(driver);}
}
