Feature: Invoices table page
  As a user, I want to see the entire invoice

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: User search invoice number
    Given User is on the invoices page
    When User search for invoice number
    Then Invoices related to the keyword are shown on then product table