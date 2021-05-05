package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.ContactPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Util.TestUtil;
import com.qa.Util.WebEventListener;


public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage  homepage;
	ContactPage contactpage;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		homepage=loginpage.login(prop.getProperty("user"),prop.getProperty("password"));
	}
	
	@Test
	public void verifyhomePageTittleTest()
	{
		String homepagetittle=homepage.verifyHomePageTittle();
		Assert.assertEquals(homepagetittle, "CRMPRO");
		
	}
	
	@Test
	public void verifyuserNameTest()
	{
		testutil.switchToFrame();
		boolean flag1=homepage.userNameLabel();
		Assert.assertTrue(flag1);
	}
	
	@Test
	public void verifycontactLinkTest()
	{
		testutil.switchToFrame();
		contactpage=homepage.clickonContactsLink();
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
