package com.qa.TestDataDriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_ExcelDrive {
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(); 
        System.out.println("User has installed the chrome hence launching the chrome browser");
        //driver.get("https://classic.crmpro.com/login.cfm");
        driver.get("https://lego-aa4d355e1.dispatcher.hana.ondemand.com/index.html#Dashboard"); 
        
        
        
	
	}
 // @Test(dataProvider="getData")
	
	@Test(dataProvider="testData")
  public void loginTest(String title, String desc) throws InterruptedException
  {
	  Thread.sleep(5000);
	  driver.findElement(By.xpath("//span[contains(text(),'New Project')]")).click();
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//label/span[contains(text(),'Project Title')]//following::input[1]")).clear();
	  driver.findElement(By.xpath("//label/span[contains(text(),'Project Title')]//following::input[1]")).sendKeys(title);
	  driver.findElement(By.xpath("//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[1]/div[2]/textarea")).sendKeys(desc);
	  driver.findElement(By.xpath("//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/button[2]")).click();
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//span[contains(text(),'Save & Close')]")).click();
	  System.out.println("REgigster data is entered successfully");
  }
  @DataProvider(name="testData")
  public Object[][] getData() throws IOException
  {
 Object [][] data= new Object[2][2];
  
	  data[0][0]=ExcelUtility.getCellData("Registration", 0, 0);
	  data[0][1]=ExcelUtility.getCellData("Registration", 0, 1);
	  
	  data[1][0]=ExcelUtility.getCellData("Registration", 1, 0);
	  data[1][1]=ExcelUtility.getCellData("Registration", 1, 1);
	//  String title=ExcelRevertMultiple.getCellData("Registration", 0, 0);
	 // String desc=ExcelRevertMultiple.getCellData("Registration", 1, 1);
	  
	  
	 
	 return data;
	  
			  
  }
}
