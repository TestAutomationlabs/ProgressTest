package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestUtil.CustomListner;
import com.qa.pages.LandingPage;
import com.qa.pages.RegistrationPage;
import com.qa.pages.SupplierPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

@Listeners(CustomListner.class)
public class SupplierPageTest extends TestBase{
	
	LandingPage landingpage;
	RegistrationPage registerpage;
	SupplierPage supplierpage;
	ExtentReports report;
	ExtentTest test;
	
	public SupplierPageTest()
	{
		super();
	}
	
	
	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		
		report=ExtentFactory.Instance();
		
		landingpage = new LandingPage();
		System.out.println("Browser launched of Progress");
		registerpage=new RegistrationPage();
		supplierpage=new SupplierPage();
		

	}
	@Test(priority=1)
	public void verifyNewProjectTest() throws Exception, InterruptedException {
		Thread.sleep(10000);
		test=report.startTest("LandingPage-->VerifyNewProjectButton");
		landingpage.verifyNewProjectButton(test);
		System.out.println("NewProjectbutton is present");
		
	
	}
	
  @Test(priority=2)
  public void verifySortPageTest() throws InterruptedException
  {
	  registerpage.verify_SupplierButtonClick(test);
	  supplierpage.verifySort();
	  
  }

	@Test(priority=3)
	public void verifyAddNewSupplierTest() throws InterruptedException
	{
	supplierpage.verify_AddNewSupplier();
	}
}
