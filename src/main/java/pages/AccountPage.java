package pages;


import core.TestContext;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class AccountPage {


    public AccountPage(WebDriver driver){
        PageFactory.initElements(driver, this);}

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

    @FindBy(xpath = "//input[@name='Name']")
    public WebElement newAccountName;

    @FindBy(xpath = "//input[@name='AccountNumber']")
    public WebElement newAccountNumber;

    @FindBy(xpath = "//label[text()='Type']//following::button[@aria-label = 'Type']/span")
    public WebElement selectTypeField;

    @FindBy(xpath = "//span[@title='Prospect']")
    public WebElement selectTypeOption_Prospect;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    public WebElement saveBtn;

    @FindBy(xpath = "//lightning-formatted-text[@slot='primaryField']")
    public WebElement accountHeaderText;

    public String newlyCreatedAccountName;

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
