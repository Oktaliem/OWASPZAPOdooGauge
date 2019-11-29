package net.oktaliem.librarytest;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static net.oktaliem.Path.LOGIN_PAGE_URL;

public class LoginPage extends HeaderComponent {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By userNameLogin = By.id("login");
    private By passwordLogin = By.id("password");
    private By loginButton = By.className("btn-primary");
    private By DBManage = By.className("border-right");


    @FindBy(id = "login")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "btn-primary")
    private WebElement loginBtn;

    @FindBy(className = "o_menu_brand")
    private WebElement pageHeader;

    @FindBy(className = "border-right")
    private WebElement manageDB;

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

    @Step("Get Text sample Page Factory")
    public void getTextSamplePF() {
        String text = getTextFromElement(manageDB);
        checkIfTextIsExpected(manageDB, text);
    }

    @Step("Get Text sample Page Object")
    public void getTextSamplePO() {
        String text = getTextFromElement(DBManage);
        checkIfTextIsExpected(DBManage,text);
    }

    @Step("Login with Javascript Btn")
    public void login() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickViaJavascriptExecutor(loginBtn);
    }
}
