# new feature
# Tags: optional

Feature: Rating to Applicant

  Scenario: User give rating to Applicant that not rated before
    Given user already in my event screen
    When user click on past tab at my event screen
    And user click on the event box
    And click on rate user button
    And click on one of the stars
    And user click on submit button
    And user click on rated button
    Then message user successfully give a rating will be display
