@Pet @petStatus
Feature: All available pet data to be tested

  Scenario:TC01_available_pet_data
    Given user sends petStatus get request
    When user deserializes the available pet data
    Then user saves the available pet data into correspondent files and  verifies the data
