package stepDefs.apiSteps;

import core.TestContext;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class UserApiSteps {

    private TestContext testContext;

    public UserApiSteps(TestContext testContext) {this.testContext = testContext;}

    @Then("I should get not less than {int} user")
    public void i_should_get_not_less_than_user(int number) {
        Assert.assertTrue(testContext.API().users.size() >= number);
    }
}
