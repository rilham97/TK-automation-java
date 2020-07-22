Feature: Notification for Event Applicant
	@Accept
  Scenario: Applicant want to see notification when event creator successfully accept the application
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When Event creator accept the application
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Applicant click bell icon
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully accept the application
	@Accept
  Scenario: Applicant want to see notification when event creator successfully accept the application and application doesn't open
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When The user minimize the application
    And Event creator accept the application
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully accept the application
	@CancelAccept
  Scenario: Applicant want to see notification when event creator successfully cancel the acceptance
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When Event creator cancel the acceptance
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Applicant click bell icon
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully cancel the acceptance
	@CancelAccept
  Scenario: Applicant want to see notification when event creator successfully cancel the acceptance and application doesn't open
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When The user minimize the application
    And Event creator cancel the acceptance
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully cancel the acceptance
	@Reject
  Scenario: Applicant want to see notification when event creator successfully reject the application
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When Event creator reject the application
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Applicant click bell icon
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully reject the application
	@Reject
  Scenario: Applicant want to see notification when event creator successfully reject the application and application doesn't open
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When The user minimize the application
    And Event creator reject the application
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully reject the application
	@CancelEvent
  Scenario: Applicant want to see notification when event creator successfully cancel the event
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When Event creator cancel the event
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Applicant click bell icon
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully cancel the event
	@CancelEvent
  Scenario: Applicant want to see notification when event creator successfully cancel the event and application doesn't open
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When The user minimize the application
    And Event creator cancel the event
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully cancel the event
	@EditEvent
  Scenario: Applicant want to see notification when event creator successfully edit the event
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When Event creator edit the event
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Applicant click bell icon
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully edit the event
	@EditEvent
  Scenario: Applicant want to see notification when event creator successfully edit the event and application doesn't open
    Given Applicant has access the home screen
      | email              | password |
      | applicant@mail.com | R3st@mu  |
    When The user minimize the application
    And Event creator edit the event
      | email            | password |
      | creator@mail.com | R3st@mu  |
    And Open notification tray from own device
    Then The number of notification icons will increasing
    And Get notification for their applications if event creator successfully edit the event
