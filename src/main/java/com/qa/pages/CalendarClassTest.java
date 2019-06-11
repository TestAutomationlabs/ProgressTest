package com.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarClassTest {
	
	public static void calendardata()
	{
		String threedaysbefore="";
		Date date=new Date();
		System.out.println("Date is"+ date);
		Calendar cal =Calendar.getInstance();
		cal.setTime(date);
	//	System.out.println(" cal is " +cal.setTime(date));
		
		cal.add(Calendar.DAY_OF_YEAR, -10);
		Date before=cal.getTime();
		System.out.println("before is "+before);
		SimpleDateFormat formatter=new SimpleDateFormat("dd.MM");
		threedaysbefore=formatter.format(before);
		 System.out.println(threedaysbefore);
		 
		 
		
		
	}
	
	public static void main(String[] args) {
		Date date =new Date();
		System.out.println("Current date is" + date);
		System.out.println("date.getDate() :: " + date.getDate());
		System.out.println("date.getDay() :: " + date.getDay());
		System.out.println("date.getMonth() :: " + date.getMonth());
		System.out.println("date.getYear() :: " +date.getYear());
		
		calendardata();
		
	}

}
