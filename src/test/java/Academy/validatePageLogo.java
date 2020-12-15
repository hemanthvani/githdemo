package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import resources.base;

public class validatePageLogo extends base{
	public WebDriver driver;
	LandingPage land;
	
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver=InitalizeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("Browser Invoked in validatePageLogo Class");
		
	}
	
	@Test
	public void validatePageTitle() throws IOException {
	
		land = new LandingPage(driver);
		Assert.assertEquals(land.getCreateLoginText().getText(), "Create Account");
		log.info("Create Account Tab text Spelling is Right");
		
	}
	

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
