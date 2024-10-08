package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class AccountPage {


    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);}

    public String newlyCreatedAccountName;

    @FindBy(xpath = "(//p[@title='Phone']/following-sibling::p)[1]")
    public WebElement headerPhone_text;
    @FindBy(xpath = "(//p[@title='Website']/following-sibling::p)[1]")
    public WebElement headerWebsite_text;
    @FindBy(xpath = "(//p[@title='Industry']/following-sibling::p)[1]")
    public WebElement headerIndustry_text;
    @FindBy(xpath = "(//p[@title='Type']/following-sibling::p)[1]")
    public WebElement headerType_text;
    @FindBy(xpath = "(//p[@title='Account Owner']/following-sibling::p)[1]")
    public WebElement headerAccountOwner_text;
    @FindBy(xpath = "//th//a[@title]")
    public List<WebElement> items_recentlyViewed;
    @FindBy(xpath = "//a[@data-tab-value='detailTab']")
    public List<WebElement> editDetailsBtn;
    @FindBy(xpath = "//button[@title='Edit Account Name']")
    public WebElement editAccountNameBtn;
    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveBtn;
    @FindBy(xpath = "//input[@name='Name']")
    public WebElement newAccountName;
    @FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
    public WebElement accountHeaderText;

    public void editAccountDetails(String accountName){
        editAccountNameBtn.click();
        newAccountName.clear();
        newAccountName.sendKeys(accountName);

        saveBtn.click();
    }

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

    @FindBy(xpath = "//li[contains(@data-target-selection-name, 'Account.New')]")
    public WebElement createNewAccountBtn;

    @FindBy(xpath = "//input[@name='AccountNumber']")
    public WebElement newAccountNumber;

    @FindBy(xpath = "//label[text()='Type']//following::button[@aria-label = 'Type']/span")
    public WebElement selectTypeField;

    @FindBy(xpath = "//span[@title='Prospect']")
    public WebElement selectTypeOption_Prospect;

    public void createNewAccount(String accountName, String accountNumber, String type){
        createNewAccountBtn.click();
        newAccountName.sendKeys(accountName);
        newAccountNumber.sendKeys(accountNumber);
        selectTypeField.click();

        switch (type.toLowerCase()){
            case "prospect": selectTypeOption_Prospect.click();
                break;
            default:
                Assert.fail("Type was not found");
        }

        saveBtn.click();
    }

}
