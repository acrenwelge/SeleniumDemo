package theinternetdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumdemo.SeleniumUtil;

public class TheInternetDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumUtil.getDriver();
		driver.get("http://the-internet.herokuapp.com");
		Thread.sleep(1000);
		driver.findElement(By.linkText("Dynamic Controls")).click();
		WebElement checkBoxBtn = driver.findElements(By.tagName("button")).get(0);
		checkBoxBtn.click();
		Thread.sleep(1000);
		WebElement checkBox = driver.findElement(By.id("checkbox")).findElement(By.tagName("input"));
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(checkBox));
		Thread.sleep(1000);
		checkBoxBtn.click();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox")));
		driver.findElement(By.id("checkbox")).click();
	}

}
