package net.oktaliem.librarytest;

import org.testng.annotations.Test;

import java.io.IOException;

public class UnitTest extends BaseTest{

    @Test(description ="Page Factory - login ")
    public void TC01(){
        user.loginPage().launchTheApplication();
        user.loginPage().loginSamplePF();
        user.loginPage().landingToDiscussPagePF();
    }

    @Test(description = "Page Object - login ")
    public void TC02(){
        user.loginPage().launchTheApplication();
        user.loginPage().loginSamplePO();
    }

    @Test(description = "General - refresh page")
    public void TC03(){
        user.loginPage().launchTheApplication();
        user.loginPage().refreshPage();
    }

    @Test(description = "General - Open and Switch Tab")
    public void TC04(){
        user.loginPage().launchTheApplication();
        user.loginPage().openNewTab();
        user.loginPage().switchToSecondBrowser();
        user.loginPage().wait(3000);
        user.loginPage().switchToFirstBrowser();
        user.loginPage().wait(2000);
    }

    @Test(description = "Page Factory - Get and Verify Text")
    public void TC05(){
        user.loginPage().launchTheApplication();
        user.loginPage().getTextSamplePF();
    }

    @Test(description = "Page Object - Get and Verify Text")
    public void TC06(){
        user.loginPage().launchTheApplication();
        user.loginPage().getTextSamplePO();
    }

    @Test(description = "General - Go back and go forward on web page")
    public void TC_07(){
        user.loginPage().launchTheApplication();
        user.loginPage().wait(3000);
        user.loginPage().goToPreviousPage();
        user.loginPage().wait(3000);
        user.loginPage().goToNextPage();
        user.loginPage().wait(3000);
    }

    @Test(description = "General - Click via Javascript")
    public void TC08(){
        user.loginPage().launchTheApplication();
        user.loginPage().login();
    }

    @Test(description = "General - Get HTML source")
    public void TC09() throws IOException {
        user.loginPage().launchTheApplication();
        user.loginPage().getHtmlSource("loginPage");
    }

    @Test(description = "Page Factory - Dropdown Test")
    public void TC10() {
        user.loginPage().launchTheApplication();
        user.loginPage().login();
        user.loginPage().openDropDownMenu();
        user.loginPage().goToSettingPagePF();
    }

    @Test(description = "Page Object - Dropdown Test")
    public void TC11() {
        user.loginPage().launchTheApplication();
        user.loginPage().login();
        user.loginPage().openDropDownMenu();
        user.loginPage().goToSettingPagePO();
    }

    @Test(description = "Page Factory - Select CheckBox")
    public void TC12(){
        user.loginPage().launchTheApplication();
        user.loginPage().login();
        user.loginPage().openDropDownMenu();
        user.loginPage().goToSettingPagePO();
        user.settingPage().selectAllName();
    }

    @Test(description = "General - Get Login Page URL")
    public void TC13(){
        user.loginPage().launchTheApplication();
        user.loginPage().login();
        user.loginPage().getLoginPageURL();
    }


}
