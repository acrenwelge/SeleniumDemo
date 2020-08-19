package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import saucedemo.HomePage;
import saucedemo.LoginPage;
import seleniumdemo.SeleniumUtil;

public class HomePageTest {

	static WebDriver driver;
	static LoginPage loginPg;
	static HomePage homePg;
	
	@BeforeClass
	public static void init() {
		driver = SeleniumUtil.getDriver();
		loginPg = new LoginPage(driver);
		homePg = new HomePage(driver);
		driver.get("https://www.saucedemo.com/index.html");
		loginPg.login("standard_user", "secret_sauce");
	}
	
	@After
	public void waitForDemoPurposes() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@AfterClass
	public static void shutdown() {
		driver.quit();
	}
	
	@Test
	public void testAlphabeticalSort() {
		homePg.sortItemsReverseAlpha();
		String firstItem = homePg.getItemsInOrder().get(0).getText();
		assertEquals(firstItem, "Test.allTheThings() T-Shirt (Red)");
	}
	
	@Test
	public void testPriceSort() {
		homePg.sortByHighToLowPrice();
		String firstItem = homePg.getItemsInOrder().get(0).getText();
		assertEquals(firstItem, "Sauce Labs Fleece Jacket");
	}
}
