@UploadDownload @UI
Feature: US02 UploadDownload

  Background:
    Given user goes to landing page
    And user presses the element button

  Scenario:TC01_Upload_and_Download
    When user clicks the upload button
    And user chooses the file button
    Then verify the visibility of the selected file
    When user download a file
    Then Verify the visibility of the downloaded file
