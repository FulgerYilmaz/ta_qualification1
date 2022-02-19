Feature: All pending pet data to be tested


  @Pet
  Scenario: pending pet data to be tested
    And user sends petPending get request
    When user deserializes the pending pet data
    Then user saves the pending pet data into correspondent files and  verifies the data