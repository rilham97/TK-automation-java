Feature: User can create password when register using google

  Scenario Outline: User create password with mandatory field
    Given User already sign in using google account
    When User tap hamburger button on home screen
    And Tap My account button
    And Fill pasword form with <password> and confirm password form with <confirm_password>
    And Tap create password button
    And Tap Ok button on popup confirmation
    Then Success notification about password has created will be dispalyed

    Examples: 
			|password  |confirm_password |
			|"R3st@mu" |"R3st@mu"				 |
			
			
	Scenario Outline: User create password with blank data
    Given User already sign in using google account
		When User tap hamburger button on home screen
    And Tap My account button
    And Fill pasword form with <password> and confirm password form with <confirm_password>
    And Tap create password button
    And Tap Ok button on popup confirmation
    Then Success notification about password has created will be dispalyed

    Examples: 
			|password  |confirm_password |
			|"R3st@mu" |"R3st@mu"				 |
			
		