package Basepackage;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeSuite
	public void Configuration() {
		
		//extent report configuration
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//Automation Report//ExtentReport.html");
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);
                
		//extent report Document configuration
		htmlReporter.config().setDocumentTitle("Rediif Test Report"); // Tittle of Report
		htmlReporter.config().setReportName("Rediif Test Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

		// General information releated to application
		extent.setSystemInfo("Application Name", "Rediff Test");
		extent.setSystemInfo("User Name", "Vaibhav Prabhu Gaonkar");
		extent.setSystemInfo("Envirnoment", "Satging");
		
		//driver setup
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.setBinary("C:\\Users\\vaibhav_p\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		System.setProperty("webdriver.chrome.driver", ".//Chromdriver//chromedriver.exe");
                driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.get("http://rediff.com/");
		
		

	}
	@AfterSuite
	public void afterconfig() {
		
		//clearing the content of the extent report after a test cycle
		extent.flush();
		driver.quit();
		
	}
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
	if(result.getStatus() == ITestResult.FAILURE){
	//MarkupHelper is used to display the output in different colors
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
	test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
	//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
	//We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
	//String Screenshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
	String screenshotPath = getScreenShot(driver, result.getName());
	//To add it in the extent report
	test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
	}
	else if(result.getStatus() == ITestResult.SKIP){
	test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
	}
	else if(result.getStatus() == ITestResult.SUCCESS)
	{
	test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
	}
	
	}
	
	//Get Screenshot method
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName +" "+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	
	


}
