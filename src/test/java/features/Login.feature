Feature: Login Functionality

  Scenario: Login with valid credentials
    Given User is on the login page
    When User enters email "hardstop-pharmacist6@mailinator.com"
    And User enters password "Password1#"
    And User clicks on the Sign In button
    Then User should be logged in successfully

