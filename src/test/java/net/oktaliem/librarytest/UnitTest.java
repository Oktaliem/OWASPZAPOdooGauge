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


}
