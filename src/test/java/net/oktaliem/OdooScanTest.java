package net.oktaliem;

import org.testng.annotations.Test;
import java.io.IOException;

import static net.oktaliem.Path.BASE_URL_ODOO;
import static net.oktaliem.Path.DATABASE_MANAGER;


public class OdooScanTest extends ZapScannerBase {

    @Test
    public void tc01_odooSecurityPassiveScanOnLoginPage()throws IOException{
        odoo.navigateToLoginPage(BASE_URL_ODOO);
        spiderOdooWithZap(BASE_URL_ODOO);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(BASE_URL_ODOO);
        removeFalsePositive();
        writeHtmlReport("loginPage.html");
    }

    @Test
    public void tc02_odooSecurityPassiveScanOnDatabaseManager()throws IOException{
        odoo.navigateToDatabaseManagerPage(DATABASE_MANAGER);
        spiderOdooWithZap(DATABASE_MANAGER);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(DATABASE_MANAGER);
        removeFalsePositive();
        writeHtmlReport("databaseManager.html");
    }

    @Test
    public void tc03_odooSecurityPassiveScanAfterLogin() throws IOException {
        String homePage = odoo.loginToOdoo(BASE_URL_ODOO);
        spiderOdooWithZap(homePage);
        setAlertAndAttackStrength();
        zapScanner.setEnablePassiveScan(true);
        scanOdooWithZap(homePage);
        removeFalsePositive();
        writeHtmlReport("homePage.html");

    }
}
