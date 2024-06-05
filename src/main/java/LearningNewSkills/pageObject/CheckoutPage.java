package LearningNewSkills.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningNewSkills.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement checkoutButton;
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement enterShippingCountry;
	
	//By enterShippingCountry = By.cssSelector("[placeholder='Select Country']");
	By countryList = By.cssSelector(".ta-results");
	
	public void shippingInformation(String countryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(enterShippingCountry, countryName).build().perform();
		waitForElementToAppear(countryList);		
		selectCountry.click();		
	}
	
	public OrderConfirmationPage goToOrderConfirmationPage() throws InterruptedException {
		checkoutButton.click();
		OrderConfirmationPage confPage = new OrderConfirmationPage(driver);
		return confPage;
		
	}

}
