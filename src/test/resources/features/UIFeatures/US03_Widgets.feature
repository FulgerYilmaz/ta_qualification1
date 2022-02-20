@dataPicker
Feature: US03 date picker_maple

  Background:
    Given user goes to landing page
    And user presses the element button

  Scenario:TC01_date_picker
    When user clicks calender
    And User selects Year, Month, Day
      | Year | Month | Day |
      | 2000 | May   | 01  |
    Then User verifies that date and time can be selected

  Scenario Outline:TC02_date_picker_calender
    And User clicks calender
    And verify that info "<year>","<month>","<day>"

    Examples:
      | year  |month| day|
      | 1971  | 03   | 12 |
      | 2000  | 12   | 31 |
      | 1999  | 01   | 01 |
      | 2100  | 12   | 12 |
      | 1999  | 02   | 28 |


  Scenario:TC02_time
    And user clicks widgets tab
    And user selects the year "2011"
    And user selects month 12
    And user selects day 19
    And user selects time "11:45"
    Then user verifies date "2011","12","19","11:45"