package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AppLauncherPage;

public class AppLauncherSteps {
    private final TestContext testContext;

    public AppLauncherSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Then("Verify {string} option is visible")
    public void verify_option_is_visible(String option) {
        switch (option.toLowerCase()) {
        case "Appexchange":
        Assert.assertTrue(testContext.UI().getAppLauncherPage().appExchangeBtn.isDisplayed());
        break;
    }
}



}
