Feature: Ticket purchase flow on F1 Tickets website

  As a visitor
  I want to select a Formula 1 ticket
  So that I can proceed to checkout

  @smoke
  Scenario: User adds ticket to cart
    Given the user is on the main F1 Tickets page
    When the user selects Azerbaijan GP ticket
    And the user adds the ticket to the cart
    Then the cart should contain the ticket

  @regression
  Scenario: User proceeds to checkout
    Given the ticket is already in the cart
    When the user proceeds to checkout
    Then the checkout page should be opened