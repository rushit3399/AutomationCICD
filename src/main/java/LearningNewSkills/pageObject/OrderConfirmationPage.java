package LearningNewSkills.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningNewSkills.AbstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents{
	
	WebDriver driver;

	public OrderConfirmationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".hero-primary")
	WebElement orderConfirm;
	
	public String orderConfirmation() {
		return orderConfirm.getText();
	}

}
