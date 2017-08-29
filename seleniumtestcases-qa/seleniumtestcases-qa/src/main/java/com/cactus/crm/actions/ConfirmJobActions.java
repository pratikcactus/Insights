package com.cactus.crm.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.crm.pages.ConfirmJobPage;
import com.cactus.crm.pages.EnquiryAndJobViewPage;
import com.relevantcodes.extentreports.ExtentTest;

public class ConfirmJobActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	public ConfirmJobActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;

		PageFactory.initElements(driver, this);

	}

	public EnquiryAndJobViewPage createJobForUser(Map<String, String> testData) {
		EnquiryAndJobViewPage enquiryJobViewPage = new CreateEnquiryActions(driver, test, wait)
				.createAndSubmitEnquiry(testData);
		ConfirmJobPage confirmJobPage = enquiryJobViewPage.clickJobConfirmAndNavigateToConfirmJobPage();
		EnquiryAndJobViewPage enquiryViewPage=confirmJobPage.confirmJobWithoutEmail(); 
		testData.put("JobCode",confirmJobPage.getJobId());
		testData.put("status", enquiryViewPage.getStatus().getText());
		testData.put("PMId",confirmJobPage.clickOnPMEditButtonAndGetPMID(testData.get("EditPM"),testData.get("PMId")));
		testData.put("CMId",confirmJobPage.clickOnCMEditButtonAndGetCMID(testData.get("EditCM"),testData.get("CMId")));
		
		return enquiryViewPage;
	}
	

	public EnquiryAndJobViewPage createJobExistingUser(Map<String, String> testData) {
		EnquiryAndJobViewPage enquiryJobViewPage = new CreateEnquiryActions(driver, test, wait)
				.createAndSubmitEnquiry(testData);
		ConfirmJobPage confirmJobPage = enquiryJobViewPage.clickJobConfirmAndNavigateToConfirmJobPage();
		EnquiryAndJobViewPage enquiryViewPage=confirmJobPage.confirmJobWithoutEmail(); 
		testData.put("JobCode",confirmJobPage.getJobId());
		testData.put("status", enquiryViewPage.getStatus().getText());
		testData.put("PMId",confirmJobPage.clickOnPMEditButtonAndGetPMID(testData.get("EditPM"),testData.get("PMId")));
		testData.put("CMId",confirmJobPage.clickOnCMEditButtonAndGetCMID(testData.get("EditCM"),testData.get("CMId")));
		return enquiryViewPage;
	}
}
