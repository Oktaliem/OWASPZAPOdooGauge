package net.oktaliem.librarytest;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static net.oktaliem.Path.LOGIN_PAGE_URL;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    By userNameLogin = By.id("login");
    By passwordLogin = By.id("password");
    By loginButton = By.className("btn-primary");

    @FindBy(id = "login")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(className = "btn-primary")
    WebElement loginBtn;

    @FindBy(className = "o_menu_brand")
    WebElement pageHeader;


    @Step("Go to Odoo Login Page")
    public void launchTheApplication() {
        driver.get(LOGIN_PAGE_URL);
        log.info("Landing to Login Page: " + LOGIN_PAGE_URL);
    }

    @Step("Page Factory - Login")
    public void loginSamplePF() {
        inputTextBox(userName, "test");
        inputTextBox(password, "test");
        clickOn(loginBtn);
    }

    @Step("Page Object - Login")
    public void loginSamplePO() {
        inputTextBox(userNameLogin, "test");
        inputTextBox(passwordLogin, "test");
        wait(5000);
        clickOn(loginButton);
    }

    @Step("Landing to Discuss Page")
    public void landingToDiscussPagePF() {
       // checkIfElementIsVisible(pageHeader,10);
       // waitForElementActionable(pageHeader,10);


    }
}
