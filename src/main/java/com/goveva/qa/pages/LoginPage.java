package com.goveva.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.goveva.qa.base.TestBase;

public class LoginPage extends TestBase  {
	// pagefactory
		//public static WebDriver driver;
		@FindBy(xpath = "//*[@name='Email']")
		static WebElement username;

		@FindBy(xpath = "//*[@name='Password']")
		static WebElement password;

		@FindBy(xpath = "//*[@class='placeholder']")
		static WebElement selectDisplayName;
		
		
		@FindBy(xpath = "//div[@class='toggle']")
		static WebElement clickCompanyBox ;
		
		
		@FindBy(xpath = "//input[@autocomplete='off']")
		static WebElement dropdownValue;
		
		
		@FindBy(xpath = "//*[@type='button']")
		static WebElement LoginBtn;
		
		// Initialize the page factory
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			
		}
		
		
		public static Dashboard login(String un , String pw)
		{
			username.sendKeys(un);
			clickCompanyBox.click();
			dropdownValue.sendKeys("HDFC Bank Ltd.");
			dropdownValue.sendKeys(Keys.ENTER);
			password.sendKeys(pw);
			
			return new Dashboard();
		}
		public static String validateTitleOfPSS(WebDriver driver) {
			return driver.getTitle();

		}

}
