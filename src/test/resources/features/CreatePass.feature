Feature: User can create password when register using google

  Scenario Outline: User create password with mandatory field
    Given User already sign in using google account
    When User click hamburger button
    And User click on my account menu
    And Fill password form with <password>
    And Confirm password form with <confirmPass>
    And Tap create password button
    And Tap Ok button on popup confirmation
    Then Success notification about password has created will be dispalyed

    Examples: 
			|password  |confirmPass |
			|"R3st@mu" |"R3st@mu"	  |
			
			
	Scenario Outline: User create password with blank data
    Given User already sign in using google account
		When User click hamburger button
    And User click on my account menu
    And Fill password form with <password>
    And Confirm password form with <confirmPass>
    And Tap create password button
    And Tap Ok button on popup confirmation
    Then Failed notification will be dispalyed  

    Examples: 
			|password |confirmPass | message        |
			|"" 			|""				 	 |"Please fill "	|
		