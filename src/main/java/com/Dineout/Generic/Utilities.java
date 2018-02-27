package com.Dineout.Generic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utilities 
{

	public WebDriver driver;
	public static void selectByIndex(WebElement element,int n)
	{
	Select sel=new Select(element);
	sel.selectByIndex(n);
	}
	public static void selectByValue(WebElement element,String value)
	{
	Select sel=new Select(element);
	sel.selectByValue(value);
	}
	public static void selectByVisibleText(WebElement element,String text)
	{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
	}
	public static void moveToElement(WebElement element,WebDriver driver)
	{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
	}
	public static void dragAndDrop(WebElement source,WebElement target,WebDriver driver)
	{
	Actions act=new Actions(driver);
	act.dragAndDrop(source, target);
	}
	public static void alertAccept(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public static void alertDismiss(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	

}
