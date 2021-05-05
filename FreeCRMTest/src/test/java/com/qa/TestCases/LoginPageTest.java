package com.qa.TestCases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Util.ExtentReporterNG;
import com.qa.Util.WebEventListener;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteClassListenerAdapter;
import com.aventstack.extentreports.testng.listener.*;


@Listeners(ExtentReporterNG.class)
public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	Logger logger;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setup()
	{   logger=LogManager.getLogger(LoginPageTest.class);
		intialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void loginPageTittleTest()
	{
		String tittle=loginpage.verifyLoginPageTittle();
		Assert.assertEquals(tittle, "Free CRM - CRM software for customer relationship management, sales, and support.");
		logger.info("loginPageTittleTest info");
		logger.error("loginPageTittleTest error");
		logger.warn("loginPageTittleTest warn");
		logger.fatal("loginPageTittleTest fatal");
		
	}
	
	
	@Test
	public void logoTest()
	{
		boolean flag=loginpage.verifyLogo();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void loginTest()
	{
		 homepage=loginpage.login(prop.getProperty("user"),prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	

}
