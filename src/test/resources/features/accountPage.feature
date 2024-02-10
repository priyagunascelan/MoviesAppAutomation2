Feature: Test Header Section
  As a user of the Movies App
  I want to check Movie details Page
  So that I can view result


  Scenario: Test Popular Page UI
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
    When I Test the navigation to account page through elements in header section
    When I Test all the UI elements present on the Account page
    Then I Test the Logout functionality
