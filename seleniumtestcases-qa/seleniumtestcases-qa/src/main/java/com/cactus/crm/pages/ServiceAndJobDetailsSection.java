package com.cactus.crm.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class ServiceAndJobDetailsSection extends AddEnquiryPage {
	WebElement service_id;
	WebElement field_subject_area;
	WebElement field_enq_ex_journal_formatg;

	@FindBy(xpath = ".//*[@id='field_preferred_plan_widget']//button")
	WebElement field_preferred_plan_widget;

	WebElement field_enq_ex_desired_delivery;
	WebElement field_enq_ex_plan;
	WebElement field_enq_ex_fastest_cheapest_cheapest_plan;
	WebElement field_enq_ex_fastest_cheapest_fastest_plan;

	@FindBy(xpath = ".//*[.='Service and job information']")
	WebElement headerServiceAndJobInformation;

	@FindBy(xpath = ".//input[@id='skip-sa-2']")
	WebElement determineArea;

	@FindBy(xpath = ".//input[@id='field_specialized_subject_area']")
	WebElement specializedSubjectArea;

	@FindBy(xpath = "//*[@id='field_preferred_plan_widget']//div[contains(@class,'dg-datetimepicker-icon')]")
	WebElement dateButtonService;

	@FindBy(xpath = ".//*[@title='Close the picker']//span")
	WebElement proceedDateButton;

	@FindBy(xpath = ".//input[@id='field_enq_ex_publish_manuscript']")
	WebElement dateInputManuscript;

	@FindBys(value = { @FindBy(xpath = "//tbody//tr//td[@class='day']") })
	List<WebElement> listDatesManuscript;

	@FindBy(xpath = "//select[@id='field_enq_ex_narrator_speed']")
	WebElement narratorSpeed;

	@FindBys(value = {
			@FindBy(xpath = "//*[@id='field_preferred_plan_widget']//div[contains(@class,'two-month-datepicker')]//table[@class='table-condensed']//tbody//tr//td[@class='day rightDate']") })
	List<WebElement> listDatesService;

	By byPreferredPlan = By.xpath(".//*[@id='field_preferred_plan_widget']//button");
	By byJournalFormat = By.id("field_enq_ex_journal_formatg");
	By specializedSubjectAreaBy = By.xpath(".//input[@id='field_specialized_subject_area']");
	By byTargetAudience = By.xpath("//input[@id='field_enq_ex_target_audience']");
	By byWorkImmediately = By.xpath(".//*[contains(@id,'field-enq-ex-can-we-start')]");
	By byTypeOfDoc = By.xpath("//select[@id='field_enq_ex_type_of_doc']");
	By byTitle = By.xpath(".//input[@id='field_enq_ex_title']");
	By byDeliveryDateAndPlanPreference = By.id("field_preferred_plan_widget");
	By byPublishManuscript = By.id("field_enq_ex_publish_manuscript");
	By byBuildYourPackage = By.id("field_enq_ex_custom_pack");
	By byLanguageStyle = By.id("field_language_style");
	By byPreferredJournalPublication = By.xpath(".//input[@id='field_enq_ex_journal_name']");
	By byJournalFormatting = By.id("field_enq_ex_formatng_info");

	By subjectAreaContainer = By.id("field_subject_area_container");
	By byExpectedCount = By.xpath(".//input[@id='field_enq_ex_expected_count']");
	By byAudioType = By.xpath("//select[@id='field_enq_ex_audio_type']");
	By byReferenceMaterials = By.id("field_enq_ex_ref_material_prvd");
	By byTranscriptPurpose = By.id("field_enq_ex_transcript_purpose");
	By bySummarizeDocument = By.xpath("//select[@id='field_enq_ex_doc_summarize']");
	By byExtentToSummarize = By.xpath("//input[@id='field_enq_ex_dpnd_doc_summarize']");
	By bySummaryFormat = By.xpath("//select[@id='field_enq_ex_summery_format']");
	By byPreferredTranscriptFormat = By.xpath("//select[@id='field_enq_ex_transc_format']");
	By byAudioLanguage = By.xpath("//select[@id='field_enq_ex_audio_lang']");
	By byLanguageToBeTranscribed = By.xpath("//select[@id='field_enq_ex_transcribed_lang']");
	By byPreferredNarratedType = By.id("field_enq_ex_pre_narrator_type");
	By byEndUseOfNarrationAudio = By.xpath("//select[@id='field_enq_ex_narration_audio']");
	By byNarratorSpeed = By.id("field_enq_ex_narrator_speed");
	By byVoicePreference = By.xpath("//select[@id='field_enq_ex_voice_preference']");
	By byReceiveAQuotation = By.id("field_enq_ex_quote_service");
	By byPosterPrinting = By.id("field_enq_ex_poster_printing");
	By byFactorRange = By.xpath(".//input[@id='field_enq_ex_impact_factor']");
	By byDesiredDelivery = By.id("field_enq_ex_desired_delivery");
	By byIsItMRE = By.id("field_enq_ex_first_mre_free");

	By byProceedDateButton = By.xpath("//*[normalize-space(.)='Proceed']");
	By byActive = By.xpath("//*[contains(@class='active')]");
	By byPlan = By.id("field_enq_ex_plan");

	public ServiceAndJobDetailsSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(service_id, "Wait until service_id is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
	}

	public void enterServiceAndJobDetails(Map<String, String> testData) {
		executor.moveToElement(service_id);
		executor.selectFromDropDown(service_id, "visbleText", testData.get("Services"));

		int i = 0;
		while (executor.isElementPresent(getCrmloader()) && i < 5) {
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of CRM Loader");
			i++;
		}
		executor.moveToElement(headerServiceAndJobInformation);
		//executor.scrollDown();
		executor.pause(1);
		
		questionActions(testData);

		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of CRM Loader");

		// Select subject area
		executor.type(field_subject_area, testData.get("SubjectArea"), "Enter subject area");
		executor.sendkeys(field_subject_area, Keys.TAB, "Send Keyboard keys");
		if (testData.get("UnableToDetermineSubjectArea").equalsIgnoreCase("yes")) {
			executor.softWaitforElementToBeClickable(determineArea, "Wait for determineArea to be clickable");
			executor.click(determineArea, "Select Determine subject area");
		}

		if (executor.isElementPresent(specializedSubjectAreaBy)) {
			executor.type(specializedSubjectArea, "CactusTest", "Enter specialized Subject area");
		}
		// Language style
		executor.clickOnRadioBox("id", "field_language_style", testData.get("LanguageStyle"), "Select Language Style");

		// Delivery date / plan preference
		if (testData.get("SelectDateTimeDelivery").equalsIgnoreCase("yes")) {
			selectPlanDateSpeed(testData.get("DesiredDateTimeDelivery"), "current",
					testData.get("preferredDeliveryPlan"), testData.get("CheapestOrFastest"));
		}

	}

	public void selectPlanDateSpeed(String type, String date, String plan, String CheapestOrFastest) {
		if (executor.isElementPresent(byPreferredPlan)) {

			executor.click(field_preferred_plan_widget, "Click on Delivery Date and plan preference");
			if (type.equalsIgnoreCase("date")) {
				executor.softWaitforElementToBeClickable(field_enq_ex_desired_delivery,
						"Wait for element to be clickable");
				enterDeliveryDateTime(dateButtonService, listDatesService);

			} else if (type.equalsIgnoreCase("plan")) {
				// preferredDeliveryPlan
				executor.softWaitforElementToBeClickable(field_enq_ex_plan, "Wait for element to be clickable");

				boolean flag = executor.checkValueAndSelectDropDown(field_enq_ex_plan, "visibletext", plan);
				if (!flag) {
					String id = executor.getAttributeValue(byPlan, "id");
					executor.selectInDropDown(id, plan);
					executor.sendkeys(field_enq_ex_plan, Keys.ENTER, "Send Enter Keys on plan");

				}

			} else {
				// Cheapest or Fastest plan
				if (CheapestOrFastest.equalsIgnoreCase("cheapest")) {
					executor.softWaitforElementToBeClickable(field_enq_ex_fastest_cheapest_cheapest_plan,
							"Wait for element to be clickable");
					executor.click(field_enq_ex_fastest_cheapest_cheapest_plan, "Click on cheapest plan");
				} else {
					executor.softWaitforElementToBeClickable(field_enq_ex_fastest_cheapest_fastest_plan,
							"Wait for element to be clickable");
					executor.click(field_enq_ex_fastest_cheapest_fastest_plan, "Click on fastest plan");
				}
			}
		}
	}

	public void enterDeliveryDateTime1(WebElement dateButton, List<WebElement> liDates) {
		executor.actionClick(dateButton, "DateButton");
		executor.mouseHover(dateButton);
		liDates.get(liDates.size() - 1).click();

	}

	public void enterDeliveryDateTime(WebElement dateButton, List<WebElement> liDates) {
		String actualDateValue = field_enq_ex_desired_delivery.getAttribute("value");
		String expDateValue = "30/10/2017 00:00";
		executor.sendkeys(field_enq_ex_desired_delivery, expDateValue, "Data send" + expDateValue);

		actualDateValue = field_enq_ex_desired_delivery.getAttribute("value");

		if (actualDateValue.equalsIgnoreCase("")) {
			executor.softWaitforElementToBeClickable(dateButton, "wait for Date");
			executor.actionClick(dateButton, "DateButton");
			executor.softWaitforVisibilityOfWebElement(byProceedDateButton, "Click on Proceed Date Button");
			executor.mouseHover(dateButton);
			int elNo = liDates.size() - 1;
			executor.softWaitforElementToBeClickable(liDates.get(elNo), "wait for particular Date");
			WebElement el = liDates.get(elNo);
			executor.moveToElement(el);
			executor.click(el, "Select Date");
			executor.softWaitforCondition(ExpectedConditions.stalenessOf(el), "element is selected");
			executor.softWaitforVisibilityOfWebElement(byActive, "Wait for byActive element");

			if (executor.isElementPresent(byProceedDateButton)) {
				executor.softWaitforElementToBeClickable(byProceedDateButton,
						"Element to be clickable byProceedDateButton");
				executor.actionClick(byProceedDateButton, "Click on Proceed Date Button");
			}

		}

	}

	public void questionActions(Map<String, String> testData) {
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
				"Invisibility of spinner");

		/* Who is your target audience? */
		if (executor.isElementPresent(byTargetAudience)) {
			executor.type(byTargetAudience, testData.get("TargetAudience"), "Enter target audience");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		/* Can we start work on your request immediately? */
		if (executor.isElementPresent(byWorkImmediately)) {
			String id = executor.getAttributeValue(byWorkImmediately, "id");
			executor.moveToElement(byWorkImmediately);
			executor.clickOnRequestedElement("id", id, testData.get("WorkRequestImmidiately"),
					"Click on Work Immediately");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
			
		}

		/* Do you want first MR to be free? */
		if (executor.isElementPresent(byIsItMRE)) {
			String id = executor.getAttributeValue(byIsItMRE, "id");
			executor.clickOnRequestedElement("id", id, testData.get("FirstMREFree"), "Click on FirstMREFree");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Do you require journal formatting for your document?
		if (executor.isElementPresent(byJournalFormatting) || executor.isElementPresent(byJournalFormat)) {
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
			String flag = testData.get("RequireJournalFormatting");
			By byId = By.xpath(".//*[contains(@id,'field-enq-ex-formatng-info')]");
			if (executor.isElementPresent(byId)) {
				String id = executor.getAttributeValue(byId, "id");
				executor.softWaitforElementToBeClickable(byId,"Journal formating to be clickable");
				executor.clickOnRequestedElement("id", id, flag, "Click on Journal formatting");
			}

			// journalNameOrURL
			if (flag.equalsIgnoreCase("yes")
					|| executor.isElementDisplayed(field_enq_ex_journal_formatg, "If Journal URL Is displayed")) {
				executor.softWaitforElementToBeClickable(field_enq_ex_journal_formatg, "JournalURL");
				executor.sendkeys(field_enq_ex_journal_formatg, testData.get("JournalURL"), "Journal URL");
			}
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Type of document
		if (executor.isElementPresent(byTypeOfDoc)) {
			executor.selectFromDropDownByAttribute(byTypeOfDoc, "title", testData.get("TypeOfDocument"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Title
		if (executor.isElementPresent(byTitle)) {
			executor.sendkeys(byTitle, testData.get("Title"), "title");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// factor Range
		if (executor.isElementPresent(byFactorRange)) {
			executor.sendkeys(byFactorRange, testData.get("FactorRange"), "factorRange");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// By when you would like to publish the manuscript?
		if (executor.isElementPresent(byPublishManuscript)) {
			executor.sendkeys(dateInputManuscript, Keys.PAGE_DOWN, "Page Down");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// Build your package
		if (executor.isElementPresent(byBuildYourPackage)) {
			String id = executor.getAttributeValue(byBuildYourPackage, "id");
			executor.clickOnRequestedElement("id", id, testData.get("BuildYourPackage"), "Build Your Package");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// The preferred journal for publication
		if (executor.isElementPresent(byPreferredJournalPublication)) {
			executor.sendkeys(byPreferredJournalPublication, testData.get("PreferredJournalForPublication"),
					"preferredJournalPublication");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// Expected no./count/duration of copies/images/words/audio
		if (executor.isElementPresent(byExpectedCount)) {
			executor.sendkeys(byExpectedCount, testData.get("ExpectedNoCountDurationOfCopiesImagesWordsAudio"),
					"expectedNoCountDurationOfCopiesImagesWordsAudio");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Please select the type of audio file
		if (executor.isElementPresent(byAudioType)) {
			executor.selectFromDropDown(byAudioType, "visibletext", testData.get("TypeOfAudioFile"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Please tell us what reference materials you can provide
		if (executor.isElementPresent(byReferenceMaterials)) {
			String id = executor.getAttributeValue(byReferenceMaterials, "id");
			executor.clickOnRequestedElement("id", id, testData.get("ReferenceMaterials"),
					"Reference Materials:" + testData.get("ReferenceMaterials"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Purpose of the transcript
		if (executor.isElementPresent(byTranscriptPurpose)) {
			String id = executor.getAttributeValue(byTranscriptPurpose, "id");
			executor.clickOnRequestedElement("id", id, testData.get("PurposeOfTheTranscript"), "Purpose of Transcript");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// Please choose on what basis you would like us to summarize your
		// document
		if (executor.isElementPresent(bySummarizeDocument)) {
			executor.selectFromDropDown(bySummarizeDocument, "visibletext", testData.get("SummarizeYourDoc"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");

		}

		// Please specify the extent to which you would like us to summarize
		if (executor.isElementPresent(byExtentToSummarize)) {
			executor.sendkeys(byExtentToSummarize, testData.get("WouldlikeToSummarize"), "WouldlikeToSummarize");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");


		}

		// Summary format
		if (executor.isElementPresent(bySummaryFormat)) {
			executor.selectFromDropDown(bySummaryFormat, "visibletext", testData.get("SummaryFormat"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Audio Language
		if (executor.isElementPresent(byAudioLanguage)) {
			executor.moveToElement(byAudioLanguage);
			String id = executor.getAttributeValue(byAudioLanguage, "id");
			executor.selectInDropDown(id, testData.get("AudioLanguage"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Language that needs to be transcribed
		if (executor.isElementPresent(byLanguageToBeTranscribed)) {
			executor.selectFromDropDown(byLanguageToBeTranscribed, "visibletext",
					testData.get("LanguageToBeTranscribed"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Preferred narrator type
		if (executor.isElementPresent(byPreferredNarratedType)) {
			String id = executor.getAttributeValue(byPreferredNarratedType, "id");
			executor.clickOnRequestedElement("id", id, testData.get("PreferredNarratorType"),
					"Preffered Narrator Type");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// What is the end use of narration audio?
		if (executor.isElementPresent(byEndUseOfNarrationAudio)) {
			executor.selectFromDropDown(byEndUseOfNarrationAudio, "visibletext",
					testData.get("EndUseOfNarrationAudio"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Preference in terms of narrator speed
		if (executor.isElementPresent(byNarratorSpeed)) {
			String id = executor.getAttributeValue(byNarratorSpeed, "id");
			executor.selectInDropDown(id, testData.get("NarratorSpeed"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Voice Preference
		if (executor.isElementPresent(byVoicePreference)) {
			executor.selectFromDropDown(byVoicePreference, "visibletext", testData.get("VoicePreference"));
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Would you like to receive a quotation for any other service?
		// (Additional charges apply)
		if (executor.isElementPresent(byReceiveAQuotation)) {
			String id = executor.getAttributeValue(byReceiveAQuotation, "id");
			executor.clickOnCheckBox("id", id, testData.get("QuotationForAnyOtherService"),
					"receive A Quotation for other services");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

		// Do you also require poster printing?
		if (executor.isElementPresent(byPosterPrinting)) {
			String id = executor.getAttributeValue(byPosterPrinting, "id");
			executor.clickOnRadioBox("id", id, testData.get("RequirePosterPrinting"), "RequirePosterPrinting");
			executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getCrmloader()),
					"Invisibility of spinner");
		}

	}

}
