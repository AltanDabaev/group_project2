package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class OppSteps {
    private final TestContext testContext;

    public OppSteps(TestContext testContext) {this.testContext = testContext;}


    @When("I navigate to {string} page from favourites list")
    public void i_navigate_to_page_from_favourites_list(String listItem) {
        switch (listItem.toLowerCase()){
            case "all opportunities":
                testContext.UI().getOppPage().favListBtn.click();
                testContext.UI().getOppPage().allOpportunitiesOption.click();
                break;
            default:
                Assert.fail(listItem + " item was not found");
        }
    }

}
