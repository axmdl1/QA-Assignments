Feature: User login on F1 Tickets website

  As a registered user
  I want to log in to the F1 Tickets website
  So that I can continue ticket purchase

  Scenario: Successful login with valid credentials
    Given the user is on the F1 Tickets checkout page
    And the user clicks on "Already have an account"
    When the login modal is opened
    And the user enters a valid email
    And the user enters a valid password
    And the user clicks the Sign In button
    Then the user should be logged in successfully

   Scenario: Login with invalid credentials
     Given the user is on the F1 Tickets checkout page
     And the user clicks on "Already have an account"
     When the login modal is opened
     And the user enters an invalid email
     And the user enters an invalid password
     And the user clicks the Sign In button
     Then an error message should be displayed