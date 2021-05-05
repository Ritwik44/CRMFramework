package com.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.Base.TestBase;
import com.qa.Pages.ContactPage;
import com.qa.Pages.HomePage;
import com.qa.Pages.LoginPage;
import com.qa.Util.TestUtil;
import com.qa.Util.WebEventListener;


public class ContactPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage  homepage;
	ContactPage contactpage;
	TestUtil testutil;
	String sheetName="contactsdata";
	
	public ContactPageTest()
	{
		super();
	}

	
	
	@BeforeMethod
	public void setup()
	{
		intialization();
		loginpage=new LoginPage();
		testutil=new TestUtil();
		contactpage=new ContactPage();
		homepage=loginpage.login(prop.getProperty("user"),prop.getProperty("password"));
		testutil.switchToFrame();
	    contactpage=homepage.clickonContactsLink();
		
	}
	
	@Test
	public void verifyContactlabelTest()
	{
		boolean flag2=contactpage.contactLabel();
		Assert.assertTrue(flag2);
	}
	
	@Test
	public void selectContactTest() 
	{
		contactpage.selectContactList("Babulal Pathak");
		
	}
	
	@Test
	public void verifyNewContactlink()
	{
		homepage.clickonNewContactLink();
	}
	
	@DataProvider
	public Object[][] getTestdata()
	{
		Object[][] tdata=TestUtil.getTestData(sheetName);
		return tdata;
	}
	
	@Test(dataProvider="getTestdata")
	public void verfyCreateNewContact(String title, String fname, String lname, String company)
	{
		homepage.clickonNewContactLink();
		contactpage.createNewContact(title, fname, lname, company);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
