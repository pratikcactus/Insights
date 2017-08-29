package com.cactus.eosapp.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class FeedbackPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(xpath = "//*[@name='outstanding']")
	WebElement outstandingFeedback;

	@FindBy(xpath = "//*[@name='acceptable']")
	WebElement acceptableFeedback;

	@FindBy(xpath = "//*[@name='not-acceptable']")
	WebElement notacceptableFeedback;

	@FindBy(xpath = "//*[@class='checkbox-title']//*[@class='main-label']")
	WebElement feedbackHeaderTitle;

	@FindBy(xpath = "//*[@class='submit-feedback']")
	WebElement submitFeedback;

	@FindBy(xpath = "//*[@class='job-quality']//h2")
	WebElement thankyouFeedbackMsg;

	@FindBy(xpath = "//*[@class='job-quality-type']")
	WebElement feedbackQualityMsg;

	@FindBy(xpath = "//*[@id='No']")
	WebElement contactFeedbackNo;

	@FindBy(xpath = "//*[@id='Yes']")
	WebElement contactFedbackYes;

	@FindBy(xpath = ".//*[@id='field_cf_not_acceptable_help_us_textarea']")
	WebElement feedbackTextMsg;

	@FindBy(xpath = ".//*[@id='field_cf_not_acceptable_revised']/div/div[1]/input")
	WebElement uploadfileFeedback1;

	@FindBy(xpath = ".//*[@id='field_cf_not_acceptable_referenc']/div/div[1]/input")
	WebElement uploadfileFeedback2;

	@FindBy(xpath = (".//*[@class='qq-upload-spinner-selector qq-upload-spinner']"))
	WebElement byFileUploadLoader;

	@FindBy(xpath = (".//*[@id='time-input2']"))
	WebElement feedbackCalender;

	@FindBy(xpath = ("//*[@class='picker-calendar']"))
	WebElement feedbackDateCell;

	@FindBy(xpath = ("//*[.='7']"))
	WebElement feedbackDatePick;

	public FeedbackPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	public void clickOnTypeOfFeedback(String feebackType) {
		WebElement element;
		if (feebackType.equalsIgnoreCase("Outstanding")) {
			element = outstandingFeedback;
		} else if (feebackType.equalsIgnoreCase("Acceptable")) {
			element = acceptableFeedback;
		} else {
			element = notacceptableFeedback;
		}
		executor.softWaitforVisibilityOfWebElement(element, "Visibility of feedback");
		executor.softWaitforElementToBeClickable(element, "feedback to be clickable");
		executor.click(element, "Click on feedback option");
		executor.softWaitforVisibilityOfWebElement(feedbackHeaderTitle, "visibility of feedback Title");
		executor.waitForPageLoadJS();
	}

	public void selectFeedback(Map<String, String> testData) {

		String feebackType = testData.get("FeedbackRating");

		executor.pause(1);

		clickOnTypeOfFeedback(testData.get("FeedbackRating"));

		selectQuestions(testData);
		submitFeedback();
		if (testData.get("FeedbackRating").equalsIgnoreCase("NotAcceptable")
				&& testData.get("ContactFeedback").equalsIgnoreCase("Yes")) {
			submitForRevision(testData);
			submitFeedback();
		}
		verifyFeedbackMessage(feebackType);
	}

	public void submitForRevision(Map<String, String> testData) {
		executor.softWaitforVisibilityOfWebElement(submitFeedback, "Wait for submit button to be clickable");

		clickQuestion(testData.get("FeedbackReference"));

		clickQuestion(testData.get("FilesToWork"));
		executor.pause(1);
		if (executor.isElementExist(uploadfileFeedback2)) {
			selectUploadFiles(testData.get("UploadFiles"), uploadfileFeedback2);
		}
		executor.pause(1);
		if (executor.isElementExist(uploadfileFeedback1)) {
			selectUploadFiles(testData.get("AddMoreFiles"), uploadfileFeedback1);
		}

		clickOnYesOrNo(testData.get("ContactFeedback"));
		executor.pause(1);
		selectDate();
	}

	public void verifyFeedbackMessage(String feebackType) {
		executor.softWaitforVisibilityOfWebElement(thankyouFeedbackMsg, "Thank you for your feedback!");
		String feedbackMsgActual = thankyouFeedbackMsg.getText();

		if (feebackType.equalsIgnoreCase("Outstanding"))
			executor.verifyEquals(feedbackMsgActual, "Outstanding! We’re glad Editage made you happy!",
					"Verify feedback thank you message");
		else if (feebackType.equalsIgnoreCase("Acceptable"))
			executor.verifyEquals(feedbackMsgActual, "Acceptable. We promise to do better next time",
					"Verify feedback thank you message");
		else
			executor.verifyEquals(feedbackMsgActual, "We’re sorry you’re disappointed.",
					"Verify feedback thank you message");

	}

	public void clickQuestion(String question) {
		By byXpath = By.xpath("//*[.=\"" + question + "\"]/../..//span");
		executor.softWaitforElementToBeClickable(byXpath, "Question should be clickable");
		executor.actionClick(byXpath, "click on question");
	}

	public void submitFeedback() {
		executor.softWaitforElementToBeClickable(submitFeedback, "Wait for submit button to be clickable");
		executor.actionClick(submitFeedback, "Click on Submit button");
	}

	public void selectQuestions(Map<String, String> testData) {
		String feebackType = testData.get("FeedbackRating");
		String questions = testData.get(testData.get("FeedbackRating"));
		String[] arrQuestions = questions.split(";");
		for (String question : arrQuestions) {
			clickQuestion(question);
		}
		if (!feebackType.equalsIgnoreCase("Outstanding")) {
			clickOnYesOrNo(testData.get("ContactFeedback"));
		}

	}

	public void clickOnYesOrNo(String value) {
		if (value.equalsIgnoreCase("No"))
			executor.actionClick(contactFeedbackNo, "Click on No radio button");
		else
			executor.actionClick(contactFedbackYes, "Click on Yes radio button");
	}

	public void selectUploadFiles(String uploadFile, WebElement element) {
		String[] uploadJobFiles = uploadFile.split(";");
		for (int i = 0; i < 1; i++) {
			String filepath = util.getFileAbolutePath(uploadJobFiles[i]);
			executor.fileUploadBySendkeys(element, filepath, "jobFiles");

		}

	}

	public void selectDate() {
		executor.actionClick(feedbackCalender, "click on calender button");
		// WebElement StartdateWidget = feedbackDateCell;
		executor.actionClick(feedbackDateCell, "Click on calender date cell");
		// executor.actionClick(feedbackDatePick, "click on date");
	}

}
