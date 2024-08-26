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

  @US-17
  Scenario: Verify user can create account
    When I create a new Account with following fields populated:
      | Account Number | 112233445                 |
      | Account Name   | Account - {current_time} |
      | Type           | Prospect                  |
    Then Verify Account header has given Account name