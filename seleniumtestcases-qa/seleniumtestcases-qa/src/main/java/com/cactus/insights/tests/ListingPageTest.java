package com.cactus.insights.tests;

import java.net.MalformedURLException;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cactus.insights.actions.ListingPageActions;
import com.cactus.insights.pages.LoginPage;
import com.cactus.utils.ExcelUtil;

public class ListingPageTest extends BaseTest {

	private ListingPageActions listingPageActions;
	private LoginPage loginPage;

	@Test
	public void headerSection() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.descriptionCheck(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void headerSectionDetailedPage() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuclickData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.detailedPageClick(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void detailedPageEventsResearchSlideshare() throws InterruptedException {
		listingPageActions = new ListingPageActions(driver, test, wait);
		listingPageActions.detailedPageResearch();
	}

	@Test
	public void ListingTabVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.tabValidation(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void newToOldTabVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.newToOldSort(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void paginationCheck() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.paginationValidation(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void listingPageSizeCheck() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.pageSizeCheck(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void rightHandSectionVerification() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.rightHandSideValidation(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void contentValidationCheck() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.contentVerification(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void headerCheckListingPage() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.headerValidation(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@Test
	public void footerCheckListingPage() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPageActions = new ListingPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					listingPageActions.footerValidation(testData.get("MainCategory").trim(),
							testData.get("SubCategory").trim(), testData.get("MenuName").trim());
				}
			}
		}

	}

	@DataProvider // (parallel=true)
	public Object[][] menuformData() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu");
	}

	@DataProvider // (parallel=true)
	public Object[][] menuclickData() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu2");
	}

}
