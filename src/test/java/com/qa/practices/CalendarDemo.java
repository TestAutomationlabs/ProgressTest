package com.qa.practices;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar calendar=Calendar.getInstance();
		System.out.println("The current date is: "+calendar.getTime());
		
		
		
		calendar.add(calendar.DATE, -15);
		System.out.println("15 days ago is "+calendar.getTime());
		
		calendar.add(calendar.DATE, +5);
		System.out.println("5 days later is "+calendar.getTime());
	//	calendar.add(calendar.DATE, 4);
	//	System.out.println("4 months later "+calendar.getTime());
		
		//calendar.add(calendar.YEAR, 2);
		//System.out.println("2 years later "+calendar.getTime());
		
		System.out.println("Present calendar year "+calendar.get(calendar.YEAR));
		
		//TWodays later
		calendar.add(calendar.DAY_OF_MONTH,2);
		Date twodayslater=calendar.getTime();
		System.out.println("Two days later calendar date "+twodayslater);
		System.out.println("Present calendar date "+calendar.get(calendar.DATE));
		System.out.println("Present calendar day "+calendar.get(calendar.DAY_OF_MONTH));
		System.out.println("Present calendar week "+calendar.get(calendar.DAY_OF_WEEK));
		
		
	}

}
