package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountPage {

    public AccountPage(WebDriver driver){PageFactory.initElements(driver, this);}

    @FindBy(xpath = "//th//a[@data-refid = 'recordId']")
    public WebElement firstAccountOnTheList;

    @FindBy(xpath = "//p[@title='Phone']")
    public WebElement headerPhone;

    @FindBy(xpath = "//p[@title='Website']")
    public WebElement headerWebsite;

    @FindBy(xpath = "//p[@title='Industry']")
    public WebElement headerIndustry;

    @FindBy(xpath = "//p[@title='Type']")
    public WebElement headerType;

    @FindBy(xpath = "//p[@title='Account Owner']")
    public WebElement headerAccountOwner;

}
