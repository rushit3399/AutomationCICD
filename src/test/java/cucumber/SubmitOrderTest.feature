
@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on Home Page of Ecommerce Page


  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <name> and password <password>
    When I add product <productName> to cart
    And Checkout with product <productName> and Submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name  										 | password 			| productName  |
      | rushit.patel1907@gmail.com | Password01 		| ZARA COAT 3	 |
