package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:test-output/default-cucumber-reports.html",
                "json:test-output/json-reports/cucumber.json",
                "junit:test-output/xml-reports/cucumber.xml",
                "rerun:test-output/failedRerun.txt"
        },
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke",
        dryRun = false
)
public class TestRunner {
}
