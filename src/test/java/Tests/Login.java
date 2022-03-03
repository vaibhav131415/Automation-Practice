package Tests;






import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import Basepackage.Baseclass;


public class Login extends Baseclass{
	public SoftAssert assertion = new SoftAssert();

	@Test(priority = 1 , description = "To Verify the Title of the Page")
	public void TitleCheck()  {
         test = extent.createTest("Verify the homepage title");
//		String actual = driver.getTitle();
//		String Expected = "Rediff.com: News | Rediffmail | Stock Quotes | Shopping";
		SoftAssert softassert = new SoftAssert();
		softassert.assertEquals(driver.getTitle(), "Rediff.com: News | Rediffmail | Stock Quotes | Shopping");
        softassert.assertAll();
	}


	@Test(priority = 2, description = "Click on money link and assert")
	public void moneylink() {
		test = extent.createTest("Verify if user is able to navigate to moneypage");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		try {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		}catch(Exception e) {
			
			throw e;
		}
		//WebElement actual1 = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/a/span"));
		
		
   }



	@Test(priority = 3, description = "To verify valid login scenario")
	public void ValidLogin() throws InterruptedException, IOException {
		
		 test = extent.createTest("Verify if user is able to login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("useremail")).sendKeys("vprabhugaonkar13@gmail.com");
		driver.findElement(By.id("userpass")).sendKeys("Test@123");
		driver.findElement(By.id("rememberflag")).click();
		driver.findElement(By.id("loginsubmit")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	String ele1 = 	driver.findElement(By.xpath("//*[@id=\"username\"]/a")).getText();
	
//	String ele2 = "Test";
	Assert.assertEquals(ele1, "vaibhav");
		
			
		
		
		


	}


}
