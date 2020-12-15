package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	private By signin=By.xpath("//*[@id=\"signin_info\"]/a[1]");
	private By logo = By.xpath("/html/body/div[2]/div/div[1]/span");
	private By createAccountText = By.xpath("//*[@id=\"signin_info\"]/a[2]");
	private By EnterPriseText = By.xpath("//*[@class='cell topicons']/a[5]");
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public LogInPage getSignin() {
		driver.findElement(signin).click();
		LogInPage lg = new LogInPage(driver);
		return lg;
		
	}
	
	public WebElement getLogo() {
		return driver.findElement(logo);
	}
	
	public WebElement getCreateLoginText() {
		return driver.findElement(createAccountText);
	}
	
	public WebElement getEnterpriseText() {
		return driver.findElement(EnterPriseText);
	}

}
