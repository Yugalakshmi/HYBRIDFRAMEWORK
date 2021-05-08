package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automation.utility.Browserfactory;

public class Loginpage {
WebDriver driver;

	public Loginpage(WebDriver ldriver)
	{
		this.driver =ldriver;
	}
	@FindBy(name="email") WebElement uname;
	@FindBy(name="passwd") WebElement pword;
	@FindBy(name="SubmitLogin") WebElement Signin;
	
	public void Logintoguru99(String usernameapp, String passwordapp)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameapp);
		pword.sendKeys(passwordapp);
		Signin.click();
			}
}
