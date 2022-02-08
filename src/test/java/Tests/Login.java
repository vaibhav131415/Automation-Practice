package Tests;




import java.time.Duration;


import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Basepackage.Baseclass;


public class Login extends Baseclass{
	public SoftAssert assertion = new SoftAssert();

	@Test(priority = 1 , description = "To Verify the Title of the Page")
	public void TitleCheck() {

		String actual = driver.getTitle();
		String Expected = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		if(actual.equals(Expected)) {
			System.out.println("Title Verified");
		}else {
			System.out.println("Title not verified");
		}


	}


	@Test(priority = 2, description = "Click on money link and assert")
	public void moneylink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//WebElement actual1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/a/span"));
		
		
       
		
			
		
		


	}



	@Test(priority = 3, description = "To verify valid login scenario")
	public void ValidLogin() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("vprabhugaonkar13@gmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@123");
		driver.findElement(By.id("rememberflag")).click();
		driver.findElement(By.id("loginsubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	WebElement ele1 = 	driver.findElement(By.xpath("//*[@id=\"username\"]/a"));
		try{
			assertion.assertEquals(ele1, "Vaibhav");
		
	    System.out.println("Assert passed for after sign in check");
		}catch(AssertionError e1) {
			System.out.println("Assert passed for after sign in check");
			throw e1;
			
			
		}
		
		


	}


}
