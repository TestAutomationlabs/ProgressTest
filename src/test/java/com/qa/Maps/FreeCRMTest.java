package com.qa.Maps;

import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest {
	WebDriver driver;
	public String creditianls;
	public String creditianlsinfo[];

	
	@BeforeMethod
	public void setup()
	{

	System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
	
	//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
	driver = new ChromeDriver(); 
    System.out.println("User has installed the chrome hence launching the chrome browser");
	driver.get("https://classic.crmpro.com");
	
	
	
	
}
	@Test(priority=1)
	public void loginwithAdminTest() throws Exception {
		/*
		 * Splits are used to store in String array[], 
		 * Hence we are using public String creditianlsinfo[];

		 */
		Thread.sleep(3000);
		//String admincreditianls=Data.getUserLoginInfo().get("admin");
		creditianls=Data.getUserLoginInfo().get("admin");
		creditianlsinfo=creditianls.split("_");
		
		driver.findElement(By.name("username")).sendKeys(creditianlsinfo[0]);
		driver.findElement(By.name("password")).sendKeys(creditianlsinfo[1]);
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
		
		
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		Select select = new Select(driver.findElement(By.name("slctMonth")));
		select.selectByVisibleText(Data.monthMap().get(10));
		
		
		
		
		
	}

	
/*@Test(priority=2)
public void loginwithcustomerTest() throws Exception {
	Thread.sleep(3000);
	creditianls=Data.getUserLoginInfo().get("customer");
	creditianlsinfo=creditianls.split("_");
	
	driver.findElement(By.name("username")).sendKeys(creditianlsinfo[0]);
	driver.findElement(By.name("password")).sendKeys(creditianlsinfo[1]);
	WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", loginBtn);
}*/
}
	
	
	/*public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		WebDriver driver = new ChromeDriver(); 
	    System.out.println("User has installed the chrome hence launching the chrome browser");
		driver.manage().window().maximize();
		driver.get("https://classic.crmpro.com");
		String admincreditianls=Data.getUserLoginInfo().get("admin");
		String creditianlsinfo[]=admincreditianls.split("_");
		driver.findElement(By.name("username")).sendKeys(creditianlsinfo[0]);
		driver.findElement(By.name("password")).sendKeys(creditianlsinfo[1]);
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
		
	}
	*/
	/* WebDriver driver;
	public String creditianls;
	public String creditianlsinfo[];

	
	
	
	
	@Test(enabled=false)
	public void loginwithCustomerTest() {
		creditianls=Data.getUserLoginInfo().get("customer");
		creditianlsinfo=creditianls.split("_");
		
		driver.findElement(By.name("username")).sendKeys(creditianlsinfo[0]);
		driver.findElement(By.name("password")).sendKeys(creditianlsinfo[1]);
		WebElement loginBtn=driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}
}
*/