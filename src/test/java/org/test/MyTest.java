package org.test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.listeners.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
	
	@Test
	public void login() {
		Assert.assertEquals(false, false);
	}
	
	
	@Test
	public void fbtitle() {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		Assert.assertEquals(driver.getTitle(), "facebook");
		
		driver.quit();
		
	}
	
	
	@Test
	public void  logout() {
		
		System.out.println("logout");
	}
	
	
	
public static void captureScreenShot() throws AWTException, IOException {
		
		Robot r = new Robot();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rec = new Rectangle(d);
		
		BufferedImage image = r.createScreenCapture(rec);
		
		File  dest = new File("./ScreenShots/facebook"+System.currentTimeMillis()+".png");
				
		ImageIO.write(image, "png", dest);
		
	}
	

}
