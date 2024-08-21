package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;

public class AppLauncherPage {
    public AppLauncherPage(WebDriver driver){
        PageFactory.initElements(driver, this);}


    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "Login")
    public WebElement loginBtn;
    @FindBy(xpath = "//button[@title='App Launcher']")
    public WebElement appLauncherBtn;
    @FindBy(xpath = "//button[text()='View All']")
    public WebElement viewAllLaunchBtn;

    @FindBy(xpath = "//button[text()='Visit AppExchange']")
    public WebElement appExchangeBtn;



    public void loginAsAdmin() {
        usernameField.sendKeys(ConfigReader.readProperty("config.properties", "username"));
        passwordField.sendKeys(ConfigReader.readProperty("config.properties", "password"));
        loginBtn.click();

    }

}

