package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.IOException;

public class TestBase {
 
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		try {
		prop = new Properties();
		FileInputStream input = new FileInputStream("H:\\Java_Practice\\Eclipse_WorkSpace_1\\FreeCRMTestAutomation\\src\\main\\java\\config\\Properties\\config.properties");
		prop.load(input);
		
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","H:\\Java_Practice\\Selenium\\drivers\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// launch URL
		driver.get(prop.getProperty("url"));
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}
	
	
	
}
