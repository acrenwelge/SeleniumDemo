package theinternetdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumdemo.SeleniumUtil;

public class TheInternetDemo {
	
	static WebDriver driver = SeleniumUtil.getDriver();
	static WebDriverWait wait = new WebDriverWait(driver, 5);

	public static void main(String[] args) throws InterruptedException {
		driver.get("http://the-internet.herokuapp.com");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		WebElement checkBoxBtn = driver.findElements(By.tagName("button")).get(0);
		checkBoxBtn.click();
		Thread.sleep(1000);
		WebElement checkBox = driver.findElement(By.id("checkbox")).findElement(By.tagName("input"));
		wait.until(ExpectedConditions.invisibilityOf(checkBox));
		Thread.sleep(1000);
		checkBoxBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		driver.findElement(By.id("checkbox")).click();
	}

}
