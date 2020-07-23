# new feature
# Tags: optional

Feature: Filter in applied event

  @currentTab
  Scenario Outline: User wants to filter my current event
    Given user already in the my applied event screen
    When user click on filter icon
    And click on one of <Method> filter
    Then application will display only events with <METHOD> status

    Examples:
      | Method     | METHOD     |
      | "Applied"  | "APPLIED"  |
      | "Accepted" | "ACCEPTED" |
      | "Rejected" | "REJECTED" |

  @pastTab
  Scenario Outline: User wants to filter my past event
    Given user already in the my applied event screen
    When user click on past tab
    And user click on filter icon
    And click on one of <Method> filter
    Then application will display only events with <METHOD> status

    Examples:
      | Method     | METHOD      |
      | "Applied"  | "APPLIED"   |
      | "Accepted" | "ACCEPTED"  |
      | "Rejected" | "REJECTED"  |
      | "Canceled" | "CANCELLED" |