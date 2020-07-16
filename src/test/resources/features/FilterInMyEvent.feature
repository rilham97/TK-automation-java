# new feature
# Tags: optional

Feature: Filter in my event

  Scenario Outline: User want to filter my current event
    Given user already in the my applied event screen
    When user click on icon filter
    And click on one of <Method> filter
    Then application will display only events with <METHOD> status

    Examples:
      | Method    | METHOD    |
      | "Applied" | "APPLIED" |

