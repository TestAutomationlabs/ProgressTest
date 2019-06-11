package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IncognitoLaunch {
	public WebDriver driver;
	@BeforeClass
	public void setUp() throws InterruptedException {

		//initialization();
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		//driver = new ChromeDriver(); 
	}
	
	@Test
	public void testcase()
	{
		System.out.println("Firsttestcase");
	}
}
