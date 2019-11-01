package com.mindtree.wait.advance;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MercuryTours {

	WebDriver driver;
	String Title1;
	Select dropdown;
	File srcFile, destinationFile;
	TakesScreenshot screenShot;

	public void loginPage() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com");
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.name("userName")).sendKeys("raghavdce1");
		driver.findElement(By.name("password")).sendKeys("Rumble@12");
		driver.findElement(By.name("login")).click();

	}

	public void flightFinder() {
		Title1 = driver.getTitle();
		System.out.println(Title1);

		driver.findElement(By.xpath("//input[@value='roundtrip']")).click();
		WebElement element = driver.findElement(By.name("passCount"));
		dropdown = new Select(element);
		driver.findElement(By.name("passCount")).click();
		dropdown.selectByVisibleText("1");
		WebElement element1 = driver.findElement(By.name("fromPort"));
		dropdown = new Select(element1);
		dropdown.selectByVisibleText("London");
		WebElement element2 = driver.findElement(By.name("fromMonth"));
		dropdown = new Select(element2);
		dropdown.selectByVisibleText("February");
		WebElement element3 = driver.findElement(By.name("fromDay"));
		dropdown = new Select(element3);
		dropdown.selectByVisibleText("3");
		WebElement element4 = driver.findElement(By.name("toPort"));
		dropdown = new Select(element4);
		dropdown.selectByVisibleText("Paris");
		WebElement element5 = driver.findElement(By.name("toMonth"));
		dropdown = new Select(element5);
		dropdown.selectByVisibleText("January");
		WebElement element6 = driver.findElement(By.name("toDay"));
		dropdown = new Select(element6);
		dropdown.selectByVisibleText("30");
		driver.findElement(By.xpath("//input[@value='Business']")).click();
		WebElement element7 = driver.findElement(By.name("airline"));
		dropdown = new Select(element7);
		dropdown.selectByVisibleText("Unified Airlines");
		driver.findElement(By.name("findFlights")).click();
	}

	public void selectFlight() {
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
		driver.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();
		driver.findElement(By.name("reserveFlights")).click();
	}

	public void bookAFlight() {
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.name("passFirst0")).sendKeys("Ragavendran");
		driver.findElement(By.name("passLast0")).sendKeys("Venkatesan");
		WebElement element8 = driver.findElement(By.name("pass.0.meal"));
		dropdown = new Select(element8);
		dropdown.selectByVisibleText("Vegetarian");
		driver.findElement(By.name("creditnumber")).sendKeys("1234");
		takeScreenShot();
		driver.findElement(By.name("buyFlights")).click();
	}

	public void flightConfirmation() {
		Title1 = driver.getTitle();
		System.out.println(Title1);
		takeScreenShot();
		driver.findElement(By.xpath(
				"html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[7]/td/table/tbody/tr/td[3]/a/img"))
				.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

	
	public void takeScreenShot() {
		Date d = new Date();
		destinationFile = new File("D:\\MediaFiles\\Training\\201-Selenium\\Assignment\\Mercury_"+d.getTime()+".jpg");
		screenShot = (TakesScreenshot)driver;
		srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MercuryTours obj = new MercuryTours();
		obj.loginPage();
		obj.flightFinder();
		obj.selectFlight();
		obj.bookAFlight();
		obj.flightConfirmation();

	}

}
