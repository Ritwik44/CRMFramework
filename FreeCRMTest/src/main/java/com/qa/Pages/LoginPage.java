package com.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory-Object Repository:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement crmLogo;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//Actions: methods
	public String verifyLoginPageTittle()
	{
		return driver.getTitle();
	}	
	
	public boolean verifyLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	
	public HomePage login(String usr, String pwd)
	{
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginbtn.click();
	 // after clicking on login button it is landing into HomePage and we have HomePage Class already
		return new HomePage();
		
	}
}
