Feature: Notification for Event Creator

  Scenario: User want to see notification when other user apply to the event
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When Other user apply to the event
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    And Event Creator click bell icon
    Then The number of notification icons will increasing
    And Get notification for their created event if other user successfully applying to the event

  Scenario: User want to see notification tray when other user apply to the event and  application doesn't open
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When The user minimize the application
    And Other user apply to the event
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then Get notification for their created event if other user successfully applying to the event

  Scenario: User want to see notification when other user cancel application to the event
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When Other user cancel application to the event
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    And Event Creator click bell icon
    Then The number of notification icons will increasing
    And Get notification for their created event if other user successfully cancel application to the event

  Scenario: User want to see notification tray when other user cancel application to the event and application doesn't open
    Given Event Creator has access the home screen
      | email              | password |
      | resta.mu@gmail.com | R3st@mu  |
    When The user minimize the application
    And Other user cancel application to the event
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then Get notification for their created event if other user successfully cancel application to the event
