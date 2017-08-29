package com.cactus.eosapp.actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.editage.pages.LoginPage;
import com.cactus.eosapp.pages.FeedbackPage;
import com.cactus.executor.Executioner;
import com.cactus.utils.DatabaseUtil;
import com.relevantcodes.extentreports.ExtentTest;

public class FeedbackActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;

	public FeedbackActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void giveFeedback(Map<String, String> testData) {
		FeedbackPage feedbackPage = new FeedbackPage(driver, test, wait);
		feedbackPage.selectFeedback(testData);
	}

	public void loginAndNavigateToFeedbackPage(Map<String, String> testData, String testURL) {
		LoginPage loginPage = new LoginPage(driver, test, wait);
		loginPage.loginToEditageDashboard(testData.get("ClientEmail"), testData.get("ClientPassword"));
		executor.navigateToURL(testURL + testData.get("JobCode"));
		executor.waitForPageLoadJS();
		executor.refresh();

	}

	public List<String> getFeedbackQuestionMap(String language, String testEnv,
			Map<String, String> feebackQuestionMapTemp,
			Map<String, Map<String, Map<String, String>>> feebackTranslationMap, String feedback) {
		List<String> questions = new ArrayList<String>();
		Map<String, Map<String, String>> translationMap = feebackTranslationMap.get(feedback.toLowerCase());
		String temp1 = "";
		String temp2 = "";

		if (feedback.equalsIgnoreCase("outstanding")) {
			temp1 = "outstandingQ1";
			temp2 = "outstandingQ2";
		} else if (feedback.equalsIgnoreCase("acceptable")) {
			temp1 = "accepatableQ1";
			temp2 = "accepatableQ2";
		} else {
			temp1 = "notacceptableQ1";
			temp2 = "notacceptableQ2";
		}
		String questionSet1 = feebackQuestionMapTemp.get(temp1);
		String questionSet2 = feebackQuestionMapTemp.get(temp2);

		List<String> liQs = DatabaseUtil.getInstance().getFeebackQuestinType(questionSet1, testEnv);
		for (String ques : liQs) {
			Map<String, String> questionLan = translationMap.get(ques);
			questions.add(questionLan.get(language));
		}

		return questions;
	}
}
