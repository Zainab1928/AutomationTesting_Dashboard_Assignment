Feature: Verify draggable table headings in the Patient Task

  Scenario: Verify table heading drag functionality after login
    Given User is logged in
    When User clicks on patient tab
    And User enters patient ID "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
    And User clicks on the task tab
#    Then User verifies that the table headings are draggable
