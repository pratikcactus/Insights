package com.cactus.crm.pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class ClientInformationSection extends AddEnquiryPage {
	WebElement partner_id;
	WebElement user_contact;
	WebElement partner_name;

	@FindBy(xpath = "//.//*[@id='block-placement']//*[@id='block-group']")
	WebElement groupBlock;

	WebElement submission_type_self;
	WebElement submission_type_group;
	WebElement client_type_corporate;
	WebElement client_type_individual;
	WebElement client_category;

	@FindBy(xpath = "//*[@id='block-custom-client-code']//button[@data-widget='collapse']")
	WebElement customClientCodelink;

	@FindBy(xpath = ".//*[@id='custom-client-code-error']/div[@class='availability-success']")
	WebElement availabilitySuccessMessage;

	@FindBy(xpath = ".//*[@id='custom-client-code-error']/div[@class='availability-success']//span[contains(@class,'check')]")
	WebElement availabilitySuccessOrError;

	WebElement custom_client_code;

	WebElement validate_custom_code;

	@FindBy(xpath = "//div[@class='box-footer']//button[@id='get-client-details']")
	WebElement proceedButton;

	@FindBy(xpath = "//*[@id='block-client-details']//h3[@class='box-title']")
	WebElement clientSection;

	@FindBy(xpath = ".//*[.='Client information']")
	WebElement clientInformationText;

	By audioLangBy = By.xpath("//select[@id='field_enq_ex_audio_lang']");

	By bySubmission_type_self = By.id("submission_type_self");
	By byProceedButton = By.xpath("//div[@class='box-footer']//button[@id='get-client-details']");

	public ClientInformationSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		PageFactory.initElements(driver, this);
		executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisiblity of Loader");
		executor.softWaitforVisibilityOfWebElement(clientInformationText, "Wait clientInformationText is displayed");

	}

	public void enterNewClientInformation(Map<String, String> testData) {
		String val = "";
		executor.selectFromDropDown(partner_id, "visbleText", testData.get("Partner"));
		if (testData.get("ClientCategory").toLowerCase().contains("cor")) {
			executor.softWaitforElementToBeClickable(client_type_corporate,
					"Element client_type_corporate to be clickable");
			executor.click(client_type_corporate, "Select client category: Corporate");
			executor.selectFromDropDown(client_category, "visibleText", testData.get("CorporateCategory"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of CRM Loader");
		} else {
			executor.softWaitforElementToBeClickable(client_type_individual,
					"Element client_type_individual to be clickable");
			executor.click(client_type_individual, "Select client category: Individual");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of CRM Loader");
		}
		executor.softWaitforElementToBeClickable(customClientCodelink, "Element customClientCodelink to be clickable");
		executor.click(customClientCodelink, "Click on client code link");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of CRM Loader");
		int i = 0;
		do {
			val = util.getRandomStringValueUpto5Chars();
			executor.type(custom_client_code, val, "Enter Client code:" + val);
			executor.click(validate_custom_code, "click on 'Check Availability' button");
			executor.softWaitforVisibilityOfWebElement(availabilitySuccessMessage, "Visibilitly of success message");
			i++;
		} while (!executor.warningIfElementDisplayed(availabilitySuccessOrError, "Check if element is displayed")
				&& i <= 5);

		executor.softWaitforVisibilityOfWebElement(availabilitySuccessMessage, "Visibilitly of success message");
		executor.softWaitforElementToBeClickable(proceedButton, "Wait for Proceed button to be clickable");

		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of CRM Loader");

		executor.click(proceedButton, "Click on 'Proceed' button");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of CRM Loader");
		executor.softWaitforInvisibilityOFWebElement(byProceedButton, "Element Proceed button to be invisible");
		if (executor.isElementPresent(byProceedButton)) {
			executor.click(proceedButton, "Click on 'Proceed' button");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of CRM Loader");
		}
		executor.softWaitforVisibilityOfWebElement(clientSection, "Visibilitly of Client Section");
		testData.put("ClientCode", val);
	}

	public void enterExistingClientAndGroupInformation(Map<String, String> testData) {
		if (user_contact.getTagName().equalsIgnoreCase("select")) {
			executor.selectFromDropDown(user_contact, "index", "1");
		}

		enterGroupInformation(testData);
	}

	public void enterGroupInformation(Map<String, String> testData) {

		if (executor.isElementPresent(bySubmission_type_self)) {
			if (testData.get("TypeOfJobSubmission").toLowerCase().contains("self")) {
				executor.softWaitforElementToBeClickable(submission_type_self,
						"Element submission_type_self to be clickable");
				executor.click(submission_type_self, "Select Self Submission");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
						"Invisibility of CRM Loader");

				if (!submission_type_self.isSelected()) {
					executor.click(submission_type_self, "Select Self Submission");
					executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
							"Invisibility of CRM Loader");
				}
			} else {
				executor.softWaitforElementToBeClickable(submission_type_group,
						"Element submission_type_group to be clickable");
				executor.click(submission_type_group, "Select Group Submission");
				executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
						"Invisibility of CRM Loader");
			}
		}

	}

}
