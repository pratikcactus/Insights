package com.cactus.crm.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.AbstractPage;
import com.cactus.inits.Config;
import com.cactus.utils.Util;
import com.cactus.whiteboard.pages.AllocateJobPage;
import com.cactus.whiteboard.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EnquiryAndJobViewPage extends AbstractPage {
	protected ExtentTest test;
	private Executioner executor;
	private Util util;

	@FindBy(xpath = "//*[@class='fa fa-power-off']")
	WebElement signOutLink;

	@FindBy(xpath = ".//*[contains(@class,'logo')]")
	WebElement logo;

	@FindBy(xpath = ".//div[@id='me-info-header']//button[contains(.,'More')]")
	WebElement moreDropdownButton;

	@FindBy(xpath = ".//div[@id='me-info-header']//ul[@class='dropdown-menu']//a[@action-name='reject-quote']")
	WebElement rejectQuoteTab;

	@FindBy(xpath = ".//div[@id='me-info-header']//ul[@class='dropdown-menu']//a[@_crm_track_label='Allocate job']")
	WebElement allocateJobTab;

	@FindBy(xpath = ".//*[@id='enquiry_title']/span")
	WebElement enquiryTitle;

	@FindBy(xpath = ".//*[@class='enq-code']")
	WebElement enqCode;

	@FindBy(xpath = ".//*[@class='label label-default']")
	WebElement enqLabel;

	@FindBy(xpath = "//*[@id='me-info-header']//button[@title='Confirm job']")
	WebElement confirmJob;

	@FindBy(xpath = "//a[contains(@href,'/new-crm/auto-logout')]")
	WebElement logout;

	@FindBy(xpath = ".//*[@ _crm_track_label='Mark job complete']")
	WebElement markJobComplete;

	@FindBy(xpath = ".//*[@ _crm_track_label='Send job to client']")
	WebElement sendJobToClient;

	@FindBy(xpath = ".//div[@id='me-info-header']//ul[@class='dropdown-menu']//a[normalize-space()='Mark job complete']")
	WebElement MarkJobCompleteOption;

	@FindBy(xpath = ".//input[@id='edit-submit']")
	WebElement MarkJobCompleteAndSendToClient;

	@FindBy(xpath = ".//div[@class='proinfo-box process-progress']//button")
	WebElement uploadFileButton;

	@FindBy(xpath = "//div[@id='process-files-modal']//*[contains(@id,'process_files')]//input[@type='file']")
	List<WebElement> UplaodButtons;

	@FindBy(xpath = "//input[@id='do-force-submit']")
	WebElement forceToSubmitButton;

	@FindBy(xpath = ".//select[contains(@id,'process_files_reason')]")
	List<WebElement> ReasonDropdown;

	@FindBy(xpath = ".//*[contains(@id,'process_files_reason')]")
	WebElement selectReason;

	@FindBy(xpath = "//button[@_crm_track_label='process_submit']")
	WebElement UploadFilePopupSubmit;

	WebElement mark_job_complete_save;

	By byMarkJobCompleteSave = By.id("mark_job_complete_save");
	By byEmailId = By.xpath("//*[@class='dropdown-toggle']//span");
	By refreshSpinner = By.xpath(".//*[@id='action_block']//*[contains(@class,'fa-refresh')]");
	By modalContent = By.className("modal-content");
	By byButtonYes = By.xpath(".//button[.='Yes']");
	By bySelectReason = By.xpath(".//*[contains(@id,'process_files_reason')]");
	By bySendJobToClient = By.xpath(".//*[@ _crm_track_label='Send job to client']");
	// By byMarkJobComplete = By.xpath(".//*[@ _crm_track_label='Mark job
	// complete']");
	By byMarkJobComplete = By.xpath(".//a[normalize-space()='Mark job complete']");
	By byFileUploadLoader = By.xpath(".//*[@class='qq-upload-spinner-selector qq-upload-spinner']");
	By byLogOut = By.xpath("//a[contains(@href,'/new-crm/auto-logout')]");

	public EnquiryAndJobViewPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		this.test = test;
		this.executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.CRM_PAGE_TITLE), "Wait for Title");
		executor.softWaitforVisibilityOfWebElement(logo, "Wait until logo is displayed");
		executor.softWaitforVisibilityOfWebElement(enqCode, "Wait until enqCode is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(refreshSpinner),
				"Invisibility of refreshSpinner");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.CRM_PAGE_TITLE.toLowerCase())) {
			executor.addStatus(LogStatus.FAIL, "This is not  the  CRM Dashboard Page");
			throw new IllegalStateException("This is not  the  CRM Dashboard Page");
		}
	}

	public EnquiryAndJobViewPage(WebDriver driver, WebDriverWait wait, ExtentTest test, String userEmail) {
		super(driver, wait, test);
		this.test = test;
		this.executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.CRM_PAGE_TITLE), "Wait for Title");
		executor.softWaitforVisibilityOfWebElement(logo, "Wait until logo is displayed");
		executor.softWaitforVisibilityOfWebElement(enqCode, "Wait until enqCode is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(refreshSpinner),
				"Invisibility of refreshSpinner");

		String url = driver.getCurrentUrl();
		if (!verifyUserNameOnCRM(userEmail)) {
			String logoutUrl = url.replaceAll("job.*", "logout");
			logoutUrl = url.replaceAll("job.*", "logout");
			// executor.click(logout, "Click on Logout for :" + userEmail);
			executor.navigateToURL(logoutUrl);
			executor.waitForPageLoadJS();
			executor.navigateToURL(url);
			executor.waitForPageLoadJS();
		}

		if (!driver.getTitle().trim().toLowerCase().contains(Config.CRM_PAGE_TITLE.toLowerCase())) {
			executor.addStatus(LogStatus.FAIL, "This is not  the  CRM Dashboard Page");
			throw new IllegalStateException("This is not  the  CRM Dashboard Page");
		}
	}

	public WebElement getMoreDropdownButton() {
		return moreDropdownButton;
	}

	public WebElement getMarkJobComplete() {
		return markJobComplete;
	}

	public WebElement getSendJobToClient() {
		return sendJobToClient;
	}

	public WebElement getMarkJobCompleteOption() {
		return MarkJobCompleteOption;
	}

	public WebElement getMarkJobCompleteAndSendToClient() {
		return MarkJobCompleteAndSendToClient;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getEnqLabel() {
		return enqLabel;
	}

	public By getByMarkJobComplete() {
		return byMarkJobComplete;
	}

	public By getBySendJobToClient() {
		return bySendJobToClient;
	}

	public By getByMarkJobCompleteSave() {
		return byMarkJobCompleteSave;
	}

	public void clickOnSignOut() {
		executor.softWaitforVisibilityOfWebElement(signOutLink, "Visibility of SignOutLink");
		executor.click(signOutLink, "Click on SignOutLink");
		executor.softWaitforInvisibilityOFWebElement(signOutLink, "Invisibility of SignOutLink");
		new LoginPage(driver, wait, test);

	}

	public RejectQuotePage clickOnMoreAndNavigateToRejectQuotePage() {
		executor.click(moreDropdownButton, "MoreDropdown");
		executor.click(rejectQuoteTab, "getRejectQuoteTab");
		return new RejectQuotePage(driver, wait, test);
	}

	public AllocateJobPage clickOnMoreAndNavigateToAllocateJobPage() {
		executor.click(moreDropdownButton, "MoreDropdown");
		executor.softWaitforVisibilityOfWebElement(allocateJobTab, "Wait for allocateJobTab");
		executor.click(allocateJobTab, "Click on allocateJobTab");
		return new AllocateJobPage(driver, wait, test);
	}

	public String getEnquiryCode() {
		executor.softWaitforVisibilityOfWebElement(enquiryTitle, "Enquiry title");
		return enquiryTitle.getText().trim();
	}

	public ConfirmJobPage clickJobConfirmAndNavigateToConfirmJobPage() {
		executor.click(confirmJob, "Click on Confirm Job");
		executor.softWaitforInvisibilityOFWebElement(refreshSpinner, "Invisibility of spinner");
		//executor.softWaitforInvisibilityOFWebElement(confirmJob, "Invisible of confirmJob");
		executor.softWaitforElementToBeClickable(confirmJob, "confirmJob to be clickable");
		if (executor.isElementPresent(modalContent)) {
			if (executor.isElementPresent(modalContent)
					&& executor.isElementDisplayed(byButtonYes, "If Yes is displayed")) {
				executor.click(byButtonYes, "Click on Yes button");
			}
			executor.softWaitforInvisibilityOFWebElement(refreshSpinner, "Invisibility of spinner");
		}
		return new ConfirmJobPage(driver, wait, test);
	}

	public LoginPage logout() {
		executor.sendkeys(logout, Keys.PAGE_UP, "Page Up");
		executor.softWaitforElementToBeClickable(logout, "Wait for Logout to be clickable");
		executor.actionClick(logout, "click on Logout");
		if (executor.isElementPresent(byLogOut)) {
			executor.click(logout, "Click on Logout");
		}
		return new LoginPage(driver, wait, test);
	}

	public void uploadFileAndForceSubmit(String uploadFile, String forceSubmitReason) {
		executor.softWaitforElementToBeClickable(uploadFileButton, "Element uploadFileButton to be clickable");
		executor.sendkeys(uploadFileButton, Keys.PAGE_DOWN, "Send keys Page Down");

		executor.actionClick(uploadFileButton, "Click on Upload File Button");
		executor.softWaitforVisibilityOfWebElement(getModalHeader(), "Visibility of modal header");
		executor.pause(1);
		uploadEnquiryJobFile(uploadFile);
		executor.softWaitforElementToBeClickable(forceToSubmitButton, "Element to be clickable Force Upload Button");
		executor.click(forceToSubmitButton, "Click on Force Upload Button");
		executor.softWaitforCondition(ExpectedConditions.elementSelectionStateToBe(forceToSubmitButton, true),
				"Is element selected");

		executor.softWaitforVisibilityOfWebElement(selectReason, "Visibility of Reason drop down");
		if (!executor.isElementPresent(bySelectReason)) {
			executor.click(forceToSubmitButton, "Click on Force Upload Button");
			executor.softWaitforCondition(ExpectedConditions.elementSelectionStateToBe(forceToSubmitButton, false),
					"Is element selected");
			executor.click(forceToSubmitButton, "Click on Force Upload Button");
			executor.softWaitforCondition(ExpectedConditions.elementSelectionStateToBe(forceToSubmitButton, true),
					"Is element selected");
		}
		selectReasonFromDropdown(forceSubmitReason);
		executor.click(UploadFilePopupSubmit, "Click on UploadFilePopupSubmit");
		executor.softWaitforInvisibilityOFWebElement(getLoader(), "Invisibility of Loader");
		if (executor.isElementPresent(getLoader())) {
			executor.softWaitforInvisibilityOFWebElement(getLoader(), "Invisibility of Loader");
		}
	}

	public void uploadEnquiryJobFile(String value) {
		String[] file = value.split("\\;");
		int lenFiles = file.length;
		int len = UplaodButtons.size();
		for (int i = 0, j = 0; i < len; i++) {
			String filepath = util.getRootPath() + util.getResourcePath() + "\\" + file[j];
			UplaodButtons.get(i).sendKeys(filepath);
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader),
					"Invisibility of File Loader");
			if (j < lenFiles - 1) {
				j++;
			} else {
				j = 0;
			}
		}
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byFileUploadLoader),
				"Invisibility of File Loader");
	}

	public void selectReasonFromDropdown(String value) {
		executor.softWaitforVisibilityOfWebElement(selectReason, "Visibility of Reason drop down");
		for (int i = 0; i < ReasonDropdown.size(); i++) {
			executor.selectFromDropDown(ReasonDropdown.get(i), "value", value);
		}
	}

	public boolean verifyUserNameOnCRM(String userName) {
		if (executor.isElementPresent(byEmailId)) {
			String actualUserName = driver.findElement(byEmailId).getText();
			if (actualUserName.equalsIgnoreCase(userName)) {
				return true;
			}
		} else {
			executor.addStatus(LogStatus.WARNING, "USerName is different on CRM");
		}
		return false;

	}
}
