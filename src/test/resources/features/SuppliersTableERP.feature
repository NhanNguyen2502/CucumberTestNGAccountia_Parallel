Feature:
  As a user, I want to management all supplier of the company

  Background: User is logged in the ERP system
    Given Users logged

  Scenario:  User search the supplier name.
    Given User is already on the supplier table
    When Users enters keywords to the supplier search input
    Then Products related to the keyword are shown on then supplier table

  Scenario Outline: User search the supplier name by text
    Given User is already on the supplier table
    When User enter "<keywords>" to the supplier search input
    Then Products related to the keyword are shown on then supplier table
    Examples:
      | keywords          |
      | Lauretta Lang DDS |
      | Maryrose Brown    |
      | Leslie Wolff      |
      | 4013              |
      | 4341              |

  Scenario Outline: User filter by status
    Given User is already on the supplier table
    When User select "<status>" on the supplier status filter
    Then Products related to the status are shown on then customer table
    Examples:
      | status   |
      | ENABLED  |
      | disabled |
      |          |