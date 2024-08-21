package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SetupPage {

    public SetupPage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//a[@class='setupLink']")
    public List<WebElement> mostRecentlyUsed;

}
