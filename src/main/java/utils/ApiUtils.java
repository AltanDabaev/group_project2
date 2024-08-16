package utils;

import core.TestContext;
import io.restassured.RestAssured;

public class ApiUtils {
    private TestContext testContext;

    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    public void setUpConnection() {
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.baseUri(ConfigReader.readProperty("base-url"));
        //testContext.API().requestSpecification.auth().oauth2(getBearerToken());
    }

}
