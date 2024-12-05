package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productCardItems;

	@FindBy(id = "checkout")
	private WebElement checkOutItem;

	public boolean verifyProduct(String product) {
		boolean match = productCardItems.stream()
				.anyMatch(productCardItem -> productCardItem.getText().equalsIgnoreCase(product));
		return match;
	}

	public CheckOutPage makeCheckOut() {
		checkOutItem.click();
		CheckOutPage checkOutPage=new CheckOutPage(driver);
		return checkOutPage;
	}
}