package com.cactus.insights.pages;


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

public class UploadManuscriptFormPage {//extends AbstractPage {
	// private final WebDriver driver;

	private Executioner executor;
	private ExtentTest test;
	private Util util;
	
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = ".//*[@class='step-link-03']")
	WebElement uploadManuscript;

	@FindBy(xpath = "//input[@id='field_enquiry_subjectarea-value-main']")
	WebElement subjectAreaManuscript;

	@FindBy(xpath = "//input[@id='field_enq_ex_formatng_info-No']/../span")
	WebElement journalFormattingNoButton;

	@FindBy(xpath = "//input[@id='field_enq_ex_formatng_info-Yes']/../span")
	WebElement journalFormattingYesButton;

	@FindBy(xpath = "//span[@class='gentleselect-label']")
	WebElement typeOfManuscript;

	@FindBy(id = "field_enq_ex_type_of_doc-nid")
	WebElement selectManuscript;

	@FindBy(xpath = "//label[@for='ame']")
	WebElement americanLanguage;

	@FindBy(xpath = "//label[@for='bre']")
	WebElement britishLanguage;

	@FindBy(xpath = "(.//input[@type='file'])[1]")
	WebElement browseAndUploadFileButton;

	@FindBy(xpath = "(.//input[@type='file'])[2]")
	WebElement browseAndUploadReferenceFileButton;

	@FindBy(xpath = ".//*[@id='field_enquiry_client_inst-value']")
	WebElement otherInstructionForEdit;

	@FindBy(xpath = "//input[@id='field_client_profile_firstname-value']")
	WebElement Firstname;

	@FindBy(xpath = ".//input[@id='field_client_profile_lastname-value']")
	WebElement Lastname;

	@FindBy(xpath = ".//input[@id='field_client_profile_pri_email-email']")
	WebElement PrimeryEmailAddress;

	@FindBy(xpath = ".//input[@id='reEnterEmail']")
	WebElement ConfirmEmailAddress;

	@FindBy(xpath = ".//select[@id='scCountry']")
	WebElement Country;

	@FindBy(xpath = ".//input[@id='field_client_profile_primary_ph-number']")
	WebElement Primary_Conact_Number;

	@FindBy(xpath = ".//select[@id='field_client_profile_ref_source-value']")
	WebElement How_Did_You_Hear_About_Us;

	@FindBy(xpath = ".//input[@id='field_psit_engus_invoice_nm-value']")
	WebElement Name_On_Invoice;

	@FindBy(xpath = ".//*[@id='field_client_profile_salutation-nid']")
	WebElement Salutation;

	@FindBy(xpath = "//*[@id='paymentInstructions']")
	WebElement PaymentInstructions;

	@FindBy(xpath = "//*[@id='add_details_section']/div//button[@onclick='confirm_order()']")
	WebElement ProceedConfirmButton;

	@FindBy(xpath = "//*[@id='field_enq_ex_journal_formatg-value']")
	WebElement JournalURLTextbox;

	@FindBy(xpath = "//input[@id='field_enq_ex_can_we_start-Yes']/../span")
	WebElement YesStartWorkOnYourRequestButton;

	@FindBy(xpath = "//input[@id='field_enq_ex_can_we_start-No']/../span")
	WebElement NoStartWorkOnYourRequestButton;

	@FindBy(xpath = "//a[@rel='subject-area']")
	WebElement SubjectAreaOfYourManuscriptLink;

	@FindBy(xpath = ".//div[@id='subject-area']//button")
	WebElement ContinueBtn;
	
	@FindBy(xpath = ".//*[@id='field_client_profile_org-value']")
	WebElement Agency_Org;
	
	@FindBy(xpath = ".//*[@id='field_client_profile_department-value']")
	WebElement AffiliationDegreeUniversityDept;
	
	@FindBy(xpath = ".//*[@id='field_client_profile_native_firstName-value']")
	WebElement FirstNameInMarket;
	
	@FindBy(xpath = ".//*[@id='field_client_profile_native_lastName-value']")
	WebElement LastNameInMarket;
	
	@FindBy(xpath = "//*[@id='field_cp_job_description-nid']")
	WebElement jobDecriptionSelect;
	
	By loader=By.xpath(".//*[@id='status' and @style='display: block;']");

	public UploadManuscriptFormPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		//super(driver, wait);

		this.driver = driver;
		this.wait=wait;
		
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(uploadManuscript,
				"Wait until Upload Manuscript Element is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getLoader()),
				"Invisibility of spinner");
		/*if (!Config.SERVICE_PAGE_TITLE.toLowerCase().equals(driver.getTitle().trim().toLowerCase())) {
			throw new IllegalStateException("This is not  the Upload Manuscript Page");
		}*/
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the Upload Manuscript Page");
		}
	}
	
	public By getLoader() {
		return loader;
	}

	public void fillManuscriptForm(Map<String, String> testData) {
		if (testData.get("enterSubjectAreaManuscript ").toLowerCase().contains("text")) {
			executor.type(subjectAreaManuscript, testData.get("subjectAreaManuscriptByTextBox"), "Enter subject Area");
		} else {
			executor.click(SubjectAreaOfYourManuscriptLink, "SubjectAreaOfYourManuscriptLink");
			selectSubjectAreaManuscriptFromPopup(testData.get("subjectAreaManuscriptByPopup"));
		}

		if (testData.get("journalFormatting").equalsIgnoreCase("Yes")) {
			executor.click(journalFormattingYesButton, "Click on Journal formattin Yes Button");
			executor.type(JournalURLTextbox, testData.get("JournalURL"), testData.get("JournalURL"));

		} else {
			executor.click(journalFormattingNoButton, "Click on Journal formattin No Button");
		}

		clickOnStartWorkButtonOnRequestButton(testData.get("RequestImmediatelyStartWork"));

		if (executor.isElementExist(typeOfManuscript)) {
			executor.click(typeOfManuscript, "Click on Type of Manuscript");
			WebElement menuscript = driver
					.findElement(By.xpath(".//ul/li[contains(text(),'" + testData.get("typeOfManuscript") + "')]"));
			executor.actionClick(menuscript,"menuscript");
			// executor.selectFromDropDown(selectManuscript, "visibleText",
			// testData.get("typeOfManuscript"));
		}
		String filePath = util.getFileAbolutePath(testData.get("uploadFile"));
		executor.sendkeys(browseAndUploadFileButton, filePath, "Upload Files");

		executor.type(otherInstructionForEdit, testData.get("optionForEditDocument"), "Data");
		String userEmail = enterPersonalAndContactInformation(testData);

	}

	public void selectSubjectAreaManuscriptFromPopup(String value) {
		WebElement SubjectArea = driver.findElement(By.xpath(".//input[@label_val='" + value + "']/../span"));
		executor.actionClick(SubjectArea,"SubjectArea");
		executor.click(ContinueBtn, "Click on continue");
	}

	public String enterPersonalAndContactInformation(Map<String,String> testData) {
		if(executor.isElementExist(FirstNameInMarket)){
			executor.type(FirstNameInMarket, testData.get("FirstNameMarket"), "FirstNameInMarket");
		}
		if(executor.isElementExist(LastNameInMarket)){
			executor.type(LastNameInMarket, testData.get("LastNameMarket"), "LastNameInMarket");
		}
		
		String UserEmail = util.getNewEmailId();
		executor.selectFromDropDown(Salutation, "visibleText", testData.get("Salutation"));
		executor.type(Firstname, testData.get("FirstName"), "FirstName");
		executor.type(Lastname, testData.get("LastName"), "LastName");
		executor.type(PrimeryEmailAddress, UserEmail, "UserEmail");
		executor.type(ConfirmEmailAddress, UserEmail, "USerEmail");
		executor.selectFromDropDown(Country, "visibleText", testData.get("Country"));
		executor.type(Primary_Conact_Number, testData.get("PrimaryContactNumber"), "Primary_Conact_Number");
		if(executor.isElementExist(Agency_Org)){
			executor.type(Agency_Org, testData.get("Agency/Org"), "Agency/Org");
		}
		if(executor.isElementExist(AffiliationDegreeUniversityDept)){
			executor.type(AffiliationDegreeUniversityDept, testData.get("Dept"), "Dept");
		}
		if(executor.isElementExist(jobDecriptionSelect)){
			executor.selectFromDropDown(jobDecriptionSelect, "visibleText", testData.get("JobDescription"));
		}
		
		executor.selectFromDropDown(How_Did_You_Hear_About_Us, "visibleText", testData.get("HearAboutUs"));
		
		return UserEmail;
	}

	public ReviewAndConfirmFormPage clickOnConfirm() {
		executor.click(ProceedConfirmButton, "Click on Proceed To Confirm");
		return new ReviewAndConfirmFormPage(driver, test, wait);

	}

	public void clickOnStartWorkButtonOnRequestButton(String value) {
		if (value.contains("Yes"))
			executor.click(YesStartWorkOnYourRequestButton, "YesStartWorkOnYourRequestButton");
		else
			executor.click(NoStartWorkOnYourRequestButton, "NoStartWorkOnYourRequestButton");
	}
}
