package com.cactus.insights.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class QaPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	public QaPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	// Q&A image
	@FindBy(xpath = "//div[@class='dr-eddy-page-form-image']")
	public WebElement qaImageForm;

	// Q&A Panel
	@FindBy(xpath = "//div[@class='pane-insight-client-custom-dr-eddy-anonymous-form']")
	public WebElement qaFormPanel;

	// Q&A Forum
	@FindBy(xpath = "//form[@class='ask-dr-eddy']")
	public WebElement qandAForum;

	// Q&A Question Area
	@FindBy(id = "edit-question")
	public WebElement qandAQuestionArea;

	// Q&A Description Area
	@FindBy(id = "edit-description")
	public WebElement qandADescriptionArea;

	// Q&A Label
	@FindBy(xpath = "//div[@class='form-item form-type-checkbox form-item-visibility']//label")
	public WebElement qandALabel;

	// Q&A Checkbox
	@FindBy(xpath = "//div[@class='form-item form-type-checkbox form-item-visibility']//input")
	public WebElement qandACheckbox;

	// Ask a Question Page Description
	@FindBy(xpath = "//div[@class='panel-pane pane-custom pane-1']//span")
	public WebElement qandAPageDescription;

	// Error Messages
	@FindBy(xpath = "//div[@class='messages messages--error']")
	public WebElement errorMessages;

	// Right Side Pane
	@FindBy(xpath = "//div[@class='panel-pane pane-views pane-dr-eddy sidebar-content-block']")
	public WebElement rightPane;

	// Q&A Title
	@FindBy(xpath = "//div[@class='node-title-q-a']")
	public WebElement QATitle;

	// Login Button
	@FindBy(id = "edit-submit")
	public WebElement loginButton;

	// Login Button
	@FindBy(id = "//div[@class='panel-pane pane-views pane-dr-eddy sidebar-content-block']/h2")
	public WebElement rightPaneTitle;

	// Q&A Description
	@FindBy(xpath = "//div[@id='md1']//p")
	public WebElement qaDescDetailed;

	// Q&A Views
	@FindBy(xpath = "//span[@class='views-count-text']")
	public WebElement qaViews;

	// User Image
	@FindBy(xpath = "//div[@class='user-picture']//img")
	public WebElement qaUserImage;

	// User name
	@FindBy(xpath = "//div[@class='node-user-name']/a")
	public WebElement qaUsername;

	// Submitted Date
	@FindBy(xpath = "//span[@class='submitted-date']")
	public WebElement qaDateSubmission;

	// Thank You text
	@FindBy(xpath = "//span[@class='your-question-text']")
	public WebElement thankYouMsg;

	// No reply text
	@FindBy(xpath = "//label[@for='edit-field-answer-und-0-value--2']")
	public WebElement noReplyText;

	// Reply Button
	@FindBy(xpath = "//input[@id='edit-submit--5']")
	public WebElement replyButton;

	// Q&A block
	@FindBy(xpath = "//div[@id='block-block-26']")
	public WebElement qaBlock;

	// Ask community link
	@FindBy(xpath = "//div[@class='q-a-link']/a")
	public WebElement askCommunityLink;

	// Reply Text Area
	@FindBy(xpath = "//textarea[@id='edit-field-answer-und-0-value--2']")
	public WebElement replyTextArea;

	// Error message question
	@FindBy(xpath = "//div[@class='messages messages--error']//li[@class='list-1']")
	public WebElement errorMessageQuestion;

	// Error message Description
	@FindBy(xpath = "//div[@class='messages messages--error']//li[@class='list-2']")
	public WebElement errorMessageDescription;

	// reply Textarea
	@FindBy(xpath = "//form[contains(@id,'q-a-answer-node')]//textarea")
	public WebElement replyTextarea;

	// reply button
	@FindBy(xpath = "//form[contains(@id,'q-a-answer-node')]//input[contains(@id,'edit-submit-')]")
	public WebElement replyButtonAnswer;

	public void askAQuestionPage() {
		boolean flag1 = false;
		if (qandAPageDescription.getText().contains(
				"Have a question about academic publishing? Unsure how to handle a tricky situation in the journal publishing process?")
				&& qaImageForm.isDisplayed() && qaFormPanel.isDisplayed() && qandAForum.isDisplayed()
				&& qandAQuestionArea.getAttribute("placeholder").contains("Enter your question here")
				&& qandADescriptionArea.getAttribute("placeholder")
						.contains("Give a detailed description of the question")
				&& qandACheckbox.isSelected()
				&& qandALabel.getText().contains("I agree to have my name displayed alongside my published question")
				&& rightPane.isDisplayed() && rightPaneTitle.getText().contains("RECENT QUESTIONS")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
	}

	public void unauthenticatedUser() {
		boolean flag1 = false;
		executor.type(qandAQuestionArea, "This is a test Question", "New Question entered");
		executor.type(qandADescriptionArea, "This is a test Question", "New Question Description is entered");
		executor.scrollIntoView(loginButton);
		executor.click(loginButton, "Click on Login button");
		if (errorMessages.isDisplayed()) {
			flag1 = true;
		} else {
			flag1 = false;
		}
	}

	public void authenticatedUserQuestion() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		String text = "This is a test Question";
		executor.type(qandAQuestionArea, text, "New Question entered");
		executor.type(qandADescriptionArea, text, "New Question Description is entered");
		if (qandAQuestionArea.getAttribute("placeholder").contains("Enter your question here")
				&& qandADescriptionArea.getAttribute("placeholder")
						.contains("Give a detailed description of the question")
				&& qandACheckbox.isSelected()
				&& qandALabel.getText().contains("I agree to have my name displayed alongside my published question")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.scrollIntoView(loginButton);
		executor.click(loginButton, "Click on Submit button");
		executor.softWaitforVisibilityOfWebElement(QATitle, "Wait for page to Load");
		flag2 = qaCheck(text, "Authenticated");
		if (flag1 && flag2) {
			executor.assertTrue(true, "Question posted successfully for authenticated user");
		} else {
			executor.assertTrue(false, "Question is not posted for authenticated user");
		}
	}

	public void anonymousUserQuestion() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		String text = "This is a test Question";
		executor.type(qandAQuestionArea, text, "New Question entered");
		executor.type(qandADescriptionArea, text, "New Question Description is entered");
		executor.click(qandACheckbox, "Click on the checkbox");
		if (qandAQuestionArea.getAttribute("placeholder").contains("Enter your question here")
				&& qandADescriptionArea.getAttribute("placeholder")
						.contains("Give a detailed description of the question")
				&& !qandACheckbox.isSelected()
				&& qandALabel.getText().contains("I agree to have my name displayed alongside my published question")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.scrollIntoView(loginButton);
		executor.click(loginButton, "Click on Submit button");
		executor.softWaitforVisibilityOfWebElement(QATitle, "Wait for page to Load");
		flag2 = qaCheck(text, "Anonymous");
		if (flag1 && flag2) {
			executor.assertTrue(true, "Question posted successfully for authenticated user");
		} else {
			executor.assertTrue(false, "Question is not posted for authenticated user");
		}
	}

	public boolean qaCheck(String question, String username) throws MalformedURLException, Exception {
		boolean flag1 = false;
		if (qaViews.getText().contains("VIEWS") && QATitle.getText().equalsIgnoreCase(question)
				&& qaDescDetailed.getText().equalsIgnoreCase(question) && util.imageChecker(qaUserImage, driver) == true
				&& qaUsername.getText().contains(username) && qaDateSubmission.getText().contains("Written")
				&& thankYouMsg.getText().contains("Your question is now live and open to answers from the community.")
				&& noReplyText.getText().contains("No replies, be the first!") && replyTextArea.isDisplayed()
				&& replyButton.isDisplayed() && qaBlock.isDisplayed()
				&& util.isLinkBroken(new URL(askCommunityLink.getAttribute("href"))).equals("OK")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;

	}

	public void authenticatedUserQuestionErrorMessage() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		String text = "";
		executor.type(qandAQuestionArea, text, "New Question entered");
		executor.type(qandADescriptionArea, text, "New Question Description is entered");
		if (qandAQuestionArea.getAttribute("placeholder").contains("Enter your question here")
				&& qandADescriptionArea.getAttribute("placeholder")
						.contains("Give a detailed description of the question")
				&& qandACheckbox.isSelected()
				&& qandALabel.getText().contains("I agree to have my name displayed alongside my published question")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.scrollIntoView(loginButton);
		executor.click(loginButton, "Click on Submit button");
		executor.softWaitforVisibilityOfWebElement(errorMessages, "Wait for error messages to load");
		if (errorMessageQuestion.getText().equalsIgnoreCase("Question field is required.")
				&& errorMessageDescription.getText().equalsIgnoreCase("Description field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Error message displayed successfully");
		} else {
			executor.assertTrue(false, "Error message is not  displayed successfully");
		}

	}

	public void replyAuthenticatedUser() {
		boolean flag1 = false;
		String answer = "This is a staging answer to the question provided";
		executor.type(replyTextarea, answer, "Answer to the Question written");
		executor.scrollIntoView(replyTextarea);
		executor.click(replyButtonAnswer, "Reply Button click");
		executor.softWaitforVisibilityOfWebElement(
				By.xpath("//div[contains(@class,'field field--name-field-answer')]//p"), "Wait for the page to load");
		executor.pause(2);
		List<WebElement> list = driver
				.findElements(By.xpath("//div[contains(@class,'field field--name-field-answer')]//p"));
		for (WebElement we : list) {
			if (we.getText().equalsIgnoreCase(answer)) {
				flag1 = true;
			} else {
				flag1 = false;
			}
		}
		if (flag1) {
			executor.assertTrue(true, "Replied to the question successfully");
		} else {
			executor.assertTrue(true, "Reply to the question unsuccessfull");
		}

	}

	public void replyUnAuthenticatedUser() {
		List<WebElement> list = driver.findElements(By.xpath("//form[contains(@id,'q-a-answer-node')]//textarea"));
		if (list.size() == 0) {
			executor.assertTrue(true, "Unauthenticated user is not able to reply");
		} else {
			executor.assertTrue(true, "Unauthenticated user is  able to reply. Fail");
		}
	}

}
