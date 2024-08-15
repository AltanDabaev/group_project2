package core;

import io.cucumber.java.Scenario;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.BrowserUtils;
import java.util.HashMap;
import java.util.Map;
import utils.ApiUtils;

public class TestContext {

    private final UI UI;
    private final API API;
    public Map<String, Object> sharedData;
    public Exception e;
    public Scenario scenario;

    public TestContext() {
        UI = new UI();
        API = new API(this);
        sharedData = new HashMap<>();
        e = new Exception();
    }
    public UI UI() {
        return this.UI;
    }
    public API API() {
        return this.API;
    }

    public class UI {
        private final WebDriver driver;
        private final BrowserUtils browserUtils;
        private final LoginPage loginPage;
        private final HomePage homePage;
        private final OppPage oppPage;
        private final SetupPage setupPage;
        private final AccountPage accountPage;

        public UI(){
            this.driver = new Driver().initializeDriver("chrome");
            this.browserUtils = new BrowserUtils(driver);
            this.loginPage = new LoginPage(driver);
            this.homePage = new HomePage(driver);
            this.accountPage = new AccountPage(driver);
            this.oppPage = new OppPage(driver);
            this.setupPage = new SetupPage(driver);

        }

        public WebDriver getDriver() {
            return this.driver;
        }

        public BrowserUtils getBrowserUtils() {
            return this.browserUtils;
        }

        public LoginPage getLoginPage() {
            return this.loginPage;
        }

        public HomePage getHomePage() {
            return this.homePage;
        }

        public AccountPage getAccountPage(){return this.accountPage;}
        public OppPage getOppPage(){return this.oppPage;}
        public SetupPage getSetupPage(){return this.setupPage;}
    }

    public class API {
        public RequestSpecification requestSpecification;
        public Response response;
        public ApiUtils ApiUtils;

        public API(TestContext testContext) {
            ApiUtils = new ApiUtils(testContext);
        }
    }
}
