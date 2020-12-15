package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver InitalizeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	//	String browserName=System.getProperty("browser");	// for multiple browers from Jenkins
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			ChromeOptions options = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			// 
			if (browserName.contains("headless")) 
			{
			options.addArguments("--headless");
			}
			driver = new ChromeDriver(options); 
//			driver = new ChromeDriver();  

		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("Edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\msedgedriver.exe");
			driver = new EdgeDriver();

		}   
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
