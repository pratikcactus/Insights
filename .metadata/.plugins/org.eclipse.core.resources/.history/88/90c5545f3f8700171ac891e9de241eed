package com.cactus.insights.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.Config;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SelectServiceFormPage {//extends AbstractPage 

	private Executioner executor;
	private ExtentTest test;
	private Util util;
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[@id='ecf-lft-nav']//a")
	List<WebElement> servicestab;

	@FindBy(xpath = ".//*[@id='child-service']//span[@class='heading']")
	List<WebElement> subServicesHeadings;

	@FindBy(xpath = "//*[contains(@style,'display')]//input[contains(@id,'manuscript-count')]")
	WebElement displayedWordCount;

	@FindBy(xpath = "//*[contains(@style,'display')]//button[contains(@onclick,'sortcalculatedDeadline')]")
	WebElement displayedFastPlanButton;

	@FindBy(xpath = "//*[contains(@style,'display')]//button[contains(@onclick,'sortpriceRaw')]")
	WebElement displayedBudgetPlanButton;

	@FindBy(xpath = "//*[contains(@style,'display')]//button[contains(@onclick,'express_plans') and @class='ecf-box-bot-btn']")
	WebElement displayedGetAQuoteByUploadManuScriptButton;

	@FindBy(xpath = "//*[contains(@style,'display')]//button[contains(@onclick,'express_plans') and contains(@class,'tooltip')]")
	WebElement applyButton;

	public SelectServiceFormPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		//super(driver, wait);
		this.driver = driver;
		this.wait=wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforCondition(ExpectedConditions.titleContains(Config.SERVICE_PAGE_TITLE),"Wait for Title of the Page");
		/*executor.softWaitforCondition(ExpectedConditions.titleIs(Config.SERVICE_PAGE_TITLE),
				"Wait for Title of the Page");*/
		/*if (!Config.SERVICE_PAGE_TITLE.toLowerCase().equals(driver.getTitle().trim().toLowerCase())) {
			throw new IllegalStateException("This is not  the Service Page");
		}*/
		
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the Service Page");
		}
	}

	public void selectServices(String services) {
		LogStatus flag = LogStatus.FAIL;
		for (WebElement e : servicestab) {
			if (e.getText().toLowerCase().equals(services.toLowerCase())) {
				executor.click(e, "Click on Service:" + services);
				flag = LogStatus.PASS;
				break;
			}
		}
		if (flag == LogStatus.FAIL)
			executor.addStatus(flag, "No Services Available");
	}

	public void selectSubServices(String subServices) {
		LogStatus flag = LogStatus.FAIL;
		int i = 1;
		for (WebElement e : subServicesHeadings) {

			if (e.getText().toLowerCase().trim().equals(subServices.toLowerCase().trim())) {
				WebElement getQuote = driver.findElement(By.xpath("(.//*[@id='child-service']//span[@class='heading'])["
						+ i + "]/ancestor::div[contains(@class,'ecf-service-box')]//a"));
				executor.click(getQuote, "Click on Sub-Service:" + subServices);
				flag = LogStatus.PASS;
				break;
			}
			i++;
		}
		if (flag == LogStatus.FAIL)
			executor.addStatus(flag, "No Services Available");
	}

	public void enterWordCount(String wordCount) {
		executor.type(displayedWordCount, wordCount, "Enter word count" + wordCount);
	}

	public CheckPricingFormPage selectPlanAndNavigateToPricingPage(String plan) {
		selectPlan(plan);
		return new CheckPricingFormPage(driver, test, wait);
	}
	
	public UploadManuscriptFormPage selectPlanAndNavigateToUploadManuscriptPage(String plan) {
		selectPlan(plan);
		executor.click(applyButton, "click on Apply button");
		return new UploadManuscriptFormPage(driver, test, wait);
	}
	
	public void selectPlan(String plan){
		if (plan.toLowerCase().contains("fast")) {
			executor.click(displayedFastPlanButton, "Click on Fast Plan");
		} else {
			executor.click(displayedBudgetPlanButton, "Click on Budget Plan");
		}
	}

	public UploadManuscriptFormPage clickOnGetAQuoteByUploadManuscript() {
		executor.click(displayedGetAQuoteByUploadManuScriptButton, "Manuscript");
		return new UploadManuscriptFormPage(driver, test, wait);

	}

}
