Feature: Test Header Section
  As a user of the Movies App
  I want to check Movie details Page
  So that I can view result


  Scenario: Test Home Page UI
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    But I should be redirected to the homepage
    Then I in the Home Page click on any Movie and test all the UI elements present in it

  Scenario: Test Popular Page UI
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
    When I Test Popular pages through elements in header section
    And I Test whether the movies are displayed
    Then I in the Popular Page click on any Movie and test all the UI elements present in it



