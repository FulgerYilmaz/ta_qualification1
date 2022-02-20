@Pet @getPetId
Feature:get request

  Scenario:TC01_get_request
    Given user sends get request for 7574746 pet id
    Then user prints to response on terminal
    Then user verifies that status code is 200
    And user confirms that name field is "Hardy"
