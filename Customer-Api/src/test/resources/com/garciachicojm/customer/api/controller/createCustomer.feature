@CreateCustomer
Feature: Feature to test create_customer method

  @TestingID
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @ID
    Examples: 
      | id   | firstName | lastName | active | age | birth      | status |
      | -100 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |   -1 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |    0 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |    1 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    201 |
      |  100 | Jose      | Garcia   | false  |  20 | 11/07/1900 |    201 |
      |    5 | Jose      | Garcia   |        |  20 | 11/07/1900 |    201 |
      |    3 | Jose      | Garcia   | false  |  20 |            |    201 |

  @TestingFirstName
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @FirstName
    Examples: 
      | id | firstName | lastName | active | age | birth      | status |
      |  1 |           | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |  2 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    201 |
      |  3 | 23Jose    | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |  4 | Jose*     | Garcia   | true   |  20 | 11/07/1900 |    401 |
      |  5 | ?+*")(    | Garcia   | true   |  20 | 11/07/1900 |    401 |

  @TestingLastName
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @LastName
    Examples: 
      | id | firstName | lastName | active | age | birth      | status |
      |  1 | Jose      |          | true   |  20 | 11/07/1900 |    401 |
      |  2 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    201 |
      |  3 | Jose      | Garcia45 | true   |  20 | 11/07/1900 |    401 |
      |  4 | Jose      | Garcia+  | true   |  20 | 11/07/1900 |    401 |
      |  5 | Jose      | ?+*")(   | true   |  20 | 11/07/1900 |    401 |

  @TestingActive
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @Active
    Examples: 
      | id | firstName | lastName | active | age | birth      | status |
      |  1 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    201 |
      |  2 | Jose      | Garcia   | false  |  20 | 11/07/1900 |    201 |

  @TestingAge
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @Age
    Examples: 
      | id | firstName | lastName | active | age  | birth      | status |
      |  1 | Jose      | Garcia   | true   |   -1 | 11/07/1900 |    401 |
      |  2 | Jose      | Garcia   | true   | -100 | 11/07/1900 |    401 |
      |  3 | Jose      | Garcia   | true   |    0 | 11/07/1900 |    201 |
      |  4 | Jose      | Garcia   | true   |    1 | 11/07/1900 |    201 |
      |  5 | Jose      | Garcia   | true   |  115 | 11/07/1900 |    201 |
      |  6 | Jose      | Garcia   | true   |  200 | 11/07/1900 |    401 |

  @TestingBirth
  Scenario Outline: Include a customer calling /rest/api/customer
    Given id <id>, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @Birth
    Examples: 
      | id | firstName | lastName | active | age | birth      | status |
      |  1 | Jose      | Garcia   | true   |  20 | 40/07/1900 |    401 |
      |  2 | Jose      | Garcia   | true   |  20 | 11/13/1900 |    401 |
      |  3 | Jose      | Garcia   | true   |  20 | 11/07/2020 |    401 |
      |  4 | Jose      | Garcia   | true   |  20 | 11/07/1900 |    201 |
      |  5 | Jose      | Garcia   | true   |  20 | 30/12/1900 |    201 |

  @TestingNoProperties
  Scenario Outline: Include a customer calling /rest/api/customer
    Given no properties, id <id>, name <firstName>, lastName <lastName>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @NoProperties
    Examples: 
      | id | firstName | lastName | status |
      | -1 | Jose      | Garcia   |    401 |
      |  1 | Jose      | Garcia   |    201 |
      |  2 |           | Garcia   |    401 |
      |  3 | Jose      |          |    401 |
      |  4 | Jose      | Garcia   |    201 |
      |  5 | Jose      | Garcia   |    201 |

  @TestingNullId
  Scenario Outline: Include a customer calling /rest/api/customer
    Given null id, name <firstName>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @NullId
    Examples: 
      | firstName | lastName | active | age | birth      | status |
      | Jose      | Garcia   | true   |  20 | 11/07/1900 |    401 |

  @TestingNullFirstName
  Scenario Outline: Include a customer calling /rest/api/customer
    Given null name, id <id>, lastName <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @NullFirstName
    Examples: 
      | id | lastName | active | age | birth      | status |
      |  1 | Garcia   | true   |  20 | 11/07/1900 |    401 |

  @TestingNullLastName
  Scenario Outline: Include a customer calling /rest/api/customer
    Given null lastName, id <id>, name <lastName>, active <active>, age <age>, birth <birth>
    When the user calls /rest/api/customer
    Then the user receives status code of <status>

    @NullLastName
    Examples: 
      | id | firstName | active | age | birth      | status |
      |  1 | Jose      | true   |  20 | 11/07/1900 |    401 |
