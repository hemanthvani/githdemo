package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

	public WebDriver driver;

	private By forgotEmail = By.id("txtlogin");
	private By submitNext = By.xpath("//input[@type='submit']");

	public ForgotPassword(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getEmail() {
		return driver.findElement(forgotEmail);

	}

	public WebElement getSubmit() {
		return driver.findElement(submitNext);
	}

}
