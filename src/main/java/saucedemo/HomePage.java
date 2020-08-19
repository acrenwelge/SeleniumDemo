package saucedemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	@FindBy(className = "product_sort_container")
	private WebElement selectDropdown;
	
	@FindBy(className = "inventory_list")
	private WebElement itemContainer;
	
	public void sortItemsReverseAlpha() {
		new Select(selectDropdown).selectByValue("za");
	}
	
	public void sortByHighToLowPrice() {
		new Select(selectDropdown).selectByValue("hilo");
	}
	
	public List<WebElement> getItemsInOrder() {
		return itemContainer.findElements(By.className("inventory_item_name"));
	}
	
	public HomePage(WebDriver d) {
		PageFactory.initElements(d, this);
	}
}
