Feature: Home Page
  As a user of the movies website
  I am able to log in to my account
  So that i can access personalised feature and watch movies

  Scenario: Test the heading texts of each section
    Given I am on the home page
    When I am on home page first heading should be 'Trending Now'
    Then the second heading should be 'Originals'
    And play button should be visible on the home page
    And Trending now movies should be visible
    And Originals movies should be visible
    And contact us icons should be visible
    And contact us Section should be visible