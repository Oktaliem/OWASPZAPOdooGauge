package net.oktaliem.gaugetest;

import com.thoughtworks.gauge.Step;

import java.io.IOException;

import static net.oktaliem.Path.DATABASE_MANAGER_URL;
import static net.oktaliem.Path.LOGIN_PAGE_URL;

public class PageSteps extends PageActions {

    public PageSteps() {
        super();
    }

    String url = "";

    @Step("Landing to Odoo Login Page")
    public void launchTheApplicationGauge() {
        driver.get(LOGIN_PAGE_URL);
        log.info("Landing to Login Page: " + LOGIN_PAGE_URL);
    }

    @Step("Landing to Database Management Page")
    public void launchDatabaseManagement() {
        driver.get(DATABASE_MANAGER_URL);
        log.info("Landing to Database Manager Page: " + DATABASE_MANAGER_URL);
    }


    @Step("Spider App with ZAP")
    public void scanOdoowithZAP() {
        url = driver.getCurrentUrl();
        System.out.println(url);
        spiderWithZAP(url);
    }

    @Step("Set Alert and Attack Strength")
    public void setAlertAndAttackStrength() {
        setAlertAttackStrength();
    }

    @Step("Set Enable Passive Scan")
    public void setPassiveScan() {
        setEnablePassiveScanner(true);
    }

    @Step("Scan App with ZAP")
    public void scanApp() {
        scanAppWithZAP(url);
    }

    @Step("Remove False Positive")
    public void falsePositive() {
        removeFalsePositive();
    }

    @Step("Generate HTML Report")
    public void htmlReport() throws IOException {
        generateHTMLReport("gauge.html");
    }


}