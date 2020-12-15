package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {

	public WebDriver driver;

	private By email = By.id("login1");
	private By password = By.id("password");
	private By login = By.xpath("//input[@class='signinbtn']");
	private By singInLogo = By.xpath("//div[@class='logtext']");
	private By forgotPassWord = By.cssSelector("[href*='newforgot/index']");

	public LogInPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public ForgotPassword forgotPassWord() {
		driver.findElement(forgotPassWord).click();
		return new ForgotPassword(driver);

	}

	public WebElement getEmail() {
		return driver.findElement(email);

	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getSignLogo() {
		return driver.findElement(singInLogo);
	}

}
