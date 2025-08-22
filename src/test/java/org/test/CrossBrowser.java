package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CrossBrowser {
	
	WebDriver driver;
	
	
	@Parameters({"browsername","url"})
	@BeforeMethod
	public void browsersetup(String browsername , String url) {
		
		
		switch(browsername) {
		
			case  "chrome":
			driver = new ChromeDriver();
			driver.get(url);
			break;
			
			case  "edge":
				driver = new EdgeDriver();
				driver.get(url);
				break;
				
			case  "forefox":
				driver = new FirefoxDriver();
				driver.get(url);
				break;
				
			default :
				System.out.println("Invalid browser name");
				
		}
		
	}
	
	
	@Test
	public void fbtitle() {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}
	
	@AfterMethod
	public void tear() {
		driver.quit();
	}

}
