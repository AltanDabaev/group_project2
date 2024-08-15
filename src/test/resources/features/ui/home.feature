Feature: Home page Tests

  Background: Navigating to home page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button


  @US108
  Scenario: Home page should have following nav buttons
    Then Verify "Accounts" navigation button is visible
    Then Verify "Contacts" navigation button is visible
    Then Verify "Cases" navigation button is visible
    Then Verify "Reports" navigation button is visible
    Then Verify "Dashboards" navigation button is visible


