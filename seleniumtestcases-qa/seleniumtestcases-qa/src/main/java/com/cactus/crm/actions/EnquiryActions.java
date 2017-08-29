package com.cactus.crm.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.crm.pages.AddEnquiryPage;
import com.cactus.crm.pages.PaymentPreferencesSection;
import com.cactus.crm.pages.ServiceAndJobDetailsSection;
import com.cactus.crm.pages.ClientInformationSection;
import com.cactus.crm.pages.DeliveryAndFeeDetailsSection;
import com.cactus.executor.Executioner;

import com.cactus.whiteboard.pages.Dashboard;
import com.cactus.whiteboard.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

public class EnquiryActions {
	AddEnquiryPage addEnquiryPage;

	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;

	public EnquiryActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);

		PageFactory.initElements(driver, this);

	}

	public void setAddEnquiryPage(AddEnquiryPage addEnquiryPage) {
		this.addEnquiryPage = addEnquiryPage;
	}

	public void fillClientForm(Map<String, String> testData) {
		if (executor.isElementPresent(addEnquiryPage.getPhpDebugger())) {
			executor.click(addEnquiryPage.getPhpDebugger(), "Click on Php debugger Close Button");
		}
		if (testData.get("CreateNewUser").equalsIgnoreCase("yes")) {
			new ClientInformationSection(driver, wait, test).enterNewClientInformation(testData);
			addEnquiryPage.new ClientDetailsSection(driver, wait, test).enterClientDetails(testData);
		} else {
			new ClientInformationSection(driver, wait, test).enterExistingClientAndGroupInformation(testData);
		}

		new ServiceAndJobDetailsSection(driver, wait, test).enterServiceAndJobDetails(testData);
		addEnquiryPage.new UploadFilesSection(driver, wait, test).selectUploadFiles(testData);
		addEnquiryPage.new IntructionsSection(driver, wait, test).enterInstructions(testData.get("Instructions"));
		new DeliveryAndFeeDetailsSection(driver, wait, test).enterDeliveryAndFeeDetails(testData);

		if (testData.get("CreateNewUser").equalsIgnoreCase("yes")) {
			new PaymentPreferencesSection(driver, wait, test).enterPaymentPreferences(testData);
		} else {
			new PaymentPreferencesSection(driver, wait, test).enterPaymentPreferencesExistingUser(testData);
		}
	}

	public void fillNewClientForm(Map<String, String> testData) {
		if (executor.isElementDisplayed(addEnquiryPage.getPhpDebuggerCloseButton(), "Php debugger")) {
			executor.click(addEnquiryPage.getPhpDebuggerCloseButton(), "Click on Php debugger Close Button");
		}
		new ClientInformationSection(driver, wait, test).enterNewClientInformation(testData);
		addEnquiryPage.new ClientDetailsSection(driver, wait, test).enterClientDetails(testData);

		new ServiceAndJobDetailsSection(driver, wait, test).enterServiceAndJobDetails(testData);
		addEnquiryPage.new UploadFilesSection(driver, wait, test).selectUploadFiles(testData);
		addEnquiryPage.new IntructionsSection(driver, wait, test).enterInstructions(testData.get("Instructions"));
		new DeliveryAndFeeDetailsSection(driver, wait, test).enterDeliveryAndFeeDetails(testData);

		new PaymentPreferencesSection(driver, wait, test).enterPaymentPreferences(testData);
	}

	public void fillExistingClientForm(Map<String, String> testData) {
		if (executor.isElementDisplayed(addEnquiryPage.getPhpDebuggerCloseButton(), "Php debugger")) {
			executor.click(addEnquiryPage.getPhpDebuggerCloseButton(), "Click on Php debugger Close Button");
		}
		new ClientInformationSection(driver, wait, test).enterExistingClientAndGroupInformation(testData);

		new ServiceAndJobDetailsSection(driver, wait, test).enterServiceAndJobDetails(testData);
		addEnquiryPage.new UploadFilesSection(driver, wait, test).selectUploadFiles(testData);
		addEnquiryPage.new IntructionsSection(driver, wait, test).enterInstructions(testData.get("Instructions"));
		new DeliveryAndFeeDetailsSection(driver, wait, test).enterDeliveryAndFeeDetails(testData);

		new PaymentPreferencesSection(driver, wait, test).enterExistingClientPaymentPreferences(testData);
	}

	public AddEnquiryPage loginAndNavigateToAddEnquiryPage(String email, String password) {
		Dashboard dashboard = loginAndNavigateToDashboard(email, password);
		return addEnquiryPage = dashboard.navigateToNewEnquiry();
	}

	public Dashboard loginAndNavigateToDashboard(String email, String password) {
		LoginPage loginPage = new LoginPage(driver, wait, test);
		return loginPage.login(email, password);
	}

}
