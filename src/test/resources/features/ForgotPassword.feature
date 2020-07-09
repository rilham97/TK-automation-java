# new feature
# Tags: optional
Feature: Forgot Password

  Scenario Outline: User change password from forgot password screen with correct verification code
    Given User in the login page
    When User click on forgot password button
    And User input registered <email> address
    And User click on send button
    And User input verification code with <verificationCode>
    And User input new password with <newPassword>
    And User input confirm password with <confirmPassword>
    And User click on reset password
    Then User successfully reset the password
    And User successfully login with <email> and <newPassword>

    Examples: 
      | email             | verificationCode | newPassword | confirmPassword |
      | "reset@gmail.com" | "10201"          | "Ron@123!"  | "Ron@123!"      |
      | "reset@gmail.com" | "10201"          | "R3set!"    | "R3set!"        |
