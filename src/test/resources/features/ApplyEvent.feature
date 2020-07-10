# new feature
# Tags: optional

Feature: Apply event

  Scenario: User wants to apply an event
    Given User in the home screens
    When User click on search icon
    And User click on an event box
    And User click on apply to event button
    And User click on button ok at the popup confirmation
    Then User successfully apply to event
