Feature: Home page Tests

  @US8
  Scenario: AppExchage button
    Given I login to salesforce app
    When I click "App Launcher" button
    Then I click "View All" button
    Then Verify AppExchange is clicable