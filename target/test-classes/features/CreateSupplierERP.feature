Feature: Create suppliers
  As a user I want to create suppliers so that I can keep track of them.

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: Create a supplier
    Given User is on the create supplier page
    And User fills in the supplier name
    When User clicks on the create supplier button
    Then The supplier table should be displayed

  @Success
  Scenario:  Create a supplier has both roles
    Given User is on the create supplier page
    And User fills in the supplier name
    And User selects the customer role
    When User clicks on the create supplier button
    Then The supplier table should be displayed

  @Success
  Scenario: Create a customer add discount
    Given User is on the create supplier page
    And User fills in the supplier name
    And User enters the supplier discount
    When User clicks on the create supplier button
    Then The supplier table should be displayed

  @Success
  Scenario: Create a supplier add group
    Given User is on the create supplier page
    And User fills in the supplier name
    And User enters the supplier group
    When User clicks on the create supplier button
    Then The supplier table should be displayed

  @Success
  Scenario: Create a supplier add another currency
    Given User is on the create supplier page
    And User fills in the supplier name
    And User selects another currency for supplier
    When User clicks on the create supplier button
    Then The supplier table should be displayed

  @Failure
  Scenario: Create a supplier without name
    Given User is on the create supplier page
    When User clicks on the create supplier button
    Then The warning text of the supplier name should be displayed
