package net.oktaliem;

import org.testng.annotations.Test;
import java.io.IOException;

import static net.oktaliem.Path.LOGIN_PAGE_URL;
import static net.oktaliem.Path.DATABASE_MANAGER_URL;


public class OdooScanTest extends ZapScannerBase {

    @Test
    public void tc01_odooSecurityPassiveScanOnLoginPage()throws IOException{
        odoo.navigateTo(LOGIN_PAGE_URL);
        spiderOdooWithZap(LOGIN_PAGE_URL);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(LOGIN_PAGE_URL);
        removeFalsePositive();
        writeHtmlReport("loginPage.html");
    }

    @Test
    public void tc02_odooSecurityPassiveScanOnDatabaseManager()throws IOException{
        odoo.navigateTo(DATABASE_MANAGER_URL);
        spiderOdooWithZap(DATABASE_MANAGER_URL);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(DATABASE_MANAGER_URL);
        removeFalsePositive();
        writeHtmlReport("databaseManager.html");
    }

    @Test
    public void tc03_odooSecurityPassiveScanAfterLogin() throws IOException {
        String homePage = odoo.loginToOdoo(LOGIN_PAGE_URL);
        spiderOdooWithZap(homePage);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(homePage);
        removeFalsePositive();
        writeHtmlReport("homePage.html");

    }
}
