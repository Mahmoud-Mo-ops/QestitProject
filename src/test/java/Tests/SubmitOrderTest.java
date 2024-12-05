package Tests;

import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.CheckoutOverview;
import pageObjects.CompletePage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTest {
	private String selectedProduct; // Define the product name you want to verify

	@Test
	public void openBrowser() {
		LandingPage landingPage = launchApplication();
		ProductCatalogPage productCatalogPage = landingPage.login("standard_user", "secret_sauce");

		Optional<String> productName = productCatalogPage.findAndAddProductsByPrice(10);
		if (productName.isPresent()) {
			selectedProduct = productName.get();
			CartPage cartPage = productCatalogPage.goToCartPage();
			Boolean match = cartPage.verifyProduct(selectedProduct);
			Assert.assertTrue(match, "The selected product was not found in the cart.");
			CheckOutPage checkOutPage	=cartPage.makeCheckOut();
			CheckoutOverview checkoutOverview=	checkOutPage.fillCheckoutDetails("mahmoud","Goma","5151");
			CompletePage completePage=	checkoutOverview.confirm();
			String confirmationText= completePage.verifcationText();
			
			Assert.assertEquals(confirmationText, "Thank you for your order!");
			
		} else {
			Assert.fail("No products found under the specified price.");
		}
	}
}