package stepdefinitions.api_steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class postPetRequestStepDef {

    HashMap<String, Object> requestBody;
    Response response;
    String endpoint;

    @Given("user sends a Post request")
    public void user_sends_a_post_request() {
        endpoint = "/store/order";
    }

    @Then("user verifies that status code is {int}.")
    public void userVerifiesThatStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @And("Validates user Id and petId fields")
    public void ValidatesuserIdandpetIdfields() {
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(requestBody.get("petId"), jsonPath.getInt("petId"));
    }

    @Then("creates data with userID {int} petId {int}")
    public void createsDataWithUserIDPetId(int userId, int petId) {
        requestBody = createReqBody(userId, petId);
        response = given().contentType(ContentType.JSON).body(requestBody).when().post(endpoint);
        response.prettyPrint();
    }

    public HashMap<String, Object> createReqBody(int userId, int petId) {
        HashMap<String, Object> reqBody = new HashMap<>();
        reqBody.put("id",userId);
        reqBody.put("petId", petId);
        reqBody.put("quantity", 0);
        reqBody.put("shipDate", "2022-02-19T20:34:01.698Z");
        reqBody.put("status", "placed");
        reqBody.put("complete", true);
        return reqBody;
    }
}

