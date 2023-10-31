package genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ListenersImplementation implements ITestListener{

	
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		
	String testScriptName = result.getMethod().getMethodName();
	System.out.println(testScriptName+"======== test script execution started =============");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"==== Passed =============");
	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		//Screenshot
		//Exception for failure
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"======== Failed =============");
		
		//Exception for Failure
		System.out.println(result.getThrowable());
	String screenShotName = testScriptName + new JavaUtility().getSystemDate();	
	
	WebDriverUtility w = new WebDriverUtility();
	try {
		w.captureScreenShot(BaseClass.sdriver, screenShotName);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testScriptName = result.getMethod().getMethodName();
		System.out.println(testScriptName+"======== Skipped =============");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("========Suite execution started =============");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("========Suite execution finished =============");
		
		
	}

}
