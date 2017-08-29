package com.cactus.crm.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.AbstractPage;
import com.cactus.inits.Config;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddEnquiryPage extends AbstractPage {
	protected ExtentTest test;
	protected Executioner executor;
	protected Util util;

	WebElement email_id;
	WebElement client_code;
	WebElement submit_enquiry;
	WebElement partner_name;

	@FindBy(xpath = ".//button[normalize-space() = 'Proceed to create enquiry']")
	WebElement proceedToCreateEnquiry;

	@FindBy(xpath = "//*[@class='result-loader-inner']")
	WebElement loaderElement;

	//By loader = By.xpath("//*[@class='result-loader-inner']");
	By requiredWarning = By.xpath(".//*[@class='form-control-feedback glyphicon glyphicon-alert']");
	// -------------//
	@FindBy(xpath = ".//*[@class='phpdebugbar-close-btn']")
	WebElement phpDebuggerCloseButton;
	
	By saveEnquiryMessage=By.xpath(".//*[contains(text(),'Saving the enquiry')]");

	public AddEnquiryPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait,test);
		this.test = test;
		this.executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.CRM_PAGE_TITLE), "Wait for Title");
		
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.CRM_PAGE_TITLE.toLowerCase())) {
			executor.addStatus(LogStatus.FAIL, "This is not  the  CRM Add Enquiry  Page");
			throw new IllegalStateException("This is not  the  CRM Add Enquiry  Page");
		}
	}

	public WebElement getPhpDebuggerCloseButton() {
		return phpDebuggerCloseButton;
	}

	public WebElement getPartner_name() {
		return partner_name;
	}

	public String createNewUserIdandProceedToCreateEnquiry() {
		executor.softWaitforVisibilityOfWebElement(proceedToCreateEnquiry, "Wait until 'Proceed to create enquiry' is displayed");
		String newUserEmailId = util.getNewEmailId();
		executor.sendkeys(email_id, newUserEmailId, "Enter Email (New/ Existing client):" + newUserEmailId);
		executor.click(proceedToCreateEnquiry, "Click on 'Proceed to create enquiry' button");
		return newUserEmailId;
	}

	public void enterClientCodeAndProceedToCreateEnquiry(String clientCode) {
		executor.sendkeys(client_code, clientCode, "Enter CleintCode:" + clientCode);
		executor.click(proceedToCreateEnquiry, "Click on 'Proceed to create enquiry' button");

	}

	public void enterClientEmailAndProceedToCreateEnquiry(String clientEmail) {
		executor.sendkeys(email_id, clientEmail, "Enter Email (New/ Existing client):" + clientEmail);
		executor.click(proceedToCreateEnquiry, "Click on 'Proceed to create enquiry' button");

	}

	public EnquiryAndJobViewPage clickOnSubmitEnquiry() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", submit_enquiry);
		executor.softWaitforElementToBeClickable(submit_enquiry, "Submit Enquiry");
		executor.moveToElement(submit_enquiry);
		
		List<WebElement> liEs=new ArrayList<>();
		liEs.add(submit_enquiry);
		executor.click(submit_enquiry, "Click on submit enquiry");

		if (executor.isElementPresent(requiredWarning)) {
			executor.addStatus(LogStatus.FAIL, "Warniing exists in the enquiry page");
			throw new IllegalStateException("Warniing exists in the enquiry page");
		}
		executor.softWaitCondition(ExpectedConditions.invisibilityOfAllElements(liEs), "Wait for invisibility of SubmitEnquiry button");
		executor.softWaitforInvisibilityOFWebElement(saveEnquiryMessage, "Invisibility of Save Enquiry Message");
		executor.softWaitforInvisibilityOFWebElement(getLoader(), "Wait for invisibility of Loader");
		if (executor.isElementExist(submit_enquiry)) {
			executor.click(submit_enquiry, "Click on submit enquiry");
		}
		executor.isElementDisplayed(loaderElement, "Loader");

		return new EnquiryAndJobViewPage(driver, wait, test);

	}

	public class ClientDetailsSection {
		WebElement field_client_profile_firstname;
		WebElement field_client_profile_lastname;
		WebElement field_client_profile_salutation;
		WebElement field_client_profile_native_name;
		WebElement field_client_profile_primary_ph_number;

		public ClientDetailsSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			PageFactory.initElements(driver, this);
			executor.softWaitforVisibilityOfWebElement(field_client_profile_firstname,
					"Wait until field_client_profile_firstname is displayed");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
		}

		public void enterClientDetails(Map<String, String> testData) {
			executor.type(field_client_profile_firstname, testData.get("FirstName"),
					"Enter First Name:" + testData.get("FirstName"));
			executor.type(field_client_profile_lastname, testData.get("LastName"),
					"Enter Last Name:" + testData.get("LastName"));
			executor.selectFromDropDown(field_client_profile_salutation, "visibleText", testData.get("Salutation"));
			executor.type(field_client_profile_native_name, testData.get("NativeName"), "Enter Native Name:");
			executor.type(field_client_profile_primary_ph_number, testData.get("PhoneNumber"),
					"Enter Primary Phone Number");
		}
	}

	public class UploadFilesSection {
		WebElement job_files;
		@FindBy(xpath = "//*[@id='job_files']//input[@type='file']")
		WebElement jobFiles;

		@FindBy(xpath = "//*[@id='reference_files']//input[@type='file']")
		WebElement referenceFiles;
   
        @FindBy(xpath="//*[@id='job-files-container']//*[contains(@class,'s3-file-count')]")
        WebElement jobFilesCount;
        
        @FindBy(xpath="//*[@id='reference-files-container']//*[contains(@class,'s3-file-count')]")
        WebElement referenceFilesCount;
		
		By byFileUploadLoader=By.xpath(".//*[@class='qq-upload-spinner-selector qq-upload-spinner']");

		public UploadFilesSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			PageFactory.initElements(driver, this);
			executor.softWaitforVisibilityOfWebElement(job_files, "Wait until job_files is displayed");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
		}

		public void selectUploadFiles(Map<String, String> testData) {
			
			String uploadJobFile = testData.get("UploadJobFiles");
			String[] uploadJobFiles = uploadJobFile.split(";");

			String UploadReferenceFile = testData.get("UploadReferenceFiles");
			String[] uploadReferenceFiles = UploadReferenceFile.split(";");

			int jobFilesExp=uploadJobFiles.length;
			for (int i = 0; i < jobFilesExp; i++) {
				String filepath = util.getFileAbolutePath(uploadJobFiles[i]);
				executor.fileUploadBySendkeys(jobFiles, filepath, "jobFiles");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader), "Invisibility of File Loader");
			}
			
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader), "Invisibility of File Loader");
			

			
			int refFilesExp=uploadReferenceFiles.length;
			for (int i = 0; i < refFilesExp; i++) {
				String filepath = util.getFileAbolutePath(uploadReferenceFiles[i]);
				executor.fileUploadBySendkeys(referenceFiles, filepath, "referenceFiles");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader), "Invisibility of File Loader");
			}
			
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader), "Invisibility of File Loader");
			
			
			
			int i=0;
			while(executor.isElementPresent(byFileUploadLoader)&&i<5){
				executor.softWaitforInvisibilityOFWebElement(byFileUploadLoader, "Invisibility of File Loader");
				i++;
			}
			
			int actualJobFiles=Integer.parseInt(jobFilesCount.getText());
			executor.verifyEquals(actualJobFiles, jobFilesExp, "Verification of uploaded JobFiles:");
			int actualRefFiles=Integer.parseInt(referenceFilesCount.getText());
			executor.verifyEquals(actualRefFiles, refFilesExp, "Verification of Reference Files:");


		}
	}

	public class IntructionsSection {
		@FindBy(xpath = "//div[@id='block-client-instruction']//textarea")
		WebElement instructions;

		public IntructionsSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			PageFactory.initElements(driver, this);
			executor.softWaitforVisibilityOfWebElement(instructions, "Wait until jobFiles is displayed");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
		}

		public void enterInstructions(String instruction) {
			executor.type(instructions, instruction, "Send instructions");
		}
	}

	public class SummarySection {
		WebElement summary_job_unit;
		WebElement summary_service;
		WebElement summary_plan;
		WebElement summary_delivery_date;
		WebElement summary_final_price;

		@FindBy(xpath = ".//*[.='Summary']")
		WebElement headerSummary;

		public SummarySection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			PageFactory.initElements(driver, this);
			executor.softWaitforVisibilityOfWebElement(headerSummary, "Wait until headerSummary is displayed");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
		}

		public void verifySummary(String jobUnit, String service, String plan, String deliveryDate, String finalPrice) {
			executor.verifyEquals(summary_job_unit.getText().replace(",", ""), jobUnit, "Verify JobUnit Count: ");
			executor.verifyEquals(summary_service.getText(), service, "Verify summary_service Count: ");
			executor.verifyEquals(summary_plan.getText(), plan, "Verify summary_plan Count: ");
			executor.verifyEquals(summary_delivery_date.getText(), deliveryDate,
					"Verify summary_delivery_date Count: ");
			executor.verifyEquals(summary_final_price.getText(), finalPrice, "Verify summary_final_price Count: ");
		}
	}
}
