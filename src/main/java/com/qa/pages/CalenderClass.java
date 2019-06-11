package com.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderClass {
	public static WebDriver driver;
	static int currentDate;
	static int currentMonth;
	static int currentyear;
	
	public static void getCurrentDayMonth() {

	
	
	    Calendar cal = Calendar.getInstance();
	    currentDate = cal.get(Calendar.DAY_OF_MONTH);
	    currentMonth = cal.get(Calendar.MONTH) +1;
	    currentyear = cal.get(Calendar.YEAR);
	    System.out.println("Current date is "+currentDate);
	    System.out.println("Current month is "+currentMonth);
	    System.out.println("Current year is"+currentyear);
	}
public static void current()
{
	
	Calendar calendar = Calendar.getInstance();
    
//	 get a date to represent "today"
	    Date today = calendar.getTime();
	   
	    System.out.println("today:    " + today);
	 
//	    // add one day to the date/calendar
	    calendar.add(Calendar.DAY_OF_YEAR, +2);
	    
//	    
//	    // now get "tomorrow"
	    Date tomorrow = calendar.getTime();
//
//	    // print out tomorrow's date
	    System.out.println("tomorrow: " + tomorrow);
	
	System.setProperty("webdriver.chrome.driver", "./ExternalJars/ChromeDriver/chromedriver.exe");	
	
	//C:\Users\SLANKEGO\eclipse-workspace\STP_Automation\ExternalJars\ChromeDriver\chromedriver.exe
	driver = new ChromeDriver(); 
    System.out.println("User has installed the chrome hence launching the chrome browser");
    driver.get("https://www.makemytrip.com/");
   WebElement ele= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/label/span"));
   ele.click();
   WebElement ele2= driver.findElement(By.xpath("//div[contains(text(),'April 2019')]"));
   List<WebElement>dates=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div/div/p"));
   int count=dates.size();
   System.out.println("count of date size is"+count);
   

	for (int i = 0; i < count; i++) {
		String text = driver
				.findElements(By.xpath(
						"//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div/div/p"))
				.get(i).getText();
   
   
   if(text.equalsIgnoreCase("tomorrow")) {
	   driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div/div/div/p")).get(i).click();
	    break;

	}
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String threedaysbefore="";
		Date date=new Date();
		System.out.println("Date is"+ date);
		Calendar cal =Calendar.getInstance();
		cal.setTime(date);
		
		cal.add(Calendar.DAY_OF_YEAR, -3);
		Date before=cal.getTime();
		SimpleDateFormat formatter=new SimpleDateFormat("dd.MM");
		threedaysbefore=formatter.format(before);
		 System.out.println(threedaysbefore);
		 
		 getCurrentDayMonth();
		 current();
		
		

	}

}
