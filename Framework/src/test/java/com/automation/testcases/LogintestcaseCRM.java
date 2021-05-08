package com.automation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.pages.Baseclass;
import com.automation.pages.Loginpage;
import com.automation.utility.Browserfactory;
import com.automation.utility.Exceldataprovider;
import com.automation.utility.Helper;

public class LogintestcaseCRM extends Baseclass{
	
		
	@Test(priority = 1)
	public void loginapp()
	
	{
		logger = report.createTest("Login to guru website");
		Loginpage login = 	PageFactory.initElements(driver, Loginpage.class);
		logger.info("Starting application");
		login.Logintoguru99(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));	
		logger.pass("Login success");
		Helper.captureSreenshot(driver);
	}
	
	@Test(priority=2)
	public void loginapp1()
	
	{
		logger = report.createTest("Log out");
		logger.fail("Logout failed");
		
	}
	
}
