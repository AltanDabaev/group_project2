package stepDefs;

import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class Hooks {

    private final TestContext testContext;

    public Hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void setUp(Scenario scenario){
        testContext.scenario = scenario;
        testContext.UI().getDriver().get(ConfigReader.readProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            testContext.UI().getBrowserUtils().logFailScreenshot(scenario);
        }
        if (testContext.UI().getDriver() != null)
            testContext.UI().getDriver().quit();
    }


}
