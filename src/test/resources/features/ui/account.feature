Feature: Account page tests

  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button
    And I click "Accounts" button

  @US-16
  Scenario: Verify 1 Account has 5 headers displayed.
    And I click each account and verify the following headers are present:
      | Type          |
      | Phone         |
      | Website       |
      | Account Owner |
      | Industry      |
