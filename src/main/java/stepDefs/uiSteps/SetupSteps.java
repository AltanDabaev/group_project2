package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.And;
import org.junit.Assert;

public class SetupSteps {

    private final TestContext testContext;

    public SetupSteps(TestContext testContext) {this.testContext = testContext;}

    @And("I should see max {int} items displayed under Most Recently Used section")
    public void i_should_see_max_items_displayed_under_most_recently_used_section(int number) {
        Assert.assertTrue(testContext.UI().getSetupPage().mostRecentlyUsed.size() <= 10);
    }

}
