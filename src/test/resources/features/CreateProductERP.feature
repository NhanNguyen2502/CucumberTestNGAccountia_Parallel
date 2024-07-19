Feature:  Create Product
  As a user, I want to create products

  Background: User is logged in the ERP system
    Given Users logged

  @Success
  Scenario: User creates a new product
    Given User is on the create product page
    And User fills in the required fields
    When User clicks on the create button
    Then User should see a product table

  @Success
  Scenario Outline: User creates a new product with types
    Given User is on the create product page
    And User fills in the required fields
    And User select product "<type>"
    When User clicks on the create button
    Then User should see a product table
    Examples:
      | type    |
      | item    |
      | service |

  @Success
  Scenario: User create a new product with another price
    Given User is on the create product page
    And User click on add another price button
    And User fills in the required fields
    And User enter price to another price field
    When User clicks on the create button
    Then User should see a product table

  @Success
  Scenario: User create a new product with tax
    Given User is on the create product page
    And User fills in the required fields
    And User select tax for the product
    When User clicks on the create button
    Then User should see a product table

  Scenario: User create a new product with tax and another price
    Given User is on the create product page
    And User click on add another price button
    And User enter price to another price field
    And User fills in the required fields
    And User select tax for the product
    When User clicks on the create button
    Then User should see a product table


  @Success
  Scenario Outline: User create a new product with other prices
    Given User is on the create product page
    And User click "<index>" on add another price button
    And User fills in the required fields
    And User enter price to another price field
    When User clicks on the create button
    Then User should see a product table
    Examples:
      | index |
      | 2     |
      | 3     |
      | 4     |

  @priority:100
  @Failure
  Scenario: User creates a new product with an existing name
    Given User is on the create product page
    And User fills in the required fields with an existing product name
    When User clicks on the create button
    Then User should see an error message

