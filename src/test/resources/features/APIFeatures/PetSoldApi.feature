Feature: All sold pet data to be tested

  @PetSold
  Scenario: sold pet data to be tested
    And user sends petStatusSold get request
    When user deserializes the sold pet data
    Then user saves the sold pet data into correspondent files and  verifies the data