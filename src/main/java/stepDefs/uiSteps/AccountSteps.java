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
    }
}


