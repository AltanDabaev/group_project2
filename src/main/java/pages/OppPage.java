package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class OppPage {

    public OppPage(WebDriver driver){PageFactory.initElements(driver, this);}
    @FindBy(xpath = "//div[@aria-label='Favorite this item']/following-sibling::div/button")
    public WebElement favListBtn;

    @FindBy(xpath = "//a[contains(@href, 'AllOpportunities') and @role]")
    public WebElement allOpportunitiesOption;

}
