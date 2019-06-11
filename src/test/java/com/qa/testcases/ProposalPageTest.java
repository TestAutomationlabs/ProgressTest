package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.pages.AlignmentPhase;
import com.qa.pages.LandingPage;
import com.qa.pages.ProposalPhase;
import com.qa.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ProposalPageTest extends TestBase{
	LandingPage landingpage;
	RegistrationPage registerpage;
	AlignmentPhase alignmentpage;
	ProposalPhase proposalpage;
	ExtentReports report;
	ExtentTest test;
	
	public ProposalPageTest()
	{
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {

		initialization();
		
		report=ExtentFactory.Instance();
		alignmentpage = new AlignmentPhase();
		proposalpage = new ProposalPhase();
		System.out.println("-----------------User is about to validate the proposal phase------------------");
		
	}
	
	
	@Test(priority=1)
	public void verify_Navigate_DashboardPage() throws InterruptedException
	{
		Thread.sleep(3000);
		test=report.startTest("AlignmentPhase-->Verify_RegisterPhaseToAliggnmentPhase");
		alignmentpage.verifyAlignmentValidation(test);
		System.out.println("Alignment validation is completed");
		test=report.startTest("ProposalPhase-->verify_Navigate_DashboardPage");
		proposalpage.verify_Navigate_DashboardPage(test);
		System.out.println("Naviagate to proposal dashboard is completed");
	}
	@Test(priority=2)
	public void verify_ClickOnProposalIcon()
	{
		test=report.startTest("ProposalPhase-->Verify_Clickon_ProposalIcon");
		proposalpage.verify_ClickOn_Proposal_Icon(test);
		System.out.println("Proposal icon is clicked and moved to the registration page");
	}
	@Test(priority=3)
	public void verify_AlignmentStatusTest() throws InterruptedException
	{
		test=report.startTest("ProposalPhase-->Verify_AlignmentStatusTest");
		proposalpage.verify_AlignmentStatus(test);
		System.out.println("Alignment status test is validated");
	}
	@Test(priority=4)
	public void verify_ProposaluploadValidation() throws InterruptedException
	{
		Thread.sleep(3000);
		proposalpage.verify_proposal_UploadValidation(test);
		System.out.println("upload validation  test is validated");
		Thread.sleep(2000);
		proposalpage.verify_proposal_DownloadValidation(test);
	}
		
	}
		

