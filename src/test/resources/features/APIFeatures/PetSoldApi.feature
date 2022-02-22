@Api @PetSold
Feature: All sold pet data to be tested

  Scenario:TC01_get_request_sold_pet
    And user sends petStatusSold get request
    When user deserializes the sold pet data
    Then user saves the sold pet data into correspondent files and  verifies the data