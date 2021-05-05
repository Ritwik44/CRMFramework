package com.qa.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.qa.Util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
//	public static WebEventListener eventlistener;
//	public static EventFiringWebDriver e_driver ;

	
	public TestBase()
	{
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("G:\\Selenium Video\\workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(ip);
			
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
	}

	
	public static void intialization()
	{
	  String browsername=prop.getProperty("browser");
	  if (browsername.equals("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "G:\\Selenium Video\\JDK Software\\Drivers\\chromedriver_win32\\chromedriver.exe");
		 
		    ChromeOptions capability = new ChromeOptions();
	        capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	        capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

	        driver = new ChromeDriver(capability);
	        
	//      Chromeoptions was introduced as we are getting error as: Your connection is not private
	//      driver=new ChromeDriver();
	        
	  }
	  
	  
	    /*e_driver=new EventFiringWebDriver(driver);
	    eventlistener=new WebEventListener();
	    e_driver.register(eventlistener);
	    driver=e_driver;*/
	    
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	
}
