package com.snyder.test.utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.ScreenOrientation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DeviceHandle {

	public static void ChangeOrientationToPortait(RemoteWebDriver driver)
	{
		
		if(driver.getClass().getName().contains("Android"))
		{
			AndroidDriver android_driver = (AndroidDriver) driver;
			org.openqa.selenium.ScreenOrientation current = android_driver.getOrientation();
			if (current.toString().equalsIgnoreCase("landscape")) {
				try {
					android_driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
					
				} catch (Exception e) {
					System.err.println("Orientation is not supported by the app");
				}
			}
		}
		else if (driver.getClass().getName().contains("ios"))
				{
					IOSDriver ios_driver = (IOSDriver) driver;
					org.openqa.selenium.ScreenOrientation current = ios_driver.getOrientation();
					if (current.toString().equalsIgnoreCase("portrait")) {
						try
						{
							ios_driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
						}
						catch(Exception e)
						{
							System.err.println("Orientation is not supported by the app");
						}
					}
				}
	}
	
	public static void ChangeOrientationToLandscape(RemoteWebDriver driver)
	{
		AppiumDriver appium_driver = (AppiumDriver) driver;
		org.openqa.selenium.ScreenOrientation current = appium_driver.getOrientation();
		if(current.toString().equalsIgnoreCase("Portrait"))
		{
			appium_driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
		}	
	}
	
	public static void enableNetwork(AppiumDriver driver)
	{
		
	}
	
	public static void disableNetwork (AppiumDriver driver)
	{
		
	}
	
	public static void swipeRightToLeftScreen(AppiumDriver driver)
	{
		driver.swipe(1010, 820, 80, 820, 2000);
	}
	
	public static void swipeLeftToRightScreen(AppiumDriver driver)
	{
		driver.swipe(80, 820, 1010, 820, 2000);
	}
	
	
}
