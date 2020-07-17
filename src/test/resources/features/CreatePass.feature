Feature: User can create password when register using google

  Scenario Outline: User create password with mandatory field
    Given User already sign in using google account
    When User click hamburger button
    And User click on my account menu
    And Fill password form with <password> and confirm password form with <confirmPass>
    And Tap create password button
    And Tap Ok button on popup confirmation
    Then Success notification about password has created will be displayed

    Examples: 
      | password   | confirmPass |
      | "Test123!" | "Test123!"  |
