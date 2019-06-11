package com.qa.practices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;

public class GmailPracticeTest extends TestBase{
	public WebDriver driver;
	public WebElement gmailusername;
	public WebElement gmailpassword;
	public WebElement primarybutton;
	
	@BeforeClass
	public void setUp() throws InterruptedException {

		//initialization();
		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(); 
        System.out.println("User has installed the chrome hence launching the chrome browser");
		driver.manage().window().maximize();
		
		System.out.println("-----------------User is launching the chrome browser ------------------");
		
		Thread.sleep(3000);
		driver.get("https://www.gmail.com");
		 
		 
	}
@Test(priority=1)
public void gmailLogin() throws Exception
{
	gmailusername=driver.findElement(By.xpath("//input[@type='email']"));
	gmailusername.click();
	gmailusername.sendKeys("testautomation4selenium");
	driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	Thread.sleep(4000);
	
	
	gmailpassword=driver.findElement(By.xpath("//input[@name='password']"));
	gmailpassword.click();
	gmailpassword.sendKeys("test4selenium");		
	driver.findElement(By.xpath("//*[@id='passwordNext']/content/span[@class='RveJvd snByac' and contains(text(),'Next')]")).click();
	
	
	
}
@Test(priority=2)
public void verifyprimary() throws Exception
{
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[@class='aKz' and contains(text(),'Social')]")).click();
	System.out.println("Social dashboard is clicked");
	try {
	
	primarybutton=driver.findElement(By.xpath("//div[@class='aKz' and contains(text(),'Primary')]"));
	if(!primarybutton.isDisplayed())
			{
		System.out.println("primary button is not selected");
				
			}
	else
	{
		primarybutton.click();
		System.out.println("Primary button is clicked");
	}
}
	catch(Exception e)
	{
		System.out.println("primary button is not displayed");
	}
}

@Test(priority=3)
public void TotalMails()
{
	/*Iterating using for loop*/
	/*List<WebElement>mailcounts=driver.findElements(By.xpath("//span[@class='bqe']"));
	System.out.println("Total mail counts in the primary section is" +mailcounts.size());

	for(int i=0; i<mailcounts.size(); i++)
	{
		String mailcontext=mailcounts.get(i).getText();
		System.out.println("Mail context is" +mailcontext);
	}
	*/
	/*Iterating using iterator*/
	/*List<WebElement>mailcountss=driver.findElements(By.xpath("//span[@class='bqe']"));
	System.out.println("Total mail counts in the primary section is" +mailcounts.size());
	Iterator<WebElement>itr=mailcountss.iterator();
	while(itr.hasNext())
	{
		WebElement ele=itr.next();
		String str=ele.getText();
		System.out.println("List of iterated webelements" +str);	
}
*/
	/*Arraylist with for loop
	 Typecast the webelement into arraylist
	 
	try {
ArrayList<WebElement>deal_options=(ArrayList<WebElement>) driver.findElements(By.xpath("//span[@class='bqe']"));
for(int i=0; i<deal_options.size(); i++)
{
	String mailcontext=deal_options.get(i).getText();
	System.out.println("Arraylist Mail context is" +mailcontext);
}
	} catch (StaleElementReferenceException e) {
		System.out.println("Staleelementexception found");
	}
*/
}

}
	