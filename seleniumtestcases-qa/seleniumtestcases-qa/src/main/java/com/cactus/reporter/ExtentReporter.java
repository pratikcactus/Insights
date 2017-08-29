package com.cactus.reporter;

import java.util.Calendar;
import java.util.Locale;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReporter {
	private static ExtentReporter instance;
	private ExtentReports report;
	private ExtentTest test;

	public synchronized static ExtentReporter getInstance() {
		if (instance == null) {
			instance = new ExtentReporter();
		}
		return instance;
	}

	private ExtentReporter() {

		Calendar calendar = Calendar.getInstance();
		
		String folderPath = "/" + calendar.get(Calendar.YEAR) + "/"
				+ (calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())) + "/"
				+ calendar.get(Calendar.DATE) + "/";

		String rootPath = System.getProperty("user.dir");

		long time = System.currentTimeMillis();
		String reportPath = rootPath + "/test-output/custom-reports" + folderPath + "custom-report" + time + ".html";

		report = new ExtentReports(reportPath);
		
		instance = this;
	}

	public ExtentTest startTest(String testName) {
		return report.startTest(testName);
	}

	public void endReporter() {
		report.flush();
		report.close();
	}

	public void endTest(ExtentTest test) {
		report.flush();
		report.endTest(test);
	}

	public ExtentTest getTest() {
		return test;
	}

	public void setTest(ExtentTest test) {
		this.test = test;
	}

	public ExtentReports getReport() {
		return report;
	}
}
