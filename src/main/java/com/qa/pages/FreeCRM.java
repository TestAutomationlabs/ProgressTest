package com.qa.pages;


	

	import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;


	public class FreeCRM extends TestBase{
		//public WebDriver driver;
		
		//Page Factory - OR:
		@FindBy(xpath="//input[@name='username']")
		public WebElement username;
		
		@FindBy(xpath="//input[@name='buff']")
		public WebElement password;
		
		@FindBy(xpath="//input[@type='submit']")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//a[@class='navbar-brand']")
		WebElement crmLogo;
		
		//Initializing the Page Objects:
		public FreeCRM(){
			PageFactory.initElements(driver, this);
		}
		
		
		
		//Actions:
		public String validateLoginPageTitle(){
			
			System.out.println("Title is " +driver.getTitle());
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public void login(){
			username.click();
			username.sendKeys("eclipse");
			password.sendKeys("eclipse");
			loginBtn.click();
//			    	JavascriptExecutor js = (JavascriptExecutor)driver;
//			    	js.executeScript("arguments[0].click();", loginBtn);
//			    	
			
		
	}
}
