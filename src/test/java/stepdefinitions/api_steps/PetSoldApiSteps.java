package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petStatusOut;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApiRequestsUtils.getRequest;

public class PetSoldApiSteps {

    Response response;
    String petFindByStatusEndpoint = "/pet/findByStatus?status=sold";
    String fileNameSold = ConfigReader.getProperty("fileNameSold");
    pojos.petStatusOut[] petStatusOut;

    @Given("user sends petStatusSold get request")
    public void user_sends_petStatusSold_get_request() {
        response = getRequest(petFindByStatusEndpoint);
    }
    @When("user deserializes the sold pet data")
    public void user_deserializes_the_sold_pet_data() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        petStatusOut = obj.readValue(response.asString(), petStatusOut[].class);
    }

    @Then("user saves the sold pet data into correspondent files and  verifies the data")
    public void user_saves_the_sold_pet_data_into_correspondent_files_and_verifies_the_data() {
        WriteToTxt.petApiData(fileNameSold, petStatusOut);
        List<String> expectedData = new ArrayList<>();

        expectedData.add("9");
        expectedData.add("38852226");
        expectedData.add("9223372016854961249");

        List<String> actualData = ReadTxt.petStatusId(fileNameSold);
        Assert.assertTrue(actualData.containsAll(expectedData));
    }
}


