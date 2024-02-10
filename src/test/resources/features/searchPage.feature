Feature: Test Header Section
  As a user of the Movies App
  I want to check Search Page
  So that I can view result


  Scenario: Test Popular Page UI
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    And I should be redirected to the homepage
    And I Test the Search functionality by searching with some movie names
    And I enter the Movie name in search Icon
    Then I count the number of movies display
    Then I clicking movie in search results, redirect to the movie details page


