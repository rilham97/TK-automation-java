@Login
Feature: Login to Application

  @Regression
  Scenario Outline: Login using valid data format or mandatory field
    Given User has accessed Login page
    When User input valid email with <email>
    And User input valid password with <password>
    And User click on Login button
    Then User should be directed to home screen
    And Welcome message will be shown

    Examples: 
      | email                | password  |
      | "resta.mu@gmail.com" | "R3st@mu" |
      | "fadhila@mail.com"   | "R3st@mu" |

  @Regression @Negative
  Scenario Outline: Login using blank data
    Given User has accessed Login page
    When User fill email form with <email>
    And User fill password form with <password>
    And User click on Login button
    Then User should failed to home screen
    And User should recieve error message <message> on login screen

    Examples: 
      | email              | password  | message                    |
      | ""                 | "R3st@mu" | "Please fill the email"    |
      | "fadhila@mail.com" | ""        | "Please fill the password" |

  #@Exploratory
  #Scenario Outline: Login when the internet connection is disconnected
    #Given User has accessed Login page
    #When User input valid email with <email>
    #And User input valid password with <password>
    #And Set the internet connection on the user's device to be disconnected
    #And User click on Login button
    #Then User should failed to home screen
    #And Popup notification about internet connection is disconnected will be displayed
#
    #Examples: 
      #| email                | password  |
      #| "resta.mu@gmail.com" | "R3st@mu" |