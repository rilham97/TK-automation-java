Feature: Filter event

  Scenario Outline: User filter the event
    Given User already in the home screen
    When User click magnifying glass icon
    And User click filter button
    And User set the range age
    And User select the creator gender with <gender>
    And User select the start date
    And User select the end date
    And User select the start time
    And User select the end time
    And User input the city with <city>
    And User tap apply button
    Then Sorting menu popup will be disappeared
    And Filtered event with city <city> will be displayed

    Examples: 
      | gender   | city      |
      | "Female" | "Denpasar"|
