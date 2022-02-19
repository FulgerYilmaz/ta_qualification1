Feature: All available pet data to be tested


@Pet
  Scenario: available pet data to be tested
    And user sends petStatus get request
    When user deserializes the available pet data
   Then user saves the available pet data into correspondent files and  verifies the data
