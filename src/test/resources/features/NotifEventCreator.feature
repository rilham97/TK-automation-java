Feature: Notification for Event Creator

  Scenario: User want to see notification when other user apply to the event
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When Other user apply to the event
    And Event Creator click bell icon
    Then Get notification for their created event if other user successfully applying to the event
    And The number of notification icons will increasing

  Scenario: User want to see notification when other user cancel application to the event
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When Other user cancel application to the event
    And Event Creator click bell icon
    Then Get notification for their created event if other user successfully cancel application to the event
    And The number of notification icons will increasing
