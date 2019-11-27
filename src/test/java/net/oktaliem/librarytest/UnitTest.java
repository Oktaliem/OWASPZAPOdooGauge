package net.oktaliem.librarytest;

import org.testng.annotations.Test;

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
        loginPage.switchToSecondBrowserTab();
        loginPage.wait(3000);
        loginPage.switchToFirstBrowserTab();
        loginPage.wait(2000);
    }

}
