Feature: User Registration

  Scenario: Successful registration
    Given I am on the nopCommerce home page
    When I navigate to the registration page
    And I enter first name "Johnn", last name "Doee", email "johnn123@example.com", password "Password1234", and confirm password "Password1234"
    And I click register
    Then I should see the registration success message and be logged in
