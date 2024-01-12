Feature: Movie Details Page
  As a user of the movies website
  I want to explore and interact with detailed information
  about movies from different categories.

  Scenario: In the Popular Page click on any Movie and test all the UI elements present in it
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I am on home page first heading should be 'Trending Now'
    And the second heading should be 'Originals'
    And play button should be visible on the home page
    And Trending now movies should be visible
    And Originals movies should be visible
    And contact us icons should be visible
    And contact us Section should be visible
    And I click popular route option on header section
    And the popular movies should be visible on popular page
    When I click on a movie in popular page
    Then I should be navigate to that movie details page
    And the movie title should be visible on movie details page
    And the sensor rating should be visible on movie details page
    And the release year should be visible on movie details page
    And the movie overview should be visible on movie details page
    And the similar movies list should be visible on movie details page
    And the genre list should be visible on movie details page
    And the available audios should be visible on movie details page
    And the rating count should be visible on movie details page
    And the rating average should be visible on movie details page
    And the budget should be visible on movie details page
    And the release date should be visible on movie details page
    And the play button should be visible on movie details page


  Scenario: In the Home Page click on any Trending Movie and test all the UI elements present in it
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I am on home page first heading should be 'Trending Now'
    And the second heading should be 'Originals'
    And play button should be visible on the home page
    And Trending now movies should be visible
    And Originals movies should be visible
    And contact us icons should be visible
    And contact us Section should be visible
    When I click on one trending movie for movies details page
    Then the movie watch time should be visible on movie details page
    And the movie title should be visible on movie details page
    And the sensor rating should be visible on movie details page
    And the release year should be visible on movie details page
    And the movie overview should be visible on movie details page
    And the similar movies list should be visible on movie details page
    And the genre list should be visible on movie details page
    And the available audios should be visible on movie details page
    And the rating count should be visible on movie details page
    And the rating average should be visible on movie details page
    And the budget should be visible on movie details page
    And the release date should be visible on movie details page
    And the play button should be visible on movie details page

  Scenario: In the Home Page click on any Originals Movie and test all the UI elements present in it
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I am on home page first heading should be 'Trending Now'
    And the second heading should be 'Originals'
    And play button should be visible on the home page
    And Trending now movies should be visible
    And Originals movies should be visible
    And contact us icons should be visible
    And contact us Section should be visible
    When I click on one originals movie for movies details page
    Then the movie watch time should be visible on movie details page
    And the movie title should be visible on movie details page
    And the sensor rating should be visible on movie details page
    And the release year should be visible on movie details page
    And the movie overview should be visible on movie details page
    And the similar movies list should be visible on movie details page
    And the genre list should be visible on movie details page
    And the available audios should be visible on movie details page
    And the rating count should be visible on movie details page
    And the rating average should be visible on movie details page
    And the budget should be visible on movie details page
    And the release date should be visible on movie details page
    And the play button should be visible on movie details page


