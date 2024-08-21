 @loginTests
Feature: Login Page Tests
  Background: Login to the app as an admin
    Given I login to salesforce app

  @US1
  Scenario: Login as an admin
    Given I login to salesforce app
    Then Verify title of the page should contain Home
