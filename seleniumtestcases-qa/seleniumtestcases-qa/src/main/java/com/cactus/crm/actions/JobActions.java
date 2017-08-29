package com.cactus.crm.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.crm.pages.EnquiryAndJobViewPage;
import com.cactus.executor.Executioner;
import com.cactus.utils.ExcelUtil;
import com.cactus.utils.Util;
import com.cactus.whiteboard.pages.Dashboard;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JobActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private Executioner executor;
	private Util util;

	public JobActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		this.executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
		util = Util.getInstance();

	}

	public void acceptJob(Map<String, String> testData) {
		String resource = testData.get("Resource");

		String id = "";
		String[] str = resource.split(";");
		for (int i = 0; i < str.length; i++) {
			executor.navigateToURL(testData.get("testURL"));

			id = util.getResourceId(str[i]);
			EnquiryActions enquiryAction = new EnquiryActions(driver, test, wait);
			Dashboard dashboard = enquiryAction.loginAndNavigateToDashboard(id, testData.get("FLPassword"));
			String currentWindowHandle = driver.getWindowHandle();
			if (testData.get("testJobURL") != null) {
				dashboard.checkCRMJobViewPage(testData.get("testJobURL"), testData.get("crmLogoutURL"),
						currentWindowHandle, testData.get("JobCode"), id);
			}
			String jobId = testData.get("JobCode");
			currentWindowHandle = driver.getWindowHandle();

			dashboard.goToJobSection();
			EnquiryAndJobViewPage jobViewPage = dashboard.findAndClickOnJObId(jobId, id);
			testData.put("testJobURL", driver.getCurrentUrl());

			jobViewPage.uploadFileAndForceSubmit(testData.get("UploadFiles"), testData.get("ForceToSubmitReason"));
			executor.navigateToURL(testData.get("testJobURL"));

			executor.softWaitforVisibilityOfWebElement(jobViewPage.getStatus(), "Wait for visibility of Status");
			executor.pause(1);
			String status = jobViewPage.getStatus().getText();
			testData.put("status", status);

			new ExcelUtil().setCellValue(util.getFilePath("testData_FL.xlsx"), "FLData", "JobCode", "status", jobId,
					testData.get("status"));
			new ExcelUtil().setCellValue(util.getFilePath("testRunData.xlsx"), "Job", "JobCode", "status", jobId,
					testData.get("status"));

			executor.actionClick(jobViewPage.getLogout(), "logout");
			executor.closeBrowser();
			driver.switchTo().window(currentWindowHandle);
			executor.click(dashboard.getLogoutLink(), "Click on Logout Link");
			executor.waitForPageLoadJS();

		}

	}

	public void markJobComplete(Map<String, String> testData) {
		EnquiryAndJobViewPage jobViewPage = loginAndGoToCRMJobView(testData.get("PMId"), testData.get("PMPassword"),
				testData.get("testURLCRMJobView"), testData.get("JobCode"));

		clickOnMoreAndCheckSuccessFlow("PM", jobViewPage);

		executor.pause(1);
		getStatusAndWriteInExcel(testData, jobViewPage);
		executor.actionClick(jobViewPage.getLogout(), "logout");
		if (driver.getWindowHandles().size() > 1) {
			executor.closeBrowser();
			// Set<String> handles=driver.getWindowHandles();
			executor.findAndSwitchToAvailableWindow();
			// driver.switchTo().defaultContent();
		}

	}

	public void sendToClientFromCM(Map<String, String> testData) {
		EnquiryAndJobViewPage jobViewPage = loginAndGoToCRMJobView(testData.get("CMId"), testData.get("CMPassword"),
				testData.get("testURL"), testData.get("JobCode"));

		clickOnMoreAndCheckSuccessFlow("CM", jobViewPage);

		getStatusAndWriteInExcel(testData, jobViewPage);
		executor.actionClick(jobViewPage.getLogout(), "logout");
		if (driver.getWindowHandles().size() > 1) {
			executor.closeBrowser();
			executor.findAndSwitchToAvailableWindow();
		}

	}

	public EnquiryAndJobViewPage loginAndGoToCRMJobView(String id, String pwd, String testURL, String jobCode) {
		EnquiryActions enquiryAction = new EnquiryActions(driver, test, wait);
		enquiryAction.loginAndNavigateToDashboard(id, pwd);

		if (!testURL.contains(jobCode)) {
			testURL = testURL + jobCode;
		}

		executor.navigateToURL(testURL);
		executor.refresh();
		return new EnquiryAndJobViewPage(driver, wait, test, id);
	}

	public void clickOnMoreAndCheckSuccessFlow(String JobToBeDeliveredBy, EnquiryAndJobViewPage jobViewPage) {		
		String currentWindowHandle = driver.getWindowHandle();
		executor.softWaitforElementToBeClickable(jobViewPage.getMoreDropdownButton(), "Wait for More Button");
		executor.click(jobViewPage.getMoreDropdownButton(), "Click on more");
		if (executor.isElementPresent(jobViewPage.getBySendJobToClient())
				|| executor.isElementPresent(jobViewPage.getByMarkJobComplete())) {
			if (JobToBeDeliveredBy.equalsIgnoreCase("CM")) {
				executor.click(jobViewPage.getSendJobToClient(), "Click on Send To Client");
			} else {
				executor.click(jobViewPage.getMarkJobCompleteOption(), "Click on MarkJobCompleteOption");
			}

			if (driver.getWindowHandles().size() < 2
					|| executor.isElementPresent(jobViewPage.getByMarkJobCompleteSave())) {
				executor.softWaitforElementToBeClickable(jobViewPage.getByMarkJobCompleteSave(), "MarkJobCompleteSave");
				executor.click(jobViewPage.getByMarkJobCompleteSave(), "Click on MarkJobCompleteSave");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(jobViewPage.getCrmloader()),  "Invisiblity of Loader");
				executor.softWaitforInvisibilityOFWebElement(jobViewPage.getLoader(), "Invisiblity of Loader");
				executor.softWaitforElementToBeClickable(jobViewPage.getMoreDropdownButton(), "More button to be clickable");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(jobViewPage.getEditageLoader()),  "Invisiblity of Loader");
				
				int i=0;
				if(executor.isElementPresent(jobViewPage.getCrmloader())&&i<5){
					executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(jobViewPage.getCrmloader()),  "Invisiblity of Loader");
					i++;
				}
				executor.waitForPageLoadJS();
			} else {
				executor.softWaitforCondition(ExpectedConditions.numberOfWindowsToBe(2), "No of windows to be 2");
				executor.findAndSwitchToNewWindow(currentWindowHandle);

				executor.waitForPageLoadJS();
				executor.softWaitforInvisibilityOFWebElement(jobViewPage.getLoader(), "Invisiblity of Loader");
				executor.softWaitforElementToBeClickable(jobViewPage.getMarkJobCompleteAndSendToClient(),
						"getMarkJobCompleteAndSendToClient as Clickable");
				WebElement el = jobViewPage.getMarkJobCompleteAndSendToClient();
				new Actions(driver).moveToElement(el).click(el).build().perform();

				if (executor.isAlertPresent()) {
					executor.acceptUnhandledAlert();
				}
		
			executor.waitForPageLoadJS();
			Dashboard dashboard = new Dashboard(driver, wait, test);

			executor.softWaitforVisibilityOfWebElement(dashboard.getBySuccessMessage(), "Succes Message");
			executor.verifyTrue(executor.isElementPresent(dashboard.getBySuccessMessage()),
					"If success message is displayed");
			}
		}
	}

	public String navigateToCRMAndgetStatus(EnquiryAndJobViewPage jobViewPage, String testURL) {
		executor.navigateToURL(testURL);
		executor.softWaitforVisibilityOfWebElement(jobViewPage.getStatus(), "Wait for visibility of Status");
		String status = jobViewPage.getStatus().getText();
		return status;
	}

	public void getStatusAndWriteInExcel(Map<String, String> testData, EnquiryAndJobViewPage jobViewPage) {
		String jobId = testData.get("JobCode");
		String testURL = testData.get("testURLCRMJobView");
		if (!testURL.contains(jobId)) {
			testURL = testURL + jobId;
		}
		String status = navigateToCRMAndgetStatus(jobViewPage, testURL);
		testData.put("status", status);

		new ExcelUtil().setCellValue(util.getFilePath("testData_FL.xlsx"), "FLData", "JobCode", "status", jobId,
				testData.get("status"));
		new ExcelUtil().setCellValue(util.getFilePath("testRunData.xlsx"), "Job", "JobCode", "status", jobId,
				testData.get("status"));

		if (status.equalsIgnoreCase("JOB WITH CLIENT")) {
			new ExcelUtil().setCellValue(util.getFilePath("testData_FL.xlsx"), "FLData", "JobCode", "flag", jobId,
					"no");
		} else if (status.contains("COMPLETED")) {
			executor.addStatus(LogStatus.ERROR, "Job is in Completed state");
		}
	}
		

}
