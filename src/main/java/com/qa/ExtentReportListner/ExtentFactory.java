package com.qa.ExtentReportListner;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	public static ExtentReports Instance()
	{
		ExtentReports extent;
		//String ClassName = this.getClass().getSimpleName().toString();
		//report = new ExtentReports("./Reports/Report of   "+ClassName+".html",true);
		//String path="./Reports/ExtentReport_STP.html";
		
		//String path="C://Users//SLANKEGO//Desktop//Git_UpdatedCode//Progress//TestReports//ExtentReport_STP.html";
		String path="./TestReports/Extent.html";
		
		//String path=("./TestReports/Extent.html");
		//report = new ExtentReports("./Reports/"+ClassName+".html",true);
		//report.loadConfig(new File("./extent-config.xml"));
				extent = new ExtentReports(path,false);
				extent.addSystemInfo("selenium verion", "2.53");
				extent.addSystemInfo("Platform", "Windows");
		return extent;
		
	}

}
