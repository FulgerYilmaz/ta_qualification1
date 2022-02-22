@Api @postRequest
Feature:post_request

  Scenario:TC01_post_request
    Given user sends a Post request
    Then creates data with userID 8 petId 9
    Then user verifies that status code is 200.
    And Validates user Id and petId fields
