Feature: Create customers
  As a user I want to create customers so that I can keep track of them.

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: Create a customer
    Given User is on the create customer page
    And User fills in the customer name
    When User clicks on the create customer button
    Then The customer table should be displayed

  @Success
  Scenario: Create a customer both roles
    Given User is on the create customer page
    And User fills in the customer name
    And User selects the supplier role
    When User clicks on the create customer button
    Then The customer table should be displayed

  @Success
  Scenario: Create a customer add discount
    Given User is on the create customer page
    And User fills in the customer name
    And User enters the discount
    When User clicks on the create customer button
    Then The customer table should be displayed

  @Success
  Scenario: Create a customer add group
    Given User is on the create customer page
    And User fills in the customer name
    And User enters the customer group
    When User clicks on the create customer button
    Then The customer table should be displayed

  @Success
  Scenario: Create a customer with another currency
    Given User is on the create customer page
    And User fills in the customer name
    And User selects another currency for customer
    When User clicks on the create customer button
    Then The customer table should be displayed

  @Failure
  Scenario: Create a customer without name
    Given User is on the create customer page
    When User clicks on the create customer button
    Then The warning text of the customer name should be displayed
