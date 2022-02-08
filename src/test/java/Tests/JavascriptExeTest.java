package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class JavascriptExeTest {
	public WebDriver driver;
	@BeforeSuite (alwaysRun=true)
	public void Configuration() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AVV4MD744\\git\\repository2\\Sampleproject\\Chromdriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.rediff.com/");
		
		

	}
	
	
	@Test
	public void executetest() throws InterruptedException {
	
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://techterms.com/definition/staticwebsite'" );
		Thread.sleep(4000);
		
		String Actual = (String) js.executeScript("return document.title");
		try {
		Assert.assertEquals(Actual, "Static Website Definition");
		System.out.println("Assertion passed");
		}catch(AssertionError e){
			System.out.println("Assertion failed");
			throw e;
			
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement ele = driver.findElement(By.linkText("Terms"));
		js.executeScript("arguments[0].click();", ele);
		Thread.sleep(3000);
		
		
		WebElement ele1 = driver.findElement(By.id("search"));
		js.executeScript("arguments[0].value='Test'", ele1);
		Thread.sleep(3000);
		
	}
	
	


@AfterSuite(alwaysRun=true)
public void afterconfig() {

	driver.quit();
}

}
