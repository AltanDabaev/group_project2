package utils;

import core.TestContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

public class ApiUtils {
    private TestContext testContext;

    public ApiUtils(TestContext testContext){
        this.testContext = testContext;
    }

    public void setUpConnection() {
        testContext.API().requestSpecification = RestAssured.given();
        testContext.API().requestSpecification.baseUri(ConfigReader.readProperty("base-url"));
        testContext.API().requestSpecification.auth().oauth2(getBearerToken());
    }

    public String getBearerToken() {
        Map<String, String> data = new HashMap<>();
        data.put("grant_type", "password");
        data.put("username", ConfigReader.readProperty("username"));
        data.put("client_id", ConfigReader.readProperty("consumer_key"));
        data.put("client_secret", ConfigReader.readProperty("consumer_secret"));
        data.put("password", ConfigReader.readProperty("password")
                + ConfigReader.readProperty("security_token"));

        return RestAssured.given()
                .contentType(ContentType.URLENC)
                .formParams(data)  // Use formParams for x-www-form-urlencoded data
                .when()
                .post(ConfigReader.readProperty("auth_url"))
                .jsonPath()
                .getString("access_token");
    }


}
