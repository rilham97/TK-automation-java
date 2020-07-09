#reject applicant
Feature: Reject Applicant

  Scenario: Reject Applicant
    Given User login and in the home screen
    And User go to My Event Screen
    And User sort event based on Event Date (DESC)
    When User click on the first event
    And User click on button Reject
    And User confirm the rejection
    Then Applicant is rejected
