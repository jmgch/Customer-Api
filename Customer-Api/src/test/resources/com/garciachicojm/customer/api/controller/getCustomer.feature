@GetCustomer
Feature: Feature to get customer information

  Scenario Outline: user makes call to GET /rest/api/customer/<id>
    When the user calls /rest/api/customer/<id>
    Then the user receives status code of <status>

    Examples: 
      | id | status |
      | -1 |    404 |
      |  0 |    404 |
      |  1 |    200 |
      |  2 |    404 |