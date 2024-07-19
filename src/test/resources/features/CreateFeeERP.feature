Feature: Create Fee
  As a user I want to create fee so that I can keep track of them.

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: Create Fee
    Given User is on the create fee page
    And User enters fee name
    And User enters fee price
    When User click on the create fee button
    Then  The fee table should be displayed

  @Success
  Scenario: Create Fee with another price
    Given User is on the create fee page
    And User enters fee name
    And User clicks add another price button
    And User enters fee price
    When User click on the create fee button
    Then  The fee table should be displayed

  @Success
  Scenario Outline: Create Fee with other price
    Given User is on the create fee page
    And User enters fee name
    And User clicks "<index>" add another price button
    And User enters fee price
    When User click on the create fee button
    Then  The fee table should be displayed
    Examples:
      | index |
      | 2     |
      | 3     |
      | 4     |
      | 5     |

  @Failure
  Scenario: Create Fee with empty name
    Given User is on the create fee page
    And User enters fee price
    When User click on the create fee button
    Then The warning text the name is required should be displayed


