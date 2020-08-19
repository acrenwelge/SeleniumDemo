package seleniumdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleExample {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.init();
		driver.get("https://google.com");
		WebElement inputBox = driver.findElement(By.name("q"));
		inputBox.sendKeys("What is Bitcoin");
		inputBox.sendKeys(Keys.ENTER);
		List<WebElement> wikiLinks = driver.findElements(By.partialLinkText("Wikipedia"));
		for (WebElement link : wikiLinks) {
			System.out.println("here's a link: " + link.getText());
		}
		wikiLinks.get(0).click();
		Thread.sleep(1000);
		String wikiUrl = driver.getCurrentUrl();
		// go back to Google!
		driver.navigate().back();
		System.out.println(wikiUrl);
		driver.quit();
	}

}
