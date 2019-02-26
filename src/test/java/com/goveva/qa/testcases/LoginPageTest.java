package com.goveva.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.goveva.qa.base.TestBase;
import com.goveva.qa.pages.Dashboard;
import com.goveva.qa.pages.LoginPage;


public class LoginPageTest extends TestBase{
	
	LoginPage LoginPage;
	Dashboard dashboard;
	public LoginPageTest(){
		
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		LoginPage LoginPage = new LoginPage(driver);
		
	}
	
	@Test(priority = 1)
	public void LogInTitleTest() { 
		String title = LoginPage.validateTitleOfPSS(driver);  
		Assert.assertEquals(title, "GovEva Client");
	} 
	
	@Test(priority = 2)
	public void LoginTest()
	{
	
		dashboard = LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//dashboard = LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	

}
