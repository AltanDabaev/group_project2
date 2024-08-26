package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
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
            case "accounts":
                testContext.UI().getHomePage().accountsNavBtn.click();
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
    @And("I should see max {int} items displayed under Most Recently Used section")
    public void i_should_see_max_items_displayed_under_most_recently_used_section(int number) {
        Assert.assertTrue(testContext.UI().getSetupPage().mostRecentlyUsed.size() <= 10);
    }

}
