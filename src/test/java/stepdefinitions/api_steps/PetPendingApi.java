package stepdefinitions.api_steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.ReadTxt;
import utilities.WriteToTxt;

import java.util.ArrayList;
import java.util.List;

import static utilities.ApiRequestsUtils.getRequest;

public class PetPendingApi {

        Response response;
        String petFindByStatus = ConfigReader.getProperty("petFindByStatusPending");
        String fileNamePending = ConfigReader.getProperty("fileNamePending");
        pojos.petStatusOut[] petStatusOut;


        @Given("user sends petPending get request")
        public void user_sends_petPending_get_request() {
            response = getRequest(petFindByStatus);
            response.prettyPrint();
        }
        @When("user deserializes the pending pet data")
        public void user_pending_the_sold_pet_data() throws JsonProcessingException {
            ObjectMapper obj = new ObjectMapper();
            petStatusOut = obj.readValue(response.asString(), pojos.petStatusOut[].class);
            System.out.println("size: "+petStatusOut.length);
        }
        @Then("user saves the pending pet data into correspondent files and  verifies the data")
        public void user_saves_the_pending_pet_data_into_correspondent_files_and_verifies_the_data() {
            WriteToTxt.PetPendingData(fileNamePending, petStatusOut);

            List<String> expectedData = new ArrayList<>();
            expectedData.add("12");
            expectedData.add("32777890");
            expectedData.add("20593238");
            System.out.println(expectedData);

            ReadTxt.petStatusData(fileNamePending);
            List<String> actualData = ReadTxt.petStatusId(fileNamePending);
            Assert.assertTrue(actualData.containsAll(expectedData));
            System.out.println(actualData);

        }
    }
