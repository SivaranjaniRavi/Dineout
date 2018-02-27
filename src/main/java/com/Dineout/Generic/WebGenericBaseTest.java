package com.Dineout.Generic;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public abstract class WebGenericBaseTest 
{
	public static WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	@BeforeSuite
	public void createReport()
	{
		report=new ExtentReports("/home/tyss/Desktop/Sivaranjani_Poc/POC/Dineout/src/test/resources/Reports/result.html");
		report.loadConfig(new File("/home/tyss/Desktop/Sivaranjani_Poc/POC/Dineout/src/test/resources/Reports/extent-config.xml"));
		
	}
	@BeforeMethod
	public void openApplication() throws IOException
	{
		//logger=report.startTest("started Running Test Scripts");
		File file=new File("./src/test/resources/Data/TestData.properties");
		FileInputStream fileInput=new FileInputStream(file);
		Properties props=new Properties();
		props.load(fileInput);
		System.setProperty(props.getProperty("CHROME_KEY"),props.getProperty("CHROME_VALUE"));
		driver=new ChromeDriver();
		driver.get(props.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}
	@AfterMethod
	public void closeApplication()
	{
		driver.close();
		//report.endTest(logger);
		
	}
	
	@AfterSuite
	public void flushReport()
	{
		report.close();
		report.flush();
	}

}
