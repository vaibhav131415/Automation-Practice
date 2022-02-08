package Basepackage;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Baseclass {
	public WebDriver driver;

	@BeforeSuite (alwaysRun=true)
	public void Configuration() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AVV4MD744\\git\\repository2\\Sampleproject\\Chromdriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rediff.com/");
		
		

	}
	@AfterSuite(alwaysRun=true)
	public void afterconfig() {

		driver.quit();
	}


}
