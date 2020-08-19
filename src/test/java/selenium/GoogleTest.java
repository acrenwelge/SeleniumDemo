package selenium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import seleniumdemo.SeleniumUtil;

public class GoogleTest {
	
	@Test
	public void testGooglePage() {
		WebDriver driver = SeleniumUtil.init();
		driver.get("https://google.com");
		String title = driver.getTitle();
		assertEquals(title, "Google");
		driver.quit();
	}
}
