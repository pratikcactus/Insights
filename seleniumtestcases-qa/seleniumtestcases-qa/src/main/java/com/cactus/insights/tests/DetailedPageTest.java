/**
 * 
 */
package com.cactus.insights.tests;

import java.net.MalformedURLException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cactus.insights.actions.DetailedPageActions;
import com.cactus.insights.pages.LoginPage;
import com.cactus.utils.ExcelUtil;

/**
 * @author swapnil.raut
 *
 */
public class DetailedPageTest extends BaseTest {

	private DetailedPageActions detailedPageActions;
	private LoginPage loginPage;

	/*
	 * @Test public void detailedPageValidation() throws MalformedURLException,
	 * Exception{ loginPage = new LoginPage(driver, test, wait);
	 * loginPage.bannerWait();
	 * loginPage.loginUser("authenticated-user-test@mailinator.com",
	 * "Ye@r2o17AwsTeSt_1", "authenticatedusertest"); detailedPageActions = new
	 * DetailedPageActions(driver, test, wait); Object[][] testData1 =
	 * menuformData(); for (Object[] obj1 : testData1) { for (Object obj : obj1)
	 * { Map<String, String> testData = (Map) obj; if
	 * (testData.get("Flag").equalsIgnoreCase("yes")) {
	 * detailedPageActions.verificationDetailedPage(testData.get("MainCategory")
	 * .trim(), testData.get("SubCategory").trim(),
	 * testData.get("MenuName").trim()); } } }
	 * 
	 * }
	 */

	@Test(dataProvider = "menuformData")
	public void detailedPageElementVerification(Map<String, String> testData) throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
		detailedPageActions = new DetailedPageActions(driver, test, wait);
		detailedPageActions.verificationDetailedPage(testData.get("MainCategory").trim(),
				testData.get("SubCategory").trim(), testData.get("MenuName").trim());
	}

	@DataProvider // (parallel=true)
	public Object[][] menuformData() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu");
	}
}
