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

public class PetSoldApiSteps {

        Response response;
        String petFindByStatus = ConfigReader.getProperty("petFindByStatusSold");
        String fileNameSold = ConfigReader.getProperty("fileNameSold");
        pojos.petStatusOut[] petStatusOut;

        @Given("user sends petStatusSold get request")
        public void user_sends_petStatusSold_get_request() {
            response = getRequest(petFindByStatus);
            response.prettyPrint();
        }
        @When("user deserializes the sold pet data")
        public void user_deserializes_the_sold_pet_data() throws JsonProcessingException {
            ObjectMapper obj = new ObjectMapper();
            petStatusOut = obj.readValue(response.asString(), petStatusOut[].class);
            System.out.println("size: "+petStatusOut.length);
        }
        @Then("user saves the sold pet data into correspondent files and  verifies the data")
        public void user_saves_the_sold_pet_data_into_correspondent_files_and_verifies_the_data() {
            WriteToTxt.PetApiData(fileNameSold, petStatusOut);
            List<String> expectedData = new ArrayList<>();

            expectedData.add("12");
            expectedData.add("32777890");
            expectedData.add("20593238");
            System.out.println(expectedData);

            ReadTxt.petStatusData(fileNameSold);
            List<String> actualData = ReadTxt.petStatusId(fileNameSold);
            Assert.assertTrue(actualData.containsAll(expectedData));
            System.out.println(actualData);

        }
    }


