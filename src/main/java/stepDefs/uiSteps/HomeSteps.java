package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private final TestContext testContext;

    public HomeSteps(TestContext testContext) {this.testContext = testContext;}

    @When("I click {string} button")
    public void i_click_button(String button) {
        switch (button.toLowerCase()) {
            case "app launcher":
                testContext.UI().getHomePage().appLauncherBtn.click();
                break;
            case "view all":
                testContext.UI().getBrowserUtils().Waits.waitForElementToBeVisible(testContext.UI().getHomePage().viewAllLaunchBtn);
                testContext.UI().getHomePage().viewAllLaunchBtn.click();
                break;
    }

        }

    @Then("Verify AppExchange is clicable")
    public void verifyAppExchangeIsClicable() {
        Assert.assertTrue(testContext.UI().getHomePage().appExchangeBtn.isEnabled());
        testContext.UI().getBrowserUtils().logFailScreenshot(testContext.scenario);
    }
}

