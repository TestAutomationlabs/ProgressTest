package com.qa.practices;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sun.glass.ui.View.Capability;

import bsh.Capabilities;

public class SSLCertifcate {
	
	public WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup()
	{
	
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		//To enable the browser
		//cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		//To disable the browser
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,false);
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
	
}
	@Test
	public void openApplication() {
		System.out.println("Navigating application");
		driver.get("https://cacert.org/");
}
}