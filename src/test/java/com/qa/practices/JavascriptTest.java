package com.qa.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JavascriptTest {
	WebDriver driver;
	WebElement loginbutton;
	
	//js.executeScript(Script, Arguments);
	
	@BeforeClass
	public void setUp() throws InterruptedException {


		System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		driver = new ChromeDriver(); 
        System.out.println("User has installed the chrome hence launching the chrome browser");
       // driver.get("http://newtours.demoaut.com/");
        driver.get("http://demo.guru99.com/V4/");
        Thread.sleep(3000);
      
        
       // driver.get("https://classic.crmpro.com/login.cfm");
	}
  @Test
  public void f() throws Exception {
	  Thread.sleep(5000);
	  System.out.println("Test method started");
	  JavascriptExecutor js=(JavascriptExecutor)driver;
	  /* js.executeScript("document.getElementsByName('userName')[0].value='test4selenium';");
	  js.executeScript("document.getElementsByName('password')[0].value='test4selenium@123';");
	  js.executeScript("document.getElementsByName('login')[0].click()';");*/
	  js.executeScript("document.getElementsByName(\"uid\")[0].value=\"mngr200186\";");
	  js.executeScript("document.getElementsByName(\"password\")[0].value=\"tEzAbEt\";");
	 //Login button
	  loginbutton=driver.findElement(By.xpath("//input[@name='btnLogin']"));
	 // js.executeScript("document.getElementsByName(\"btnLogin\")[0].click()");
	  js.executeScript("arguments[0].click();", loginbutton);
	  System.out.println("loginbutton clicked");
	  //String title;
	String stext=js.executeScript("return document.title;").toString();
	System.out.println("Stext is"+stext);
	
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
	js.executeScript("window.location = 'https://www.softwaretestingmaterial.com");
	  //System.out.println("title is"+title);
	  //js.executeScript("document.querySelectorAll(\"a[href='http://demo.guru99.com/']\")[0].click()");
	  //js.executeScript("document.getElementsByName(\"emailid\")[0].value=\"test4selenium@gmail.com\";");
	  //js.executeScript("document.getElementsByName(\"btnLogin\")[0].click()");
  }
}
