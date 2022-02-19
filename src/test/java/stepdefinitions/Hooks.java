package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;
import java.io.IOException;
import static base_url_setup.PetStoreBaseUrl.petstore;

public class Hooks {

    @Before(order=2, value="@")
    public void beforeScenario() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Before(order=3, value="@ ")
    public void beforeRegistration() {

        Driver.getDriver().get("https://demoqa.com/account/register");
    }

    @Before(order=3, value="@Api")
    public void beforeApi() {

        petstore();
    }

    @After(order=3, value="@UI")
    public void tearDown(Scenario scenario) throws IOException {


        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}