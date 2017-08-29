package com.cactus.eosapp.tests;

import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cactus.editage.tests.BaseTest;
import com.cactus.eosapp.actions.FeedbackActions;
import com.cactus.utils.ExcelUtil;

public class FeedbackTest extends BaseTest {

	@Test(dataProvider = "formData")
	public void feedbackTest(Map<String, String> testData) {
		/*Map<String, String> partnerMap = DatabaseUtil.getInstance().getPartnerMap(configMap.get("TestEnvironment"));
		Map<String, String> serviceMap = DatabaseUtil.getInstance().getServiceMap(configMap.get("TestEnvironment"));

		String partnerId = partnerMap.get(testData.get("Partner"));
		String serviceId = serviceMap.get(testData.get("Services"));

		Map<String, String> feebackQuestionMapTemp = DatabaseUtil.getInstance().getEOSFeedbackQuestionMap(
				configMap.get("TestEnvironment"), partnerId, serviceId, testData.get("ClientCategory"));

		Map<String, Map<String, Map<String, String>>> feebackTranslationMap = new ExcelUtil()
				.getUserDataInMapFromExcelServiceFeedbackTranslation("translation.xlsx", "data");*/

		FeedbackActions feedbackActions = new FeedbackActions(driver, test, wait);

		/*List<String> feebackQuestionList = feedbackActions.getFeedbackQuestionMap("Japanese",
				configMap.get("TestEnvironment"), feebackQuestionMapTemp, feebackTranslationMap,
				testData.get("FeedbackRating"));*/

		testURL = util.getTestURL("ServiceFeedback", testData.get("Partner") + "APP", configMap);

		feedbackActions.loginAndNavigateToFeedbackPage(testData, testURL);

		feedbackActions.giveFeedback(testData);

	}

	@Test(dataProvider = "uploadTestData")
	public void feedbackUploadTest(Map<String, String> testData) {

		FeedbackActions feedbackActions = new FeedbackActions(driver, test, wait);
		testURL = util.getTestURL("ServiceFeedback", testData.get("Partner") + "APP", configMap);

		feedbackActions.loginAndNavigateToFeedbackPage(testData, testURL);

		feedbackActions.giveFeedback(testData);

	}
	@DataProvider // (parallel=true)
	public Object[][] formData() {
		return new ExcelUtil().getUserDataFromExcel("testData_EOSAPP.xlsx", "feedback");
	}
	
	@DataProvider // (parallel=true)
	public Object[][] uploadTestData() {
		return new ExcelUtil().getUserDataFromExcel("testDataUpload.xlsx", "feedback");
	}

}
