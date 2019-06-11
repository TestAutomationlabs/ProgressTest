package com.qa.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.qa.TestUtil.CustomListner;
import com.qa.pages.Contacts;
import com.qa.pages.LandingPage;
import com.qa.pages.RegistrationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
@Listeners(CustomListner.class)

public class ContactsPageTest extends TestBase {
	
	LandingPage landingpage;
	Contacts contactspage;
	ExtentReports report;
	ExtentTest test;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException {


		initialization();
		
		report=ExtentFactory.Instance();
		
		landingpage = new LandingPage();
		System.out.println("Browser launched of Progress");
		
		contactspage = new Contacts();
		
		

	}
	
	
	
	
	@Test(priority=1)
	public void verifycontactsPageTest() throws Exception, InterruptedException {
		Thread.sleep(10000);
		test=report.startTest("LandingPage-->VerifyNewProjectButton");
		landingpage.verifyNewProjectButton(test);
		System.out.println("NewProjectbutton is present");
		Thread.sleep(3000);
		test=report.startTest("Contactspage-->VerifyContactsPageTest");
		contactspage.ContactsPage(test);
		System.out.println("Navigated to contactspage");
		//test.log(LogStatus.PASS, "Helppoup is present");
		//report.endTest(test);
		contactspage.ContactsList(test);
		

	}
}
