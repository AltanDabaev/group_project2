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
            case "service":
                testContext.UI().getHomePage().serviceLaunchBtn.click();
                break;
            case "accounts":
                testContext.UI().getHomePage().accountsNavBtn.click();
                break;
    }

        }

    @Then("Verify AppExchange is clicable")
    public void verifyAppExchangeIsClicable() {
        Assert.assertTrue(testContext.UI().getHomePage().appExchangeBtn.isEnabled());
        testContext.UI().getBrowserUtils().logFailScreenshot(testContext.scenario);
    }
}

