package com.qa.Maps;

import java.util.HashMap;

public class Data {
	public static HashMap<String, String> getUserLoginInfo()
	{
		HashMap<String, String> usermap =new HashMap<String, String>();
		usermap.put ("admin", "eclipse_eclipse");
		usermap.put("customer", "netbeans_netbeans");
		return usermap;
	}

	public static HashMap<Integer, String> monthMap() {
		HashMap<Integer,String>monthmap=new HashMap<Integer, String>();
		monthmap.put(1, "January");
		monthmap.put(2, "February");
		monthmap.put(3, "March");
		monthmap.put(4, "April");
		monthmap.put(5, "May");
		monthmap.put(6, "June");
		monthmap.put(7, "July");
		monthmap.put(8, "August");
		monthmap.put(9, "September");
		monthmap.put(10, "October");
		monthmap.put(11, "November");
		monthmap.put(12, "December");
		
		
		return monthmap;
		
	}
	/*
	public static HashMap<Integer, String> daymap()
	{
		 HashMap<Integer, String>daymap=new HashMap<Integer, String>();
		 daymap.put(1, "monday");
		 daymap.put(2, "tuesday");
		 daymap.put(3, "wednesday");
		 daymap.put(4, "thrusday");
		 daymap.put(5, "friday");
		 daymap.put(6, "saturday");
		 daymap.put(7, "sunday");
		 
		return daymap;
	}
	*/
}
