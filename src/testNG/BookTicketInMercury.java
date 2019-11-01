package testNG;

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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class BookTicketInMercury {

	WebDriver driver;
	String Title1;
	Select dropdown;
	File srcFile, destinationFile;
	TakesScreenshot screenShot;
	
	//WebElement element1 = driver.findElement(By.name("login"));
	


	@Test
	public void aloginPage() {
		driver.get("http://newtours.demoaut.com");
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.name("userName")).sendKeys("raghavdce1");
		driver.findElement(By.name("password")).sendKeys("Rumble@12");

	}

	@Test
	public void bflightFinder() {
		driver.findElement(By.name("login")).click();
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

	}

	@Test
	public void cselectFlight() {
		driver.findElement(By.name("findFlights")).click();
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.xpath("//input[@value='Unified Airlines$363$281$11:24']")).click();
		driver.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();

	}

	@Test
	public void dbookAFlight() {
		driver.findElement(By.name("reserveFlights")).click();
		Title1 = driver.getTitle();
		System.out.println(Title1);
		driver.findElement(By.name("passFirst0")).sendKeys("Ragavendran");
		driver.findElement(By.name("passLast0")).sendKeys("Venkatesan");
		WebElement element8 = driver.findElement(By.name("pass.0.meal"));
		dropdown = new Select(element8);
		dropdown.selectByVisibleText("Vegetarian");
		driver.findElement(By.name("creditnumber")).sendKeys("1234");
		driver.findElement(By.name("billAddress1")).clear();
		driver.findElement(By.name("billAddress1")).sendKeys("9226 golf road");
		takeScreenShot();

	}

	@Test
	public void eflightConfirmation() {
		driver.findElement(By.name("buyFlights")).click();
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

	}

	@AfterMethod
	public void takeScreenShot() {
		Date d = new Date();
		destinationFile = new File(
				"C:\\MediaFiles\\201-Selenium\\Assignment\\Mercury_" + d.getTime() + ".jpg");
		screenShot = (TakesScreenshot) driver;
		srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Raghav\\201-training\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
