package net.oktaliem.librarytest;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingPage extends HeaderComponent {

    public SettingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "custom-control-label")
    List<WebElement> firstCheckBoxName;

    @Step("Select Checkbox Name")
    public void selectAllName() {
        selectCheckBox(firstCheckBoxName.get(0),"y");

        //This below action returns false positive. This checkbox object is not applicable for this library action
        //because when element is validated by .isSelected then the result return false
        //and since the checkbox should be clicked by javascript (meaning selenium unable to find that element is intractable)
        // otherwise it will return error ElementClickInterceptedException
        //This action library is not applicable for certain condition like this
        //Odoo is using Djago Framework
        //but another framework .isSelected probably works
        selectCheckBox(firstCheckBoxName.get(0),"n");

        //to un-select without validation by disregard the checkbox is selected or not.
        selectCheckBox(firstCheckBoxName.get(0),"y");
    }

}
