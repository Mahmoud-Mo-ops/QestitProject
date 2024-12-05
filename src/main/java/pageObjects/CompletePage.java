package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage {
	WebDriver driver;

	
	public CompletePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css =".complete-header")
	private WebElement confirmationText;
	
	public String verifcationText() {
		String VerificationText=confirmationText.getText();
		return VerificationText;
	}
}
