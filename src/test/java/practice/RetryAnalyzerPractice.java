package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer =genericUtility.RetryAnalyserImplementation.class)
	public void analyserPractice() {
		Assert.fail();
		System.out.println("Hi");
	}
}
