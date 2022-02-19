Feature: US08_UploadDownload


  Background:
    Given user goes to landing page
    Then user presses the elements button

  Scenario: TC_01_Upload
    When user clicks the upload button
    When user chooses the file button
    Then verify the visibility of the selected file
    Then user download a file
    And Verify the visibility of the downloaded file
