
Feature: User Login
  As a user
  I want to login to the system
  So that I can access my account

  Scenario Outline: Login with <type> credentials
    Given I am on the login page
    When I enter valid email "<email>" and password "<password>"
    And I click the login button
    Then Login to the main page <result>

    Examples:
    | type    | email                   | password       | result |
    | valid   | shtrung.se@yandex.ru    | shtrungSem24F  | true   |
    | invalid | shtrung.se@yandex       | shtrungSem24F  | false  |
    | invalid | shtrung.se@yandex.ru    | shtrungSem24FF | false  |
    | invalid | shtrung.se@google.com   | shtrungSem24F  | false  |
    | invalid |                         | shtrungSem24F  | false  |
    | invalid | shtrung.se@yandex.ru    |                | false  |
    | invalid |                         |                | false  |

