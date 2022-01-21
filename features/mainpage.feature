Feature: Main Page
  Background: A user is on the Main page
  Scenario: Creating a post on the feed
    Given A user is on the Main Page
    When A user creates a post in the post area
    Then A post is made
  Scenario: Viewing your posted pictures
    Given A user is on the Main Page
    When a user clicks view pictures
    Then The user will be taken to their picture page
  Scenario: Viewing the main feed
    Given A user is on the Main Page
    When A user clicks Feed to view their feed
    Then The user will be brought to their feed
  Scenario: Logging out
    Given A user is on the Main Page
    When A user clicks the logout button
    Then The user will be brought to the login page




