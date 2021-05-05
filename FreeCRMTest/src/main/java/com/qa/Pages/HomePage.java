package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.Base.TestBase;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath="//td[contains(text(),'User: Mukesh Otwani')]")
	WebElement userNamelabel;
	
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//Actions: methods
	public String verifyHomePageTittle()
	{
		return driver.getTitle();
	}	

	
	public boolean userNameLabel()
	{
	  return userNamelabel.isDisplayed();
	}
	
	public ContactPage clickonContactsLink()
	{
		contactsLink.click();
		return new ContactPage();
	}
	
	public DealsPage clickonDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TaskPage clickonTasksLink()
	{
		tasksLink.click();
		return new TaskPage();
		
	}

	//This method is called after navigating into Contact page
	public void clickonNewContactLink() 
	{
		Actions act=new Actions(driver);
		//moving back to Homepage as moveToElement(contactsLink).click() is not working in the contact page 
		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
		act.moveToElement(contactsLink).build().perform();
		newcontactLink.click();
		
		
	}
}
