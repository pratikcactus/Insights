package com.cactus.insights.pages;

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

public class ReviewAndConfirmFormPage extends AbstractPage {
	//private final WebDriver driver;

	private Executioner executor;
	private ExtentTest test;
	private Util util;

	@FindBy(xpath = ".//*[@class='step-link-04']")
	WebElement reviewAndConfirm;

	//@FindBy(xpath = "//*[@id='confirm_div_msg']//*[@onclick='confirm_order(true)']")
	@FindBy(xpath = "//*[contains(@style,'block')]/div/*[@onclick='confirm_order(true)']")
	WebElement confirmOrderDiv;

	public ReviewAndConfirmFormPage(WebDriver driver, ExtentTest test,WebDriverWait wait) {
		super(driver, wait, test);
		//this.driver = driver;
		this.test = test;
		executor = new Executioner(driver, test,wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(reviewAndConfirm, "Wait until Review And Confirm Element is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
		/*if (!Config.SERVICE_PAGE_TITLE.toLowerCase().equals(driver.getTitle().trim().toLowerCase())) {
			throw new IllegalStateException("This is not  the Check Services Page");
		}
		*/
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the Review And Confirm Page");
		}
	}

	public EnquirySuccessPage clickonConfirm() {
		executor.softWaitforElementToBeClickable(confirmOrderDiv, "Confirm");
		executor.click(confirmOrderDiv, "Click on Confirm Button");
		return new EnquirySuccessPage(driver, test,wait);
	}

}
