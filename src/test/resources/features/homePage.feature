Feature: Test Home page
  As a user of the Movies App
  I want to check whether the Movies are displayed
  So that I can play the movie

  Scenario: Test the Home Page
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
    When I test the heading texts of each section
    When I test whether the play button is displayed or not
    And I test whether the Trending Movies are displayed, in the corresponding movies sections
    And I test whether the Original Movies are displayed, in the corresponding movies sections
    Then I test the Contact Us Section