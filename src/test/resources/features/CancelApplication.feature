# new feature
# Tags: optional

Feature: Cancel Application

  Scenario: User wants to cancel the application
    Given User login and already in the home screen
    When User click on hamburger button
    And User click on applied events
    And User click an event box
    And User cancel application
    And User confirm the cancel application
    Then User successfully cancel the application