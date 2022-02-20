package stepdefinitions.ui_step_defs;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US03_WidgetsPage;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Month;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class US03_WidgetsStepDefinitions {
      Actions actions = new Actions(Driver.getDriver());
      US03_WidgetsPage datePicker = new US03_WidgetsPage();

    @And("user clicks calender")
    public void user_clicks_calender() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        Driver.waitAndClick( datePicker.dataPickerTab);
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);

    }
        String expectedYear, expectedDay, expectedMonth;
        JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();

    @Given("User selects Year, Month, Day")
    public void User_selects_Year_Month_Day (List<Map<String, String>> dateTable) {
        for (Map<String, String> map : dateTable) {
            ReusableMethods.waitFor(1);
            Select selectYear = new Select(datePicker.selectYear);
            selectYear.selectByValue(map.get("Year"));
            Select selectMonth = new Select(datePicker.selectMonths);
            selectMonth.selectByVisibleText(map.get("Month"));
            String month = map.get("Month");
            expectedYear = map.get("Year");
            List<WebElement> days = null;
            switch (month.toLowerCase()) {
                case "january":
                    days = datePicker.january;
                    expectedMonth = "01";
                    break;
                case "february":
                    days = datePicker.february;
                    expectedMonth = "02";
                    break;
                case "march":
                    days = datePicker.march;
                    expectedMonth = "03";
                    break;
                case "april":
                    days = datePicker.april;
                    expectedMonth = "04";
                    break;
                case "may":
                    days = datePicker.may;
                    expectedMonth = "05";
                    break;
                case "june":
                    days = datePicker.june;
                    expectedMonth = "06";
                    break;
                case "july":
                    days = datePicker.july;
                    expectedMonth = "07";
                    break;
                case "august":
                    days = datePicker.august;
                    expectedMonth = "08";
                    break;
                case "september":
                    days = datePicker.september;
                    expectedMonth = "09";
                    break;
                case "october":
                    days = datePicker.october;
                    expectedMonth = "10";
                    break;
                case "november":
                    days = datePicker.november;
                    expectedMonth = "11";
                    break;
                case "december":
                    days = datePicker.december;
                    expectedMonth = "12";
                    break;
            }
            for (WebElement day : days) {
                ReusableMethods.waitFor(2);
                if ((day.getText()).equals(map.get("Day"))) {
                    expectedDay = day.getText();
                    ReusableMethods.waitFor(2);
                    actions.click(day).perform();
                    break;
                }
            }
        }
    }
        @Then("User verifies that date and time can be selected")
        public void User_verifies_that_date_and_time_can_be_selected() {
            System.out.println(expectedMonth + "/" + expectedDay + "/" + expectedYear);
            System.out.println(datePicker.dataPickerTab.getAttribute("value"));
            Assert.assertEquals(expectedMonth + "/" + expectedDay + "/" + expectedYear, datePicker.dataPickerTab.getAttribute("value"));
        }

        @And("User clicks calender")
        public void User_clicks_calender() {

          Driver.waitAndClick(datePicker.dateSelected1);
        }

        @And("user writes {string},{string},{string}")
        public void user_writes (String year, String months, String day) {
        // year
        Select dropdownYear = new Select(datePicker.selectYear);
        dropdownYear.selectByVisibleText(year);
        // months
        int dataMonths = Integer.parseInt(months) - 1;
        Select dropdownAy = new Select(datePicker.selectMonths);
        dropdownAy.selectByIndex(dataMonths);
        ReusableMethods.waitFor(1);
        // day
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
        public void verify_that_info(String year, String months, String day) {
        String sendDate = months + "/" + day + "/" + year;
       // System.out.println("send date:  " + months + "/" + day + "/" + year);
        System.out.println("respond date: " + datePicker.dateLastTab.getAttribute("value"));
        System.out.println("-----------------------------------------------------------");
        Assert.assertTrue(datePicker.dateLastTab.getAttribute("value").equals(sendDate));

    }
        @Given("user clicks widgets tab")
        public void user_clicks_widgets_tab() {

        Driver.waitAndClick(datePicker.widgetTab);
    }

        @And("user selects the year {string}")
        public void user_enters_the_year(String arg0) {
        datePicker.selectDateYear.click();
        jsx.executeScript(arg0,datePicker.selectDateYear);
        //jsx.executeScript("return arguments[0].scrollIntoView(true);", new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(datePicker.getYear(arg0))));
        // ((JavascriptExecutor)Driver.getDriver()).executeScript("return arguments[0].scrollIntoView(true);", new WebDriverWait(Driver.getDriver(), 20).until(ExpectedConditions.elementToBeClickable(datePicker.getYear(arg0))));
        actions.click(datePicker.getYear(arg0)).perform();

/*
         Calendar calendar = Calendar.getInstance();
         int difference = calendar.get(calendar.YEAR) - Integer.parseInt(arg0);
         if (difference < 5 && difference > -5) {
         actions.click(datePicker.getYear(arg0)).perform();
       } else if (difference > 5) {
         jsx.executeScript("window.scrollBy(0,200)", "");
            for (int k = 1; k <= fark - 5; k++) {
                ReusableMethods.waitFor(1);
                actions.click(datePicker.pastYear).perform();
            }
         actions.click(datePicker.getYear(arg0)).perform();
        }
*/
    }


          @And("user selects month 12")
          public void user_selects_month12(int arg0) {

          jsx.executeScript("window.scrollBy(0,100)", "");
          datePicker.selectDateMonth.click();
          datePicker.getMonth(arg0).click();
    }
          @And("user selects day 19")
          public void user_selects_day19 (int day) {

          ReusableMethods.waitFor(1);
             for (int m = 1; m < 8; m++) {
          ReusableMethods.waitFor(1);
          WebElement dateFromCalender = datePicker.getDay(m);
            if (dateFromCalender.getText().equals("1")) {
                int certainDay = day;
                datePicker.getDay((m + certainDay - 1)).click();
                ReusableMethods.waitFor(1);
                break;
            } else {
                continue;
            }
        }
    }

         @And("user selects time {string}")
         public void user_selects_time(String arg0) {

          ReusableMethods.jsClick( datePicker.getHour(arg0));

    }
         @Then("user verifies date {string},{string},{string},{string}")
         public void user_verifies_date(String arg0, String arg1, String arg2, String arg3)  {

        String a=datePicker.DateResultTab.getAttribute("value");
        String[] gelenbol = a.split(" ");
        Calendar expectedDate = Calendar.getInstance();
        expectedDate.set(Calendar.YEAR, Integer.parseInt(gelenbol[2]));
        expectedDate.set(Calendar.MONTH, Month.valueOf(gelenbol[0].toUpperCase()).getValue()-1);
        expectedDate.set(Calendar.DATE, Integer.parseInt(gelenbol[1].substring(0,2)));
        expectedDate.set(Calendar.HOUR,Integer.parseInt(gelenbol[3].split(":")[0]));
        expectedDate.set(Calendar.MINUTE,Integer.parseInt(gelenbol[3].split(":")[1]));
        java.util.Date actualDate = expectedDate.getTime();
        System.out.println("actualDate = "+actualDate);

        Calendar selectedDate = Calendar.getInstance();
        String[] bol = arg3.split(":");

        selectedDate.set(Calendar.YEAR, Integer.parseInt(arg0));
        selectedDate.set(Calendar.MONTH, Integer.parseInt(arg1)-1);
        selectedDate.set(Calendar.DATE, Integer.parseInt(arg2));
        selectedDate.set(Calendar.HOUR,Integer.parseInt(bol[0])+1);
        selectedDate.set(Calendar.MINUTE,Integer.parseInt(bol[1]));
        java.util.Date sendingDate = selectedDate.getTime();

        System.out.println("selectedDate = "+sendingDate);
        System.out.println("compare the date " + expectedDate.equals(sendingDate));
        Assert.assertTrue(sendingDate.compareTo(actualDate)==0);
    }
}