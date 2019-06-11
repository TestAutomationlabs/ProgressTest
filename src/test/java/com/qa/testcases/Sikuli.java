package com.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import jdk.internal.dynalink.beans.StaticClass;

public class Sikuli {

	public static void main(String[] args) throws SikuliException
	{
		WebDriver driver;
	 
//		 // Creating Object of 'Screen' class
//		 //Screen is a base class provided by Sikuli. It allows us to access all the methods provided by Sikuli.
//		 Screen screen = new Screen();
//		 // Creating Object of Pattern class and specify the path of specified images
//		 // I have captured images of Facebook Email id field, Password field and Login button and placed in my local directory
//		 // Facebook user id image 
//		 Pattern username = new Pattern("C:\\Users\\SLANKEGO\\Pictures\\Progress\\username.png");
//		 // Facebook password image
//		 Pattern password = new Pattern("C:\\Users\\SLANKEGO\\Pictures\\Progress\\password.png");
//		 // Facebook login button image
//		 Pattern login = new Pattern("C:\\Users\\SLANKEGO\\Pictures\\Progress\\LogIn.png");
//		 // Initialization of driver object to launch firefox browser 
		 System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
			
			//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
			driver = new ChromeDriver(); 
		 // To maximize the browser
		 driver.manage().window().maximize();
		 // Open Facebook
		 driver.get("Google.com");
//		Thread.sleep(5000);

		// find the Explore global search trends for MeToo element using linkText Locator

		WebElement element = driver.findElement(By.linkText("Explore global search trends for MeToo"));

		// Instantiate Point class to get location of X and Y co-ordinates.

		Point point = element.getLocation();

		// Store value of elements as pixels in integers x and y

		int x = point.getX();

		System.out.println("Horizontal Position: " + x + " pixels");

		int y = point.getY();

		System.out.println("Vertical Position " + y + " pixels");

		Actions action = new Actions(driver);

		action.moveToElement(element, x, y).click().build().perform();

		}

		}


