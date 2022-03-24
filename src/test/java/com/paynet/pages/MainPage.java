package com.paynet.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	private static By welcomeLocator=By.id("welcome");
	
	
	public static void waitForPresenceOfWelcome(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(welcomeLocator));
	}
	
	public static String getMainPageUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}

	public static void clickOnWelcomeLocator(WebDriver driver)
	{
		driver.findElement(welcomeLocator).click();
	}
}
