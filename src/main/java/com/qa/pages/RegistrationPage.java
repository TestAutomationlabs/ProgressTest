package com.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;

import com.qa.TestDataDriven.ExcelUtility;
import com.qa.TestDataDriven.ExcelUtilityForAll;
import com.qa.TestUtil.TestUtil;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.awt.AWTException;
import java.awt.Robot;

import java.awt.event.KeyEvent;

import javafx.animation.Timeline;

import com.qa.TestBase.TestBase;

public class RegistrationPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'Basic information about your project')]")
	WebElement information;

	// @FindBy(xpath="//label/span[contains(text(),'Project
	// Title')]//following::input[@value='Untitled']")
	@FindBy(xpath = "//label/span[contains(text(),'Project Title')]//following::input[1]")
	WebElement Project_title;

	@FindBy(xpath = "//label/span[contains(text(),'Project Content Description')]//following::textarea")
	WebElement Project_description;

	@FindBy(xpath = "//input[@name='MAX_BUDGET']")
	WebElement Available_budget;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/button[2]")
	WebElement Information_Save_Button;

	@FindBy(xpath = "//*[@id=\"mCSB_36_container\"]/div[1]/div/div[1]/div[2]/div[1]/div/div/div[2]/div/div[2]/button[1]/span")
	WebElement Information_Cancel_Button;

	@FindBy(css = "button.btn-primary[btntext*='COMMON.EDIT']")
	WebElement Information_Edit_Button;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/i")
	// *[@id="mCSB_7_container"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/i
	WebElement TimeLine_Startdate;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/i")
	// @FindBy(xpath =
	// "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/span")
	WebElement TimeLine_Enddate;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[2]/div/div/input")
	WebElement TimeLine_MerckProjectLead;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[3]/div/div/input")
	WebElement TimeLine_ExecutiveBusinessUnit;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[4]/div/div/input")
	WebElement TimeLine_PayingBusiness_Sector;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[2]/button[2]")
	WebElement TimeLine_Save_Button;
	
	@FindBy(xpath="//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[2]/button/span")
	WebElement TimeLine_EditButton;

	// @FindBy(xpath="//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/input")
	// *[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/input
	@FindBy(xpath = "//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div/input")
	WebElement Scope_PrimaryProjectFocus;

	@FindBy(xpath = "//textarea[@name='OUT_OF_SCOPE']")
	WebElement Scope_OutOfScope;

	@FindBy(xpath = "//textarea[@name='PROJECT_OBJECTIVE']")
	WebElement Scope_ProjectObjectives;

	@FindBy(xpath = "//textarea[@name='DELIVERABLES']")
	WebElement Scope_RequiredServiceDeliverables;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/button[2]/span")
	WebElement Scope_Save_Button;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/div/button")
	WebElement Cost_Objects_CostCenter_CloseButton;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div/input")
	// *[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/div[1]/div/div/input
	WebElement Cost_Objects_CostCenter;

	@FindBy(xpath = "//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[2]/button[2]")
	WebElement Cost_Objects_SaveButton;

	// @FindBy(xpath="//button[@class='btn btn-primary button-big w-100 mx-0
	// text-left pl-3']//i")
	@FindBy(xpath = "//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[4]/div/div/div[2]/div/div[2]/div/button/i[@class='icon-add pr-2']")
	WebElement Supplier_Select_SuppliersButton;
	public WebElement Supplier_Select_SuppliersButton_ButtonValidation;
	// public String supplier_list_validation=null;
	public String supplier_list_selected_validation = null;

	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	WebElement Supplierselected_confirm;

	@FindBy(xpath = "//*[contains(@id,'mCSB')]/div[1]/div/div[1]/div[4]/div/div/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/div[2]/h6/button/i")
	WebElement Supplier_DeleteButton;
	
	@FindBy(xpath="//span[contains(text(),'Supplier deleted successfully.')]")
	WebElement Delete_ToastMessage;
	
	@FindBy(xpath = "//select[@class='form-control cursor-pointer']")
	WebElement Select_Dashboard;
	
	@FindBy(xpath="//*[contains(@id,'mCSB_7_scrollbar_vertical')]/div")
	WebElement scrollbar;

	public String ProjectTitle_TextBox;
	public String Project_ContentDescription_TextBox;
	public String Available_Budget_TextBox;

	public String OutOf_Scope_TextBox;
	public String Project_Objectives_TextBox;
	public String Required_Service_Deliverables_TextBox;
	public String DeleteSupplier_toastmessage;
	
	Actions act = new Actions(driver);
	WebDriverWait wait=new WebDriverWait(driver,160);

	@FindBy(xpath = "//span[contains(text(),'Next Phase')]")
	WebElement NextPhase;
	
	@FindBy(xpath="//*[contains(@id,'mCSB')]/div/div/div/div[1]/div/div/div[2]/div[2]/div/div[1]/div[@class='icon-alignment icon f-70p']")
	WebElement AlignmentIcon;

	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyInformation_Cancel(ExtentTest test) throws IOException, InterruptedException {
		System.out.println("----------------------Verifying Registration Cancel is as follows---------------------");
		ProjectTitle_TextBox = ExcelUtility.getCellData("Registration", 5, 0);
		Project_title.clear();
		Project_title.sendKeys(ProjectTitle_TextBox);
		System.out.println("ProjectTitle details is entered");
		test.log(LogStatus.PASS, "ProjectTitle details is entered");

		Project_ContentDescription_TextBox = ExcelUtility.getCellData("Registration", 5, 1);
		Project_description.clear();
		Project_description.sendKeys(Project_ContentDescription_TextBox);
		System.out.println("ProjectContent details is entered");
		test.log(LogStatus.PASS, "ProjectContent details is entered");

		Available_Budget_TextBox = ExcelUtilityForAll.getCellData("Registration", 5, 2);
		// Available_Budgets=Integer.valueOf(Available_Budget_TextBox);
		Available_budget.clear();
		Available_budget.sendKeys(Available_Budget_TextBox);
		System.out.println("Available budget details is entered");
		test.log(LogStatus.PASS, "Available budget details is entered");

		Thread.sleep(2000);

		Information_Cancel_Button.click();
		System.out.println("Cancel button is clicked and validated");
		test.log(LogStatus.PASS, "Cancel button is clicked and validated");

	}

	public void verifyInformation(ExtentTest test) throws IOException, InterruptedException {
		System.out.println("----------------------Verifying Registration is as follows---------------------");
		ProjectTitle_TextBox = ExcelUtility.getCellData("Registration", 5, 0);
		Project_title.clear();
		Project_title.sendKeys(ProjectTitle_TextBox);
		System.out.println("ProjectTitle details is entered");
		test.log(LogStatus.PASS, "ProjectTitle details is entered");

		Project_ContentDescription_TextBox = ExcelUtility.getCellData("Registration", 5, 1);
		Project_description.clear();
		Project_description.sendKeys(Project_ContentDescription_TextBox);
		System.out.println("ProjectContent details is entered");
		test.log(LogStatus.PASS, "ProjectContent details is entered");

		Available_Budget_TextBox = ExcelUtilityForAll.getCellData("Registration", 5, 2);
		// Available_Budgets=Integer.valueOf(Available_Budget_TextBox);
		Available_budget.clear();
		Available_budget.sendKeys(Available_Budget_TextBox);
		System.out.println("Available budget details is entered");
		test.log(LogStatus.PASS, "Available budget details is entered");

		Information_Save_Button.click();
		System.out.println("Information Save button is clicked");
		test.log(LogStatus.PASS, "Information Save button is clicked");

		Thread.sleep(2000);
		if (Information_Edit_Button.isDisplayed()) {
			Information_Edit_Button.click();
			System.out.println("Information edit button is clicked");
			test.log(LogStatus.PASS, "Information edit button is clicked");
			Information_Save_Button.click();
			System.out.println("Information save button is clicked again");
			test.log(LogStatus.PASS, "Information save button is clicked again");
		} else {
			System.out.println("Information edit button is not displayed");
		}

	}

	public void verifyTimeLineStartDate(ExtentTest test) throws IOException, InterruptedException {
		Thread.sleep(3000);
		TimeLine_Startdate.click();
		System.out.println("Timeline of start date is clicked");
		List<WebElement> dates = driver.findElements(By.xpath(
				"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div"));

		int count = dates.size();
	
		System.out.println(count);

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.xpath(
					"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div"))
					.get(i).getText();
			if (text.equalsIgnoreCase("12")) {
				driver.findElements(By.xpath(
						"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[1]/div/div/div[2]/div/div[2]/div[2]/div/div"))
						.get(i).click();
				break;
			}
		}

	}

	public void verifyTimeLineEndDate(ExtentTest test) throws InterruptedException {
		Thread.sleep(4000);
		TimeLine_Enddate.click();
		System.out.println("Time line of end date is clicked");
		List<WebElement> enddates = driver.findElements(By.xpath(
				"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div"));

		int count_enddate = enddates.size();
		System.out.println(count_enddate);

		for (int j = 0; j < count_enddate; j++) {
			String enddate_text = driver.findElements(By.xpath(
					"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div"))
					.get(j).getText();
			if (enddate_text.equalsIgnoreCase("12")) {

				driver.findElements(By.xpath(
						"//*[@id=\"mCSB_7_container\"]/div[1]/div/div[1]/div[3]/div[1]/div/div/div[2]/div/div[1]/div[1]/div[2]/div/div/div[2]/div/div[2]/div[2]/div/div"))
						.get(j).click();
				break;
			}

		}
		Thread.sleep(3000);
		TimeLine_MerckProjectLead.click();
		System.out.println("MerckProjectlead drop down is clicked");
		try {

			Thread.sleep(5000);
			List<WebElement> merckprojectlead_autosuggestion = driver
					.findElements(By.xpath("//div[@id='list-group-suggestions']/a"));
			System.out.println(
					"Size of merckprojectlead autosuggestion count is" + merckprojectlead_autosuggestion.size());
			for (int k = 0; k < merckprojectlead_autosuggestion.size(); k++) {
				System.out.println("Autosugesstion list of merck project lead is "
						+ merckprojectlead_autosuggestion.get(k).getText());
				if (merckprojectlead_autosuggestion.get(k).getText().contains("Werner Puknus")) {

					Thread.sleep(3000);
					merckprojectlead_autosuggestion.get(k).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}

		System.out.println("TimeLine_MerckProjectLead is" + TimeLine_MerckProjectLead);
		System.out.println(
				"Timeline merckprojectlead attribute value is " + TimeLine_MerckProjectLead.getAttribute("value"));
		if (TimeLine_MerckProjectLead.getAttribute("value").contains("Werner Puknus")) {
			TimeLine_ExecutiveBusinessUnit.getAttribute("SM-EME-R Rotating Equipment");
			System.out.println(
					"TimeLine Executive Business unit is" + TimeLine_ExecutiveBusinessUnit.getAttribute("value"));
		}
		TimeLine_PayingBusiness_Sector.click();

		System.out.println("Paying Business sector drop down is clicked");
		try {

			Thread.sleep(5000);
			List<WebElement> payingBusiness_autosuggestion = driver.findElements(By
					.xpath("//div//a[contains(@class,'list-group-item list-group-item-action rounded-0 text-left')]"));
			System.out.println(
					"Size of Paying Business sector drop down count is" + payingBusiness_autosuggestion.size());
			for (int l = 0; l < payingBusiness_autosuggestion.size(); l++) {
				System.out.println("Autosugesstion list of Paying Business sector is "
						+ payingBusiness_autosuggestion.get(l).getText());
				if (payingBusiness_autosuggestion.get(l).getText().contains("Life Science")) {

					Thread.sleep(3000);
					payingBusiness_autosuggestion.get(l).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}

		TimeLine_Save_Button.sendKeys(Keys.ENTER);
		System.out.println("TimeLine_Save_Button is clicked");
		TimeLine_Save_Button.sendKeys(Keys.TAB);		

	}

	public void verify_Scope(ExtentTest test) throws InterruptedException, IOException {
	
		Scope_PrimaryProjectFocus.sendKeys(Keys.SPACE);
		Thread.sleep(2000);
		System.out.println("Scope primary project focus drop down is clicked");
		try {
			Thread.sleep(5000);
			List<WebElement> primaryprojectfocus_autosuggestion = driver
					.findElements(By.xpath("//div[@id='list-group-suggestions']//a"));

			System.out.println(
					"Size of Primary project focus drop down count " + primaryprojectfocus_autosuggestion.size());
			for (int m = 0; m < primaryprojectfocus_autosuggestion.size(); m++) {
				System.out.println("Autosuggestion list of primary project focus is"
						+ primaryprojectfocus_autosuggestion.get(m).getText());
				if (primaryprojectfocus_autosuggestion.get(m).getText()
						.contains("Implementation & Change Management")) {
					Thread.sleep(2000);
					primaryprojectfocus_autosuggestion.get(m).click();
				}
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}
		// script should continue from reading the excel utility for the scope sheet//
		act.sendKeys(Keys.TAB);
		OutOf_Scope_TextBox = ExcelUtility.getCellData("Scope", 5, 0);
		Scope_OutOfScope.sendKeys(OutOf_Scope_TextBox);
		System.out.println("Out of Scope details is entered");
		test.log(LogStatus.PASS, "Out of Scope details is entered");
		Project_Objectives_TextBox = ExcelUtility.getCellData("Scope", 5, 1);
		Scope_ProjectObjectives.sendKeys(Project_Objectives_TextBox);
		System.out.println("Project objectives details is entered");
		test.log(LogStatus.PASS, "Project objectives details is entered");
		Required_Service_Deliverables_TextBox = ExcelUtility.getCellData("Scope", 5, 2);
		Scope_RequiredServiceDeliverables.sendKeys(Required_Service_Deliverables_TextBox);
		System.out.println("Scope Required Service delevirables details is entered");
		test.log(LogStatus.PASS, "Scope Required Service delevirables details is entered");
		Scope_Save_Button.click();
		System.out.println("Scope_Save_Button is clicked");
	}
	
	
		
	
	
	
	

	public void verify_CostObjects(ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		Cost_Objects_CostCenter.clear();
		Thread.sleep(2000);
		Cost_Objects_CostCenter.sendKeys("2000008L50001");
		//Cost_Objects_SaveButton.click();
		Cost_Objects_SaveButton.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB);
		Cost_Objects_SaveButton.sendKeys(Keys.ENTER);
		
		System.out.println("Costobjects_Save_Button is clicked");
		act.sendKeys(Keys.TAB);	
		
//		Cost_Objects_SaveButton.sendKeys(Keys.ENTER);
//		System.out.println("TimeLine_Save_Button is clicked");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void verify_SupplierButtonClick(ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		// WebElement select_supplier_button_click= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Supplier_Select_SuppliersButton")));   	
		// select_supplier_button_click.click();
		act.sendKeys(Keys.ENTER);
		System.out.println("Supplier button is clicked");
	}

	public void verify_Supplier(ExtentTest test) throws InterruptedException {
		String supplier_list_validation = null;
		String supplier_list_validation1 = null;
		Thread.sleep(10000);
		// WebDriverWait wait=new WebDriverWait(driver,160);
		// WebElement select_supplier_button_instance=
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("Supplier_Select_SuppliersButton")));
		// select_supplier_button_instance.click();
		Supplier_Select_SuppliersButton.click();
		Thread.sleep(5000);
		List<WebElement> supplier_list = driver.findElements(By.xpath("//h3[@class='mb-0 pr-2']"));
		int count_supplier = supplier_list.size();
		System.out.println("Supplier list count is " + count_supplier);

		
		for (int n = 0; n < supplier_list.size(); n++) {
			supplier_list_validation = supplier_list.get(n).getText();
			if (supplier_list_validation.contains("Accenture"))

			{
				//driver.findElement(By.xpath("//*[@id=\"next\"]/i")).click();
				//System.out.println("Next button is clicked");
				//Thread.sleep(6000);
				System.out.println("Accenture");
			
				WebElement ele1 = driver
						.findElement(By.xpath("//*[contains(@id,'mCSB')]/div[1]/div[2]/div/div/button"));

				ele1.click();
				break;
			}
		
		else {
				System.out.println("Element not found");
			}
		}
		
		
		
		for (int p = 0; p < supplier_list.size(); p++) {
			supplier_list_validation1 = supplier_list.get(p).getText();
			if (supplier_list_validation1.contains("McKinsey")) {
			
			//	driver.findElement(By.xpath("//*[@id=\"next\"]/i")).click();
				//Thread.sleep(6000);
				System.out.println("McKinsey");
				WebElement ele2 = driver
						.findElement(By.xpath("//*[contains(@id,'mCSB')]/div[1]/div[6]/div/div/button"));
				Thread.sleep(6000);
				ele2.click();
				break;
			}
		else {
				System.out.println("Element 2 not found");
			}

		}
		Thread.sleep(3000);

		if (Supplierselected_confirm.isDisplayed()) {
			System.out.println("Confirm button is displayed");
			Thread.sleep(2000);
			Supplierselected_confirm.click();
		} else {
			System.out.println("Confirm button is not displayed");

		}
		Thread.sleep(6000);
		supplier_list_selected_validation = driver.findElement(By.xpath("//h5[@class='mb-0 pr-2']")).getText();
		System.out.println("supplier list selected validation is " + supplier_list_selected_validation);
		// System.out.println("supplier list validaion is "+supplier_list_validation);
		Thread.sleep(2000);
		try {
			if (supplier_list_selected_validation.contains(supplier_list_validation)) {
				System.out.println("Supplier list validation is expected");
			} else {
				System.out.println("supplier list validation is not expected");
			}
		} catch (Exception e) {
			System.out.println("supplier list validation is not expected");
		}
	}

	/*public void verifyDeleteButton(ExtentTest test) throws InterruptedException
	{
		
			Thread.sleep(8000);
		/*	if (Supplier_DeleteButton.isDisplayed()) {
				System.out.println("Click on the supplier delete button");
				WebElement delete_selectsupplier= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("Supplier_DeleteButton")));   	
				delete_selectsupplier.click();
				//Supplier_DeleteButton.click();
				String deletestring=driver.findElement(By.xpath("//span[contains(text(),'Are you sure want to delete this supplier?')]")).getText();
				System.out.println("delte string" +deletestring);
				Thread.sleep(4000);
				System.out.println("Supplier list delete button is clicked");
				driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
				System.out.println(" User is clicked on the Delete--Yes button");
				//span[contains(text(),'Supplier deleted successfully.')]
				DeleteSupplier_toastmessage=Delete_ToastMessage.getText();
				System.out.println("Deletesupplier toast message" +DeleteSupplier_toastmessage);
				
			
	}*/
	
	
	/*Assert.assertTrue(Supplier_DeleteButton.isDisplayed());
	System.out.println("Click on the supplier delete button");
	Supplier_DeleteButton.click();
	String deletestring=driver.findElement(By.xpath("//span[contains(text(),'Are you sure want to delete this supplier?')]")).getText();
	System.out.println("delte string" +deletestring);
	Thread.sleep(4000);
	System.out.println("Supplier list delete button is clicked");
	driver.findElement(By.xpath("//div[@class='modal-header']")).click();
	System.out.println(" User is clicked on the Delete--Yes button");
	}

	*/	
	public void  verify_Navigate_ProcurmentDashboardPage(ExtentTest test) throws InterruptedException
	{

		driver.findElement(By.xpath("//span[contains(text(),'Save & Close')]")).click();
		System.out.println("Save and close button is clicked from the registration phase");
		
		// WebElement sele= driver.findElement(By.xpath("//select[@class='form-control
		// cursor-pointer']"));
		Thread.sleep(4000);
//		Select sct = new Select(Select_Dashboard);
//		sct.selectByVisibleText("Procurement");
//		Thread.sleep(4000);

		System.out.println("----------------Moved to the procurement Dashboard page------------------");
		

	}
	
	public void verifyREgisterValidation(ExtentTest test) throws InterruptedException {
		System.out.println("----------------Progress Title validation in Procurement Page------------------");
		driver.findElement(By.xpath("//h5[contains(text(),'Dexter')]"));
		// driver.findElement(By.xpath("//*[@id=\"Project_ALI_0\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Project_REG_0\"]")).click();
		Thread.sleep(3000);
		System.out.println("More icon is clicked");
		
		try {
			List<WebElement> more_options = driver.findElements(By.xpath("//li/span"));
			System.out.println("Size of moreoptions =" + more_options.size());
			for (int x = 0; x < more_options.size(); x++) {
				System.out.println("List of more option is is" + more_options.get(x).getText());
				if (more_options.get(x).getText().contains("Move to next phase")) {
					Thread.sleep(2000);
					more_options.get(x).click();
					System.out.println("Move to next phase is clicked");
				} else {
					System.out.println("more options is not visible for title");
				}

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}
	}
	
	public void verifyAlignmentValidation(ExtentTest test) throws InterruptedException
	{
		

		System.out.println("----------------Moving to the Alignment  phase------------------");
		//driver.findElement(By.xpath("//h5[contains(text(),'Dexter')]"));
		Thread.sleep(7000);
		driver.findElement(By.xpath(" //div/h5[contains(text(),'Dexter')]//following::a[@id='Project_ALI_0']/i")).click();
		Thread.sleep(3000);
		System.out.println("More icon is clicked");
		try {
			List<WebElement> alignment_moreoptions = driver.findElements(By.xpath("//li/span"));
			System.out.println("Size of moreoptions =" + alignment_moreoptions.size());
			for (int x = 0; x < alignment_moreoptions.size(); x++) {
				System.out.println("List of more option is is" + alignment_moreoptions.get(x).getText());
				if (alignment_moreoptions.get(x).getText().contains("Edit")) {
					Thread.sleep(2000);
					alignment_moreoptions.get(x).click();
					System.out.println("Edit button is clicked");
				} else {
					System.out.println("more options is not visible for title");
				}

			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Staleelementexception found");
		}
	}
	
	
	
	

	public void verify_RegisterPhaseToAliggnmentPhase(ExtentTest test) throws InterruptedException, FindFailed,SikuliException, AWTException {
		Thread.sleep(3000);
		if(driver.findElement(By.xpath("//*[contains(@id,'mCSB']/div[2]/div/div/div[2]/div/div/div/div/div[2]/i[@class='icon-progress progress-btn']")).isDisplayed())
		{
			System.out.println("Alignment is in progress");
		}
		else {
			System.out.println("Alignment is not in progress");
		}
		Thread.sleep(2000);
		
		System.out.println("Next phase is clicked and hence it moved to alignment page");
		
		driver.findElement(By.xpath("//span[contains(text(),'Save & Close')]")).click();
		System.out.println("Save and close button is clicked from the alignment phase");

	}
	
	public void verifyScroll()
	{
		//act.moveToElement(scrollbar).build().perform();
		
		/*act.moveToElement(scrollbar).click().build().perform();
		scrollPageDown(driver);*/
		
		act.moveToElement(scrollbar).build().perform();
		scrollIntoView(Supplier_Select_SuppliersButton, driver);
		System.out.println("Window scroll highlight is completed");
		//flash(scrollbar, driver);//highlight the element
		System.out.println("verified the highlight scroll");
		
		
		System.out.println("Scroll down is completed");
	}
	public static void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor  = element.getCssValue("backgroundColor");
        System.out.println("bgclor is "+bgcolor);
        for (int i = 0; i <  10; i++) {
            changeColor("rgb(0,200,0)", element,driver);//1
            changeColor(bgcolor, element,driver);//2
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver) {
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

        try {
            Thread.sleep(20);
        }  catch (InterruptedException e) {
        }
     }
    
    public static void scrollPageDown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
