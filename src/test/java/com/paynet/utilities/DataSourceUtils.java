package com.paynet.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataSourceUtils {

	@DataProvider
	public String[][] validCredentialData() throws IOException 
	{
		String[][] obj=ExcelUtils.getSheetIntoTwoDimArray("data/TestData.xlsx", "validCredentialTest");
		return obj;
	}
	
	
	@DataProvider
	public String[][] invalidCredentialData() {
		String[][] main = new String[4][3];

		main[0][0] = "john";
		main[0][1] = "john123";
		main[0][2] = "Invalid credentials";

		main[1][0] = "peter";
		main[1][1] = "peter123";
		main[1][2] = "Invalid credentials";

		main[2][0] = "";
		main[2][1] = "paul123";
		main[2][2] = "Username cannot be empty";

		main[3][0] = "mark";
		main[3][1] = "";
		main[3][2] = "Password cannot be empty";

		return main;
	}
	
	
	

}
