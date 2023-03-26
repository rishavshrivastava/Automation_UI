package com.automationsaas.utilities;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class RetryTestListener extends TestListenerAdapter {

	@SuppressWarnings("deprecation")
	@Override
	public void onTestFailure(ITestResult result) {

	     Reporter.setCurrentTestResult(result);
	     if(result.getMethod().getRetryAnalyzer().retry(result))
	    	 result.setStatus(ITestResult.SKIP);
	     Reporter.setCurrentTestResult(null);
	  }
}
