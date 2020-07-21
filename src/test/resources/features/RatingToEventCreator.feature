# new feature
# Tags: optional

Feature: Rating to Event Creator

  Scenario: User give rating to Event Creator that not rated before
    Given User already in the applied screen
    When click on past tab
    And select the event box
    And click on button rate user
    And click on one of the star
    And click on button submit
    Then user successfully give rating to event creator
    And click on see rating from you
