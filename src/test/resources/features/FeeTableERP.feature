Feature:
  As a user, I want to management all fee of the company

  Background: User is logged in the ERP system
    Given Users logged

  Scenario:  User search the fee name.
    Given User is already on the fee table
    When Users enters fee name to the search input
    Then Fees related to the keyword are shown on then product table

  Scenario Outline: User search the fee name by text
    Given User is already on the fee table
    When User enter "<keywords>" of fee name to the search input
    Then Fees related to the keyword are shown on then product table
    Examples:
      | keywords  |
      | Corporate Legal Developer |
      | Principal Orchestrator     |
      | 6010  |
      | 3012      |
      | 3013      |

  Scenario Outline: User filter by status
    Given User is already on the fee table
    When User select fee "<status>" to filter
    Then Fees related to the status are shown on then product table
    Examples:
      | status   |
      | ENABLED  |
      | disabled |
      |  |
