package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SetupPage {

    public SetupPage(WebDriver driver){PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//button[@title='App Launcher']")
    public WebElement appLauncherBtn;

    @FindBy(xpath = "//a[@data-label='Service']//p")
    public WebElement serviceLaunchBtn;
    @FindBy(xpath = "//span[starts-with(@class, 'title') and text()='Home']")
    public WebElement homeNavBtn;
    @FindBy(xpath = "//span[starts-with(@class, 'title') and text()='Object Manager']")
    public WebElement objManagerBtn;

    @FindBy(xpath = "//a[@class='setupLink']")
    public List<WebElement> mostRecentlyUsed;



}
