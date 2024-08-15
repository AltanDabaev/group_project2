package stepDefs.uiSteps;

import core.TestContext;
import io.cucumber.java.en.Given;

public class LoginSteps {

    private final TestContext testContext;
    public LoginSteps(TestContext testContext) {this.testContext = testContext;}

    @Given("I login to salesforce app")
    public void i_login_to_salesforce_app() {testContext.UI().getLoginPage().loginAsAdmin();}
}
