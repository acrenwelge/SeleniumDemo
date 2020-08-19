package saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id = "user-name")
	private WebElement usernameInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(id = "login-button")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver d) {
		this.driver = d;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginBtn.click();
	}
}
