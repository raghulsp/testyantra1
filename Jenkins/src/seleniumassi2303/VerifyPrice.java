package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyPrice {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	
	public void checkPlatinum() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		
//		search for rings
		WebElement search = driver.findElement(By.id("search_query_top_elastic_search"));
		search.sendKeys("rings");
		search.sendKeys(Keys.ENTER);
		
		driver.findElement(By.id("pid_26409")).click();

}
}
