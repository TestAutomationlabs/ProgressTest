package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import com.qa.ExtentReportListner.ExtentFactory;
import com.qa.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentTest;

public class Contacts extends TestBase {
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div/nav/div/ul/li[3]/a/span/span")
	WebElement contacts_tab;
	
@FindBy(xpath="//h4[@class='mb-0']")
WebElement contact_list;

public Contacts() {
	PageFactory.initElements(driver, this);
}


public void ContactsPage(ExtentTest test) throws InterruptedException {
Thread.sleep(3000);
contacts_tab.click();
	

}


public void ContactsList(ExtentTest test) throws InterruptedException
{
	List<WebElement>contacts_list=driver.findElements(By.xpath("//*[@id=\"mCSB_6_container\"]/div/div/div/div"));
	System.out.println("Total number of contacts list is "+ contacts_list.size());
	
	for(int i=0; i<contacts_list.size(); i++)
	{
		System.out.println("Contacts list is "+contacts_list.get(i).getText());
	
	if(contacts_list.get(i).getText().contains("Himanshu moreshwar Rajgure")) {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"mCSB_6_container\"]/div/div[3]/div/div/div/div[1]/div/a[3]/i")).click();
	}
			
}


}
}
