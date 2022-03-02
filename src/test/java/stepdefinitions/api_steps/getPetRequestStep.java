package stepdefinitions.api_steps;

import io.cucumber.java.en.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class getPetRequestStep {


      Response response;

    @Given("user sends get request for {int} pet id")
    public void user_sends_get_request_for_pet_id(int id) {
        response=given().accept("application/json").when().get(String.valueOf(id));

    }
    @Then("user prints to response on terminal")
    public void user_prints_to_response_on_terminal() {
        response.prettyPrint();

    }
    @Then("user verifies that status code is {int}")
    public void user_verifies_that_status_code_is(int statusCode) {
        Assert.assertTrue(response.getStatusCode()==statusCode);

    }
    @Then("user confirms that name field is {string}")
    public void user_confirms_that_name_field_is(String expectedName) {
        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(expectedName,jsonPath.getString("name"));
    }

}
