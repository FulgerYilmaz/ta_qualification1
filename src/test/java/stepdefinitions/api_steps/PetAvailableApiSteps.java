package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.petStatusOut;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApiRequestsUtils.getRequest;

public class PetAvailableApiSteps {

    Response response;
    String EndPointPetFindByStatus = ConfigReader.getProperty("petFindByStatusAvailable");
    String fileNameAvailable = ConfigReader.getProperty("fileNameAvailable");
    petStatusOut [] petStatusOut;


    @Given("user sends petStatus get request")
    public void user_sends_appointments_get_request() {
        response = getRequest(EndPointPetFindByStatus);
        response.prettyPrint();
    }
    @When("user deserializes the available pet data")
    public void user_deserializes_the_available_pet_data() throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        petStatusOut = obj.readValue(response.asString(), petStatusOut[].class);
        System.out.println("size: "+petStatusOut.length);
    }
    @Then("user saves the available pet data into correspondent files and  verifies the data")
    public void user_saves_the_available_pet_data_into_correspondent_files_and_verifies_the_data() {
        WriteToTxt.PetApiData(fileNameAvailable, petStatusOut);
        List<String> expectedData = new ArrayList<>();
        expectedData.add("9223372000001084062");
        expectedData.add("9223372000001084063");
        expectedData.add("9223372000001084064");
        System.out.println(expectedData);

        ReadTxt.petStatusData(fileNameAvailable);
        List<String> actualData = ReadTxt.petStatusId(fileNameAvailable);
        Assert.assertTrue(actualData.containsAll(expectedData));
        System.out.println(actualData);


    }
}
