Feature: Login to ERP
  As a user, I want to be able to log into the ERP application
  So that I can manage my company

  @Success
  Scenario: Successful Login
    Given User go to the log in page
    When User enter username and password
    And  Click on Login button
    Then User should be taken to the Company list
    And User should see the company list page

  @Failure
  Scenario Outline: Failed Login invalid email
    Given User go to the log in page
    When User enter "<email>" and "<password>"
    And Click on Login button
    Then Users login failed
    And The warning invalid email should be displayed
    Examples:
      | email                    | password     |
      | test                     | Password1234 |
      | testdeferp@mailinator    | Password1234 |
      | testdeferpmailinator.com | Password1234 |

  @Failure
  Scenario Outline: Failed Login wrong email or password
    Given User go to the log in page
    When User enter "<email>" and "<password>"
    And Click on Login button
    Then Users login failed
    And The warning invalid email should be displayed
    Examples:
      | email                       | password     |
      | testdeferp@mailinator.com   | Password123  |
      | testdeferp99@mailinator.com | Password1234 |


#  Scenario: aa
#    Given User go to the log in page
#    When user enter valid credentials to login
#      | username                  | password     |
#      | testdeferp@mailinator.com | Password1234 |
#      | nhannhan11                | Password1234 |