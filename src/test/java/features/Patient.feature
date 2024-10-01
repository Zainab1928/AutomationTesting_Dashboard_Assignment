Feature: Patient Search Functionality

  Scenario Outline: Search for a patient by ID and set a calender date
    Given User is logged in successfully with "<username>" and "<password>"
    When User clicks on the Patient button for patient search
    And User enters the patient ID "<patientId>"
    And User clicks on the Reports button
    And User selects the date 10 days back
    Then User clicks on the Date Converstion button
    And User logs out of the application
    Then User close browser

    Examples:
      | username                            | password   | patientId|
      | hardstop-pharmacist6@mailinator.com | Password1# | da7e9e65-a268-4ea2-adc6-a2d8cd1b64d9|


