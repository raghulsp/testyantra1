package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Slider {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	public void slideSlider() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://jqueryui.com/slider/");
        WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']")));
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		
		Actions action = new Actions(driver);
		for(int i=100; i<=400; i+=100) {
		action.dragAndDropBy(slider, i, 0).perform();
		}
		Thread.sleep(2000);
		
//		for(int i=-100; i<=-400; i-=100) {
			action.dragAndDropBy(slider, -100, 0).perform();
			action.dragAndDropBy(slider, -100, 0).perform();
			action.dragAndDropBy(slider, -100, 0).perform();
			action.dragAndDropBy(slider, -100, 0).perform();
			
			driver.close();
//		}
}
}
