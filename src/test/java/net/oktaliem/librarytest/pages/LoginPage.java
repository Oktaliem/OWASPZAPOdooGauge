package net.oktaliem.librarytest.pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

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
        goToWeb(LOGIN_PAGE_URL);
    }

    @Step("Page Factory - Login")
    public void loginSamplePF() {
        inputTextBox(userName, "user@example.com");
        inputTextBox(password, "bitnami");
        clickOn(loginBtn);
    }

    @Step("Page Object - Login")
    public void loginSamplePO() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
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
        checkIfTextIsExpected(DBManage, text);
    }

    @Step("Login with Javascript Btn")
    public void login() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickViaJavascriptExecutor(loginBtn);
    }

    @Step("Login URL")
    public void getLoginPageURL() {
        getCurrentURL();
    }

    @Step("value or Regex")
    public void getCSRFToken() throws IOException {
        String text = readFile(System.getProperty("user.dir")+
                    "/src/main/resources/actualhtmltext/loginPage.txt");
        String pattern = "csrf_token: \"\\w{41}\"";
        String values = getValueWithRegex(pattern, text);
        String value = values.substring(values.length() - 42, values.length() - 1);

        //This test is intended to fail
        Assert.assertEquals(value, "01122a113f7377a85655c778b1143914eaa38884o");
        log.info("Regex Result: " + values);
        log.info("Result: " + value);
    }

    @Step("Login with Tab And Enter")
    public void loginSamplePFWithTabEnter() {
        inputTextAndTab(userName,"user@example.com");
        inputTextAndEnter(password,"bitnami");
        wait(5000);
    }

    public void loginSamplePOWithTabAndEnter() {
        inputTextAndTab(userNameLogin,"user@example.com");
        inputTextAndEnter(passwordLogin,"bitnami");
        wait(5000);
    }
}
