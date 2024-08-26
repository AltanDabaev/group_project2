package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver){PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//a[@title='Accounts']/parent::one-app-nav-bar-item-root")
    public WebElement accountsNavBtn;

    @FindBy(xpath = "//a[@title='Contacts']/parent::one-app-nav-bar-item-root")
    public WebElement contactsNavBtn;

    @FindBy(xpath = "//a[@title='Cases']/parent::one-app-nav-bar-item-root")
    public WebElement casesNavBtn;

    @FindBy(xpath = "//a[@title='Reports']/parent::one-app-nav-bar-item-root")
    public WebElement reportsNavBtn;

    @FindBy(xpath = "//a[@title='Dashboards']/parent::one-app-nav-bar-item-root")
    public WebElement dashboardsNavBtn;

    @FindBy(xpath = "//button[@title='App Launcher']")
    public WebElement appLauncherBtn;
    @FindBy(xpath = "//a[@data-label='Service']//p")
    public WebElement serviceLaunchBtn;

    @FindBy(xpath = "//button[text()='View All']")
    public WebElement viewAllLaunchBtn;

    @FindBy(xpath = "//button[text()='Visit AppExchange']")
    public WebElement appExchangeBtn;

    @FindBy(xpath = "//a[@title='Accounts']/parent::one-app-nav-bar-item-root")
    public WebElement accountsNavBtn;


}
