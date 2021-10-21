package com.mindtree.wait.advance;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenShot {

	WebDriver driver;
	File tempFile, destinationFile;
	TakesScreenshot myScreenShot;
	String childWindow;

	public void invokeBrowser(String url) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}

	public void takeScreenShot() {
		invokeBrowser("https://www.w3schools.com");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Try it Yourself »")).click();
		childWindow = driver.getWindowHandles().toArray()[1].toString();
		driver.switchTo().window(childWindow);
		destinationFile = new File("D:\\MediaFiles\\Training\\201-Selenium\\W3schools.PNG");
		myScreenShot = (TakesScreenshot) driver;
		tempFile = myScreenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(tempFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		TakeScreenShot obj = new TakeScreenShot();
		obj.takeScreenShot();
	}

}
