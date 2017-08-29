package com.cactus.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.cactus.executor.Executioner;
import com.cactus.inits.AbstractPage;
import com.cactus.inits.Config;

import com.cactus.whiteboard.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JobViewPage extends AbstractPage {
	private ExtentTest test;
	private Executioner executor;


	@FindBy(xpath = "//*[@class='fa fa-power-off']")
	WebElement signOutLink;

	@FindBy(xpath = ".//*[@class='logo']")
	WebElement logo;
	
	@FindBy(xpath = ".//div[@id='me-info-header']//button[contains(.,'More')]")
	WebElement moreDropdownButton;
	
	@FindBy(xpath = ".//div[@id='me-info-header']//ul[@class='dropdown-menu']//a[@action-name='reject-quote']")
	WebElement rejectQuoteTab;
	
	@FindBy(xpath = ".//*[@id='enquiry_title']/span")
	WebElement enquiryTitle;
	
	@FindBy(xpath = "//*[@id='me-info-header']//button[@title='Confirm job']")
	WebElement confirmJob ;

	public JobViewPage(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait,test);
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
	

	public void clickOnSignOut() {
		executor.softWaitforVisibilityOfWebElement(signOutLink, "Visibility of SignOutLink");
		executor.click(signOutLink, "Click on SignOutLink");
		executor.softWaitforInvisibilityOFWebElement(signOutLink, "Invisibility of SignOutLink");
		new LoginPage(driver, wait, test);
		
	}
	
	public RejectQuotePage clickOnMoreAndNavigateToRejectQuotePage(){
		executor.click(moreDropdownButton, "MoreDropdown");
		executor.click(rejectQuoteTab, "getRejectQuoteTab");
		return new RejectQuotePage(driver, wait, test);
	}
	
	public String getEnquiryCode(){
		executor.softWaitforVisibilityOfWebElement(enquiryTitle, "Enquiry title");
		return enquiryTitle.getText().trim();
	}
	
	public ConfirmJobPage clickJobConfirmAndNavigateToConfirmJobPage(){
		executor.click(confirmJob, "Click on Confirm Job");
		return new ConfirmJobPage(driver, wait, test);
	}

}
