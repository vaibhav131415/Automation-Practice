package Tests;


import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Basepackage.Baseclass;
import Basepackage.VerifyBrokenLinkUtil;

public class Login extends Baseclass{

	@Test(priority = 1 , description = "To Verify the Title of the Page")
	public void TitleCheck() {

		String actual = driver.getTitle();
		String Expected = "Automation Practice Site";
		if(actual.equals(Expected)) {
			System.out.println("Title Verified");
		}else {
			System.out.println("Title not verified");
		}


	}


	@Test(priority = 2, description = "To verify the broken links")
	public void verifyBrokenLinks() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> element = driver.findElements(By.tagName("a"));
		System.out.println(element.size());	
		for (int i = 0; i <element.size(); i++) {
			
		WebElement ele = element.get(i);
		String url = ele.getAttribute("href");
		VerifyBrokenLinkUtil.Verifylink(url);
		
			
		}
		


	}

	@Test(priority = 3, description = "To verify the Invalid login scenario")
	public void InvalidLogin() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String ele = 	driver.findElement(By.name("EMAIL")).getAttribute("placeholder");

		System.out.println(ele);
		Thread.sleep(2000);
		driver.findElement(By.id("username")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("username")).sendKeys("testest");

		driver.findElement(By.id("password")).sendKeys("Test");
		driver.findElement(By.name("login")).click();

		WebElement ActualError = 	driver.findElement(By.xpath("//body/div[@id='pagewrap']/div[@id='body']/div[@id='layout']/div[@id='content']/div[@id='page-36']/div[1]/div[1]/ul[1]/li[1]"));

		String ExpectedError = "ERROR: The password you entered for the username testtest is incorrect. Lost your password?";

		try {

			SoftAssert soft = new SoftAssert();
			soft.assertEquals(ActualError, ExpectedError);
		}catch(AssertionError e) {
			System.out.println("Login Assert failed");
			throw e;
		}
		System.out.println("Login Assert passed");


	}

	@Test(priority = 4, description = "To verify valid login scenario")
	public void ValidLogin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("username")).sendKeys("vprabhugaonkar13@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Restinpeace@13");
		driver.findElement(By.name("login")).click();



	}


}
