Feature: Home page Tests

  Background: Navigating to home page
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button


  @US103
  Scenario: Home page should have following nav buttons
    Then Verify "Accounts" navigation button is visible
    Then Verify "Contacts" navigation button is visible
    Then Verify "Cases" navigation button is visible
    Then Verify "Reports" navigation button is visible
    Then Verify "Dashboards" navigation button is visible


  @US01
  Scenario: Home page URL test
    Given I login to salesforce app
    When I click "App Launcher" button
    And I click "Service" button
    Then Verify URL is ending with "/lightning/page/home"

  @US8
  Scenario: AppExchage button
    Given I login to salesforce app
    When I click "App Launcher" button
    Then I click "View All" button
    Then Verify AppExchange is clicable