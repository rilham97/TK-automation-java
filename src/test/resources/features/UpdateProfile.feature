Feature: Update Profile

  Scenario Outline: User update profile with valid credential
    Given User in the home screen
    When User click hamburger button
    And Tab My Profile button
    And Press Edit Profile button
    And Choose photo <path> from galery
    And Fill <city> in form City
    And Fill <about_me> in form About Me
    And Fill <interest> in form Interest
    And Click button save
    Then User profile is changed

    Examples: 
      | path            | city    | about_me         | interest  |
      | "img/radit.jpg" | "Ngawi" | "Automated Edit" | "Taichan" |
