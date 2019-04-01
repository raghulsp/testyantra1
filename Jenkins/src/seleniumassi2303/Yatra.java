package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Yatra {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	public void bookYatra() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.yatra.com");
		
		
		driver.findElement(By.xpath("//a[@title='Round Trip']")).click();
		WebElement origin = driver.findElement(By.id("BE_flight_origin_city"));
		origin.click();
		Thread.sleep(1000);
		origin.sendKeys("Bang");
//		origin.sendKeys(Keys.ENTER);
	}

}
