package net.oktaliem.librarytest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static net.oktaliem.Path.SELENIUM_WEB;
import static net.oktaliem.Path.W3SCHOOLDRAGANDDROP;

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
    private By originPO = By.id("drag1");
    private By targetPO = By.id("div2");
    private By guruDrPO = By.xpath("//span[@class='g-separator g-menu-item-content']//span[@class='g-menu-item-title'][contains(text(),'Testing')]");
    private By cucumberPO = By.xpath("//span[contains(text(),'Cucumber')]");
    private By countryPO = By.id("country");
    private By optionPO = By.tagName("label");
    private By inputPO = By.tagName("input");
    private By uploadFilePO = By.cssSelector("body:nth-child(2) form:nth-child(3) > input:nth-child(1)");

    @FindBy(className = "green")
    private List<WebElement> moreNewsBtn;

    @FindBy(id = "drag1")
    private WebElement origin;

    @FindBy(id = "div2")
    private WebElement target;

    @FindBy(id = "iframeResult")
    private WebElement iframe;

    @FindBy(className = "g-menu-parent-indicator")
    private List<WebElement> guruDropDown;

    @FindBy(xpath = "//span[contains(text(),'Cucumber')]")
    private WebElement cucumber;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(tagName = "label")
    private List<WebElement> options;

    @FindBy(tagName = "input")
    private List<WebElement> inputs;

    @FindBy(css = "body:nth-child(2) form:nth-child(3) > input:nth-child(1)")
    private WebElement uploadFilePF;

    public void goToSeleniumOfficialWeb() {
        goToWeb(SELENIUM_WEB);
    }

    public void gotToMoreNewsButtonPO() {
        scrollUntilViewElement(moreNews);
        wait(5000);
    }

    public void gotToMoreNewsButtonPF() {
        wait(3000);
        scrollUntilViewElement(moreNewsBtn.get(1));
        wait(3000);
    }

    public void doubleClickMoreNewsButtonPF() {
        doubleClick(moreNewsBtn.get(1));
    }

    public void doubleClickMoreNewsButtonPO() {
        doubleClick(moreNews);
    }

    public void movePointerToNewsButtonPO() {
        moveMousePointerTo(moreNews);
    }

    public void movePointerToNewsButtonPF() {
        moveMousePointerTo(moreNewsBtn.get(1));
    }

    public void goToW3SchoolDropAndDropPage() {
        goToWeb(W3SCHOOLDRAGANDDROP);
    }

    public void performDragAndDropPF() {
        switchToIframeByIdOrName(iframe);
        dragFromAndDropTo(origin, target);
        switchIframeToDefaultContent();
        wait(5000);
    }

    public void performDragAndDropPO() {
        switchToIframeByIndex(0);
        dragFromAndDropTo(originPO, targetPO);
        switchIframeToParentFrame();
        wait(5000);
    }

    public void launchTheApplicationGuru99() {
        goToWeb("https://www.guru99.com/");
    }

    public void goToTestingAndClickCucumberPF() {
        moveMousePointerTo(guruDropDown.get(0));
        moveMouseAndClick(guruDropDown.get(0), cucumber);
        wait(5000);
    }

    public void goToTestingAndClickCucumberPO() {
        moveMousePointerTo(guruDrPO);
        moveMouseAndClick(guruDrPO, cucumberPO);
        wait(3000);
    }

    public void waitViaJavaScriptExecutor() {
        waitWithJavascriptExecutor(10000);
    }

    public void selectCountryDropDownList() {
        switchToIframeByIndex(0);
        selectOnDropDownListByText(country, "USA");
        wait(5000);
        selectOnDropDownListByValue(country, "canada");
        wait(5000);
        selectOnDropDownListByValue(countryPO, "australia");
        wait(5000);
    }

    public void selectRadioW3SchoolText() {
        switchToIframeByIndex(0);
        selectOnRadioButtonByText(options, "Option 2");
        wait(5000);
        selectOnRadioButtonByText(optionPO, "Option 1");
        wait(5000);
    }

    public void selectRadioW3SchoolValue() {
        switchToIframeByIndex(0);
        selectOnRadioButtonByValue(inputs, "Firefox");
        wait(5000);
        selectOnRadioButtonByValue(inputPO, "Safari");
        wait(5000);
    }

    public void uploadFilePOPF() {
        switchToIframeByIndex(0);
        uploadFile(uploadFilePO, "/actualhtmltext/loginpage.txt");
        wait(3000);
        refreshPage();
        switchToIframeByIndex(0);
        wait(3000);
        uploadFile(uploadFilePF, "/actualhtmltext/loginpage.txt");
        wait(3000);
    }
}
