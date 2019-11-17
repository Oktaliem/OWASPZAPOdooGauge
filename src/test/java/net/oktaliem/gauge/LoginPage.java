package net.oktaliem.gauge;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

public class LoginPage extends PageActions {

    By userNameLogin = By.id("login");
    By passwordLogin = By.id("password");
    By loginButton = By.className("btn-primary");


    @Step("Login with User Name and Password")
    public void loginToApp() {
        inputTextBox(userNameLogin, "user@example.com");
        inputTextBox(passwordLogin, "bitnami");
        clickOn(loginButton);
        wait(3000);
    }
}