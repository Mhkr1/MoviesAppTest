Feature: Test the header section elements and functionalities on Home Page
  As a user exploring the application
  I want to ensure that the header section is functional
  and provides easy navigation options.


  Scenario: Test whether the UI elements of header section displayed or not
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I am on home page first heading should be 'Trending Now'
    Then the website logo should be visible
    And the home route should be visible
    And the popular route should be visible
    And the search icon should be visible
    And the profile image should be visible


  Scenario: Test the navigation to popular page through elements in header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click popular route option on header section
    Then I should be redirected to the popular route section


  Scenario: Test the navigation to profile page through elements in header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click profile route option on header section
    Then I should be redirected to the profile route section


  Scenario: Test the navigation to search page through elements on header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I am on home page first heading should be 'Trending Now'
    When I click search icon option on header section
    Then I should be redirected to the search page


  Scenario: Test the navigation to home page from popular page on header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click popular route option on header section
    And I should be redirected to the popular route section
    And I click home route on header section
    Then I should be redirected to the home page


  Scenario: Test the navigation to home page from profile page on header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    When I click profile route option on header section
    And I should be redirected to the profile route section
    And I click home route on header section
    Then I should be redirected to the home page


  Scenario: Test the navigation to home page from search page on header section
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click search icon option on header section
    And I should be redirected to the search page
    When I click home route on header section
    Then I should be redirected to the home page

