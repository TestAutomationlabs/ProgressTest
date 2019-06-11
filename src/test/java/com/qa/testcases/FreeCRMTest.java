package com.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.pages.FreeCRM;
import com.relevantcodes.extentreports.LogStatus;

public class FreeCRMTest extends TestBase{
	
	FreeCRM free;
	
	public FreeCRMTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		free=new FreeCRM();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = free.validateLoginPageTitle();
		System.out.println(free.validateLoginPageTitle());
		Assert.assertEquals(title, "CRMPRO Log In Screen");
		System.out.println("Title verifed");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = free.validateCRMImage();
		Assert.assertTrue(flag);
	System.out.println("Logo veifired");
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		Thread.sleep(3000);
		free.login();
		System.out.println("login successfully");
	}
	
	@AfterMethod
	public void TearDown(ITestResult testResult) throws IOException
	{
		if(testResult.getStatus()==ITestResult.FAILURE)
		{
			/*Note: getName-> Is used to get the testclass Name
				getMethodName-> Is used to get the testMethod Name
			*/
			String path=TestBase.Screenshot(driver,  testResult.getMethod().getMethodName());
			//String imgPath=test.addScreenCapture(path);
			//test.log(LogStatus.FAIL, "VerifyTestresults", imgPath);
		//	test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getName());
			//test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getThrowable());
		}
		
	}
	

	@AfterClass(alwaysRun = true)
public void CloseConnection() {
	driver.close();
		//report.endTest(test);
		//report.flush();
	}
}


