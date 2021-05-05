package com.qa.Util;
/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements 
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc). 

 */

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.Base.TestBase;

public class WebEventListener extends TestBase implements ITestListener {

	public void onFinish(ITestContext result) {
		System.out.println("Test Finished is "+ result.getName());
		
	}

	public void onStart(ITestContext result) {
		
		System.out.println("Test started is "+ result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
     System.out.println("Test Failed is "+ result.getName());
     TestUtil.takeScreenshotAtEndOfTest(result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
	System.out.println("Test skipped is "+ result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test started is "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test successfully compleated is "+ result.getName());
		
	}

	
	

}