package com.qa.testcases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.sikuli.script.FindFailed;
import org.sikuli.script.SikuliException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestUtil.CustomListner;
import com.qa.pages.LandingPage;
import com.qa.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(CustomListner.class)

public class RegistrationPageTest extends TestBase {
	
	LandingPage landingpage;
	RegistrationPage registerpage;
	ExtentReports report;
	ExtentTest test;
	
	public RegistrationPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		
		report=ExtentFactory.Instance();
		
		landingpage = new LandingPage();
		System.out.println("Browser launched of Progress");
		registerpage=new RegistrationPage();
		

	}
	
	@Test(invocationCount=5)
	public void verifyNewProjectTest() throws Exception, InterruptedException {
		Thread.sleep(10000);
		test=report.startTest("LandingPage-->VerifyNewProjectButton");
		landingpage.verifyNewProjectButton(test);
		System.out.println("NewProjectbutton is present");
		driver.navigate().back();
		System.out.println("navigated back");
		
		
		
	}
	
	
	/*@Test(priority=2)
	public void verifyInformationTest() throws Exception, InterruptedException {
		Thread.sleep(2000);
		test=report.startTest("RegistrationPageTest-->Verify verifyInformationTest");
		//registerpage.verifyInformation_Cancel(test);
		registerpage.verifyInformation(test);
		System.out.println("Informaiton panel is entered successfully");
		test.log(LogStatus.PASS, "Informaiton panel is entered successfully");

	}
	
	@Test(priority=3)
	public void verifyCalenderTest() throws Exception, IOException
	{
		test=report.startTest("RegistrationPageTest-->Verify verifyTimeLineTest");
		registerpage.verifyTimeLineStartDate(test);
		registerpage.verifyTimeLineEndDate(test);
		System.out.println("TimeLine Test has validated successfully");
		test.log(LogStatus.PASS, "TimeLine Test has validated successfully");
		
	}
	
	@Test(priority=4)
	public void verifyScopeTest() throws InterruptedException, IOException
	{
		
		test=report.startTest("RegistrationPageTest-->Verify verifyScopeTest");
		registerpage.verify_Scope(test);
		System.out.println("Scope Test has validated successfully");
		test.log(LogStatus.PASS, "Scope Test has validated successfully");
	}
	
	@Test(priority=5)
	public void verifyCostObjectsTest() throws InterruptedException
	{
		test=report.startTest("RegistrationPageTest-->VerifyCostObjectTest");
		registerpage.verify_CostObjects(test);
		System.out.println("Cost Objects Test has validated successfully");
		test.log(LogStatus.PASS, "Cost Objects Test has validated successfully");
	}
	
	@Test(priority=6)
	public void verifySelectSupplierTest() throws InterruptedException
	{
		test=report.startTest("RegistrationPageTest-->verifySelectSuppliersTest");
		registerpage.verify_Supplier(test);
		System.out.println("Supplier Tests has validated successfully");
		test.log(LogStatus.PASS, "Supplier Tests has validated successfully");
	}
	
	/*@Test(priority=7)
	public void verifyDeleteSupplierTest() throws InterruptedException
	{
		test=report.startTest("RegistrationPageTest-->verifyDeletesuppliersTest");
		registerpage.verifyDeleteButton(test);
		System.out.println("Supplier Tests has been deleted successfully");
		test.log(LogStatus.PASS, "Supplier Tests has been deleted successfully");
	}*/
//	@Test (priority=7)
//	public void verifyAlert()
//	{
//		registerpage.isAlertPresent();
//		System.out.println("Alert");
//	}
	/*@Test(priority=7)
	public void verifyNavigateDashobardPageTest() throws InterruptedException
	{
		test=report.startTest("RegistrationPageTest-->verifyProcurementdashboard");
		registerpage.verify_Navigate_ProcurmentDashboardPage(test);
		System.out.println("System is moved to procurment dashboard");
		test.log(LogStatus.PASS, "System is moved to registration phase to procurment dashboard");
	}
	
	@Test(priority=8)
	public void verifyREgisterValidationTest() throws InterruptedException, SikuliException, AWTException
	{
		test=report.startTest("RegistrationPageTest-->verifyREgisterValidation");
		registerpage.verifyREgisterValidation(test);
		System.out.println("Register validation is completed");
		test.log(LogStatus.PASS, "Register validation is completed");
	}
	
	@Test(priority=9)
	public void verify_AlignmentValidationTest() throws InterruptedException
	{
		test=report.startTest("RegistrationPageTest-->verifyAlignmentValidation");
		registerpage.verifyAlignmentValidation(test);
		System.out.println("System is navigated to the alignment validation page");
		test.log(LogStatus.PASS, "System is navigated to the alignment validation page");
	}*/
	
	/*@Test(priority=10)
	public void verify_ScrollTest()
	{
		registerpage.verifyScroll();
		System.out.println("Scroll bar is validated");
	}*/

	
	
	@AfterMethod
	public void TearDown(ITestResult testResult) throws IOException
	{
		if(testResult.getStatus()==ITestResult.FAILURE)
		{
			/*Note: getName-> Is used to get the testclass Name
			getMethodName-> Is used to get the testMethod Name
		*/
		String path=TestBase.Screenshot(driver,  testResult.getMethod().getMethodName());
		
		String imgPath=test.addScreenCapture(path);
		test.log(LogStatus.FAIL, "VerifyTestresults", imgPath);
			
			test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+testResult.getThrowable());
		}
		
	}
	

	@AfterClass(alwaysRun = true)
public void CloseConnection() {
	driver.close();
		report.endTest(test);
		report.flush();
	}
}


