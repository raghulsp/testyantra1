package seleniumassi2303;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BlueStoneStores {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	
	public void checkStores() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		
//		Click on "Visit our stores"
		driver.findElement(By.xpath("//a[text()='Visit Our Stores']")).click();
		
//		get count of stores
		List<WebElement> locations = driver.findElements(By.xpath("//div[@class='store-location']"));
		for(WebElement location:locations) {
			String text=location.getText();
			Reporter.log(text, true);
			
			}
		
		Reporter.log("The count of locations is: "+locations.size(), true);
		driver.close();
}
}
