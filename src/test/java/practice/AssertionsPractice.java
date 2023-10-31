package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsPractice {

	@Test
	public void practice() {
		System.out.println("Step 1");
		System.out.println("step 2");
		
		Assert.assertEquals(false, true);
		
		System.out.println("Step 3");
		System.out.println("Step 4");
	}
}
