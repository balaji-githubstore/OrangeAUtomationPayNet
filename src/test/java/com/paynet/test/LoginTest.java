package com.paynet.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paynet.base.WebDriverWrapper;
import com.paynet.utilities.DataSourceUtils;

public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataSourceUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String expectedUrl) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();

		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
	}
	
	@Test(dataProviderClass = DataSourceUtils.class,dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String expectedError)
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		
		String actualError= driver.findElement(By.id("spanMessage")).getText();
		
		Assert.assertEquals(actualError, expectedError);
	}

}
