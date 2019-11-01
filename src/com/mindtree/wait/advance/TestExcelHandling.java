package com.mindtree.wait.advance;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestExcelHandling {

	WebDriver driver;
	InputStream myStream;
	Workbook myBook;
	Sheet mySheet;
	Row myRow;
	Cell myCell;
	String[][] myData = new String[2][2];
	String username, password;

	public void loginToFacebook(String username, String password) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='u_0_r']")).submit();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();

	}

	public void fetchTestData() {
		try {
			myStream = new FileInputStream("D:\\MediaFiles\\Training\\201-Selenium\\TestData.xlsx");
			myBook = WorkbookFactory.create(myStream);
			mySheet = myBook.getSheet("Facebook");
			int rowCount = mySheet.getPhysicalNumberOfRows();
			for (int i = 0; i < rowCount; i++) {
				myRow = mySheet.getRow(i);
				for (int j = 0; j < myRow.getLastCellNum(); j++) {
					myCell = myRow.getCell(j);

					CellType type = myCell.getCellTypeEnum();

					if (type == CellType.NUMERIC) {
						myData[i][j] = String.valueOf((long) myCell.getNumericCellValue());

					} else {
						myData[i][j] = myCell.getStringCellValue();

					}
				}
			}

		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void passValue() {
		for (int x = 0; x < myData.length; x++) {
			username = myData[x][0];
			password = myData[x][1];
			loginToFacebook(username, password);

		}
	}

	public static void main(String[] args) {
		TestExcelHandling obj = new TestExcelHandling();
		obj.fetchTestData();
		obj.passValue();

	}

}
