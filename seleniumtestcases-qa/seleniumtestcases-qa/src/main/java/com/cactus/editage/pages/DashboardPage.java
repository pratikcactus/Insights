package com.cactus.editage.pages;

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

public class DashboardPage { //extends AbstractPage 
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;


	@FindBy(xpath = ".//*[@id='logo']/a")
	WebElement logo;
	
	@FindBy(xpath = "//span[@class='dashboardtabsHeader']//a[@href='/submit-jobs/add/enquiry' or @href='/submit-jobs-existing-client-form' ]")
	WebElement SubmitJobButton;
	
	By loader=By.xpath(".//*[@id='status' and @style='display: block;']");
	
	public DashboardPage(WebDriver driver, ExtentTest test,WebDriverWait wait) {
		//super(driver,wait);
		this.driver = driver;
		this.wait=wait;
		this.test = test;
		executor = new Executioner(driver, test,wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(logo, "Wait until Check Logo is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getLoader()),
				"Invisibility of spinner");
		
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Check Services  Page");
		}
	}
	
	public By getLoader() {
		return loader;
	}
	
	public SelectServiceFormPage clickonSubmitJobAndNavigateToServicesPage(){
		executor.softWaitforElementToBeClickable(SubmitJobButton, "Wait for SubmitJobButton");
		executor.click(SubmitJobButton, "SubmitJobButton");
		
		return new SelectServiceFormPage(driver, test, wait);
		
	}


	

}