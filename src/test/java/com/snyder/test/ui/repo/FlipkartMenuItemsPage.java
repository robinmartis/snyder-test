package com.snyder.test.ui.repo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.snyder.test.object.AOSFlipkartMenuItems;

public class FlipkartMenuItemsPage {
	RemoteWebDriver driver;
	public FlipkartMenuItemsPage(RemoteWebDriver driver)
	{
		this.driver= driver;
	}
	
	public WebElement getMyAccount()
	{
		if(driver.getClass().getName().contains("AndroidDriver"))
		{
			return driver.findElement(AOSFlipkartMenuItems.MyAccount);
		}
		else if (driver.getClass().getName().contains("IOSDriver"))
		{
			//TBD
		}
		return null;
	}

}
