package net.oktaliem.gauge;

import com.thoughtworks.gauge.Step;
import net.oktaliem.utils.driver.Driver;

import static net.oktaliem.Path.*;

public class AppLauncher {

    @Step("Landing to Odoo Login Page")
    public void launchTheApplication() {
        Driver.webDriver.get(LOGIN_PAGE_URL);
        System.out.println(LOGIN_PAGE_URL);
    }

    @Step("Landing to Database Management Page")
    public void launchDatabaseManagement() {
        Driver.webDriver.get(DATABASE_MANAGER_URL);
        System.out.println(DATABASE_MANAGER_URL);
    }


}
