#Cancel Event by Event Creator

Feature: Cancel Event by Event Creator

  Scenario: Cancel Event after created
    Given User login and in the home screen
    And User go to My Event Screen
    And User sort event based on Event Date (DESC)
 		When User click on the first event
    And User click on button Cancel
    And User confirm the Cancelation
    Then Event canceled

