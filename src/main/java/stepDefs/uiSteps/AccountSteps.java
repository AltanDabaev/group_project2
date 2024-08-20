package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class AccountSteps {
    private final TestContext testContext;

    public AccountSteps(TestContext testContext) {this.testContext = testContext;}


    @And("I click {string} item from recently view window")
    public void iClickItemFromRecentlyViewWindow(String item) {
        switch (item.toLowerCase()){
            case "first": testContext.UI().getAccountPage().items_recentlyViewed.get(0).click();
                break;
            default:
                Assert.fail("Item was not found");
        }
    }

    @And("I click edit {string} button")
    public void iClickEditButton(String item) {
        switch (item.toLowerCase()) {
            case "details":
                testContext.UI().getAccountPage().editDetailsBtn.get(0).click();
                break;
            default:
                Assert.fail("Item was not found");
        }
    }

    @And("I edit Accounts following fields:")
    public void iEditAccountsFollowingFields(Map<String, String> map) {
        testContext.UI().getAccountPage().editAccountDetails(
                map.get("accountName")
        );
        testContext.UI().getBrowserUtils().sleep(2000);
    }

    @Then("Verify Account name is {string}")
    public void verifyAccountNameIs(String accountName) {
        Assert.assertEquals(accountName, testContext.UI().getAccountPage().accountHeaderText.getText());
    }

}
