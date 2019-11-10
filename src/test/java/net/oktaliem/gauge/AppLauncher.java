package net.oktaliem.gauge;

import com.thoughtworks.gauge.Step;
import net.oktaliem.utils.driver.Driver;

import static net.oktaliem.Path.*;

public class AppLauncher {

    @Step("Landing to Odoo Login Page")
    public void launchTheApplication() {
        Driver.webDriver.get(BASE_URL_ODOO);
        System.out.println(BASE_URL_ODOO);
    }

    @Step("Landing to Database Management Page")
    public void launchDatabaseManagement() {
        Driver.webDriver.get(DATABASE_MANAGER);
        System.out.println(DATABASE_MANAGER);
    }


}
