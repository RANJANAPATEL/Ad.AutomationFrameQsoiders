package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertPractice {
	@Test
	public void practice() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		sa.assertEquals(false, true);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
		
		Assert.assertEquals(1, 0);
		
		sa.assertEquals("A", "A");
		sa.assertAll();
		
		
		
	}

}
