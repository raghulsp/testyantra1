package seleniumassi2303;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BlueStone22K {
	
	public WebDriver driver;
	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest test;

	 @BeforeTest
	 public void setExtent() {
	  // specify location of the report
	  htmlReporter = new ExtentHtmlReporter("C:\\Users\\vkulageri\\git\\testyantra\\TestYantra\\Reports\\22K.html");

	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	  htmlReporter.config().setReportName("Functional Testing"); // Name of the report
	  htmlReporter.config().setTheme(Theme.DARK);
	  
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  // Passing General information
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environemnt", "QA");
	  extent.setSystemInfo("user", "raghu");
	 }

	 @AfterTest
	 public void endReport() {
	  extent.flush();
	 }

	 @BeforeMethod
	 public void setup() {
	  System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.bluestone.com");
	 }

	 //Test1
	 

	 
	  
	 @AfterMethod
	 public void tearDown(ITestResult result) throws IOException {
	  if (result.getStatus() == ITestResult.FAILURE) 
	  {
		  test.log(Status.FAIL , "Test Case FAILED IS " + result.getName());
	  } 
	  else if (result.getStatus() == ITestResult.SKIP) 
	  {
	   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
	  }
	  else if (result.getStatus() == ITestResult.SUCCESS) {
		  test.log(Status.PASS, "TEST CASE PASSED IS " + result.getName()); // to add name in extent report
		   
		   String screenshotPath = BlueStone22K.getScreenshot(driver, result.getName());
		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		  
	   
	  }
	  driver.quit();
	 }
	 
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  
	  String destination = System.getProperty("user.dir") + "/screenshots/" + screenshotName + dateName + ".png";
	  File finalDestination = new File(destination);
	  FileUtils.copyFile(source, finalDestination);
	  return destination;
	 }
	
	@Test
	
	public void check22K() throws InterruptedException {
		test=extent.createTest("check22K");
		
//		search for rings
		WebElement search = driver.findElement(By.id("search_query_top_elastic_search"));
		search.sendKeys("rings");
		search.sendKeys(Keys.ENTER);

//		Go to "Gold Purity"
		driver.findElement(By.xpath("//span[text()='More Filters']")).click();
		
//		Get count of 22K
		String count = driver.findElement(By.xpath("//span[text()=' 22k ']/span/../span[2]")).getText();
		
		Reporter.log("The count of 22K is: "+count, true);
		
}
}
