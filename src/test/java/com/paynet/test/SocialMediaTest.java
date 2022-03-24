package com.paynet.test;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paynet.base.WebDriverWrapper;
import com.paynet.pages.LoginPage;

public class SocialMediaTest extends WebDriverWrapper {
	
	@Test
	public void validateLinkedinLinkTest()
	{
		LoginPage.clickOnLinkendin(driver);
		
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		Assert.assertEquals(driver.getTitle(), "Sign Up | LinkedIn");
	}
	
	@Test
	public void validateFacebookLinkTest()
	{
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		
		//switch to 2 tab
		ArrayList<String> windows=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM - World's Most Popular Opensource HRIS - Home | Facebook");
	}
	

}
