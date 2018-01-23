package com.cactus.insights.tests;

import java.net.MalformedURLException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cactus.insights.actions.ListingPageActions;
import com.cactus.insights.actions.MegaNavActions;
import com.cactus.insights.actions.QaActions;
import com.cactus.insights.pages.LoginPage;
import com.cactus.utils.ExcelUtil;

public class MegaNavTest extends BaseTest {

	private MegaNavActions megaNavActions;
	private LoginPage loginPage;

	@Test
	public void megaNavVerification() throws MalformedURLException, Exception {
		megaNavActions = new MegaNavActions(driver, test, wait);
		megaNavActions.megaNavCheck();
	}

	@Test
	public void MiddleSectionRightSectionLinksVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		megaNavActions = new MegaNavActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					megaNavActions.linkVerification(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("LeftHandLinks").trim(),
							testData.get("RightHandLinks").trim());
					// megaNavActions.linkVerification("Interactive Learning",
					// "Videos & Slideshare", "mn-megamenu-column-40",
					// "mn-megamenu-column-41");

				}
			}
		}

	}

	@Test
	public void RightSectionLinksVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		megaNavActions = new MegaNavActions(driver, test, wait);
		Object[][] testData1 = menuformDataLinks();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					megaNavActions.sublinkVerification(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("RightHandLinks").trim());
					// megaNavActions.linkVerification("Interactive Learning",
					// "Videos & Slideshare", "mn-megamenu-column-40",
					// "mn-megamenu-column-41");

				}
			}
		}

	}

	@Test
	public void shopCoursesVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		megaNavActions = new MegaNavActions(driver, test, wait);
		megaNavActions.sublinkVerification();
	}

	@DataProvider // (parallel=true)
	public Object[][] menuformData() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu3");
	}

	@DataProvider // (parallel=true)
	public Object[][] menuformDataLinks() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu4");
	}

}
