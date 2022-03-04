@webTables @UI @smoke
Feature: US01 WebTables

  Background:
    Given user goes to landing page
    And user presses the element button

  Scenario Outline:TC01_ADD_USER
    And user presses the web tables button
    And user clicks the add button
    And user writes firstName "<firstname>"
    And user writes lastName "<lastName>"
    And user writes email "<email>"
    And user writes age "<age>"
    And user writes salary "<salary>"
    And user writes department "<department>"
    And user clicks the submit button
    And user enters "<firstname>" in search button
    Then verify the firstName added"<firstname>"

    Examples:
      | firstname | lastName   | email             | age | salary | department |
      | abdullah  | mujahideen | mucahit@gmail.com | 34  | 30000  | IT         |
      | zehra     | bektas     | zhra@gmail.com    | 25  | 50000  | TESTER     |
      | lion      | tiger      | aslan@gmail.com   | 12  | 70000  | TESTER     |


