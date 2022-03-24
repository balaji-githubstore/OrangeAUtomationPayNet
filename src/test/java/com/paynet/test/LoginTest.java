package com.paynet.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paynet.base.WebDriverWrapper;
import com.paynet.pages.LoginPage;
import com.paynet.pages.MainPage;
import com.paynet.utilities.DataSourceUtils;

public class LoginTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataSourceUtils.class,dataProvider = "validCredentialData")
	public void validCredentialTest(String username,String password,String expectedUrl) {
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		MainPage.waitForPresenceOfWelcome(driver);
		
		Assert.assertEquals(MainPage.getMainPageUrl(driver), expectedUrl);
	}
	
	@Test(dataProviderClass = DataSourceUtils.class,dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String expectedError)
	{
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		String actualError= LoginPage.getErrorMessage(driver);
		
		Assert.assertEquals(actualError, expectedError);
	}

}
