package stepdefinitions.api_steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class postPetRequestStepDef {

    HashMap<String,Object> requestBody;
    ExpectedData expectedData= new ExpectedData();
    Response response;
    String url;

    @Given("user sends a Post request")
    public void user_sends_a_post_request() {
         url="https://petstore.swagger.io/v2/store/order";

    }

    @Then("user verifies that status code is {int}.")
    public void userVerifiesThatStatusCodeIs(int statusCode) {

        Assert.assertTrue(response.getStatusCode()==statusCode);

    }

    @And("Validates user Id and petId fields")
    public void ValidatesuserIdandpetIdfields() {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(requestBody.get("petId"),jsonPath.getInt("petId"));

    }

    @Then("creates data with userID {int} petId {int}")
    public void createsDataWithUserIDPetId(int arg0, int arg1) {
        requestBody=expectedData.postData();
        System.out.println(requestBody);
        response=given().contentType(ContentType.JSON).body(requestBody).when().post(url);
        response.prettyPrint();


    }
}

