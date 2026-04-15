@login
Feature: Login to application

  Scenario Outline:As a user I can login to the application
    Given I am on homepage of login endpoint
    When I want to login to application using a "<id>" and "<password>"
    Then user should login successful with appropriate message "<statusCode>" and "<message>"

    Examples:
      | id    | password   | statusCode | message             |
      | admin | password   | 200        | abc123token         |
      | user  | nopassword | 401        | Invalid credentials |

#    for status code 200, user gets a token