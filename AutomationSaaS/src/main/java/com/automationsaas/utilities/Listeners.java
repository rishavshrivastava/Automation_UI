package com.automationsaas.utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends Base implements ITestListener {

	ExtentReports extent = ExtentReporterNG.extentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Testcase executed successfully..");
	}

	public void onTestFailure(ITestResult result) {
		Generics.takeScreenShots(driver, execution_report_path + "/" + result.getTestClass().getName() + ".jpg");
		test.log(Status.FAIL, "Testcase Failed to execute and screenshot link is placed below...");
		try {
			test.addScreenCaptureFromPath(execution_report_path + "/" + result.getTestClass().getName() + ".jpg");
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentTest.get().fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "Testcase Skiped to execute..");
		extentTest.get().skip(result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
