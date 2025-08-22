package org.test;

import org.testng.annotations.Test;

public class Class2 {
	
	@Test(groups = {"smoke","regression"})
	public void class2Method1() {
		System.out.println("class2Method1");
		System.out.println(System.currentTimeMillis());
	}
	
	
	@Test(groups = {"smoke"})
	public void class2Method2() {
		System.out.println("class2Method2");
		System.out.println(System.currentTimeMillis());
	}

}
