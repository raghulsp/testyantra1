package seleniumassi2303;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class BlueStonePayment {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	
	@Test
	
	public void checkAllErrMsg() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");

//		Click on Goldmine 10+1 scheme
		driver.findElement(By.xpath("//span[text()='Subscribe Now']")).click();
		
//		Enter amount
		driver.findElement(By.id("amount")).sendKeys("2000");
		
//		Enter Email
		driver.findElement(By.id("Email")).sendKeys("raghu.kulgeri@gmail.com");
		
//		Click on "Start Now"
		driver.findElement(By.id("tahLpSubmit")).click();
		
		Thread.sleep(2000);
		
//		Enter necessary details
		driver.findElement(By.id("contactNumber")).sendKeys("9742540758");
		driver.findElement(By.id("fullname")).sendKeys("Raghu K");
		driver.findElement(By.id("address")).sendKeys("Bommanahalli, Bangalore");
		driver.findElement(By.id("postcode_delivery")).sendKeys("560068");
		
//		Click on "Next"
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		
//		Enter necessary details
		driver.findElement(By.id("nomineeName")).sendKeys("Lalitha");
		
		Select select = new Select(driver.findElement(By.id("nomineeRelationship")));
		select.selectByVisibleText("Mother");
		
		select=new Select(driver.findElement(By.id("nomineeNationality")));
		select.selectByVisibleText("Indian");
		
//		Click Next
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		
//		verify if payment page is displayed
		boolean payment = driver.findElement(By.xpath("//span[text()='Payment Details']")).isDisplayed();
		
		if(payment==true) {
			Reporter.log("Successfully navigated to payments page", true);
		}
		else {
			Assert.fail();
		}
		

//		driver.close();

}
}
