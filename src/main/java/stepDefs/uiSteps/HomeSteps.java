package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private TestContext testContext;

    public HomeSteps(TestContext testContext) {this.testContext = testContext;}
    @Given("I login to salesforce app")
    public void i_login_to_salesforce_app() {
        testContext.UI().getLoginPage().loginAsAdmin();
    }

    @Then("Verify URL is ending with {string}")
    public void verify_url_is_ending_with(String url) {
        Assert.assertTrue(testContext.UI().getDriver().getCurrentUrl().endsWith(url));
    }

    @When("I click {string} button")
    public void iClickButton(String button) {
        switch (button.toLowerCase()) {
            case "app launcher":
                testContext.UI().getHomePage().appLauncherBtn.click();
                break;
            case "service":
                testContext.UI().getHomePage().serviceLaunchBtn.click();
                testContext.UI().getBrowserUtils().Waits.waitForURLToContainText("page/home");
                break;
            default: Assert.fail();
        }
    }
}
