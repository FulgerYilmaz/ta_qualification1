package stepdefinitions;

import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {

    @Before(value = "@UI")
    public void beforeScenario() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }

    @Before(value = "@Api")
    public void beforeApi() {

        RestAssured.baseURI = ConfigReader.getProperty("api_base_url");
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver())
                .getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        Driver.closeDriver();
    }
}