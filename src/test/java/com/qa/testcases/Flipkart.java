package com.qa.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.pages.AlignmentPhase;

public class Flipkart extends TestBase{
	public WebDriver driver;
	@BeforeClass
	public void setUp() throws InterruptedException {

		//initialization();
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(); 
        System.out.println("User has installed the chrome hence launching the chrome browser");
		
		System.out.println("-----------------User is logged to chrome browser ------------------");
		
		
//		System.out.println("List of more option is is" + more_options.get(x).getText());
//		if (more_options.get(x).getText().contains("Move to next phase")) {
//			Thread.sleep(2000);
//			more_options.get(x).click();
//			System.out.println("Move to next phase is clicked");
//		} else {
//			System.out.println("more options is not visible for title");
//		}
//		
//
//	}
	}
	
  /*@Test
  public void login() throws InterruptedException {
	  driver.get("https://www.flipkart.com/");
	  driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	//h2[contains(text(),'Deals of the Day')]
	//a[contains(text(),'VIEW ALL')]
	WebElement deals;
	deals=driver.findElement(By.xpath("//h2[contains(text(),'Deals of the Day')]//following::div[@class='_2Umlwf']/a[@class='_2AkmmA _1eFTEo' and contains(text(),'VIEW ALL')]"));
	deals.click();
	Thread.sleep(3000);
	try {
		List<WebElement>deal_options=driver.findElements(By.xpath("//div//following::div[@class='iUmrbN']"));
		System.out.println("Deal options is"+deal_options.size());
		for(int i=0; i<deal_options.size(); i++)
		{
			System.out.println("List of deal options is"+deal_options.get(i).getText());
			if (deal_options.get(i).getText().contains("Puma, Adidas & more")) {	
				Thread.sleep(2000);
				deal_options.get(i).click();
				System.out.println("selected item is clicked");
						} else {
							System.out.println("selected item is not visible ");
						}

		}
	} catch (StaleElementReferenceException e) {
		System.out.println("Staleelementexception found");
	}
}
  */
 @Test(priority=2) 
 public void offers()throws InterruptedException
 {
	 driver.get("https://www.flipkart.com/");
	  driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	//h2[contains(text(),'Deals of the Day')]
	//a[contains(text(),'VIEW ALL')]
	WebElement deals;
	deals=driver.findElement(By.xpath("//h2[contains(text(),'Deals of the Day')]//following::div[@class='_2Umlwf']/a[@class='_2AkmmA _1eFTEo' and contains(text(),'VIEW ALL')]"));
	deals.click();
	Thread.sleep(3000);
	try {
		List<WebElement>deal_options=driver.findElements(By.xpath("//div[contains(text(),'Off')]"));
		System.out.println("Deal options is"+deal_options.size());
		for(int i=0; i<deal_options.size(); i++)
		{
			System.out.println("List of deal options is"+deal_options.get(i).getText());
			if (deal_options.get(i).getText().contains("Upto80%+Extra10%Off")) {	
				Thread.sleep(2000);
				deal_options.get(i).click();
				System.out.println("selected item is clicked");
						} else {
							System.out.println("selected item is not visible ");
						} 
			//Upto 70%+Extra5%Off

		}
	} catch (StaleElementReferenceException e) {
		System.out.println("Staleelementexception found");
	}
 }
}
 
