package seleniumdemo;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtil {
	
	public static final String driverPath = "src/main/resources/chromedriver.exe";
	
	private static WebDriver driver;
	
	public static WebDriver init() {
		File filePath = new File(driverPath);
		System.setProperty("webdriver.chrome.driver", filePath.getAbsolutePath());
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver getDriver() {
		if (driver != null) {
			return driver;
		}
		return init();
	}
}
