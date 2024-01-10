Feature: Account Page
  As a user of the application
  I want to interact with the Account Page to review
  and update my information and log out securely.

  Scenario: Test all the UI elements present on the account page
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click profile route option on header section
    And I should be redirected to the profile route section
    When I am on account page
    Then account heading should be visible on account page
    And membership heading should be visible on account page
    And plan details heading should be visible on account page
    And account user name should be visible on account page
    And account password should be visible on account page
    And account plan type should be visible on account page
    And account plan details should be visible on account page
    And account logout button should be visible on account page


  Scenario: Test the logout functionality from account page to login page
    Given I am on the login page
    And I enter valid username as 'rahul'
    And I enter valid password as 'rahul@2021'
    And I click the login button
    And I should be redirected to the home page
    And I click profile route option on header section
    And I should be redirected to the profile route section
    When I click on logout button on account page
    Then I should be redirected to the login page
