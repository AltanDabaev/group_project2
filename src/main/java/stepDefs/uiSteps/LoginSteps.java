package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginSteps {

    private final TestContext testContext;
    public LoginSteps(TestContext testContext) {this.testContext = testContext;}
    @Given("I login to salesforce app")
    public void i_login_to_salesforce_app() {
        testContext.UI().getLoginPage().loginAsAdmin();
    }

    @Then("Verify title of the page should contain Home")
    public void verifyTitleOfThePageShouldContainHome() {
        testContext.UI().getBrowserUtils().Waits.waitForTitleToContain("Home");
        Assert.assertTrue(testContext.UI().getDriver().getTitle().contains("Home"));
    }
}
