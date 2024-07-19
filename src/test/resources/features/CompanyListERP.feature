Feature: Company List
  As a user, I want to see the entire company that I own

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: Select company
    Given User access to company list
    When User click on the company
    Then User should be taken to the Dashboard

  @Success
  Scenario Outline: Select company by company type
    Given User access to company list
    When User click on the company that has "<type>"
    Then User should be taken to the Dashboard
    Examples:
      | type |
      | Real |
      | Demo |

  @Failure
  Scenario Outline: Select invalid company type
    Given User access to company list
    When User click on the company that has "<type>"
    Then  User still on the company list page
    Examples:
      | type  |
      | None  |
      | Empty |

