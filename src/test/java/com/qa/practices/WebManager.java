package com.qa.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.pages.AlignmentPhase;
import com.qa.pages.ProposalPhase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebManager {
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}

	@Test
	public void browserlaunch()
	{
			
		
		//System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		//driver = new ChromeDriver(); 
	    //System.out.println("User has installed the chrome hence launching the chrome browser");
	    driver.get("http://www.SoftwareTestingMaterial.com");
	   	    
	    
	
	}
}
