Feature: Patient Search Functionality

  Scenario: Search for a patient by ID and set a review date
    Given User is logged in successfully for patient search
    When User clicks on the Patient button for patient search
    And User enters the patient ID "da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9"
    And User clicks on the Reports button
    And User selects the date 10 days back
    Then User clicks on the Date Converstion button




