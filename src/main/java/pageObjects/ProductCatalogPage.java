package pageObjects;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogPage {
	WebDriver driver;

	public ProductCatalogPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".inventory_item_description")
	private List<WebElement> products;

	@FindBy(css = ".shopping_cart_link")
	private WebElement shoppingCar;

	public Optional<String> findAndAddProductsByPrice(double maxPrice) {
		List<WebElement> selectedProducts = products.stream().filter(product -> {
			String priceText = product.findElement(By.className("inventory_item_price")).getText();
			double price = Double.parseDouble(priceText.replace("$", "").replace(",", ""));
			return price < maxPrice;
		}).collect(Collectors.toList()); // Collect all matching products

		if (!selectedProducts.isEmpty()) {
			selectedProducts.forEach(product -> {
				WebElement priceElement = product.findElement(By.className("inventory_item_price"));
				System.out.println("Selected Product Price: " + priceElement.getText());
				product.findElement(By.cssSelector(".btn_inventory")).click(); // Add to cart
			});
			System.out.println("Added all products under $" + maxPrice + " to the cart.");
			// Return the name of the first product added to the cart
			return Optional.of(selectedProducts.get(0).findElement(By.className("inventory_item_name")).getText());
		} else {
			System.out.println("No products found under the specified price.");
			return Optional.empty();
		}
	}

	public CartPage goToCartPage() {
		shoppingCar.click();
		return new CartPage(driver);
	}
}