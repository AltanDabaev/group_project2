package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private TestContext testContext;

    public HomeSteps(TestContext testContext) {this.testContext = testContext;}

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().endsWith(url));
    }

    @When("I click {string} button")
    public void i_click_button(String button) {
        switch (button.toLowerCase()) {
            case "app launcher":
                testContext.UI().getHomePage().appLauncherBtn.click();
                break;
            case "service":
                testContext.UI().getHomePage().serviceLaunchBtn.click();
                testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("page/home");
                break;
            case "view all":
                testContext.UI().getBrowserUtils().Waits.waitForElementToBeVisible(testContext.UI().getHomePage().viewAllLaunchBtn);
                testContext.UI().getHomePage().viewAllLaunchBtn.click();
                break;
            case "accounts":
                testContext.UI().getHomePage().accountsNavBtn.click();
                break;
            default: Assert.fail();
    }

        }

    @Then("Verify AppExchange is clicable")
    public void verifyAppExchangeIsClicable() {
        Assert.assertTrue(testContext.UI().getHomePage().appExchangeBtn.isEnabled());
        testContext.UI().getBrowserUtils().logFailScreenshot(testContext.scenario);
    }
}

