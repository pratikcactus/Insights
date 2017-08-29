package com.cactus.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.cactus.executor.Executioner;
import com.cactus.inits.Config;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class RejectQuotePage extends EnquiryAndJobViewPage {
	//private ExtentTest test;
	private Executioner executor;

	@FindBy(xpath = "//select[@id='reject_reason']")
	WebElement rejectReasonDropdown;

	@FindBy(xpath = ".//button[@id='reject-quote-no-email_save']")
	WebElement rejectQuoteNoEmailSendButton;
	
	@FindBy(xpath=".//div[@id='action_block']//div[contains(@class,'alert')]//ul[@id='alert-list']/li")
	WebElement wellDoneAlert;
	
	public RejectQuotePage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		this.test = test;
		this.executor = new Executioner(driver, test, wait);

		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.CRM_PAGE_TITLE),
				"Wait for Title");
		executor.softWaitforVisibilityOfWebElement(logo, "Wait until logo is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.CRM_PAGE_TITLE.toLowerCase())) {
			executor.addStatus(LogStatus.FAIL, "This is not  the  CRM Dashboard Page");
			throw new IllegalStateException("This is not  the  CRM Dashboard Page");
		}
	}

	public WebElement getRejectReasonDropdown() {
		return rejectReasonDropdown;
	}
	
	
	public WebElement getRejectQuoteNoEmailSendButton() {
		return rejectQuoteNoEmailSendButton;
	}
	
	public void selectReasonAndReject(String rejectReason){
		executor.selectFromDropDown(rejectReasonDropdown, "visibleText", rejectReason);
		executor.click(rejectQuoteNoEmailSendButton, "No Email");
		executor.softWaitforVisibilityOfWebElement(wellDoneAlert, "Well Done");
	}


}
