Feature: Login Page
  Scenario: Logging in with valid credentials will bring user to dashboard
    Given A user is on the Login page
    When A user inputs valid credentials on the login form
    Then The user will be brought to the dashboard
  Scenario:Logging in with invalid credentials will display an error message
    Given A user is on the Login page
    When A user inputs invalid credentials on the login form
    Then The user will be given an invalid login message
  Scenario: Clicking the Register Button will take user to registration page
    Given A user is on the Login page
    When A user clicks the register button
    Then The user is brought to the register page
  Scenario: Click the Fogot Password Button will take user to the forgot password page
    Given A user is on the Login page
    When A user clicks the forgot password button
    Then The user is brought to the reset password page