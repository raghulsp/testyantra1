package seleniumassi2303;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BlueStoneL5gm {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;
	
	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
	
public static String captureScreen(WebDriver driver, String screenName) throws IOException{
		
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		
		String dest = "./screenshots/"+"5gmLcoin.png";
		
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		
		return dest;
	}

//public static String generateFileName(ITestResult result){
//	Date date = new Date();
//	String fileName = result.getName()+ "_" + dateFormat.format(date);
//	return fileName;
//	
//}

@BeforeTest
public void startTest() {
	reports = new ExtentReports();

	htmlReporter = new ExtentHtmlReporter("C:\\Users\\vkulageri\\git\\testyantra\\TestYantra\\Reports\\L5gm.html");
	reports.attachReporter(htmlReporter);
}

	@Test
	
	public void validate() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Gold Coins ']"))).perform();
		driver.findElement(By.xpath("//span[@data-p='l-gold-coins-weight-5gms,m']")).click();
		

		boolean imagepresent = driver.findElement(By.id("9165")).isDisplayed();
				Assert.assertEquals(imagepresent, true);
//				Assert.fail();
		
				
}
	
	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {
 
		String screenShot = BlueStoneL5gm.captureScreen(driver, result.getName());
 
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
 
		reports.flush();
		driver.close();
	}


}
