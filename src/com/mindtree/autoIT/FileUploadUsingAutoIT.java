package com.mindtree.autoIT;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadUsingAutoIT {
	
	WebDriver driver;
	
	public void googleSearch() {
		try {
			System.setProperty("webdriver.chrome.driver", "D:\\\\MediaFiles\\\\Training\\\\201-Selenium\\\\Drivers\\\\chromedriver_win32 (1)\\\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.google.com");
			driver.findElement(By.id("lst-ib")).sendKeys("Selenium");
			driver.findElement(By.name("btnK")).submit();
			driver.findElement(By.linkText("Images")).click();
			driver.findElement(By.id("qbi")).click();
			driver.findElement(By.linkText("Upload an image")).click();
			driver.findElement(By.id("qbfile")).click();
			Runtime.getRuntime().exec("D:\\MediaFiles\\Training\\201-Selenium\\AutoIt3\\Executables\\FileUpload.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

	public static void main(String[] args) {
		FileUploadUsingAutoIT obj = new FileUploadUsingAutoIT();
		obj.googleSearch();

	}

}
