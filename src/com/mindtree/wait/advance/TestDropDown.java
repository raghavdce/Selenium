	package com.mindtree.wait.advance;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDropDown {

	WebDriver driver;
	Select dropDown;

	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.amazon.in");
		dropDownSelect();
	}

	public void dropDownSelect() {
		WebElement element = driver.findElement(By.id("searchDropdownBox"));
		dropDown = new Select(element);
		List<WebElement> dropDownCategories = dropDown.getOptions();
		for (WebElement element1:dropDownCategories) {
			System.out.println(element1.getText());
		}
		driver.findElement(By.id("searchDropdownBox")).click();
		dropDown.selectByVisibleText("Books");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java basic concepts");
		driver.findElement(By.className("nav-input")).submit();

	}

	public static void main(String[] args) {
		TestDropDown obj = new TestDropDown();
		obj.invokeBrowser();

	}

}
