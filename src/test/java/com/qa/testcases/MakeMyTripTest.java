package com.qa.testcases;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class MakeMyTripTest  extends TestBase{
	public WebDriver driver;
	public String product_details;

	
	@BeforeClass
	public void setUp() throws InterruptedException {

		//initialization();
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver(capabilities);
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		//driver = new ChromeDriver(); 
		
        System.out.println("User has installed the chrome hence launching the chrome browser");
		driver.manage().window().maximize();
		System.out.println("-----------------User is logged to chrome browser ------------------");
		 driver.get(" https://www.makemytrip.com");
		 driver.manage().deleteAllCookies();
		 Thread.sleep(9000);
		 //driver.findElement(By.xpath("//*[@id=\"webklipper-publisher-widget-container-notification-close-div\"]/i")).click();
		
	}
	
	@Test(priority=1)
	public void flightbookfromdate() throws InterruptedException
	{
		WebElement roundtrip;
		roundtrip=driver.findElement(By.xpath("//ul[@class='fswTabs latoBlack greyText']//li[2]//child::span[@class='tabsCircle appendRight5']"));
		roundtrip.click();
		Thread.sleep(2000);
		WebElement fromPlace=driver.findElement(By.xpath("//label/span[contains(text(),'From')]"));
		fromPlace.click();
		Thread.sleep(5000);
		WebElement fromPlaceValue=driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']"));
		Thread.sleep(3000);
		fromPlaceValue.sendKeys("Delhi");
		Thread.sleep(4000);
		fromPlaceValue.sendKeys(Keys.TAB);
		System.out.println("Keys entered for the from place");
		
		
		
	}
	@Test(priority=2)
	public void flightbookTodate() throws InterruptedException
	{
		WebElement ToPlaceValue=driver.findElement(By.xpath("//div/input[@class='react-autosuggest__input react-autosuggest__input--open']"));
		Thread.sleep(5000);
		ToPlaceValue.sendKeys("Bangalore");
		ToPlaceValue.sendKeys(Keys.TAB);
		System.out.println("Keys entered for the To place");
		
	}
	
	@Test(priority=3)
	public void DepartureCalender() throws InterruptedException
	{
		Calendar calendar=Calendar.getInstance();
		System.out.println("The current date is: "+calendar.getTime());
		
		calendar.add(calendar.DATE, +5);
		System.out.println("5 days later is "+calendar.getTime());
		
		int fivedayslater=calendar.get(calendar.DATE);
		System.out.println("Present calendar date "+fivedayslater);
		String str1=Integer.toString(fivedayslater);
		System.out.println("After converting integer to string" +str1);
		Thread.sleep(3000);
		//WebElement departdate=driver.findElement(By.xpath("//p[@class='blackText font20 code']/span[@class='font30 latoBlack ']"));
		//departdate.click();
		
		
		List<WebElement>alldates=driver.findElements(By.xpath("//div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div"));
		System.out.println("Alldates"+alldates.size());
		for(int i=0; i<alldates.size(); i++)
		{
			if(alldates.get(i).getText().contains(str1))
					{
						Thread.sleep(3000);
						alldates.get(i).click();
						
						System.out.println("selected item is clicked");
						break;
								} else {
									System.out.println("selected item is not visible ");
								} 
					}
		
		
		
	}
	
	@Test(priority=4)
	public void ReturnDateCalender() throws InterruptedException
	{
		Calendar calendarreturn=Calendar.getInstance();
		System.out.println("The current date is: "+calendarreturn.getTime());
		
		calendarreturn.add(calendarreturn.DATE, +10);
		System.out.println("5 days later is "+calendarreturn.getTime());
		
		int tendayslater=calendarreturn.get(calendarreturn.DATE);
		System.out.println("Present calendar date "+tendayslater);
		String str2=Integer.toString(tendayslater);
		System.out.println("After converting integer to string" +str2);
		Thread.sleep(3000);
		
		List<WebElement>returndates=driver.findElements(By.xpath("//div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[2]/div[3]/div/div"));
		System.out.println("Return dates"+returndates.size());
		
		for(int j=0; j<returndates.size(); j++)
		{
			if(returndates.get(j).getText().contains(str2))
			{
				Thread.sleep(4000);
				returndates.get(j).click();
				System.out.println("Return item date is clicked");
				break;
			}
			else
			{
				System.out.println("Return date is not displayed");
			}
		}
		

		
	}
	

	@Test(priority=6)
	public void searchResutls() throws Exception
	{
		WebElement searchbutton=driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
		searchbutton.click();
		
		Thread.sleep(20000);
		List<WebElement>searchres=driver.findElements(By.xpath("//*[@id=\"ow_domrt-jrny\"]/div/div/label"));
		System.out.println("searhres is"+searchres.size());
		for(int k=0; k<searchres.size(); k++)
		{
			String searchlist=searchres.get(k).getText();
			System.out.println("Search results is listed here" + searchlist);
		}
	}
}
