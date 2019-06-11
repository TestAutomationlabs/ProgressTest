package com.qa.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessChrome {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		//co.setHeadless(true);
		
		WebDriver driver = new ChromeDriver(co);
		
		driver.get("https://classic.crmpro.com/");
		
		System.out.println("login page title is: "+ driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("netbeans");
		driver.findElement(By.id("password")).sendKeys("netbeans");
		
		driver.findElement(By.id("loginBtn")).click();
		
		Thread.sleep(10000);
		
		System.out.println("login page title is: "+ driver.getTitle());

		
		
	}

}


