@dataPicker
Feature: US03 date picker_maple

  Background:
    Given user goes to landing page
    And user presses widget section
    And user presses the date picker button

  Scenario Outline:TC02_date_picker_calender
    And User clicks calender
    And user writes "<year>","<month>","<day>"
    And verify that info "<year>","<month>","<day>"

    Examples:
      | year  |month| day|
      | 1971  | 03   | 12 |
      | 2000  | 12   | 31 |
      | 1999  | 01   | 01 |
      | 2100  | 12   | 12 |
      | 1999  | 02   | 28 |
