package net.oktaliem.librarytest;

import org.testng.annotations.Test;

import java.io.IOException;

public class UnitTest extends BaseTest{

    @Test(description ="Page Factory - login ")
    public void TC01(){
        loginPage.launchTheApplication();
        loginPage.loginSamplePF();
        loginPage.landingToDiscussPagePF();
    }

    @Test(description = "Page Object - login ")
    public void TC02(){
        loginPage.launchTheApplication();
        loginPage.loginSamplePO();
    }

    @Test(description = "General - refresh page")
    public void TC03(){
        loginPage.launchTheApplication();
        loginPage.refreshPage();
    }

    @Test(description = "General - Open and Switch Tab")
    public void TC04(){
        loginPage.launchTheApplication();
        loginPage.openNewTab();
        loginPage.switchToSecondBrowser();
        loginPage.wait(3000);
        loginPage.switchToFirstBrowser();
        loginPage.wait(2000);
    }

    @Test(description = "Page Factory - Get and Verify Text")
    public void TC05(){
        loginPage.launchTheApplication();
        loginPage.getTextSamplePF();
    }

    @Test(description = "Page Object - Get and Verify Text")
    public void TC06(){
        loginPage.launchTheApplication();
        loginPage.getTextSamplePO();
    }

    @Test(description = "General - Go back and go forward on web page")
    public void TC_07(){
        loginPage.launchTheApplication();
        loginPage.wait(3000);
        loginPage.goBack();
        loginPage.wait(3000);
        loginPage.goForward();
        loginPage.wait(3000);
    }

    @Test(description = "General - Click via Javascript")
    public void TC08(){
        loginPage.launchTheApplication();
        loginPage.login();
    }

    @Test(description = "General - Get HTML source")
    public void TC09() throws IOException {
        loginPage.launchTheApplication();
        loginPage.getHtmlSource("loginPage");
    }

    @Test(description = "Page Factory - Dropdown Test")
    public void TC10() {
        loginPage.launchTheApplication();
        loginPage.login();
        loginPage.openDropDownMenu();
        loginPage.goToSettingPagePF();
    }

    @Test(description = "Page Object - Dropdown Test")
    public void TC11() {
        loginPage.launchTheApplication();
        loginPage.login();
        loginPage.openDropDownMenu();
        loginPage.goToSettingPagePO();
    }

    @Test(description = "Page Factory - Select CheckBox")
    public void TC12(){
        loginPage.launchTheApplication();
        loginPage.login();
        loginPage.openDropDownMenu();
        loginPage.goToSettingPagePO();
        settingPage.selectAllName();
    }

}
