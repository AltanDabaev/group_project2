Feature: Home page Tests

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

