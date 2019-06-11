package com.qa.TestUtil;


import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentContent {
	
	private static ExtentTest test;
	private static ExtentReports report;
	static String browserinfo;
	//static LogTime timelog;
	//private static  data = new DataHandlers();
	
	
	
	public static ExtentReports reporter(String ClassName)
	{
		
		//String browser = data.getDataFromExcel("inputData", "main", 40, 1);
		
		
		
//		if (browser.equals("1.0")) 
//		{ browserinfo = "Chrome Browser";} 
//		else if (browser.equals("2.0")) 
//		{browserinfo = "Firefox Browser";} 
//		else if (browser.equals("3.0")) 
//		{browserinfo = "Internet Explorer Browser";} 
//		else if (browser.equalsIgnoreCase("4.0")) 
//		{browserinfo = "Microsoft Edge Browser";}
//		else 
//		{
//		browserinfo = "Chrome Browser";
//		}
			
		report = new ExtentReports("./Reports/Report of   "+ClassName+".html",true);
		
		report.addSystemInfo("Browser: ", browserinfo);
			
		report.loadConfig(new File("./extent-config.xml"));
		//test = report.startTest("Test start");
	 
	 return report;
	}
	
	public static ExtentReports reportEnd(ITestResult result)
	{
		if (result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, "Test Passed at "+ result.getName());
		}
		if (result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Failed at "+ result.getName());	
			test.log(LogStatus.FAIL, "Error accured was:"+ result.getThrowable());
		}
		else if (result.getStatus() == ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "Test skipped at "+ result.getName());
			test.log(LogStatus.SKIP, "Error accured was:"+ result.getThrowable());
		}
		report.endTest(test);
		report.flush();
		report.close();
		
		return report;
	}
//	private Date getTime(long millis) {
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTimeInMillis(millis);
//		return calendar.getTime();
//	}
}
