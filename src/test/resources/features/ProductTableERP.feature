Feature:
  As a user, I want to management all product of the company

  Background: User is logged in the ERP system
    Given Users logged

  Scenario:  User search the product name.
    Given User is already on the product table
    When Users enters keywords to the search input
    Then Products related to the keyword are shown on then product table

  Scenario Outline: User search the product name by text
    Given User is already on the product table
    When User enter "<keywords>" to the search input
    Then Products related to the keyword are shown on then product table
    Examples:
      | keywords  |
      | Biluochun |
      | Ujeon     |
      | Dianhong  |
      | 3012      |
      | 3013      |

  Scenario Outline: User filter by status
    Given User is already on the product table
    When User select "<status>" to filter
    Then Products related to the status are shown on then product table
    Examples:
      | status   |
      | ENABLED  |
      | disabled |
      |  |
