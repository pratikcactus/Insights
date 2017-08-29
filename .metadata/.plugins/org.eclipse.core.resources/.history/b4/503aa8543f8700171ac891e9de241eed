package com.cactus.insights.pages;

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

public class CheckPricingFormPage {//extends AbstractPage 
	//private final WebDriver driver;

	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = ".//*[@class='step-link-02']")
	WebElement checkPricing;

	@FindBy(xpath = "//div[@class='price-plans-recommended']//ancestor::tr//button[contains(@onclick,'no')]")
	WebElement proceedButton;
	
	By loader=By.xpath(".//*[@id='status' and @style='display: block;']");

	public CheckPricingFormPage(WebDriver driver, ExtentTest test,WebDriverWait wait) {
		//super(driver,wait);
		this.driver = driver;
		this.wait=wait;
		this.test = test;
		executor = new Executioner(driver, test,wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(checkPricing, "Wait until Check Pricing Element is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getLoader()),
				"Invisibility of spinner");
		/*if (!Config.SERVICE_PAGE_TITLE.toLowerCase().equals(driver.getTitle().trim().toLowerCase())) {
			throw new IllegalStateException("This is not  the Check Services Page");
		}
		*/
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Check Services  Page");
		}
	}
	
	public By getLoader() {
		return loader;
	}

	public UploadManuscriptFormPage clickonProceed() {
		executor.softWaitforElementToBeClickable(proceedButton, "Proceed");
		executor.click(proceedButton, "Click on Proceed Button");
		return new UploadManuscriptFormPage(driver, test,wait);
	}

}
