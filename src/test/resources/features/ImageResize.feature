Feature: Image Resize

  Scenario Outline: User upload image profile and check file size
    Given User has access the home screen
      | email           | password |
      | string@mail.com | Password!2  |
    When User click hamburger button
    And Tab My Profile button
    And Press Edit Profile button
    And Choose photo <path> from gallery
    And Click button save
    Then Change success
    And Check photo size

    Examples: 
      | path            |
      | "img/9.7MB.jpg" |
      | "img/67.5MB.png"|
