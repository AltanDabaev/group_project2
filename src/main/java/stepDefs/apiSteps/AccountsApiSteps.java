package stepDefs.apiSteps;

import core.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountsApiSteps {

    private TestContext testContext;

    public AccountsApiSteps(TestContext testContext) {
        this.testContext = testContext;
    }

    @Given("I establish a connection to the api service")
    public void iEstablishAConnectionToTheApiService() {
        testContext.API().ApiUtils.setUpConnection();
    }

    @When("I send a get request to {string}")
    public void iSendAGetRequestTo(String resource) {
        switch (resource) {
            case "/services/data/v61.0/sobjects/Account":
                testContext.API().accounts = testContext.API().ApiUtils.getAllAccounts();
                break;
            case "/services/data/v61.0/sobjects/User":
                testContext.API().users = testContext.API().ApiUtils.getAllUsers();
                break;
            default:
                Assert.fail("Resource not supported: " + resource);
        }
    }

    @When("I send a get request to {string} with Id {string}")
    public void iSendAGetRequestToWithId(String resource, String Id) {
        switch (resource) {
            case "/services/data/v61.0/sobjects/Account/{id}":
                testContext.API().account = testContext.API().ApiUtils.getAccountById(Id);
                break;
            case "/services/data/v61.0/sobjects/User/{id}":
                testContext.API().user = testContext.API().ApiUtils.getUserById(Id);
                break;
            default:
                Assert.fail("Resource not supported: " + resource);
        }
    }

    @Then("I should receive one {string} object")
    public void iShouldReceiveOneObject(String object) {
        switch (object) {
            case "Account":
                Assert.assertNotNull(testContext.API().account);
                break;
            case "User":
                Assert.assertNotNull(testContext.API().user);
                break;
            default:
                Assert.fail("No objects found");
        }
    }


    @Then("I should get more than {int} account result")
    public void iShouldGetMoreThanAccountResult(int number) {
        Assert.assertTrue(testContext.API().accounts.size() > number);
    }
}
