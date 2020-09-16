Feature: All accounts can be retrieved
  Scenario: Client makes call to GET /api/v1/accounts
    When the client calls /api/v1/accounts
    Then the client receives a status code of 200
    And the client receives a list of all accounts