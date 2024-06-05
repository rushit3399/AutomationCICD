package LearningNewSkills.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import LearningNewSkills.TestComponents.BaseTest;
import LearningNewSkills.TestComponents.Retry;
import LearningNewSkills.pageObject.CheckoutPage;
import LearningNewSkills.pageObject.OrderConfirmationPage;
import LearningNewSkills.pageObject.ProductPage;
import LearningNewSkills.pageObject.cartPage;

public class ErrorValidationTest extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void LoginErrorValidations() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		ProductPage productPage = landingPage.loginApp("rushit.patel1907@gmail.com", "Password");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	@Test
	public void ProductErrorValidations() throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		ProductPage productPage = landingPage.loginApp("rushit.patel1907@gmail.com", "Password01");
		List<WebElement> products = productPage.getProductList();
		productPage.addProductToCart(productName);
		cartPage cartpage = productPage.goToCart();
		Boolean match = cartpage.productsIncart("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
