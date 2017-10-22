package com.snyder.test.ui.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.snyder.test.object.AOSLogin;

public class FlipkartLoginPage {
	RemoteWebDriver driver;
	public FlipkartLoginPage(RemoteWebDriver driver)
	{
		this.driver= driver;
	}
	public WebElement getEmailOrPhoneTextbox()
	{
		if(driver.getClass().getName().contains("AndroidDriver"))
		{
			return driver.findElement(AOSLogin.emailOrPhome);
		}
		else if(driver.getClass().getName().contains("IOSDriver"))
		{
			//TBD
		}
		return null;
	}
	
	public WebElement getPasswordTextbox()
	{
		if(driver.getClass().getName().contains("AndroidDriver"))
		{
			return driver.findElement(AOSLogin.password);
		}
		else if (driver.getClass().getName().contains("IOSDriver"))
		{
			//TBD
		}
		return null;
	}
	
	public WebElement getSignInButton()
	{
		if(driver.getClass().getName().contains("AndroidDriver"))
		{
			return driver.findElement(AOSLogin.signIn);
		}
		else if (driver.getClass().getName().contains("IOSDriver"))
		{
			//TBD
		}
		return null;
	}
	
	public WebElement getNoneOftheAboveButton()
	{
		if(driver.getClass().getName().contains("AndroidDriver"))
		{
			return driver.findElement(AOSLogin.NoneOftheAbove);
		}
		else if (driver.getClass().getName().contains("IOSDriver"))
		{
			//TBD
		}
		return null;
	}
	
	

}
