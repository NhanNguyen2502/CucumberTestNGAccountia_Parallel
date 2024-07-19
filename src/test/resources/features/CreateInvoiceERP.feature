Feature: Create a new invoice

  Background: User access the system
    Given Users logged

    @Success
    @CashSale
  Scenario: Create a new invoice without change currency
    Given Users is on the create invoice form
    And Users select invoice type
    And Users select customer
    And Users select product
    When Users click on the create invoice button

