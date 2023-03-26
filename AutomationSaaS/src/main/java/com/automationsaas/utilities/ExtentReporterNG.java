package com.automationsaas.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG implements Interface {

	static ExtentReports extent;
	public static ExtentReports extentReportGenerator() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(execution_report_path);
		reporter.config().setReportName("Automation Saas Report");
		reporter.config().setDocumentTitle("Test Results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("SDET", "Rishav Shrivastava");
		return extent;
	}
}
