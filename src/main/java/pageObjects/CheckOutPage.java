package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='First Name']")
	private WebElement firstNameElement;

	// Password field

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	private WebElement lastNameElement;

	// login Button
	@FindBy(id = "postal-code")
	private WebElement postalCodeElement;

	@FindBy(id = "continue")
	private WebElement continueElement;

	public CheckoutOverview fillCheckoutDetails(String firstName, String lastName, String postalCode) {
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		postalCodeElement.sendKeys(postalCode);
		continueElement.click();
		CheckoutOverview checkoutOverview = new CheckoutOverview(driver);
		return checkoutOverview;
}
}