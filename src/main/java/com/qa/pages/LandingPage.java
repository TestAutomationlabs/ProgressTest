package com.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.qa.TestBase.TestBase;
import com.qa.TestUtil.TestUtil;

public class LandingPage extends TestBase {

	@FindBy(xpath = "//span[contains(text(),'New Project')]")
	public WebElement NewProject_Button;
	
	public WebElement NewProject_ButtonValidation;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/nav/div/div/button[1]")
	public WebElement HelpButton;
	
	@FindBy(xpath="//span[@class='navbar-brands]")
	public WebElement MerckLogo;
	
	@FindBy(xpath="//*[@id=\"Project_Project0\"]/i")
	public WebElement moreicon;
	
	


	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyHomeIcon(ExtentTest test) {
		try {
			if(MerckLogo.isDisplayed())
			{
				System.out.println("Homeicon is present");
			}
		}
		catch(Exception e)
		{
			System.out.println("Home icon is not present");
		}

		return MerckLogo.isDisplayed();
	}
	
	public boolean verifyMore_DeleteIconButton(ExtentTest test) throws InterruptedException
	{
		try {
			if(moreicon.isDisplayed())
				moreicon.click();
			System.out.println("More icon is clickee");
			List<WebElement>more_options=driver.findElements(By.xpath("/html/body/div[2]/div/div/div/ul/li/span"));
			System.out.println("Size of more options is"+more_options.size());
		
				for (int i = 0; i < more_options.size(); i++) {
				String text = driver.findElements(By.xpath(
						"/html/body/div[2]/div/div/div/ul/li/span"))
						.get(i).getText();
				if (text.equalsIgnoreCase("Delete")) {
					driver.findElements(By.xpath(
							"/html/body/div[2]/div/div/div/ul/li/span"))
							.get(i).click();
					break;
		}
				
	}
		}
		catch(Exception e)
		{
			System.out.println("Exception found is at" +e);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Yes')]")).click();
		return moreicon.isDisplayed();
	}
	
	public boolean verifymore_EditIconButton(ExtentTest test) throws InterruptedException
	{
		try {
			if(moreicon.isDisplayed())
				moreicon.click();
			System.out.println("More icon is clickeed");
			List<WebElement>moreList=driver.findElements(By.xpath("//html/body/div[2]/div/div/div/ul/li/span"));
			System.out.println("Size of more options is"+moreList.size());
		
				for (int i = 0; i < moreList.size(); i++) {
				String text = driver.findElements(By.xpath(
						"/html/body/div[2]/div/div/div/ul/li/span"))
						.get(i).getText();
				if (text.equalsIgnoreCase("Edit")) {
					driver.findElements(By.xpath(
							"/html/body/div[2]/div/div/div/ul/li/span"))
							.get(i).click();
					break;
		}
				
	}
		}
		catch(Exception e)
		{
			System.out.println("Exception found is at" +e);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/nav/ul/li/a/i")).click();
		System.out.println("Moved back to registration page");
		return moreicon.isDisplayed();
	}
		
	
	public boolean verifymore_DuplicateIconButton(ExtentTest test) throws InterruptedException
	{
		try {
			if(moreicon.isDisplayed())
				moreicon.click();
			System.out.println("More icon is clickeed");
			List<WebElement>more_duplicate=driver.findElements(By.xpath("//html/body/div[2]/div/div/div/ul/li/span"));
			System.out.println("Size of more options is"+more_duplicate.size());
		
				for (int i = 0; i < more_duplicate.size(); i++) {
				String text = driver.findElements(By.xpath(
						"/html/body/div[2]/div/div/div/ul/li/span"))
						.get(i).getText();
				if (text.equalsIgnoreCase("Duplicate")) {
					driver.findElements(By.xpath(
							"/html/body/div[2]/div/div/div/ul/li/span"))
							.get(i).click();
					break;
		}
				
	}
		}
		catch(Exception e)
		{
			System.out.println("Exception found is at" +e);
		}
		Thread.sleep(2000);
		System.out.println("Duplicate title has been created in Myprojects page");
		return moreicon.isDisplayed();
	}

	public boolean verifyNewProjectButton(ExtentTest test) throws InterruptedException {
		Thread.sleep(3000);
		try {
			if (NewProject_Button.isDisplayed()) {
				NewProject_Button.click();
				System.out.println("New project button is displayed and clicked");
				test.log(LogStatus.PASS, "New project button is displayed and clicked");

			} else {

				System.out.println("New project button is not displayed");
				test.log(LogStatus.FAIL, "New project button is not displayed");
			}
		} catch (Exception e) {
			System.out.println("New project button is not displayed");
			test.log(LogStatus.FAIL, "New project button is not displayed");

		}
		//NewProject_ButtonValidation=TestUtil.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("NewProject_Button")));
		//System.out.println("New project validation is copleted");
		return NewProject_Button.isDisplayed();
	}
		

	public boolean verifyHelpButton(ExtentTest test) {
		try {
			if (!HelpButton.isDisplayed()) {
				System.out.println("Help button is not displayed");
				test.log(LogStatus.FAIL, "Helpbutton is not displayed");
				
			} else {
				HelpButton.click();
				System.out.println("Helpbutton is displayed and clicked");
				test.log(LogStatus.PASS, "Helpbutton is displayed and clicked");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/nav/ul/li/a/i")).click();
				System.out.println("Navigated back to landing page");
				test.log(LogStatus.PASS, "Navigated back to landing page");
			}
		} catch (Exception e) {
			System.out.println("Help button is not displayed");
			test.log(LogStatus.FAIL, "Helpbutton is not displayed");
		}
		return HelpButton.isDisplayed();
	}
}
