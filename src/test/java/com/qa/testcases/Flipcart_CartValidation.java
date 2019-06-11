package com.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class Flipcart_CartValidation extends TestBase{
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
		 driver.get("https://www.flipkart.com/");
		 driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
	}
  @Test
  public void cart() throws InterruptedException {
	driver.findElement(By.xpath("//div/h2[contains(text(),'Deals of the Day')]"));
	WebElement deals_view=
			driver.findElement(By.xpath("//div/h2[contains(text(),'Deals of the Day')]//following::div[@class='_2Umlwf']//child::a[@class='_2AkmmA _1eFTEo' and contains(@href,'https://www.flipkart.com/dotd-store?=Web&wid=2.dealCard.OMU&otracker=hp_omu_Deals%2Bof%2Bthe%2BDay_0&otracker1=hp_omu_PINNED_neo%2Fmerchandising_Deals%2Bof%2Bthe%2BDay_NA_wc_view-all_0')] "));
			//driver.findElement(By.xpath("//div/h2[contains(text(),'Deals of the Day')]//following::div[@class='_2Umlwf']//child::a[@class='_2AkmmA _1eFTEo' and contains(@href,'offers-list/deals')]"));
	deals_view.click();
	Thread.sleep(3000);
	try {
		ArrayList<WebElement>deal_options=(ArrayList<WebElement>) driver.findElements(By.xpath("//div[contains(text(),'Off')]"));
		deal_options.add(deals_view);
		System.out.println("deal_options is" +deal_options);
		System.out.println("Deal options is"+deal_options.size());
		for(int i=0; i<deal_options.size(); i++)
		{
			System.out.println("List of deal options is"+deal_options.get(i).getText());
			if (deal_options.get(i).getText().contains("70%+Extra5%Off")) {	
				Thread.sleep(4000);
				deal_options.get(i).click();
				System.out.println("selected item is clicked");
				break;
						} else {
							System.out.println("selected item is not visible ");
						} 
			//Upto 70%+Extra5%Off

		}
	} catch (StaleElementReferenceException e) {
		System.out.println("Staleelementexception found");
	}
	
	/*
	
	Thread.sleep(3000);
	WebElement product_data=driver.findElement(By.xpath("//a[contains(text(),'Newport Friday 24 L Backpack')]"));
	//product_details=product_data.getAttribute("class");
	//System.out.println("product details of class value is "+product_details);
	product_data.click();
	//Actions action= new Actions(driver);
	//action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
	Thread.sleep(2000);
	
	*/
	
 }

}
	
