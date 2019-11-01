import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PoepleHub {
	
	WebDriver driver;
	PoepleHub peoplehubobj;
	WebDriverWait expWait;
	
	public void selectCalendar() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\MediaFiles\\Training\\201-Selenium\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.get("https://webapps.mindtree.com/MAS/forms/AttendanceReport.aspx");
		driver.findElement(By.id("input_1")).sendKeys("M1030042");
		driver.findElement(By.id("input_2")).sendKeys("Rumble@37");
		driver.findElement(By.className("credentials_input_submit")).submit();
		/*driver.findElement(By.linkText("WORK")).click();
		driver.findElement(By.xpath("//span[@class='menu-btn']")).click();
		expWait = new WebDriverWait(driver, 45);
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sub-list-title']")));
		driver.findElement(By.xpath("//div[@class='sub-list-title']")).click();
		driver.findElement(By.linkText("Attendance")).click();
		driver.findElement(By.linkText("Reports")).click();*/
		WebElement date = driver.findElement(By.className("cal_img"));
		date.sendKeys("25902017");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}

	public static void main(String[] args) {
		PoepleHub obj = new PoepleHub();
		obj.selectCalendar();

	}

}
