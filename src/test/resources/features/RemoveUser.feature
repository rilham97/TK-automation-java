# new feature
# Tags: optional
Feature: Remove User

  Scenario: User want to remove account
    Given User in the home screen
    When User click hamburger button
    And User click on my account menu
    And Click on delete account
    And Click on continue button from the popup confirmation
    Then User directed to login screen
    And User can't login with the account that already removed
