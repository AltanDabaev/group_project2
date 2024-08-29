package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private final TestContext testContext;

    public HomeSteps(TestContext testContext) {this.testContext = testContext;}

    @Then("Verify {string} navigation button is visible")
    public void verifyNavigationButtonIsVisible(String button) {
        switch (button.toLowerCase()) {
            case "accounts":
                Assert.assertTrue(testContext.UI().getHomePage().accountsNavBtn.isDisplayed());
                break;
            case "contacts":
                Assert.assertTrue(testContext.UI().getHomePage().contactsNavBtn.isDisplayed());
                break;
            case "cases":
                Assert.assertTrue(testContext.UI().getHomePage().casesNavBtn.isDisplayed());
                break;
            case "reports":
                Assert.assertTrue(testContext.UI().getHomePage().reportsNavBtn.isDisplayed());
                break;
            case "dashboards":
                Assert.assertTrue(testContext.UI().getHomePage().dashboardsNavBtn.isDisplayed());
                break;

            default:
                Assert.fail(button + " navigation button was not found");
        }
    }

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().endsWith(url));
    }

    @Then("Verify AppExchange is clicable")
    public void verifyAppExchangeIsClicable() {
        Assert.assertTrue(testContext.UI().getHomePage().appExchangeBtn.isEnabled());
        testContext.UI().getBrowserUtils().logFailScreenshot(testContext.scenario);
    }
}

