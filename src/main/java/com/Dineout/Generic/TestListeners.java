package com.Dineout.Generic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener
{

	private static  WebDriver driver = null;

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		Date date=new Date();
		SimpleDateFormat s=new SimpleDateFormat("dd:mm:yy HH:MM:SS");
		String todaysDate = s.format(date);
		String name=result.getMethod().getMethodName();
		EventFiringWebDriver e=new EventFiringWebDriver(driver);
		File src=e.getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(src, new File("./src/test/resources/Screenshots/"+name+""+todaysDate+".png"));
		}
		catch(Exception e1)
		{
		e1.printStackTrace();	
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

}
