package Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class fileuploadscript {
	
	
		public WebDriver driver;

		@BeforeSuite (alwaysRun=true)
		public void Configuration() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AVV4MD744\\git\\repository2\\Sampleproject\\Chromdriver\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://the-internet.herokuapp.com/upload");
			
			

		}
		@Test
		public void upload() throws InterruptedException {
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			WebElement ele = driver.findElement(By.id("file-upload"));
			Thread.sleep(2000);
			String Str = "C:\\Users\\AVV4MD744\\Downloads\\MicrosoftTeams-image.png";
			ele.sendKeys(Str);
			Thread.sleep(2000);
			driver.findElement(By.id("file-submit")).click();
			Thread.sleep(3000);
			
		
		}
		
	
	
	
	
	
	
		
		@AfterSuite(alwaysRun=true)
		public void afterconfig() {

			driver.quit();
		}


}
