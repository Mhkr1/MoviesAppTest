Feature: Home Page
  As a user of the application,
  I want to seamlessly navigate the Home Page,
  So that I can discover trending content, watch movies, and access the contact information.


  Scenario: Test the heading texts of each section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I am on home page first heading should be 'Trending Now'
    Then the second heading should be 'Originals'
    And play button should be visible on the home page
    And Trending now movies should be visible
    And Originals movies should be visible
    And contact us google icon should be visible
    And contact us twitter icon should be visible
    And contact us instagram icon should be visible
    And contact us youtube icon should be visible
    And contact us Section should be visible