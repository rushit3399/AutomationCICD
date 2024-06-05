package LearningNewSkills.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import LearningNewSkills.AbstractComponents.AbstractComponents;

public class OrderHistoryPage extends AbstractComponents {

	WebDriver driver;

	public OrderHistoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> productsInOrdersHistory;

	public Boolean verifyProductsInOrderHistoryPage(String productName) {
		Boolean match = productsInOrdersHistory.stream()
				.anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

//	public boolean verifyProductsInOrderHistoryPage(String productName) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
