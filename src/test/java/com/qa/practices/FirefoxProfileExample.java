package com.qa.practices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
public class FirefoxProfileExample {
 	public static void main(String[] args) {
	
 		ProfilesIni Prof = new ProfilesIni();
 		FirefoxProfile profile = Prof.getProfile("Selenium_User");
		//Open Firefoxdriver that will open your Firefox Profile
		WebDriver driver = new FirefoxDriver();		
 
 		
	//WebDriver driver = new FirefoxDriver(myprofile);
//Maximize browser window
	driver.manage().window().maximize();
//Go to URL which you want to navigate
	driver.get("http://www.google.com");
//Set  timeout  for 5 seconds so that the page may load properly within that time
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//close firefox browser
	driver.close();
	System.out.println("close the browser");
}

}