package com.cactus.crm.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.crm.pages.EnquiryAndJobViewPage;
import com.cactus.executor.Executioner;
import com.cactus.utils.DataMapUtil;
import com.cactus.utils.ExcelUtil;
import com.cactus.utils.Util;
import com.cactus.whiteboard.pages.AllocateJobPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AllocateJobActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private Executioner executor;
	private Util util;

	public AllocateJobActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		util = Util.getInstance();
		this.executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void allocateJobFromPM(Map<String, String> testData) {
		EnquiryActions enquiryAction = new EnquiryActions(driver, test, wait);
		enquiryAction.loginAndNavigateToDashboard(testData.get("PMId"), testData.get("PMPassword"));
		testData.put("status", "");
		String status = testData.get("status");
		int i = 0;
		while ((status.equalsIgnoreCase("Job Unallocated") || status.equalsIgnoreCase("")) && i < 2) {
			executor.navigateToURL(testData.get("testURL") + testData.get("JobCode"));
			executor.refresh();
			EnquiryAndJobViewPage jobViewPage = new EnquiryAndJobViewPage(driver, wait, test, testData.get("PMId"));
			AllocateJobPage allocateJobPage = jobViewPage.clickOnMoreAndNavigateToAllocateJobPage();
			allocateJobPage.assignResource(testData.get("Resource"));

			jobViewPage = allocateJobPage.submitAllocateJob();

			status = allocateJobPage.getStatus().getText();
			testData.put("status", status);
			i++;
		}
		Map<String, String> flMap = new DataMapUtil().getFLMap(testData);
		executor.addStatus(LogStatus.INFO,
				"Job Code:" + testData.get("JobCode") + ",Job status:" + testData.get("status"));
		new ExcelUtil().writeExcelFile(util.getFilePath("testData_FL.xlsx"), "FLData", flMap);
		new ExcelUtil().writeExcelFile(util.getFilePath("testRunData.xlsx"), "Job", flMap);
	}

}
