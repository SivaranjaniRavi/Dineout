package com.Dineout.Generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public  class WebGenericBasePage 
{

	public WebDriver driver;
	public WebGenericBasePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void verifyTitle (String etitle)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.titleIs(etitle));
			Reporter.log("Title is matching:"+etitle, true);
		}
		catch(Exception e)
		{
			Reporter.log("Title is not matching:"+etitle, true);
			Assert.fail();
		}
	}
	public void verifyElementPresent(WebElement element)
	{
		try
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is matching:"+element, true);
			Assert.fail();
		}
		catch(Exception e)
		{
			Reporter.log("Element is not matching:"+element, true);
			Assert.fail();
		}
	}

}
