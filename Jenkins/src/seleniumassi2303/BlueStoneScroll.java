package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BlueStoneScroll {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	
	public void checkScroll() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		
//		Scroll
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)");
		
//		Check if top logo is displayed or not
		WebElement logo = driver.findElement(By.xpath("//span[@class='logo-icon']"));
		boolean logo_present = logo.isDisplayed();
		if(logo_present==true) {
			Reporter.log("Logo is present", true);
			logo.click();			
		}
		else {
			Assert.fail();
		}

}
}
