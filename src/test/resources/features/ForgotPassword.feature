# new feature
# Tags: optional

Feature: Forgot Password

  Scenario: User change password from forgot password screen with correct verification code
    Given User in the login page
    When User click on forgot password button
    And User input registered email address
    And User click on send button
    And User input verification code
    And User input new password
    And User input confirm password
    And User click on reset password
    Then User successfully reset the password
    And User successfully login with new password
