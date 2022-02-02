package Tests;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Webtable {
	
	public WebDriver driver;

	@BeforeSuite (alwaysRun=true)
	public void Configuration() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AVV4MD744\\git\\repository2\\Sampleproject\\Chromdriver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get("https://www.rediff.com/");
		driver.get("https://www.google.com/");
		

	}
	
	
	@Test
//	public void Getrowcount() {
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.linkText("Money")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.linkText("Indices")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		driver.findElement(By.linkText("Show More >>")).click();
//		//Total Rows
//		List<WebElement> totalrows = driver.findElements(By.xpath("//*[@class = 'dataTable']/tbody/tr"));
//		System.out.println("Total rows = " + totalrows.size());
//		
//		//Total Column
//		List<WebElement> totalcol = driver.findElements(By.xpath("//*[@class = 'dataTable']/tbody/tr[1]/td"));
//		System.out.println("Total cols = " + totalcol.size());
//		
//		//get data of the specific row
//		List<WebElement> rowdata = driver.findElements(By.xpath("//*[@class = 'dataTable']/tbody/tr[2]/td"));
//		for (WebElement rowstring : rowdata) {
//			System.out.print(rowstring.getText());
//			
//		}
//		
//		//get data of a column
//		List<WebElement> coldata = driver.findElements(By.xpath("//*[@class = 'dataTable']/tbody/tr/td[1]"));
//		for (WebElement colstring : coldata) {
//			System.out.println(" " +colstring.getText());
//			
//		}
//		
//		
//		
//		
//	}
	
	public void Ajaxcall() throws InterruptedException {
		
		driver.findElement(By.name("q")).sendKeys("vaibhav");
		Thread.sleep(4000);
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
		for (WebElement element : list) {
			
			if (element.getText().equalsIgnoreCase("Vaibhav Global")) {
				element.click();
				break;
				
			}
			Thread.sleep(3000);
			
		}
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//ul[@class='G43f7e']/li"))));
//		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='G43f7e']/li"));
//		for (WebElement Element : list) {
//			if(Element.getText().equalsIgnoreCase("Vaibhav Global")) {
//				Element.click();
//				break;
				
				
				
			
			
		
		
		
	}
	
	
	
	@AfterSuite(alwaysRun=true)
	public void afterconfig() {

		driver.quit();
	}


}
