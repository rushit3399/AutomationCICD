package LearningNewSkills.stepdefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import LearningNewSkills.TestComponents.BaseTest;
import LearningNewSkills.pageObject.CheckoutPage;
import LearningNewSkills.pageObject.LandingPage;
import LearningNewSkills.pageObject.OrderConfirmationPage;
import LearningNewSkills.pageObject.ProductPage;
import LearningNewSkills.pageObject.cartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitions extends BaseTest{
	
	public LandingPage landingPage;
	public ProductPage productPage;
	public cartPage cartpage;
	public CheckoutPage checkout;
	public OrderConfirmationPage confPage;
	
	
	@Given ("I landed on Home Page of Ecommerce Page")
	public void i_landed_on_Home_Page_of_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
		
	}
	
	@Given ("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_and_password(String username, String password)
	{
		productPage = landingPage.loginApp(username, password);
		
	}
	
	@When ("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products = productPage.getProductList();
		productPage.addProductToCart(productName);
		
	}
	
	@When ("^Checkout with product (.+) and Submit the order$")  //when values are derived from Examples in feature file add (.+). Also start with ^ and end with $
	public void checkout_with_product_and_Submit_the_order(String productName) throws InterruptedException
	{
		cartpage = productPage.goToCart();
		Boolean match = cartpage.productsIncart(productName);
		Assert.assertTrue(match);
		checkout = cartpage.goToCheckout();
		checkout.shippingInformation("india");
		confPage = checkout.goToOrderConfirmationPage();
		
	}
	
	@Then ("{string} message is displayed on ConfirmationPage") //when value is not coming from examples and value is hard coded in then you can use {string} or any other datatype
	public void message_is_displayed_on_ConfirmationPage(String string)
	{
		String orderConText = confPage.orderConfirmation();
		Assert.assertTrue(orderConText.equalsIgnoreCase(string));
		driver.close();
		
	}
	
	@Then("{string} message will be displayed")
    public void incorrect_email_or_password_message_will_be_displayed(String string) {
        // Verify that the error message is displayed
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
