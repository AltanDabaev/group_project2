package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SetupSteps {

    private final TestContext testContext;

    public SetupSteps(TestContext testContext) {this.testContext = testContext;}


    @When("I click {string} button")
    public void iClickButton(String button) {
        switch (button.toLowerCase()) {
            case "app launcher":
                testContext.UI().getSetupPage().appLauncherBtn.click();
                break;
            case "service":
                testContext.UI().getSetupPage().serviceLaunchBtn.click();
                testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("page/home");
                break;
            default: Assert.fail();
        }
    }
    @Then("Verify {string} button is displayed")
    public void verifyButtonIsdisplayed(String button) {
        switch (button.toLowerCase()) {
            case "home":
                Assert.assertTrue(testContext.UI().getSetupPage().homeNavBtn.isDisplayed());
                break;
            case "object manager":
                Assert.assertTrue(testContext.UI().getSetupPage().objManagerBtn.isDisplayed());
                break;
            default:
                Assert.fail();
        }
    }

}
