Feature: Account page tests
  Background: Navigate to Accounts page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "View All" button
    Then Verify "AppExchange" option is visible