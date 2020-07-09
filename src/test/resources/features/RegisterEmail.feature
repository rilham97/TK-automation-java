Feature: Register using email

  #@tag1
  #Scenario Outline: Register using valid data
    #Given User has accessed Create Account page
    #When User input valid Full Name with <fullName>
    #And Input date of birth
    #And Choose <gender> gender
    #And Input valid Email with <email>
    #And Fill password form with <password>
    #And Confirm password form with <confirmPass>
    #And Click T&C checkbox
    #And Tap Create Account password
    #And Skip fill the additional info form
    #Then User should be directed to home screen
#
    #Examples: 
      #| fullName             | gender   | email                 | password  | confirmPass |
      #| "Automation Account" | "Female" | "automation@mail.com" | "Test123!"| "Test123!"  |

  #Scenario Outline: Register using invalid email format
    #Given User has accessed Create Account page
    #When User input valid Full Name with <fullName>
    #And Input date of birth
    #And Choose <gender> gender
    #And Input valid Email with <email>
    #And Fill password form with <password>
    #And Confirm password form with <confirmPass>
    #And Click T&C checkbox
    #And Tap Create Account password
    #Then User should recieve error message email on register screen
#
    #Examples: 
      #| fullName             | gender   | email        | password  | confirmPass |
      #| "Automation Account" | "Female" | "automation" | "Test123!"| "Test123!"  |
      
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
    Then User should recieve error message password on register screen

    Examples: 
      | fullName             | gender   | email        | password  | confirmPass |
      | "Automation Account" | "Female" | "automation" | "hello"   | "hello"     |