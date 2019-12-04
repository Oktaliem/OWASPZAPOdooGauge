package net.oktaliem.librarytest.pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    private By menuBtn = By.className("full");
    private By setting = By.className("dropdown-item");

    @FindBy(className = "dropdown-item")
    List<WebElement> Setting;

    @Step("Open Drop Down Menu")
    public void openDropDownMenu(){
        clickOn(menuBtn);
    }

    @Step("Open Setting Page - Page Factory")
    public void goToSettingPagePF(){
        selectOnDropDownListByText(Setting,"Settings");
    }

    @Step("Open Setting Page - Page Object")
    public void goToSettingPagePO() {
        selectOnDropDownListByText(setting,"Settings");
    }

}
