package com.paynet.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//need to delete
public class DemoTest {
	
	@DataProvider
	public String[][] validData()
	{
		String[][] main=new String[2][3];
		//i--> number of test case or how many set of test record
		//j-->number of parameters
		main[0][0]="John";
		main[0][1]="john123";
		main[0][2]="Invalid credentials";
		
		main[1][0]="Peter";
		main[1][1]="peter123";
		main[1][2]="Invalid credentials";
		
		return main;
	}
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password,String expectedError)
	{
		System.out.println("test "+username+password+expectedError);
	}

}
