package com.cactus.editage.pages;

import java.util.Map;

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

public class CompleteYourProfilePage {// extends AbstractPage {
	// private final WebDriver driver;

	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = ".//*[@id='efl-fc']/h1")
	WebElement profileHeader;
	@FindBy(xpath = ".//*[@id='txt-dob']")
	WebElement DOB;
	@FindBy(xpath = "//*[@id='txt-cell-ph']")
	WebElement CellNumber;
	@FindBy(xpath = "//*[@id='txt-alt-email']")
	WebElement AlternetEmail;
	@FindBy(xpath = "//*[@id='txt-org']")
	WebElement Organization;
	@FindBy(xpath = ".//*[@id='txt-department']")
	WebElement Department;
	@FindBy(xpath = ".//*[@id='txt-job-title']")
	WebElement JobTitle;
	@FindBy(xpath = "//*[@id='txt-org-url']")
	WebElement OrganizationURL;
	@FindBy(xpath = "//*[@id='txt-zip-code']")
	WebElement Zipcode;
	@FindBy(xpath = "//*[@id='txt-state']")
	WebElement State;
	@FindBy(xpath = "//*[@id='txt-city']")
	WebElement City;
	@FindBy(xpath = "//*[@id='txt-street']")
	WebElement street;
	@FindBy(xpath = "//*[@id='efl-pro-comp-btn']")
	WebElement DoneButton;
	@FindBy(id = "skip-id")
	WebElement SkipForNow;

	By loader = By.xpath(".//*[@id='status' and @style='display: block;']");

	public CompleteYourProfilePage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(profileHeader, "Wait until Header Element is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getLoader()),
				"Invisibility of spinner");
		
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the Success Page");
		}
	}

	public By getLoader() {
		return loader;
	}
	
	public WebElement getSkipForNow() {
		return SkipForNow;
	}

	public void updateUserProfile(Map<String, String> testData) {
		executor.softWaitforVisibilityOfWebElement(DOB, "Element is displayed");
		executor.type(DOB, testData.get("DOB"), "Enter DOB");
		executor.type(AlternetEmail, testData.get("AlternateEmail"), "Enter AlternetEmail");
		executor.type(Organization, testData.get("Organization"), "Enter Organization");
		executor.type(CellNumber, testData.get("CellPhone"), "Enter CellNumber");
		executor.type(Department, testData.get("Department"), "Enter Department");
		executor.type(JobTitle, testData.get("JobTitle"), "Enter JobTitle");
		executor.type(OrganizationURL, testData.get("OrganizationURL"), "Enter OrganizationURL");
		executor.type(Zipcode, testData.get("ZipCode"), "Enter Zipcode");
		executor.type(State, testData.get("State"), "Enter State");
		executor.type(City, testData.get("City"), "Enter City");
		executor.type(street, testData.get("Street"), "Enter street");

	}

	public void clickOnDoneButton() {
		executor.softWaitforElementToBeClickable(DoneButton, "Done Button");
		executor.click(DoneButton, "Done button");

	}

	public void clickOnSkip() {
		executor.softWaitforElementToBeClickable(SkipForNow, "SkipForNow");
		executor.click(SkipForNow, "SkipForNow Link");
		executor.softWaitforInvisibilityOFWebElement(getLoader(), "Invisibility of Loader");
		if (executor.isElementPresent(getLoader())) {
			executor.softWaitforInvisibilityOFWebElement(getLoader(), "Invisibility of Loader");
		}
	}

}
