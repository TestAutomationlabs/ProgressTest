package com.qa.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResizeBrowser {
	static WebDriver driver;
	public static void main(String[] args) {
		
	
System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
	
	//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
	driver = new ChromeDriver(); 
    System.out.println("User has installed the chrome hence launching the chrome browser");
    driver.navigate().to("http://www.SoftwareTestingMaterial.com");
    System.out.println(driver.manage().window().getSize());
    Dimension d=new Dimension(480,620);
    driver.manage().window().setSize(d);
    System.out.println(driver.manage().window().getSize());
    
    
}
}