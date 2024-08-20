package utils;

import core.TestContext;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import pojo.Account;
import pojo.User;

import java.util.HashMap;
import java.util.List;
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

    public List<Account> getAllAccounts() {
        testContext.API().requestSpecification.basePath("/services/data" +
                "/v61.0/sobjects/Account");
        testContext.API().response = testContext.API().requestSpecification
                .get();
        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getList("recentItems", Account.class);
    }

    public Account getAccountById(String Id) {
        testContext.API().requestSpecification.basePath("/services/data" +
                "/v61.0/sobjects/Account/" + Id);
        testContext.API().response = testContext.API().requestSpecification
                .get();
        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getObject("", Account.class);
    }

    public List<User> getAllUsers() {
        testContext.API().requestSpecification.basePath("/services/data" +
                "/v61.0/sobjects/User");
        testContext.API().response = testContext.API().requestSpecification
                .get();
        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getList("recentItems", User.class);
    }

    public User getUserById(String Id) {
        testContext.API().requestSpecification.basePath("/services/data" +
                "/v61.0/sobjects/User/" + Id);
        testContext.API().response = testContext.API().requestSpecification
                .get();
        JsonPath jsonPath = testContext.API().response.jsonPath();
        return jsonPath.getObject("", User.class);
    }
}
