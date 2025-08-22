package org.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHrmTitleTest extends BaseClass{
	
	@Test
	public void titleVerification() {
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}

}
