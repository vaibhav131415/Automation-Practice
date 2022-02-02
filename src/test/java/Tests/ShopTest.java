package Tests;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ShopTest extends Login {
	@Test(priority = 5, description = "Perform Slider Operation")
	public void slidertest() throws InterruptedException {
	driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
	Thread.sleep(6000);
	WebElement Ele = 	driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/aside[1]/div[2]/form[1]/div[1]/div[1]/div[1]"));
	Actions action= new Actions(driver);
	action.dragAndDropBy(Ele, 50, 0).build().perform();
	Thread.sleep(3000);
	
 
	
	
	}
	
	
	

}
