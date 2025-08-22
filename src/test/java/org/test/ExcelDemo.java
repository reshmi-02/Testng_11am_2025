package org.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExcelDemo extends BaseClass{

	@Test(dataProvider = "excelReader" )  //{   {user,pass}   ,{user,pass}  ,{user,pass}   }
	
	private void loginverification(String username , String password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
	
		String currentUrl = driver.getCurrentUrl();
		
		Assert.assertTrue(currentUrl.contains("dashboard"));
	}
	
	
	
	
}
