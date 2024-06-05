package LearningNewSkills.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LearningNewSkills.AbstractComponents.AbstractComponents;

import org.openqa.selenium.WebDriver;

public class LandingPage extends AbstractComponents{

	WebDriver driver;

	public LandingPage(WebDriver driver) {

		super(driver);
		// initilization
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement Submit;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement errorMessage;
	
	//.ng-tns-c4-8.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public ProductPage loginApp(String email, String pass) {

		userEmail.sendKeys(email);
		password.sendKeys(pass);
		Submit.click();
		ProductPage productPage = new ProductPage(driver);
		return productPage;
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	


}
