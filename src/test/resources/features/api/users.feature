Feature: Users test

  Background: Connect to api
    Given I establish a connection to the api service

  @US-14
  Scenario: Verify I can get all users by sending a GET request to users resource.
    When I send a get request to "/services/data/v61.0/sobjects/User"
    Then I should get not less than 1 user

  @US-15
  Scenario: Verify GET request to user resource using an id returns 1 user info.
    When I send a get request to "/services/data/v61.0/sobjects/User/{id}" with Id "005Hu00000QCTvqIAH"
    Then I should receive one "User" object