package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@BeforeSuite
	private void beforeSuite() {
		// TODO Auto-generated method stub
		System.out.println("beforeSuite");
	}
	
	@BeforeMethod
	private void beforeMethod() {
		// TODO Auto-generated method stub
		System.out.println("beforeMethod");
	}
	
	@BeforeTest
	private void beforeTest() {
		// TODO Auto-generated method stub
		System.out.println("beforeTest");
	}
	
	@BeforeClass
	private void beforeClass() {
		// TODO Auto-generated method stub
		System.out.println("beforeClass");
	}
	
	@AfterSuite
	private void afterSuite() {
		// TODO Auto-generated method stub
		System.out.println("afterSuite");
	}
	
	@AfterMethod
	private void afterMethod() {
		// TODO Auto-generated method stub
		System.out.println("afterMethod");
	}
	
	@AfterTest
	private void afterTest() {
		// TODO Auto-generated method stub
		System.out.println("afterTest");
	}
	
	@AfterClass
	private void afterClass() {
		// TODO Auto-generated method stub
		System.out.println("afterClass");
	}
	
	@Test
	private void test02() {
		// TODO Auto-generated method stub
		System.out.println("test02");
	}
	
	@Test
	private void test01() {
		// TODO Auto-generated method stub
		System.out.println("test01");
	}

}
