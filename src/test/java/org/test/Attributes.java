package org.test;

import org.testng.annotations.Test;

public class Attributes {

	@Test(priority = -1,description = "verification of login functionality",expectedExceptions = Exception.class)
	private void login() {
		// TODO Auto-generated method stub
		System.out.println("Login functionality");
		System.out.println(10/0);;
	}
	
	@Test(priority = 0,dependsOnMethods = "login",alwaysRun = true)
	private void homepage() {
		// TODO Auto-generated method stub
		System.out.println("Homepage functionality");
	}
	
	@Test(priority = 1,invocationCount = 2,invocationTimeOut =2000)
	private void productpage() {
		// TODO Auto-generated method stub
		System.out.println("productpage functionality");
	}
	
	
	@Test(priority = 2,timeOut = 2000)
	private void logout() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("logout functionality");
		Thread.sleep(3000);
	}
	
}
