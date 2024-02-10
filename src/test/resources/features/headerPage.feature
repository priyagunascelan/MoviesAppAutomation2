Feature: Test Header Section
  As a user of the Movies App
  I want to check Header UI and Header section functionality
  So that I can view result


  Scenario: Test the Header Section UI
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
    When I test website logo is display
    And I test search icon is display
    And I test Account icon is display
    Then I test Navbar elements

  Scenario: Test the Header Section Functionalities
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
    When I Test the navigation to Home
    And I Test Popular pages through elements in header section
    Then I Test whether the movies are displayed
