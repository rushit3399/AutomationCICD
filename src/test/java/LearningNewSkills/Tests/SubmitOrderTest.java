package LearningNewSkills.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LearningNewSkills.TestComponents.BaseTest;
import LearningNewSkills.pageObject.CheckoutPage;
import LearningNewSkills.pageObject.OrderConfirmationPage;
import LearningNewSkills.pageObject.OrderHistoryPage;
import LearningNewSkills.pageObject.ProductPage;
import LearningNewSkills.pageObject.cartPage;

public class SubmitOrderTest extends BaseTest {
	
	String productName = "ZARA COAT 3";

	@Test(dataProvider="getData", groups="Purchase")
	public void SubmitOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		
		ProductPage productPage = landingPage.loginApp(input.get("email"), input.get("password"));
		List<WebElement> products = productPage.getProductList();
		productPage.addProductToCart(input.get("product"));
		cartPage cartpage = productPage.goToCart();
		Boolean match = cartpage.productsIncart(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkout = cartpage.goToCheckout();
		checkout.shippingInformation("india");
		OrderConfirmationPage confPage = checkout.goToOrderConfirmationPage();
		String orderConText = confPage.orderConfirmation();
		Assert.assertTrue(orderConText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dependsOnMethods = {"SubmitOrder"})
	public void OrderHistoryTest() {
		ProductPage productPage = landingPage.loginApp("rushit.patel1907@gmail.com", "Password01");
		OrderHistoryPage orderHistory = productPage.goToOrder();
		Assert.assertTrue(orderHistory.verifyProductsInOrderHistoryPage(productName));
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("email", "rushit.patel1907@gmail.com");
//		map.put("password", "Password01");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("product", "ADIDAS ORIGINAL");
		List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//LearningNewSkills//data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}

}
