# new feature
# Tags: optional

Feature: Sorting on my event

  @currentTab
  Scenario Outline: User wants to sorting the event at the home screen
    Given user in the home screen
    When click on hamburger menu
    And click on my event
    And click on sorting icon
    And click on <sort> function
    Then user successfully <sort> the event

    Examples:
      | sort                   |
      | "Newest created event" |
      | "Oldest created event" |
      | "Date of event (ASC)"  |
      | "Date of event (DESC)" |