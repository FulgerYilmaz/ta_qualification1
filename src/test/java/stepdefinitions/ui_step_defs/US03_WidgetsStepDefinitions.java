package stepdefinitions.ui_step_defs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US03_WidgetsPage;
import utilities.Driver;
import utilities.ReusableMethods;


public class US03_WidgetsStepDefinitions {
      Actions actions = new Actions(Driver.getDriver());
      US03_WidgetsPage datePicker = new US03_WidgetsPage();

    @And("user presses widget section")
    public void userPressesWidgetSection() {
        ReusableMethods.waitFor(1);
        datePicker.widgetTab.click();


    }

    @And("user presses the date picker button")
    public void userPressesTheDatePickerButton() {

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        datePicker.dataPickerTab.click();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
    }
    @And("user clicks calender")
    public void user_clicks_calender() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.waitAndClick( datePicker.dataPickerTab);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
    }
        @And("User clicks calender")
        public void User_clicks_calender() {
        Driver.waitAndClick(datePicker.dateSelected1);
        }
        @And("user writes {string},{string},{string}")
        public void user_writes (String year, String month, String day) {
        //year
        Select dropdownYear = new Select(datePicker.selectYear);
        dropdownYear.selectByVisibleText(year);
        //months
        int dataMonths = Integer.parseInt(month) - 1;
        Select dropdownAy = new Select(datePicker.selectMonths);
        dropdownAy.selectByIndex(dataMonths);
        ReusableMethods.waitFor(1);
        //day
        for (int i = 1; i < 8; i++) {
            ReusableMethods.waitFor(1);
            WebElement calenderDay = datePicker.getDay(i);
            if (calenderDay.getText().equals("1")) {
                int certainDay = Integer.parseInt(day);
                datePicker.getDay((i + certainDay - 1)).click();
                ReusableMethods.waitFor(1);
                break;
            } else {
                continue;
            }
        }
    }
        @And("verify that info {string},{string},{string}")
        public void verify_that_info(String year, String month, String day) {
        String sendDate = month + "/" + day + "/" + year;
        System.out.println("send date:  " + month + "/" + day + "/" + year);
        System.out.println("respond date: " + datePicker.dateLastTab.getAttribute("value"));
        System.out.println("-----------------------------------------------------------");
        Assert.assertTrue(datePicker.dateLastTab.getAttribute("value").equals(sendDate));
    }
}