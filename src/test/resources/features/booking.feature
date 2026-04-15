@booking
Feature: Book a room

  Scenario: As a user I can book a room with a valid test data
    Given I am on homepage of login endpoint
    When I want to create a booking using a valid testdata
    Then I must get a valid response code 200 from categories endpoint

