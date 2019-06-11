package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import com.qa.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentTest;

public class ProposalPhase extends TestBase{
	
	@FindBy(xpath = "//select[@class='form-control cursor-pointer']")
	WebElement Select_Dashboard;
	
	//@FindBy(xpath="//*[@id=\"mCSB_7_container\"]/div/div/div/div/div/div/div[2]/div[2]/div/div/div[@class='icon-proposal icon f-70p']")
	@FindBy(xpath="//div[@class='icon-proposal icon f-70p']")
	WebElement Proposal_Icon;
	
	//@FindBy(xpath="//span[contains(text(),'Download')]")
	@FindBy(xpath="//*[contains(@id, 'mCSB')]/div[3]/div/div/div[2]/div[1]/div/div/div[2]/button")
	WebElement Proposal_Download;
	
	//@FindBy(xpath="//button[@class='btn btn-primary w-100 ml-0 mt-2 text-left pl-2']//following::input[contains(@name,'myfile')]")
	@FindBy(xpath="//*[contains(@id, 'mCSB')]/div[3]/div/div/div[2]/div[2]/div/div/div/div[2]/div/input")
	WebElement Proposal_Upload;
	
	@FindBy(xpath="//span[contains(text(),'Save & Close')]")
	WebElement SaveClose_Button;
	
	public String status_validation;
	

	public ProposalPhase() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void  verify_Navigate_DashboardPage(ExtentTest test) throws InterruptedException
	{

		System.out.println("Alignment icon is displayed hence user is click on the alignment icon");
		// WebElement sele= driver.findElement(By.xpath("//select[@class='form-control
		// cursor-pointer']"));
		Select sct = new Select(Select_Dashboard);
		sct.selectByVisibleText("My Dashboard");
		Thread.sleep(4000);

		System.out.println("----------------Moving back to the Dashboard page------------------");
		

	}
	public void verify_ClickOn_Proposal_Icon(ExtentTest test)
	{
		if(Proposal_Icon.isDisplayed())
		{
			System.out.println("Proposal icon is displayed. Hence we are clicking the proposal icon");
			Proposal_Icon.click();
			System.out.println("Proposal icon is clicked");
		}
		else
		{
			System.out.println("proposal icon is not displayed");
		}
		
	}
	
	public void verify_AlignmentStatus(ExtentTest test) throws InterruptedException
	{
		WebElement status=driver.findElement(By.xpath("//i[@class='icon-tick-thin done-btn']/following::div[@class='s-p bold']"));
		Thread.sleep(4000);
		status_validation=status.getText();
		System.out.println("Current status of alignment after it moved to proposal phase" +status_validation);
	}
	public void verify_proposal_UploadValidation(ExtentTest test)
	{
	
		try {
//			if(!Proposal_Upload.isDisplayed())
//			{
//				System.out.println("proposal upload icon is not displayed hence else is executed");
//				
//			}
//			else
//			{
				Thread.sleep(8000);
				Proposal_Upload.click();
				System.out.println("Proposal upolad icon is clicked");
				Thread.sleep(8000);
				
			    
				Screen screen = new Screen();
			    Pattern fileNameInput = new Pattern("C:\\Users\\SLANKEGO\\Pictures\\Progress\\FileInputForUpload.PNG");
			    Pattern openButton = new Pattern("C:\\Users\\SLANKEGO\\Pictures\\Progress\\OpenButtonForUpload.PNG");
			
			    
			      screen.type(fileNameInput, " C:\\Users\\SLANKEGO\\Pictures\\Progress\\rfp-summary.pdf");
			      screen.click(openButton);
			     
			}
		//}
			catch(Exception e)
			{
				System.out.println(e);
				System.out.println("Proposal upload is not displayed");
			}
		
		
	}
	
	public void verify_proposal_DownloadValidation(ExtentTest test) throws InterruptedException
	{
		try {
			
		if(Proposal_Icon.isDisplayed())
		{
		//WebDriverWait wait=new WebDriverWait(driver,80);
		//WebElement proopsal_wait=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("Proposal_Download")));
		//proopsal_wait.click();
		Thread.sleep(8000);
		Proposal_Download.click();
		System.out.println("Proposal download is clicked");
		System.out.println("Proposal download is done for RFP Template");
	}
		else {
			System.out.println("Proposal download icon is not displayed");
		}
		}
		catch(Exception e) {
			System.out.println("Propoasal download is not displayed" +e);
		}
		SaveClose_Button.click();
		}
		
	
		
}
	
	
	


