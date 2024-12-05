package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	WebDriver driver;
	// WebDriverWait wait;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		// this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // 10 seconds
		// wait
		PageFactory.initElements(driver, this);
	}

	// userName
	@FindBy(xpath = "//input[@type='text']")
	private WebElement userNameElement;

	// Password field
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordElement;

	// login Button
	@FindBy(id = "login-button")
	private WebElement loginButton;

	// Go to Website
	public void goToWebsite() {
		driver.get("https://www.saucedemo.com/");
	}

	public ProductCatalogPage login(String userName,String password) {
		userNameElement.sendKeys(userName);
		passwordElement.sendKeys(password);
		loginButton.click();
		ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
		return productCatalogPage;
	}
}