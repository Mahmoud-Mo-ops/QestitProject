package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverview {
	WebDriver driver;

	public CheckoutOverview(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "finish")
	private WebElement finishItem;

	public CompletePage confirm() {
		CompletePage completePage = new CompletePage(driver);
		finishItem.click();
		return completePage;
	}
}