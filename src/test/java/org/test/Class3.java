package org.test;

import org.testng.annotations.Test;

public class Class3 {
	
	@Test(groups = {"regression"})
	public void class3Method1() {
		System.out.println("class3Method1");
		System.out.println(System.currentTimeMillis());
	}

}
