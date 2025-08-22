package org.test;

import org.testng.annotations.Test;

public class Class1 {
	
	@Test(groups = {"sanity"})
	public void class1Method1() {
		System.out.println("class1Method1");
		System.out.println(System.currentTimeMillis());
	}

}
