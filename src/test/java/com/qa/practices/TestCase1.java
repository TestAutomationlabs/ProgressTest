package com.qa.practices;

import org.testng.annotations.Test;
public class TestCase1 {
int param;
	
	public TestCase1(int param) {
		// TODO Auto-generated constructor stub
		this.param=param;
	}
	
@Test
public void testMethod1() {
System.out.println("This is test method 1" +param);
}

@Test
public void testMethod2()
{
	System.out.println("This is test cas1 of test method 2" +param);
	}
}