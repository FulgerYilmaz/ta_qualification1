package stepdefinitions.ui_step_defs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.US01_WebTablesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US01_WebTablesStepDefinitions {

    US01_WebTablesPage uS01_WebTablesPage = new US01_WebTablesPage();
    static String name="";

    @Given("user goes to landing page")
    public void user_goes_to_landing_page()  {
        Driver.getDriver().get(ConfigReader.getProperty("demoqa_url"));
    }
    @Then("user presses the element button")
    public void user_presses_the_element_button() {
        uS01_WebTablesPage.elementsCard.click();
    }
    @And("user presses the web tables button")
    public void user_presses_the_web_tables_button() {
         ReusableMethods.waitAndClick(uS01_WebTablesPage.webTables, 1);
    }
    @Given("user clicks the add button")
    public void user_click_the_add_button() {
        ReusableMethods.waitAndClick(uS01_WebTablesPage.add, 2);
    }
    @And("user writes firstName {string}")
    public void user_writes_firstName(String arg0) {
        uS01_WebTablesPage.firstName.clear();
        uS01_WebTablesPage.firstName.sendKeys(arg0);
    }
    @And("user writes lastName {string}")
    public void user_writes_lastName(String arg0) {
        uS01_WebTablesPage.lastName.clear();
        uS01_WebTablesPage.lastName.sendKeys(arg0);
    }
    @And("user writes email {string}")
    public void user_writes_email(String arg0) {
        uS01_WebTablesPage.email.clear();
        uS01_WebTablesPage.email.sendKeys(arg0);
    }
    @And("user writes age {string}")
    public void user_writes_age (String arg0) {
        uS01_WebTablesPage.age.clear();
        uS01_WebTablesPage.age.sendKeys(arg0);
    }
    @And("user writes salary {string}")
    public void user_writes_salary (String arg0) {
        uS01_WebTablesPage.salary.clear();
        uS01_WebTablesPage.salary.sendKeys(arg0);
    }
    @And("user writes department {string}")
    public void user_writes_department(String arg0) {
        uS01_WebTablesPage.department.sendKeys(arg0);
    }
    @And("user clicks the submit button")
    public void userClicksTheSubmitButton() {
        uS01_WebTablesPage.submit.click();
        ReusableMethods.waitFor(1);
    }
    @And("user enters {string} in search button")
    public void user_enters_firstName_in_search_button(String arg0) {
        uS01_WebTablesPage.search.sendKeys(arg0);
        ReusableMethods.waitFor(2);
    }
    @Then("verify the firstName added{string}")
    public void verify_the_firstName_added (String firstName) {
        System.out.println(uS01_WebTablesPage.firstRow.getText());
        Assert.assertTrue(uS01_WebTablesPage.firstRow.getText().contains(firstName));
    }
}