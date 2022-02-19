@dataPicker
Feature: US_14_dataPicker_maple

  Background:
    Given user goes to landing page
    Then user presses the elements button


  Scenario: datePicker
    And user clicks datePicker
    And User selects Year, Month, Day
      | Year | Month | Day |
      | 2000 | May   | 01  |
    Then User verifies that date and time can be selected

  @try
  Scenario Outline: TC_02 Outline with datePicker
    And User clicks calendar
    And user writes "year","months","day"
    And verify that info "<year>","<months>","<day>"

    Examples:
      | year  |months| day|
      | 1971  | 03   | 12 |
      | 2000  | 12   | 31 |
      | 1999  | 01   | 01 |
      | 2100  | 12   | 12 |
      | 1999  | 02   | 28 |


  Scenario: TC_03 time
    And user clicks widgets tab
    And user selects the year "2011"
    And user selects months "12"
    And user selects day " "
    And user selects time "11:45"
    And user selects time " "
    Then user verifies date "2011","12","19","11:45"