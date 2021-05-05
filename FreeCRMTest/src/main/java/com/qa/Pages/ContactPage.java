package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.Base.TestBase;

public class ContactPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	/*@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactLink;
	*/
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	public ContactPage()
	{
		PageFactory.initElements(driver, this);
	}

	public boolean contactLabel()
	{
	  return contactLabel.isDisplayed();
	  
	}
	
	
	public void selectContactList(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td[@class='datalistrow']/preceding-sibling::td/input[@name='contact_id']")).click();
	}
	
	/*public void clickonNewContactLink()
	{
		Actions act=new Actions(driver);
		act.moveToElement(contactsLink).build().perform();
		newcontactLink.click();
	}	*/
	
   public void createNewContact(String title, String fname, String lname, String company)
   {
	   Select select =new Select(driver.findElement(By.name("title")));
       select.selectByVisibleText(title);
       
       firstname.sendKeys(fname);
       lastname.sendKeys(lname);
       companyname.sendKeys(company);
       savebtn.click();
   
   }
   
   
}



