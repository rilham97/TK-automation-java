Feature: Update Profile

  Scenario Outline: User update profile with valid credential
    Given User has access the home screen
      | email          | password |
      | dummy5@mail.com | R3st@mu  |
    When User click hamburger button
    And Tab My Profile button
    And Press Edit Profile button
    And Choose photo <path> from gallery
    And Fill <city> in form City
    And Fill <about_me> in form About Me
    And Fill <interest> in form Interest
    And Click button save
    Then User profile is changed
    Examples: 
      | path            | city    | about_me         | interest  |
      | "img/radit.jpg" | "Ngawi" | "Automated Edit" | "Taichan" |
