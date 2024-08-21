Feature: Setup page Tests
  Background: Login to the app as an admin
    Given I login to salesforce app

  @US104
  Scenario: Setup page should have following nav buttons
    Then Verify "Home" button is displayed
    Then Verify "Object Manager" button is displayed


    @US-6
    Scenario: Most Recently Used view
      And  I should see max 10 items displayed under Most Recently Used section
