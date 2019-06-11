package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestUtil.CustomListner;
import com.qa.pages.AlignmentPhase;
import com.qa.pages.LandingPage;
import com.qa.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
@Listeners(CustomListner.class)

public class AlignmentPhaseTest extends TestBase{
	
	LandingPage landingpage;
	RegistrationPage registerpage;
	AlignmentPhase alignmentpage;
	ExtentReports report;
	ExtentTest test;
	
	public AlignmentPhaseTest()
	{
		super();
	}
	
	

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		
		report=ExtentFactory.Instance();
		
		alignmentpage = new AlignmentPhase();
		System.out.println("-----------------User is about to validate the Align phase------------------");
		
		

	}
	@Test(dependsOnMethods={"verifyNewProjectTest"})
	public void verifyAlignmentPhasetTest() throws Exception, InterruptedException {
		Thread.sleep(10000);
		test=report.startTest("AlignmentPhase-->Verify_RegisterPhaseToAliggnmentPhase");
		alignmentpage.verifyAlignmentValidation(test);
		System.out.println("Alignment validation is completed");
		
		
	}
	@Test(priority=2)
	public void verifyDateTest() throws IOException, InterruptedException
	{
		
		alignmentpage.verifyDateRangeStartDate(test);
		Thread.sleep(3000);
		System.out.println("Date valid is completed for startdate");
		alignmentpage.verifyDateRangeEndDate(test);
		System.out.println("Date validn for end date");
		
	}
	
	
	/*@Test(priority=3)
	public void verifySupplierDropdownTest() throws InterruptedException
	{
		alignmentpage.verifySupplierDropDown(test);
		System.out.println("Supplier Dropdown is validated");
	}
	
	@Test(priority=4)
	public void verifyRequestorDropDownTest() throws InterruptedException
	{
		alignmentpage.verifyRequestor(test);
		System.out.println("Requestor Dropdown is validated");
	}
	
	@Test(priority=5)
	public void verifyprojectFocusTest() throws InterruptedException
	{
		alignmentpage.verifyProjectFocus(test);
		System.out.println("ProjectFocus Dropdown is validated");
	}
	
	@Test(priority=6)
	public void verifyUpdateButton() throws InterruptedException
	{
		alignmentpage.verifyUpdate(test);
		System.out.println("Update button test is validated");
	}
	
	@Test(priority=7)
	public void verifyExportButton()
	{
		alignmentpage.verifyExport(test);
		System.out.println("Export button test is validated");
	}*/
}