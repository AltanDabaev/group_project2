Feature: Accounts test

  Background: Connect to api
    Given I establish a connection to the api service

  @US-10
  Scenario: Verify you get multiple accounts when sent a GET request to Account resource.
    When I send a get request to "/services/data/v61.0/sobjects/Account"
    Then I should get more than 1 account result

  @US-11
  Scenario: Verify admin can get a single Account object with GET call
    When I send a get request to "/services/data/v61.0/sobjects/Account/{id}" with Id "001Hu000034km0YIAQ"
    Then I should receive one "Account" object