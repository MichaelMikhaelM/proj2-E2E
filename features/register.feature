Feature: Register Page
  Scenario: A user registers an account with valid inputs
    Given A user is on the register page
    When A user inputs valid registration credentials in the registration form
    Then The user will be brought back to the login page
  Scenario: A user attempts to register an account with invalid inputs
    Given A user is on the register page
    When A user inputs invalid registration credentials in the registration form
    Then An error message will display