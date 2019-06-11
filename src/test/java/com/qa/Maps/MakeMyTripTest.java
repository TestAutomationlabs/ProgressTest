package com.qa.Maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MakeMyTripTest {
	WebDriver driver;
	public String dateselect;
	@BeforeMethod
	public void setup()
	{

	System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
	
	//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
	driver = new ChromeDriver(); 
    System.out.println("User has installed the chrome hence launching the chrome browser");
	driver.get("https://www.makemytrip.com/");
	
	
	}
	@Test(priority=1)
	public void calendarselect() throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/label/span")).click();
		dateselect=Data_MakeMyTrip.mothmap().get(8);
		System.out.println("Dateselect is"+dateselect);
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]"));
		try {
		if(ele.equals(dateselect))
				{
			System.out.println("Selected month is August");
		
				}
		else
		{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			
		}
		}
		catch(Exception e)
		{
			System.out.println("Element not found");
		}
	}
}