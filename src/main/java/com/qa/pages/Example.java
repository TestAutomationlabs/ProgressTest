package com.qa.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
class Example{
   public static void main(String args[]){
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//Getting current date
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		//Number of Days to add
		cal.add(Calendar.DAY_OF_MONTH,7);
		
		//Date after adding the days to the current date
		String newDate = sdf.format(cal.getTime());  
		System.out.println(newDate);
		
   }
}