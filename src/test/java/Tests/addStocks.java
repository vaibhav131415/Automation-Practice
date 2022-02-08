package Tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class addStocks extends createPortfolio {
	
	@Test(priority = 5 , description = "Adding stocks")
	public void addingstocks() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.findElement(By.id("addStock")).click();
	    driver.findElement(By.id("addstockname")).sendKeys("Nestle");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"11120007\"]")).click();
	    Thread.sleep(3000);
	
		
		driver.findElement(By.id("stockAddDate")).sendKeys("13-09-2020"); 
		
		 
		 driver.findElement(By.id("addstockqty")).sendKeys("5");
		 driver.findElement(By.id("addstockprice")).sendKeys("100");
		 driver.findElement(By.xpath("//label[@class = 'selectTab']")).click();
		 driver.findElement(By.id("addStockButton")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 List<WebElement> List1 = driver.findElements(By.xpath("//*[@class= 'dataTable sortable']/tbody/tr/td[2]"));
		 for (WebElement webElement3 : List1) {
			 if(webElement3.getText().contains("Nestle India")) {
				 System.out.println(webElement3);
				 System.out.println("Company validation successful");
				 Thread.sleep(3000);
				
				 
			 }else {
				 System.out.println("Company validation not successful");
			 }
			 webElement3.findElement(By.id("radio")).click();
			 Thread.sleep(3000);
			 webElement3.findElement(By.name("Delete")).click();
			 driver.switchTo().alert().accept();
			 Thread.sleep(4000);
			 
			 
			
		}
	}

}
