package com.snyder.test.utils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CreateDriver {
	
	public static AppiumDriver getDriverInstance()
	{
		AppiumDriver driver= null;
		try
		{
			DesiredCapabilities cap = new DesiredCapabilities();
			String drivertype= ReadData.fromProperty("Configuration", "driver");
			String appActivity= ReadData.fromProperty("Configuration", "appActivity");
			String appPackage= ReadData.fromProperty("Configuration", "appPackageName");
			String deviceName= ReadData.fromProperty("Configuration", "device");
			
			System.out.println("Driver type: " +drivertype);
			System.out.println("App Activity : " +appActivity);
			System.out.println("App Package : " +appPackage);
			System.out.println("Device Name : " +deviceName);
			
			
			if(drivertype.equals("aos"))
			{
				cap.setCapability("platformName", "Android");
				cap.setCapability("platformVersion", "5.1");
				cap.setCapability("appActivity", appActivity);
				cap.setCapability("appPackage", appPackage);
				cap.setCapability("deviceName", deviceName);
				System.out.println("----Capabilities are set");
				driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				System.out.println("---App is opened");
			}
			else if(drivertype.equals("ios"))
			{
				cap.setCapability("platformName", "IOS");
				cap.setCapability("platformVersion", "10.0");
				cap.setCapability("UID", "");
				cap.setCapability("bundleID", "");
				driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			DeviceHandle.enableNetwork(driver);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}
}
