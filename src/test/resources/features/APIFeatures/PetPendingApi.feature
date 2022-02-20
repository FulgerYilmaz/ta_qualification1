@Pet @getPending
Feature: All pending pet data to be tested

  Scenario:TC01_get_request_pending_pet
    Given user sends petPending get request
    When user deserializes the pending pet data
    Then user saves the pending pet data into correspondent files and  verifies the data