package net.oktaliem.librarytest.pages;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static net.oktaliem.Path.*;

public class SeleniumPage extends BasePage {
    /**
     * Martin Flower :
     * "1. A page object wraps an HTML page, or fragment, with an application-specific API, allowing you to manipulate page elements without digging around in the HTML."
     * "2. A page object should also provide an interface that's easy to program to and hides the underlying widgetry in the window  page."
     * "3. The page object should encapsulate the mechanics required to find and manipulate the data in the page itself. A good rule of thumb is to imagine changing the concrete page -in which case the page object interface shouldn't change."
     */

    public SeleniumPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By moreNews = By.xpath("//div[@class='button green']");

    @FindBy(className = "green")
    List<WebElement> moreNewsBtn;

    @FindBy(id = "drag1")
    WebElement origin;

    @FindBy(id = "div2")
    WebElement target;

    @FindBy(id = "iframeResult")
    WebElement iframe;

    By originPO = By.id("drag1");
    By targetPO = By.id("div2");

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
    @Step("Move Pointer to More News Button - Page Object")
    public void movePointerToNewsButtonPO() {
        moveMousePointerTo(moreNews);
    }
    @Step("Move Pointer to More News Button - Page Factory")
    public void movePointerToNewsButtonPF() {
        moveMousePointerTo(moreNewsBtn.get(1));
    }
    @Step("Go To w3school drag and drop")
    public void goToW3SchoolDropAndDropPage() {
        goToWeb(W3SCHOOLDRAGANDDROP);
    }
    @Step("Move Pointer to More News Button - Page Factory")
    public void performDragAndDropPF() {
        switchToIframeByIdOrName(iframe);
        dragFromAndDropTo(origin,target);
        switchIframeToDefaultContent();
        wait(5000);
    }

    @Step("Move Pointer to More News Button - Page Object")
    public void performDragAndDropPO() {
        switchToIframeByIndex(0);
        dragFromAndDropTo(originPO,targetPO);
        switchIframeToParentFrame();
        wait(5000);
    }
}
