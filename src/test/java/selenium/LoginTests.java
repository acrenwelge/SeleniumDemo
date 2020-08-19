package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import saucedemo.LoginPage;
import seleniumdemo.SeleniumUtil;

public class LoginTests {
	static WebDriver driver;
	static LoginPage loginPg;
	
	@BeforeClass
	public static void init() {
		driver = SeleniumUtil.getDriver();
		loginPg = new LoginPage(driver);
	}
	
	@Before
	public void resetToLoginPage() {
		driver.get("https://www.saucedemo.com/index.html");
	}
	
	@After
	public void waitForDemoPurposes() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@AfterClass
	public void shutdown() {
		driver.quit();
	}
	
	@Test
	public void testValidLogin() {
		loginPg.login("standard_user", "secret_sauce");
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://www.saucedemo.com/inventory.html");
	}
	
	@Test
	public void testInvalidCredentials() {
		loginPg.login("wrong", "wrong");
		assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/index.html");
	}
}
