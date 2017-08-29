package com.cactus.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.Config;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ConfirmJobPage extends EnquiryAndJobViewPage {
	private Executioner executor;

	@FindBy(xpath = ".//*[@id='confirm-job_form']")
	WebElement confirmJobForm;

	@FindBy(xpath = ".//button[@id='confirm-job-no-email_save']")
	WebElement confirmJobWithoutEmail;

	@FindBy(xpath = ".//div[@id='action_block']//div[contains(@class,'alert')]//ul[@id='alert-list']/li")
	WebElement wellDoneAlert;

	@FindBy(xpath = ".//*[@id='left-view']//div[contains(@class,'job-details-wrap')]//h3/a[contains(@href,'crm.cactusglobal.com')]")
	WebElement jobId;

	@FindBy(xpath = "//span[@class='client-profile-edit']/a[contains(@ _crm_track_description,'PM')]")
	WebElement editPM;

	@FindBy(xpath = "//span[@class='client-profile-edit']/a[contains(@ _crm_track_description,'CM')]")
	WebElement editCM;

	@FindBy(xpath = ".//span[@id='select2-field_enquiry_pm-container']")
	WebElement pm;

	@FindBy(xpath = ".//span[@id='select2-field_enquiry_cm-container']")
	WebElement cm;

	@FindBy(xpath = ".//input[@class='select2-search__field']")
	WebElement search;

	@FindBy(xpath = "//button[.='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//button[.='Update']")
	WebElement updateButton;

	@FindBy(xpath = ".//*[@class='ui-pnotify-title']")
	WebElement wellDoneNotification;

	By byOverlayLoader = By.xpath("//*[@class='overlay']");
	By byCancelButton = By.xpath("//button[.='Cancel']");
	By bySearch = By.xpath(".//input[@class='select2-search__field']");

	public ConfirmJobPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		this.executor = new Executioner(driver, test, wait);

		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.CRM_PAGE_TITLE), "Wait for Title");
		executor.softWaitforVisibilityOfWebElement(logo, "Wait until logo is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.CRM_PAGE_TITLE.toLowerCase())) {
			executor.addStatus(LogStatus.FAIL, "This is not  the  CRM Dashboard Page");
			throw new IllegalStateException("This is not  the  CRM Dashboard Page");
		}
	}

	public EnquiryAndJobViewPage confirmJobWithoutEmail() {
		executor.softWaitforElementToBeClickable(confirmJobWithoutEmail, "Element confirmJobWithoutEmail is clickable");
		executor.click(confirmJobWithoutEmail, "confirmJobWithoutEmail");
		executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of Loader");
		executor.softWaitforVisibilityOfWebElement(wellDoneAlert, "Well Done");
		return new EnquiryAndJobViewPage(driver, wait, test);
	}

	public String getJobId() {
		executor.softWaitforVisibilityOfWebElement(jobId, "joiid");
		return jobId.getText().trim();
	}

	public String clickOnPMEditButtonAndGetPMID(String flag, String id) {
		executor.click(editPM, "Click on PM Edit");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(byOverlayLoader),
				"Invisibility of overlay loader");
		executor.softWaitforVisibilityOfWebElement(pm, "pm");
		String str = pm.getText();
		if (flag.equalsIgnoreCase("yes")) {
			executor.softWaitforElementToBeClickable(pm, "Wait for pm EditButton");
			executor.click(pm, "click on PM");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
			executor.softWaitforVisibilityOfWebElement(search, "visibility of Search");
			if(!executor.isElementPresent(bySearch)){
				executor.click(pm, "click on PM");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
						"Invisibility of spinner");
				executor.softWaitforVisibilityOfWebElement(search, "visibility of Search");
			}
			executor.sendkeys(search, id, "SendKeys value:" + id);
			executor.sendkeys(search, Keys.ENTER, "SendKeys value: ENTER");
			executor.softWaitforElementToBeClickable(updateButton, "Wait for Update Button");
			executor.click(updateButton, "Click on Update Button");
			executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");

			if (executor.isElementPresent(getCrmloader())) {
				executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");
			}
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of Crmloader");
			// executor.softWaitforVisibilityOfWebElement(getNoCRMLoader(),"Visibility
			// of CRM Status");
			executor.softWaitforVisibilityOfWebElement(wellDoneNotification, "Well Done alert is displayed");
			executor.softWaitforInvisibilityOFWebElement(wellDoneNotification, "Well Done alert is Invisible");
		} else {
			executor.click(cancelButton, "Click on Cancel Button");
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
		}

		if (executor.isElementPresent(byCancelButton)) {
			executor.click(cancelButton, "Click on Cancel Button");
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
		}
		int i = 0;
		while (executor.isElementPresent(byOverlayLoader) && i < 5) {
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
			i++;
		}

		if (flag.equalsIgnoreCase("yes"))
			return id;
		else {
			return str.substring(str.indexOf("(") + 1, str.indexOf("@")) + "@cactusglobal.com";
		}
	}

	public String clickOnCMEditButtonAndGetCMID(String flag, String id) {
		executor.click(editCM, "Click on CM Edit");
		executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
		executor.softWaitforVisibilityOfWebElement(cm, "cm");
		String str = cm.getText();

		if (flag.equalsIgnoreCase("yes")) {
			executor.softWaitforElementToBeClickable(cm, "Wait for cm EditButton");
			executor.click(cm, "click on CM");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
					"Invisibility of spinner");
			executor.softWaitforVisibilityOfWebElement(search, "visibility of Search");
			executor.sendkeys(search, id, "SendKeys value:" + id);
			executor.sendkeys(search, Keys.ENTER, "SendKeys value: ENTER");
			executor.click(updateButton, "Click on Update Button");

			executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");
			if (executor.isElementPresent(getCrmloader())) {
				executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");
			}
			executor.softWaitforVisibilityOfWebElement(wellDoneNotification, "Well Done alert is displayed");
			executor.softWaitforInvisibilityOFWebElement(wellDoneNotification, "Well Done alert is Invisible");
		} else {
			executor.click(cancelButton, "Click on Cancel Button");
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
		}

		if (executor.isElementPresent(byCancelButton)) {
			executor.click(cancelButton, "Click on Cancel Button");
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
		}

		int i = 0;
		while (executor.isElementPresent(byOverlayLoader) && i < 5) {
			executor.softWaitforInvisibilityOFWebElement(byOverlayLoader, "Invisibility of overlay loader");
			i++;
		}

		if (flag.equalsIgnoreCase("yes"))
			return id;
		else {
			return str.substring(str.indexOf("(") + 1, str.indexOf("@")) + "@cactusglobal.com";
		}
	}

}
