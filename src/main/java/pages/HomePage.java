package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class HomePage {


    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//button[@title='App Launcher']")
    public WebElement appLauncherBtn;

    @FindBy(xpath = "//a[@data-label='Service']//p")
    public WebElement serviceLaunchBtn;





}
