package com.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class Zoopla extends TestBase{
	public WebDriver driver;
	public String product_details;

	@BeforeClass
	public void setUp() throws InterruptedException {

		//initialization();
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(); 
        System.out.println("User has installed the chrome hence launching the chrome browser");
		driver.manage().window().maximize();
		System.out.println("-----------------User is logged to chrome browser ------------------");
		 driver.get("https://www.zoopla.co.uk/");
	}
	
	@Test
	public void inputsearch() throws InterruptedException
	{
		WebElement ele=driver.findElement(By.xpath("//input[@id='search-input-location']"));
		ele.sendKeys("London");
		Thread.sleep(3000);
		System.out.println("London values are entered");
		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Search')]")).click();
	}

@Test
public void propertydetails()
{
	ArrayList<String>obtainedList = new ArrayList<String>();
	List<WebElement>elementList=driver.findElements(By.xpath("//div[@class='agent_logo']//following::a[@class='listing-results-price text-price']"));
	
	
/*	for(int i=0; i<elementList.size();i++)
	{
		product_details=elementList.get(i).getText();
		System.out.println("element list values are"+ elementList.get(i).getText());
	}
	*/
	for(WebElement value: elementList)
	{
		System.out.println("values are" +value.getText());
		obtainedList.add(value.getText());
	}
	
	ArrayList<String> sortedList = new ArrayList<String>();   
	for(String s:obtainedList){
	sortedList.add(s);
	}
	System.out.println("Sorted values are below");
	Collections.sort(sortedList);
	System.out.println("After sorted order" +sortedList);
	
	

	
	
}
}