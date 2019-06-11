package com.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OSDetails {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File chrome = new File("C:/Program Files (x86)/Google/Chrome");
        if(chrome.exists())
        {
            System.out.println("User has chrome installed");
		
        }
        else
        {
        	System.out.println("User has not installed chrome");
        }
			//String browserName = prop.getProperty("browser");
			
			//if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
				
				//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
				driver = new ChromeDriver(); 
				CheckBrowserOS();
				
	}
		
		public static void CheckBrowserOS() {
			  //Get Browser name and version.
			  Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
			  String browserName = caps.getBrowserName();
			  String browserVersion = caps.getVersion();
			  
			  //Get OS name.
			  String os = System.getProperty("os.name").toLowerCase();
			  System.out.println("OS = " + os + ", Browser = " + browserName + " "+ browserVersion);	
			 } 
			}
	


