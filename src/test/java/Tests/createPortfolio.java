package Tests;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class createPortfolio extends Login {
	@Test(priority = 4, description = "Perform Slider Operation")
	
	public void portfolio() throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/ul/li[2]/a"))));
//		driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/ul/li[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		WebElement portfolio = driver.findElement(By.id("portfolioid"));
		Select sec = new Select(portfolio);
		sec.selectByVisibleText("Test portfolio");
		
//		driver.findElement(By.id("createPortfolio")).click();
//	WebElement click = 	driver.findElement(By.id("create"));
//	click.clear();
//	click.sendKeys("Test portfolio");
//		driver.findElement(By.id("createPortfolioButton")).click();
		Thread.sleep(4000);
		WebElement portfolioid = driver.findElement(By.id("portfolioid"));
		Select select = new Select(portfolioid);
		String str = select.getFirstSelectedOption().getText();
		System.out.println(str);
		String str1 = "Test portfolio";
		if(str.equals(str1)) {
			
			System.out.println("Portfolio id verified");
		}else {
			System.out.println("Portfolio id is not verified");
		}
		
		
		
	}
 
	@Test(priority = 6 , description = "Delete portfolio" , enabled = false )
	public void deleteportfolio() throws InterruptedException {
		Thread.sleep(6000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("deletePortfolio"))));
		driver.findElement(By.id("deletePortfolio")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		
	}
	}
	

	



