Feature: User Registration and Login

  Scenario: Successful registration and login
    Given I am on the nopCommerce home page
    When I navigate to the registration page
    And I enter first name "John", last name "Doe", email "john123@example.com", password "Password123", and confirm password "Password123"
    And I click register
    Then I should see the registration success message

    When I navigate to the login page
    And I enter valid username "john123@example.com" and password "Password123"
    And I click login
    Then I should be redirected to the account dashboard
    And I should see the welcome message
