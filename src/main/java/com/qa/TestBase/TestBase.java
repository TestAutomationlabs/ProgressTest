package com.qa.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.TestUtil.ExtentContent;
import com.qa.TestUtil.TestUtil;
import com.qa.TestUtil.WebEventListener;




public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public  static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventListener;
	
	
	
	
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com"
					+ "/qa/Config/config.properties");
			
			//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\src\main\java\com\qa\config\config.properties
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		

		File chrome = new File("C:/Program Files (x86)/Google/Chrome");
        if(chrome.exists() && browserName.equals("chrome"))
        {

			System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
			
			//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
			driver = new ChromeDriver(); 
            System.out.println("User has installed the chrome hence launching the chrome browser");
		
        }
        else if(!chrome.exists())
        {
        	System.out.println("User has not installed the chrome hence launching with the headless browser");
        	System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
			driver = new ChromeDriver(); 
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
		
			//Instantiate Web Driver
			 driver = new ChromeDriver(options);	
        }
		
		/*if(browserName.equals("chromeHeadless")){
			System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
			
			//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
			//driver = new ChromeDriver(); 
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
		
			//Instantiate Web Driver
			 driver = new ChromeDriver(options);
		}*/
		
		/*else if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
			
			//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
			driver = new ChromeDriver(); 
		}*/
		
	else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "./ExternalJars/GeckoDriver/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
	
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
		driver.get(prop.getProperty("url"));
		
	}


	
//	public void takeScreenshotAtEndOfTest(String testMethodName)
//	{
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		String currentDir = System.getProperty("user.dir");
//		try {
//			//FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
//		
//			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+testMethodName+"_"+".jpg"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	//}
	
	

	public static String Screenshot(WebDriver driver, String fileName) throws IOException
	{
	//	String methodname="";
		fileName=fileName+ ".png";
		String curr=System.getProperty("user.dir");
		
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		
		FileUtils.copyFile(src, new File(curr + "/Screenshots/"+fileName));
		
		
		String dest=curr + fileName;
		return dest;
		
	}
	


    
	
}
