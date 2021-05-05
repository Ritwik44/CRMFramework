/*
 * @autor : Naveen Khunteta
 * 
 */
package com.qa.Util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class ExtentReporterNG implements IReporter {
	
	public ExtentReports extent;
//	public ExtentAventReporter avent; Note: AventReporter is Pro version, use only free version
	public ExtentSparkReporter sparkreport;
	
	

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,String outputDirectory) {
		
		String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		extent = new ExtentReports();
		sparkreport = new ExtentSparkReporter(outputDirectory +File.separator+datename+"Spark-Extent.html");
		extent.attachReporter(sparkreport);
		extent.setReportUsesManualConfiguration(true);
		
		/*sparkreport = new ExtentSparkReporter("./Reports/"+ "Spark-Extent.html"");
		you can store the report in test-output(i.e in outputDirectory) or store in Report folder(manually create that) in current directory*/

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), Status.PASS);
				buildTestNodes(context.getFailedTests(), Status.FAIL);
				buildTestNodes(context.getSkippedTests(), Status.SKIP);
			}
		}

		extent.flush();
	//  extent.close()->method is removed and no longer required in current version
		
	}

	public void buildTestNodes(IResultMap tests, Status status) {
	
		ExtentTest test;

		if (tests.size() > 0) {
			for (ITestResult result : tests.getAllResults()) {
			 test = extent.createTest(result.getMethod().getMethodName());
             
				
			 //test.setStartedTime(getTime(result.getStartMillis()));
			//	test.setEndedTime(getTime(result.getEndMillis()));
			    
			test.getModel().setStartTime(getTime(result.getStartMillis()));
			test.getModel().setStartTime(getTime(result.getEndMillis()));

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);

				if (result.getThrowable() != null) {
					test.log(status, result.getThrowable());
				} else {
					test.log(status, "Test " + status.toString().toLowerCase()
							+ "ed");
				}

			//	extent.endTest(test);--->method is removed and no longer required in current version
				
			}
		}
	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}