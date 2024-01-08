Feature: Popular Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Test whether the popular page movies are displayed or not
    Given I am on the home page
    When I click on the popular route option
    Then the popular movies should be visible on popular page


  Scenario: Test the navigation to any one movie on popular page
    Given I am on the home page
    When I click on the popular route option
    And I click on a movie in popular page
    Then I should be navigate to that movie details page through popular page


