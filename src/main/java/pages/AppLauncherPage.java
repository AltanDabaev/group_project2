package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class AppLauncherPage {


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

