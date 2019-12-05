package net.oktaliem.librarytest;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class UnitTest extends BaseTest{

    /**
     * “If you have WebDriver APIs in your test methods, You're Doing It Wrong.” Simon Stewart
     */

    @Test(description ="Page Factory - input and click ")
    public void TC01(){
        user.loginPage().launchTheApplication();
        user.loginPage().loginSamplePF();
        user.loginPage().landingToDiscussPagePF();
    }

    @Test(description = "Page Object - input and click ")
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

    @Test(description = "General - Get Value with Regex")
    public void TC14() throws IOException {
        user.loginPage().launchTheApplication();
        user.loginPage().getCSRFToken();
        //This test is intended to fail
    }


    @Test(description = "General - Scroll Up and Scroll Down ")
    public void TC15(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().scrollToBottomPage();
        user.seleniumPage().wait(3000);
        user.seleniumPage().scrollToTopPage();
        user.seleniumPage().wait(3000);
    }

    @Test(description = "Page Object - Scroll until view element")
    public void TC16(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPO();
    }

    @Test(description = "Page Factory - Scroll until view element")
    public void TC17(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPF();
    }

    @Test(description = "Page Factory - Double Click")
    public void TC18(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPF();
        user.seleniumPage().doubleClickMoreNewsButtonPF();
    }

    @Test(description = "Page Object - Double Click")
    public void TC19(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPO();
        user.seleniumPage().doubleClickMoreNewsButtonPO();
    }

    @Test(description = "Page Object - Move Mouse Pointer")
    public void TC20(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPO();
        user.seleniumPage().movePointerToNewsButtonPO();
    }

    @Test(description = "Page Factory - Move Mouse Pointer")
    public void TC21(){
        user.seleniumPage().goToSeleniumOfficialWeb();
        user.seleniumPage().gotToMoreNewsButtonPF();
        user.seleniumPage().movePointerToNewsButtonPF();
    }

    @Test(description = "drag and drop action - Page Factory")
    public void TC22(){
        user.seleniumPage().goToW3SchoolDropAndDropPage();
        user.seleniumPage().performDragAndDropPF();
    }

    @Test(description = "drag and drop action - Page Object")
    public void TC23(){
        user.seleniumPage().goToW3SchoolDropAndDropPage();
        user.seleniumPage().performDragAndDropPO();
    }

    @Test(description ="Page Factory - input and tab and enter ")
    public void TC24(){
        user.loginPage().launchTheApplication();
        user.loginPage().loginSamplePFWithTabEnter();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC25(){
        user.loginPage().launchTheApplication();
        user.loginPage().loginSamplePOWithTabAndEnter();
    }

    @Test(description ="Page Factory - input and tab and enter ")
    public void TC26(){
        user.seleniumPage().launchTheApplicationGuru99();
        user.seleniumPage().goToTestingAndClickCucumberPF();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC27(){
        user.seleniumPage().launchTheApplicationGuru99();
        user.seleniumPage().goToTestingAndClickCucumberPO();
    }

    @Test(description = "Page Object - input and tab and enter ")
    public void TC28(){
        user.seleniumPage().launchTheApplicationGuru99();
        user.seleniumPage().waitViaJavaScriptExecutor();
    }

    @Test(description = "General - Execute Javascript ")
    public void TC29(){
        user.seleniumPage().launchTheApplicationGuru99();
        user.seleniumPage().wait(5000);
        user.seleniumPage().wait(5000);
        user.seleniumPage().executeJavascript("alert(\"Hello World!\")");
        user.seleniumPage().wait(5000);
        user.seleniumPage().handleJavascriptPopUp("Hello World!");
        user.seleniumPage().executeJavascript("window.confirm(\"sometext\");");
        user.seleniumPage().wait(5000);
        user.seleniumPage().handleJavascriptPopUp("cancel");
        user.seleniumPage().executeJavascript("window.prompt(\"sometext\",\"defaultText\");");
        user.seleniumPage().wait(5000);
        user.seleniumPage().handleJavascriptPopUp("defaultText");
        user.seleniumPage().refreshPageViaJavaScriptExecutor();
        user.seleniumPage().executeJavascript("window.open()");
        user.seleniumPage().executeJavascript("window.focus()");
        user.seleniumPage().executeJavascript("screen.height");
    }

    @Test(description = "General - Login with javascript executor (Negative Scenario) ")
    public void TC30(){
        user.loginPage().launchTheApplication();
        user.loginPage().executeJavascript("document.getElementById('login').value='bitnami'");
        user.loginPage().executeJavascript("document.getElementById('password').value='test'");
        user.loginPage().executeJavascript("document.getElementsByClassName('btn-primary')[0].click()");
    }
}
