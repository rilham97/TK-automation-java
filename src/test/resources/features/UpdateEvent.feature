#update event
Feature: Update Event

  Scenario: Update the event with valid data
    Given User already login and in the home screen
    And User go to My Event Screen
    And User sort event based on Event Date(ASC)
    When User click on the first event
    And User click on button Edit
    And User edit city
    And User edit event title
    And User edit event date
    And User edit event start time
    And User edit event end time
    And User edit range age
    And User edit gender
    And User edit additional info
    And User click on button Save
    Then Event is updated
    And check the updated data
