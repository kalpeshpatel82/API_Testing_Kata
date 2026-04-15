Feature: Login to application

  @login @regression @sanity
  Scenario Outline: As a user I can login to the application
    Given I am on homepage of login endpoint
    When I want to login to application using a "<user>" and "<password>"
    Then user should login successful with appropriate message "<statusCode>" and "<message>"

    Examples:
      | user  | password   | statusCode | message             |
      | admin | password   | 200        | abc123token         |
      | user  | nopassword | 401        | Invalid credentials |

#    for status code 200, user gets a token

# to use the token for getting user info
  @user
  Scenario Outline: As a user I can get the user info
    Given I am on homepage of login endpoint
    When I want to login to application using a "<user>" and "<password>"
    Then user should able to get user info of given id "<BookingID>"

    Examples:
      | user  | password | BookingID |
      | admin | password | 6        |


