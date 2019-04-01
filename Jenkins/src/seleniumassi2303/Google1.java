package seleniumassi2303;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google1 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("ambika");
		List<WebElement> suggestions = driver.findElements(By.xpath("//span[contains(text(),'ambika')]"));
		int count = suggestions.size();
		System.out.println(count);
		
		for(WebElement we:suggestions) {
			String text = we.getText();
			System.out.println(text);
			
		}
		suggestions.get(2).click();
		

	}

}
