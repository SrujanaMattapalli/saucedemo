// src/test/java/pages/LoginPage.java
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void loginToApplication(String username, String password) {
		waitForElementToBeVisible(usernameField);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
}
