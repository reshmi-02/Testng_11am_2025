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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportDemo {
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		// directory where output is to be printed
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Admin\\eclipse-workspace\\Tesstng_11am_july29_2025\\Reports\\report.html");
		 extent = new ExtentReports();
		extent.attachReporter(spark);
		
		
		
		

	}
	@BeforeMethod
	public void brpwsersetup() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
	}
	
	@Test
	public void checkTitle() {
		
		ExtentTest test = extent.createTest("verfication of google page title");
		
		if(driver.getTitle().equals("Goolge")) {
			test.pass("title matched successfully");
		}
		else {
			test.fail("title didn't get match");
		}
		
	}
	
	@Test
	public void verifyGmailLink() throws AWTException, IOException {
		
		ExtentTest test = extent.createTest("gmail link variafication");
		
		try {
			driver.findElement(By.linkText("Gmil")).click();
			
		}
		catch(Exception e) {
			test.fail("exception handled  : " +( e.getMessage()));
			test.addScreenCaptureFromPath(ExtendReportDemo.captureScreenShot());
		}
		
	}
	
public static String captureScreenShot() throws AWTException, IOException {
		
		Robot r = new Robot();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle rec = new Rectangle(d);
		
		BufferedImage image = r.createScreenCapture(rec);
		
		File  dest = new File("./ScreenShots/google"+System.currentTimeMillis()+".png");
				
		ImageIO.write(image, "png", dest);
		
		String absolutePath = dest.getAbsolutePath();
		
		
		return absolutePath;
	}

	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	
//	@Test
//	public void signup() {
//		
//		ExtentTest test = extent.createTest("signup test");
//		test.log(Status.PASS, "sign up page test got passed");
//		
//	}
//	
//	@Test
//	public void homepage() {
//		
//		ExtentTest test = extent.createTest("Homepage test").assignAuthor("oranium").assignCategory("smoke").assignDevice("chrome");
//		test.fail("homepage test got failed");
//	}
//	
//	
//	@Test
//	public void productpage() {
//		
//		ExtentTest test = extent.createTest("productpage test").assignAuthor("priya").assignCategory("sanity").assignDevice("edge");
//		test.pass("productpage test got passed");
//	}
//	
//	
	@AfterTest
	public void tear() {		
		extent.flush();
	}
	

}
