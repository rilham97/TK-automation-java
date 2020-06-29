# new feature
# Tags: optional

Feature: Create event

  Scenario Outline: User create event with valid data
    Given User already in the home screen
    When User click on create event button icon
    And User input valid event title with <title>
    And User input valid city with <city>
    And User input valid event date with <eventDate>
    And User input valid event start time with <startTime>
    And User input valid event end time with <endTime>
    And User set range age
    And User set gender
    And User input valid additional info <addInfo>
    And User click on button create event
    Then Event is created
    And User directed to home screen

    Examples:
      | title                |
      | "resta.mu@gmail.com" |
