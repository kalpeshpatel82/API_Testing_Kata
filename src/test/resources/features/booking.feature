@booking @regression @sanity
Feature: Book a room

  Scenario Outline: As a user I can book a room with a valid test data
    Given I am on homepage of login endpoint
#    And I want to login to application using a "<user>" and "<password>"
    When I want to create a booking using a valid testdata "<id>","<firstname>","<lastname>","<depositPaid>","<checkin>","<checkout>","<email>","<phone>"
    Then I must get a valid response code 201 from categories endpoint

    Examples:
      | id | firstname | lastname | depositPaid | checkin    | checkout   | email                | phone      | user | password|
      | 1  | Joe       | Dave     | true        | 2026-10-13 | 2026-10-15 | john.doe@example.com | 12312312312 | admin | password |
      | 2  | kalpesh   | patel    | false       | 2026-09-13 | 2026-09-15 | john.doe@example.com | 12312312312 | admin | password |