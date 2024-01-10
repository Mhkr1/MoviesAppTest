Feature: Popular Page
  As a user of the movies website
  I want to navigate to the Popular Page
  view the listed movies, and explore details of a specific movie.


  Scenario: Test whether the popular page movies are displayed or not
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click popular route option on header section
    Then the popular movies should be visible on popular page


  Scenario: Test the navigation to any one movie on popular page
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click popular route option on header section
    And the popular movies should be visible on popular page
    When I click on a movie in popular page
    Then I should be navigate to that movie details page


