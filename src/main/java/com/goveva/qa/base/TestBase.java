package com.goveva.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.goveva.qa.utils.TestUtils;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase()
	{
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\dinesh\\workspace\\pssTest\\src\\main\\java\\com\\goveva\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
	
	public static void initialization(){
		String BrowserName = prop.getProperty("browser");
		if(BrowserName.equals("chrome"))
			
		{
			
			String exePath = "D:\\Dinesh\\Software\\chromedriver_win32\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", exePath);
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		
			driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			//WebDriverWait wait=new WebDriverWait(driver, 30);
			driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
		}
			
		
	}
	
	

}
