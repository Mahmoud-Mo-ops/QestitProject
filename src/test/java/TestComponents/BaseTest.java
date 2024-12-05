package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import pageObjects.LandingPage;

public class BaseTest {
	public WebDriver driver;

	public WebDriver initializeDriver() {
		try {
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}


	public LandingPage launchApplication() {
		// open edge
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goToWebsite();
		return landingPage;
	}
}