package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.TestBase.TestBase;

public class SupplierPage extends TestBase{
	
	@FindBy(xpath="//div[contains(@id,'mCSB')]/nav[2]/div/div/div[1]/input[contains(@placeholder, 'Search')]")
	WebElement SearchBar;
	
	@FindBy(xpath="//div[contains(@id,'mCSB')]/nav[2]/div/div/div[1]/button/span[contains(text(),'Search')]")
	WebElement SearchBox;
	
	@FindBy(xpath="//span[contains(text(), 'New Supplier')]")
	WebElement NewSupplier_Button;
	
	@FindBy(xpath="//div[@class='pr-5 mr-5']/select[@class='form-control']")
	WebElement sortdropdown;
	
	
	
public SupplierPage()
{
	PageFactory.initElements(driver, this);
}
	

public void verify_AddNewSupplier() throws InterruptedException
{
	if(NewSupplier_Button.isDisplayed())
	{
		Thread.sleep(2000);
		NewSupplier_Button.click();
		driver.findElement(By.xpath("//html/body/div[2]/div/div[1]/div/div/div[2]/div/div[2]/div/div[2]/button[2]/span")).click();
		System.out.println("New supplier button save button is clicked");
	}
	
}
public void verifySort() throws InterruptedException
{
	//WebElement sortdropdown=driver.findElement(By.xpath("//div[@class='pr-5 mr-5']/select[@class='form-control']"));
	sortdropdown.click();
	Thread.sleep(3000);
	sortdropdown.click();
	System.out.println("Sort drop down is clicked");
	try {
	Thread.sleep(3000);
	List<WebElement>sort_dropdown=driver.findElements(By.xpath("//div[@class='pr-5 mr-5']/select[@class='form-control']/option"));
	System.out.println("Size of sort dropdown is "+ sort_dropdown.size());
	
	for(int x=0; x<sort_dropdown.size(); x++)
	{
		System.out.println(sort_dropdown.get(x).getText());
		if(sort_dropdown.get(x).getText().equals("Weekly Rates"))
		{
			sort_dropdown.get(x).click();
			break;
		}
	}
	}
catch (StaleElementReferenceException e) {
	System.out.println("Staleelementexception found");
}
	
	

	}
}
