package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestDataDriven.ExcelWrite;
import com.qa.TestUtil.CustomListner;
import com.qa.pages.LandingPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListner.class)

public class LandingPageTest extends TestBase {

	LandingPage landingpage;
	ExtentReports report;
	ExtentTest test;
	SoftAssert softAssert=new SoftAssert();
	
	public LandingPageTest() {
		super();
	}
	

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		//System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
		
		//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
		//driver = new ChromeDriver(); 
        //sSystem.out.println("User has installed the chrome hence launching the chrome browser");
	
		//Thread.sleep(8000);
		report=ExtentFactory.Instance();
		landingpage = new LandingPage();
		System.out.println("Browser launched of Progress");
		

	}
	

    //@Test(priority=1, retryAnalyzer = RetryAnalyzer.class)
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		test=report.startTest("HomePage-->VerifyHomePageTitle");
		String landingpageTitle = landingpage.verifyHomePageTitle();
		softAssert.assertEquals(landingpageTitle, "Progress");
		System.out.println("HomePage title is Present and validated");
		test.log(LogStatus.PASS, "HomePage title is present and validated");
		softAssert.assertAll();
	}
	
	@Test(priority=2)
	public void verifyMerckLogoTest() {
		test=report.startTest("HomePage-->VerifyHomeIcon");
		landingpage.verifyHomeIcon(test);
		Assert.assertTrue(landingpage.verifyHomeIcon(test));
		System.out.println("Merck Icon is Present");
		test.log(LogStatus.PASS, "Merck logo is present and validated");
	}

	/*@Test(priority=3)
	public void verifyHelpButtonTest() throws Exception, InterruptedException {
		test=report.startTest("HomePage-->VerifyHelpPOpup");
		landingpage.verifyHelpButton(test);
		Assert.assertTrue(landingpage.verifyHelpButton(test));
		System.out.println("Helptbutton is present");
		test.log(LogStatus.PASS, "Helppoup is present and clicked");
		
			

	}
	@Test(priority=4)
	public void verifymoreIconTest() throws InterruptedException
	{
		Thread.sleep(3000);
		test=report.startTest("LandingPage--> More Icon");
		landingpage.verifyMore_DeleteIconButton(test);
		Assert.assertTrue(landingpage.verifyMore_DeleteIconButton(test));
		System.out.println("More icon is validated");
		test.log(LogStatus.PASS, "More Icon is present and validated");
	}
	
	@Test(priority=5)
	public void verifyEditIconTest() throws InterruptedException
	{
		Thread.sleep(3000);
		test=report.startTest("LandingPage-->EditIconTest");
		landingpage.verifymore_EditIconButton(test);
		Assert.assertTrue(landingpage.verifymore_EditIconButton(test));
		System.out.println("More icon and edit button is validated");
		test.log(LogStatus.PASS, "More Icon is present and validated");
	}
	
	
	@Test(priority=6)
	public void verifyDuplicateIconTest() throws InterruptedException
	{
		Thread.sleep(3000);
		test=report.startTest("LandingPage-->DuplicateIconTest");
		landingpage.verifymore_DuplicateIconButton(test);
		Assert.assertTrue(landingpage.verifymore_DuplicateIconButton(test));
		System.out.println("More icon  and duplicate button is validated");
		test.log(LogStatus.PASS, "Duplicate Icon is present and validated");
		
	}
	@Test(priority=7)
	public void verifyNewProjectTest() throws Exception, InterruptedException {
		test=report.startTest("LandingPage-->VerifyNewProjectButton");
		landingpage.verifyNewProjectButton(test);
		Assert.assertTrue(landingpage.verifyNewProjectButton(test));
		System.out.println("NewProjectbutton is present");
		test.log(LogStatus.PASS, "Newproject button  is present and validated");
		report.endTest(test);

	}*/
	
	
	
	
	@AfterMethod
	public void TearDown(ITestResult testResult) throws IOException
	{
		 if(testResult.getStatus()==ITestResult.SUCCESS)
		{
			ExcelWrite.PassedCreateCellData("Results", 7, 1);
		}
		 else if(testResult.getStatus()==ITestResult.FAILURE)
		{
			 ExcelWrite.FailedCreateCellData("Results", 7, 0);
			//takeScreenshotAtEndOfTest(testResult.getMethod().getMethodName());
			String path=TestBase.Screenshot(driver,  testResult.getName());
			//String imgPath=test.addScreenCapture(path);
			//test.log(LogStatus.FAIL, "VerifyTestresults", imgPath);
			test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getThrowable());
			
		}
		
		
	}
}

	



