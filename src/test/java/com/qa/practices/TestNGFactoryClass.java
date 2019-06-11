/* https://www.youtube.com/watch?v=L45dOpEa2aQ 
  Learn Automation Testing with Akanksha
 */



package com.qa.practices;

import org.testng.annotations.Factory;

public class TestNGFactoryClass {
	
@Factory()
public Object[] getTestCaseClasses(){
Object[] data = new Object[2];
data[0] = new TestCase1(0);
data[1] = new TestCase1(1);
//TestCase1 t=new TestCase1();
//Object[]obj= {t};

return data;
}
}