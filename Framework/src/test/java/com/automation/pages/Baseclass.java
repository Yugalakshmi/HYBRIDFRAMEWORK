package com.automation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.Browserfactory;
import com.automation.utility.Exceldataprovider;
import com.automation.utility.Helper;
import com.automation.utility.configdataprovider;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Baseclass {
public WebDriver driver;
public Exceldataprovider excel;
public configdataprovider conf;
public ExtentReports report;
public ExtentTest logger;

@BeforeSuite
public void setupsuite()
{
	Reporter.log("Trying to start launching browser", true);
	 excel = new Exceldataprovider();
	 conf = new configdataprovider();
	 
	 ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/demoguru99com.html_"+Helper.getCurrentDateTime()+".html"));
	 report = new ExtentReports();
	 report.attachReporter(extent);
}

@BeforeClass
public void setup()
{
	Reporter.log("Appication is getting started", true);

	driver = Browserfactory.startApplication(driver, conf.getBrowser(), conf.getStagingURL());
	System.out.println(driver.getTitle());
	Reporter.log("application launched successfully", true);

}
@AfterClass
public void teardown()
{
	Browserfactory.quitBrowser(driver);
}
@AfterMethod
public void tearDownMethod(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		
		logger.fail("Test Failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSreenshot(driver)).build());
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		
		logger.pass("Test Passed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureSreenshot(driver)).build());
	}
	
	report.flush();
	Reporter.log("Test completed and report generated", true);

}
}