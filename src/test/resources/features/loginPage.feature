Feature: Test login page
  As a user of the Movies App
  I want to check Logo is displayed and enter username and password
  So that I can view result

  Scenario: Test the Login Page UI
    Given I am on the login page
    When I check Logo is display
    When I check Heading Text Login
    When I check username label text
    And I check password label text
    Then I check login button

  Scenario: Login with empty input fields
    Given I am on the login page
    When I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty User ID field
    Given I am on the login page
    When I enter a valid PIN
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with empty PIN field
    Given I am on the login page
    When I enter a valid User ID
    And I click on the login button
    Then an error message '*Username or password is invalid' should be visible

  Scenario: Login with invalid pin
    Given I am on the login page
    When I enter a valid User ID
    And I enter an invalid PIN
    And I click on the login button
    Then an error message '*username and password didn't match' should be visible

  Scenario: Login with invalid username

    Given I am on the login page
    When I enter a valid User ID
    And I enter an invalid User Name
    And I click on the login button
    Then an error username invalid message '*Username or password is invalid' should be visible

  Scenario: Login with invalid UserID password field
    Given I am on the login page
    When I enter an invalid PIN
    And I enter an invalid User Name
    And I click on the login button
    Then an error both invalid message '*Username or password is invalid' should be visible

  Scenario: Successful Login
    Given I am on the login page
    When I enter a valid User ID
    And I enter a valid PIN
    And I click on the login button
    Then I should be redirected to the homepage
