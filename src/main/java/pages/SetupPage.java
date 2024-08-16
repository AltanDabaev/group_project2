package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SetupPage {

    public SetupPage(WebDriver driver){PageFactory.initElements(driver, this);}

}
