package com.snyder.test.smoke;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.snyder.test.ui.repo.FlipkartHomePage;
import com.snyder.test.ui.repo.FlipkartLoginPage;
import com.snyder.test.ui.repo.FlipkartMenuItemsPage;
import com.snyder.test.utils.CreateDriver;

import io.appium.java_client.AppiumDriver;

public class TestLoginUS109 {
	
	AppiumDriver driver ;
	FlipkartHomePage home_page;
	FlipkartMenuItemsPage menu_items;
	FlipkartLoginPage login_page;
	
	@BeforeMethod
	public void setup()
	{
		driver=CreateDriver.getDriverInstance();
		home_page= new FlipkartHomePage(driver);
		menu_items= new FlipkartMenuItemsPage(driver);
		login_page= new FlipkartLoginPage(driver);
	}
	
	@Test
	public void testLoginSuccessTC119() throws InterruptedException
	{
		//Click on Menu item
		home_page.getMenuIcon().click();
		System.out.println("Clicked on the Menu icon");
		
		//Click on My accounts
		menu_items.getMyAccount().click();
		System.out.println("Clicked on My accounts");
		
		//Click on email or phone no text box
		login_page.getEmailOrPhoneTextbox().click();
		System.out.println("Clicked on Email or Phone no");
		
		//Click on None of the above 
		login_page.getNoneOftheAboveButton().click();
		System.out.println("Click on none of the above button ");
		
		//Enter the email
		login_page.getEmailOrPhoneTextbox().sendKeys("robin.martis@gmail.com");
		System.out.println("Enter the email or phone no");
		
		//Enter the password
		login_page.getPasswordTextbox().sendKeys("dfdfdf");
		System.out.println("Enter the password");
		
		//Click on Sugn in button
		login_page.getSignInButton().click();
		System.out.println("Click on Sign in button");
		
		Thread.sleep(5000);
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
