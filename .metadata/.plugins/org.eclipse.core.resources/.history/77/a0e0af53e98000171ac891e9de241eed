package com.cactus.editage.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.editage.pages.CheckPricingFormPage;
import com.cactus.editage.pages.CompleteYourProfilePage;
import com.cactus.editage.pages.EnquirySuccessPage;
import com.cactus.editage.pages.ResetPasswordPage;
import com.cactus.editage.pages.ReviewAndConfirmFormPage;
import com.cactus.editage.pages.SelectServiceFormPage;
import com.cactus.editage.pages.UploadManuscriptFormPage;
import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class FormActions {
	private SelectServiceFormPage selectServicePage;
	private CheckPricingFormPage checkPricinPage;
	private UploadManuscriptFormPage uploadManuscriptPage;
	private ReviewAndConfirmFormPage reviewAndConfirmPage;
	private EnquirySuccessPage enquirySuccessPage;
	private ResetPasswordPage resetPasswordPage;
	private CompleteYourProfilePage completeProfilePage;

	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;

	public FormActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);

	}

	public void fillClientForm(Map<String, String> testData) {

		selectServicePage = new SelectServiceFormPage(driver, test, wait);
		selectServicePage.selectServices(testData.get("services"));
		selectServicePage.selectSubServices(testData.get("subServices"));

		double count = Double.parseDouble(testData.get("wordCount"));
		if (testData.get("useWordCount").equalsIgnoreCase("Yes")) {
			selectServicePage.enterWordCount(testData.get("wordCount"));

			if (count > 8000)
				uploadManuscriptPage = selectServicePage
						.selectPlanAndNavigateToUploadManuscriptPage(testData.get("checkPlan"));
			else {
				checkPricinPage = selectServicePage.selectPlanAndNavigateToPricingPage(testData.get("checkPlan"));
				uploadManuscriptPage = checkPricinPage.clickonProceed();
			}
		} else {
			uploadManuscriptPage = selectServicePage.clickOnGetAQuoteByUploadManuscript();
		}

		uploadManuscriptPage.fillManuscriptForm(testData);
		reviewAndConfirmPage = uploadManuscriptPage.clickOnConfirm();
		enquirySuccessPage = reviewAndConfirmPage.clickonConfirm();
		resetPasswordPage = enquirySuccessPage.clickonLoginButton();
		completeProfilePage = resetPasswordPage.resetPassword(testData.get("NewPassword"));
		completeProfilePage.updateUserProfile(testData);
		completeProfilePage.clickOnDoneButton();

	}
}
