
@tag
Feature: Error Validation
  I want to use this template for my feature file


  @ErrorValidations
  Scenario Outline: Validating error upon entering incorrect login
    Given I landed on Home Page of Ecommerce Page
    When Logged in with username <name> and password <password>
    Then "Incorrect email or password." message will be displayed

    Examples: 
      | name  					 | password 	 |
      | shetty@gmail.com | Iamking@0 |  
