package Academy;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IDynamicGraph.Status;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base{
	public WebDriver driver;
	
	LandingPage land;
	
	public static Logger log = (Logger) LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void launchBrowser() throws IOException {
		driver=InitalizeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("URL", Status.FINISHED, "Url Navigated to HomePage");
		
	}
	

	@Test
	public void titleValidation() throws IOException {
		
		
		land = new LandingPage(driver);
		Assert.assertTrue(land.getLogo().isDisplayed());
		log.info("WebPage Logo is Available");
		
	}
	
	@Test
	public void validateEnperpriseText() throws IOException {
		
		
		Assert.assertTrue(land.getEnterpriseText().isDisplayed());
		log.info("Enterprises Text is Available");
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}
