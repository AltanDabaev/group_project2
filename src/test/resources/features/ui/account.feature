Feature: Account page tests
  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button
    And I click "Accounts" button


  @US118
  Scenario: Edit existing Account
    And I click "first" item from recently view window
    And I click edit "Details" button
    And I edit Accounts following fields:
      | accountName   | Aliia - Test   |
    Then Verify Account name is "Aliia - Test"







