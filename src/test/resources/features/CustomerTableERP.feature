Feature:
  As a user, I want to management all customer of the company

  Background: User is logged in the ERP system
    Given Users logged

  Scenario:  User search the customer name.
    Given User is already on the customer table
    When Users enters keywords to the customer search input
    Then Products related to the keyword are shown on then customer table

  Scenario Outline: User search the customer name by text
    Given User is already on the customer table
    When User enter "<keywords>" to the customer search input
    Then Products related to the keyword are shown on then customer table
    Examples:
      | keywords           |
      | Maryrose Brown     |
      | Arnoldo Rosenbaum1 |
      | Dianhong           |
      | 4010               |
      | 4028               |

  Scenario Outline: User filter by status
    Given User is already on the customer table
    When User select "<status>" on the customer status filter
    Then Products related to the status are shown on then customer table
    Examples:
      | status   |
      | ENABLED  |
      | disabled |
      |          |