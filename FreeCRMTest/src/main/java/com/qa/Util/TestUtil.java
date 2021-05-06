package com.qa.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import com.qa.Base.TestBase;

public class TestUtil extends TestBase {
	
	public static String TESTDATA_SHEET_PATH = "G:\\Selenium Video\\workspace\\FreeCRMTest\\src\\main\\java\\com\\qa\\Testdata\\CRMTestdata.xlsx";

	static Workbook book;
	static Sheet sheet;

	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	//Test 1
	//Test2
	/*public static void takeScreenshotAtEndOfTest() throws IOException {
		
	
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	//	String currentDir = System.getProperty("user.dir");
	//	FileHandler.copy(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	    above 2 lines of code is not creating the Screenshot folder in the Project Directory, so we have created a normal Screenshot
		folder manually in the Current Project directory and it works but this method will not capture the screenshot when assertion error will come	
		
		FileHandler.copy(scrFile, new File("./Screenshots/" +System.currentTimeMillis() + ".png"));
	
	}*/
	
	
	public static void takeScreenshotAtEndOfTest(String testname) {
		
		String datename=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(scrFile, new File("./Screenshots/" +testname +datename+ ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
}



