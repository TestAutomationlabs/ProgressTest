package com.qa.practices;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) throws ParseException {
		
	
	Date currentDate=new Date();
	 System.out.println("Current Date: "+currentDate);  
	 
	 String dateToStr=DateFormat.getInstance().format(currentDate);
	 System.out.println("Date format using getInstance "+ dateToStr);
	 
	 dateToStr=DateFormat.getDateInstance().format(currentDate);
	 System.out.println("Date format of getDateInstance "+ dateToStr);
	 
	 dateToStr=DateFormat.getTimeInstance().format(currentDate);
	 System.out.println("Date format of getTimeInstance "+ dateToStr);
	 
	 
	 Date d = DateFormat.getDateInstance().parse("31, Mar, 2018");  
     System.out.println("Date is: "+d);  
     
     
    // String str="2015-03-31";
    // Date date=Date.
    // System.out.println("Date of string is"+date);
	 

}
}