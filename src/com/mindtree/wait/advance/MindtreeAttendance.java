package com.mindtree.wait.advance;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class MindtreeAttendance {
	
	WebDriver driver;
	Action seriesofActions;
	Actions myAction;
	
	public void markAttendance() {
	
	System.setProperty("webdriver.chrome.driver",
			"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://essapps.mindtree.com/sites/TimeSheet/_layouts/15/TimeSheetPh2/Timesheet.aspx");
	//myAction = new Action();
	driver.findElement(By.id("ctl00_PlaceHolderMain_gvUsers_ctl02_txtEffortDay1")).clear();
	driver.findElement(By.id("ctl00_PlaceHolderMain_gvUsers_ctl02_txtEffortDay1")).sendKeys("1.00");
	driver.findElement(By.id("ctl00_PlaceHolderMain_btnProjSave")).click();
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MindtreeAttendance obj = new MindtreeAttendance();
		obj.markAttendance();

	}

}
