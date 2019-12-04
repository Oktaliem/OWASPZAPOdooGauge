package net.oktaliem.librarytest.pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static net.oktaliem.Path.SELENIUM_WEB;

public class SeleniumPage extends BasePage {
    public SeleniumPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By moreNews = By.xpath("//div[@class='button green']");

    @FindBy(className = "green")
    List<WebElement> moreNewsBtn;

    @Step("Go To Selenium Official Page")
    public void goToSeleniumOfficialWeb() {
        goToWeb(SELENIUM_WEB);
    }

    @Step("Go to More News button - Page Object")
    public void gotToMoreNewsButtonPO(){
        scrollUntilViewElement(moreNews);
        wait(5000);
    }

    @Step("Go to More News button - Page Factory")
    public void gotToMoreNewsButtonPF(){
        wait(3000);
        scrollUntilViewElement(moreNewsBtn.get(1));
        wait(3000);
    }

    @Step("Double Click More News Button - Page Factory")
    public void doubleClickMoreNewsButtonPF() {
        doubleClick(moreNewsBtn.get(1));
    }
    @Step("Double Click More News Button - Page Object")
    public void doubleClickMoreNewsButtonPO() {
        doubleClick(moreNews);
    }

    public void movePointerToNewsButtonPO() {
        moveMousePointerTo(moreNews);
    }

    public void movePointerToNewsButtonPF() {
        moveMousePointerTo(moreNewsBtn.get(1));
    }
}
