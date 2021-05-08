package com.automation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browserfactory {

	public static WebDriver startApplication(WebDriver driver,String browsername,String appURL)
	{
	if(browsername.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./Driverss/chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(browsername.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "./Driverss/geckodriver.exe");
		driver = new FirefoxDriver();

	}
	else if(browsername.equalsIgnoreCase("IE"))
	{
		System.setProperty("webdriver.ie.driver", "./Driverss/IEDriverServer.exe");
		driver = new InternetExplorerDriver();

	}
	else 
	{
		System.out.println("Sorry,We dont support this browser");
	}
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	return driver;
	}
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
}
