package LearningNewSkills.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import LearningNewSkills.AbstractComponents.AbstractComponents;

public class cartPage extends AbstractComponents{
	
	WebDriver driver;
	
	
	public cartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".cart h3")
	List<WebElement> cartProducts;
	
	@FindBy(css = "[class*=subtotal] button")
	WebElement checkoutButton;

	public boolean productsIncart(String productName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;		
	}
	
	public CheckoutPage goToCheckout() {
		checkoutButton.click();
		CheckoutPage checkout = new CheckoutPage(driver);
		return checkout;
	}

}
