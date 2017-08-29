package com.cactus.crm.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.crm.pages.AddEnquiryPage;
import com.cactus.crm.pages.EnquiryAndJobViewPage;
import com.cactus.utils.DataMapUtil;
import com.cactus.utils.ExcelUtil;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class CreateEnquiryActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private Util util;
	
	public CreateEnquiryActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;

		util=Util.getInstance();
		PageFactory.initElements(driver, this);

	}
	
	public EnquiryAndJobViewPage createAndSubmitEnquiry(Map<String, String> testData){		
		EnquiryActions addEnquiryAction = new EnquiryActions(driver, test, wait);
		
		AddEnquiryPage addEnquiryPage = addEnquiryAction.loginAndNavigateToAddEnquiryPage(testData.get("LoginID"),
				testData.get("LoginPassword"));
			
		if (testData.get("CreateNewUser").equalsIgnoreCase("yes")) {
			String email = addEnquiryPage.createNewUserIdandProceedToCreateEnquiry();
			testData.put("ClientEmail", email);
		}else{
			if (testData.get("ClientCodeOrEmail").contains("email")) {
				addEnquiryPage.enterClientEmailAndProceedToCreateEnquiry(testData.get("ClientEmail"));
			} else
				addEnquiryPage.enterClientCodeAndProceedToCreateEnquiry(testData.get("ClientCode"));
		}

		addEnquiryAction.setAddEnquiryPage(addEnquiryPage);
		addEnquiryAction.fillClientForm(testData);

		addEnquiryPage.new SummarySection(driver, wait, test).verifySummary(testData.get("JobUnitCount"),
				testData.get("Services"), testData.get("PlanNativeName"), testData.get("deliveryDateTime"),
				testData.get("finalPrice"));
		EnquiryAndJobViewPage enquiryViewPage = addEnquiryPage.clickOnSubmitEnquiry();
		testData.put("EnquiryCode",enquiryViewPage.getEnquiryCode());
		
		String status=enquiryViewPage.getEnqLabel().getText();
		testData.put("status", status);

		return enquiryViewPage;
		
	}

	public EnquiryAndJobViewPage createAndSubmitEnquiryNewUser(Map<String, String> testData){		
		EnquiryActions addEnquiryAction = new EnquiryActions(driver, test, wait);
		
		AddEnquiryPage addEnquiryPage = addEnquiryAction.loginAndNavigateToAddEnquiryPage(testData.get("LoginID"),
				testData.get("LoginPassword"));

		String email = addEnquiryPage.createNewUserIdandProceedToCreateEnquiry();
		testData.put("ClientEmail", email);

		addEnquiryAction.setAddEnquiryPage(addEnquiryPage);
		addEnquiryAction.fillNewClientForm(testData);

		addEnquiryPage.new SummarySection(driver, wait, test).verifySummary(testData.get("JobUnitCount"),
				testData.get("Services"), testData.get("PlanNativeName"), testData.get("deliveryDateTime"),
				testData.get("finalPrice"));
		EnquiryAndJobViewPage enquiryViewPage = addEnquiryPage.clickOnSubmitEnquiry();
		testData.put("EnquiryCode",enquiryViewPage.getEnquiryCode());
		

		String status=enquiryViewPage.getEnqLabel().getText();
		testData.put("status", status);
		
		return enquiryViewPage;
		
	}
	
	public EnquiryAndJobViewPage createAndSubmitEnquiryExistingUser(Map<String, String> testData){

		EnquiryActions addEnquiryAction = new EnquiryActions(driver, test, wait);

		AddEnquiryPage addEnquiryPage = addEnquiryAction.loginAndNavigateToAddEnquiryPage(testData.get("LoginID"),
				testData.get("LoginPassword"));

		if (testData.get("ClientCodeOrEmail").contains("email")) {
			addEnquiryPage.enterClientEmailAndProceedToCreateEnquiry(testData.get("ClientEmail"));
		} else
			addEnquiryPage.enterClientCodeAndProceedToCreateEnquiry(testData.get("ClientCode"));

		addEnquiryAction.setAddEnquiryPage(addEnquiryPage);
		addEnquiryAction.fillExistingClientForm(testData);

		addEnquiryPage.new SummarySection(driver, wait, test).verifySummary(testData.get("JobUnitCount"),
				testData.get("Services"), testData.get("PlanNativeName"), testData.get("deliveryDateTime"),
				testData.get("finalPrice"));
		EnquiryAndJobViewPage enquiryViewPage = addEnquiryPage.clickOnSubmitEnquiry();
		testData.put("EnquiryCode",enquiryViewPage.getEnquiryCode());		
		return enquiryViewPage;
		
	}

	public void writeEnqData(Map<String, String> testData) {
		Map<String, String> enqMap = new DataMapUtil().getEnqMap(testData);
		new ExcelUtil().writeExcelFile(util.getFilePath("testRunData.xlsx"), "Enquiry", enqMap);	
	}
	
}
