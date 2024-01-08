Feature: Search Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Test the search functionality with empty input
    Given I am on the home page
    When No input was entered
    And I click search button
    Then I should get the count of movies displayed

  Scenario: Test the search functionality with invalid input
    Given I am on the home page
    When I enter invalid movie name 'salaar'
    And I click search button
    Then An error message 'Your search for salaar did not find any matches.' should be visible

  Scenario: Test the search functionality with valid input
    Given I am on the home page
    When I enter valid movie name 'Titanic'
    And I click search button
    Then I should get the count of movies displayed