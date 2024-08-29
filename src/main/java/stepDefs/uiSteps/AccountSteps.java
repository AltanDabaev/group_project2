package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;
import java.util.Map;

public class AccountSteps {
    private final TestContext testContext;

    public AccountSteps(TestContext testContext) {this.testContext = testContext;}

    @And("I click {string} item from recently view window")
    public void iClickItemFromRecentlyViewWindow(String item) {
        switch (item.toLowerCase()) {
            case "first":
                testContext.UI().getAccountPage().items_recentlyViewed.get(0).click();
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

    @And("I click each account and verify the following headers are present:")
    public void i_click_each_account_and_verify_the_following_headers_are_present(List<String> list) {
        testContext.UI().getAccountPage().firstAccountOnTheList.click();
           for (String header: list){
               switch (header.toLowerCase()){
                   case "type":
                       Assert.assertTrue(testContext.UI().getAccountPage().headerType.isDisplayed());
                       break;
                   case "phone":
                       Assert.assertTrue(testContext.UI().getAccountPage().headerPhone.isDisplayed());
                       break;
                   case "website":
                       Assert.assertTrue(testContext.UI().getAccountPage().headerWebsite.isDisplayed());
                       break;
                   case "account owner":
                       Assert.assertTrue(testContext.UI().getAccountPage().headerAccountOwner.isDisplayed());
                       break;
                   case "industry":
                       Assert.assertTrue(testContext.UI().getAccountPage().headerIndustry.isDisplayed());
                       break;
                   default: Assert.fail("Header was not found");
               }
           }


       }

    @When("I create a new Account with following fields populated:")
    public void iCreateANewAccountWithFollowingFieldsPopulated(Map<String, String> map) {
            testContext.UI().getAccountPage().newlyCreatedAccountName = map.get("Account Name").replace("{current_time}",
                    testContext.UI().getBrowserUtils().getLogTime());
            testContext.UI().getAccountPage().createNewAccount(
                    map.get("Account Name").replace("{current_time}",
                            testContext.UI().getBrowserUtils().getLogTime()),
                    map.get("Account Number"),
                    map.get("Type")
            );
        }

    @Then("Verify Account header has given Account name")
    public void verifyAccountHeaderHasGivenAccountName() {
        Assert.assertEquals(testContext.UI().getAccountPage().newlyCreatedAccountName,
                testContext.UI().getAccountPage().accountHeaderText.getText());
        testContext.UI().getBrowserUtils().captureScreenshot(testContext.UI().getDriver(), testContext.scenario);
        testContext.UI().getBrowserUtils().logTestDataAndLocator(testContext.scenario,
                testContext.UI().getAccountPage().accountHeaderText, testContext.UI().getAccountPage().newlyCreatedAccountName);
    }
}


