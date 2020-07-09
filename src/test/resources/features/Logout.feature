# new feature
# Tags: optional
@Logout
Feature: Logout from application

  @Positive
  Scenario: User logout from the application
    Given user already in the home screen
    When user click drawer button
    And user click logout button
    And user click yes on pop up confirmation
    Then user back to login page
