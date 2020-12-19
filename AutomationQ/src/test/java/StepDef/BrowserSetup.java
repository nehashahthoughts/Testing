package StepDef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserSetup 
{
	public WebDriver driver; //initializing the web driver 
	public Properties prop; // initializing the properties class by creating prop object
	
	public WebDriver initializeDriver() throws IOException {
		
	prop=new Properties();
	
	//FileInputStream is useful to read data from a file in 
	FileInputStream fis=new FileInputStream("D:\\AutomationQ\\src\\test\\java\\StepDef\\Data.properties");
	prop.load(fis);
	//to get the path of the browser you are using from data.properties
	String browserName=prop.getProperty("Browser");
	
	if(browserName.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",".\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		
	}
	if(browserName.equalsIgnoreCase("firefox")) {

		System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
		 driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
   }

}
