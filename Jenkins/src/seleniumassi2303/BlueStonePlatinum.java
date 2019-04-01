package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BlueStonePlatinum {
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
		
//		Move the cursor to "Metal"
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Metal']"))).perform();
		
//		Get count of Platinum
		Thread.sleep(2000);
		String count=driver.findElement(By.xpath("//span[text()=' Platinum ']/span/../span[2]")).getText();
		
//		Reporter.log("Next Day Delivery Count is: "+count, true);
		Reporter.log("The count of Platinum is: "+count, true);
		
		driver.close();

}

}
