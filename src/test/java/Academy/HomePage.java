package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LogInPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver=InitalizeDriver();
		driver.manage().window().maximize();
		log.info("Browser Launched Successfully");
		log.error("Home Page Browser not Invoked");
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
	
		driver.get(prop.getProperty("url"));
		
		LandingPage land = new LandingPage(driver);
		LogInPage lg = land.getSignin();
		
		lg.getEmail().sendKeys(username);
		lg.getPassword().sendKeys(password);
		System.out.println(text);
		log.info("Users Verified Successfully");
		lg.getLogin().click();
		
		ForgotPassword fp = lg.forgotPassWord();
		fp.getEmail().sendKeys("hemanth");
		fp.getSubmit().click();
		log.info("Navigated to Forgot Password Page");
		
	}
	
	// to automate with different User Credentials(UserName,Password)
	
	//	user			 email - password - Text
	// restricted		
	// non restriceted
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		
		data[0][0] = "restricteduser@qa.com";
		data[0][1] = "restricted1234";
		data[0][2] = "Restricted User should not Login";
		
		data[1][0] = "nonrestricteduser@qa.com";
		data[1][1] = "nonrestr12345";
		data[1][2] = "Non-Restricted User should be Login";
		
		return data;

	}
	@AfterTest
	
	public void tearDown() {
		driver.close();
	}

}
