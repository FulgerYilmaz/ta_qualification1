package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;
import static base_url_setup.PetStoreBaseUrl.petstore;

public class Hooks {

    @Before(value="@UI")
    public void beforeScenario() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }
    @Before(value="@Api")
    public void beforeApi() {
        petstore();
    }

    @After(value="@UI")
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
    }
}