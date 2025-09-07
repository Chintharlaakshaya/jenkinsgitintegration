Feature: Login Functionality
  As a registered user
  I want to login to nopCommerce
  So that I can access my account

  Scenario: Successful login with valid credentials
    Given I am on the nopCommerce home page
    When I navigate to the login page
    And I enter valid username "admin@yourstore.com" and password "admin"
    And I click login
    Then I should be redirected to the account dashboard
    And I should see the welcome message
