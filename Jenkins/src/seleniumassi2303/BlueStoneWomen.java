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

public class BlueStoneWomen {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	
	public void checkWomen() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		
//		search for rings
		WebElement search = driver.findElement(By.id("search_query_top_elastic_search"));
		search.sendKeys("rings");
		search.sendKeys(Keys.ENTER);

//		Goto "Gender"
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[text()='Gender']"))).perform();
		
//		Get count of Women
		String count = driver.findElement(By.xpath("//span[text()=' Women ']/span/../span[2]")).getText();
		
		Reporter.log("The count of Women is: "+count, true);
		driver.close();
		
}
}