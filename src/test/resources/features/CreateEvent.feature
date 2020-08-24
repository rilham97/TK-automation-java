# new feature
# Tags: optional

Feature: Create event

  Scenario Outline: User create event with valid data
    Given User already in the home screen
    When User click on create event button icon
    And User input valid event title with <title>
    And User input valid city with <city>
    And User input valid event date with <date>
    And User input valid event start time
    And User input valid event end time
    And User set range age
    And User set gender
    And User input valid additional info <addInfo>
    And User click on button create event
    Then Event is created
    And User directed to home screen

    Examples:
      | title                     | city      | date         | addInfo         |
      | "Kondangan makan Kenyang" | "Jakarta" | "09/10/2020" | "makan kenyang" |
