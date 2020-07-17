Feature: Register using email

  Scenario Outline: Register using valid data
    Given User has accessed Create Account page
    When User input valid Full Name with <fullName>
    And Input date of birth
    And Choose <gender> gender
    And Input valid Email with <email>
    And Fill password form with <password>
    And Confirm password form with <confirmPass>
    And Click T&C checkbox
    And Tap Create Account password
    And Tap OK button
    And Skip fill the additional info form
    Then User should be directed to home screen using own email <email>

    Examples: 
      | fullName             | gender   | email                  | password   | confirmPass |
      | "Automation Account 1" | "Female" | "automation@mail.com" | "Test123!" | "Test123!"  |


  Scenario Outline: Register using invalid email format
    Given User has accessed Create Account page
    When User input valid Full Name with <fullName>
    And Input date of birth
    And Choose <gender> gender
    And Input valid Email with <email>
    And Fill password form with <password>
    And Confirm password form with <confirmPass>
    And Click T&C checkbox
    And Tap Create Account password
    Then User should receive error message email on register screen

    Examples: 
      | fullName             | gender   | email        | password   | confirmPass |
      | "Automation Account" | "Female" | "automation" | "Test123!" | "Test123!"  |

  Scenario Outline: Register using invalid password format
    Given User has accessed Create Account page
    When User input valid Full Name with <fullName>
    And Input date of birth
    And Choose <gender> gender
    And Input valid Email with <email>
    And Fill password form with <password>
    And Confirm password form with <confirmPass>
    And Click T&C checkbox
    And Tap Create Account password
    Then User should receive error message password on register screen

    Examples: 
      | fullName             | gender   | email                 | password   | confirmPass |
      | "Automation Account" | "Female" | "automation@mail.com" | "hello123" | "hello123"  |
