package com.mindtree.wait.advance;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {

	WebDriver driver;
	File tempFile, destinationFile;
	TakesScreenshot myscreenshot;

	public void testGoogle() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.id("lst-ib")).sendKeys("Sithalapakam");
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText("Sithalapakkam - Wikipedia")).click();
	}
	public void printScreen() {
		try {
			destinationFile = new File("D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\sample.PNG");
			myscreenshot = (TakesScreenshot)driver;
			tempFile = myscreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(tempFile, destinationFile);
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		SampleTest obj = new SampleTest();
		obj.testGoogle();
		obj.printScreen();

	}

}
