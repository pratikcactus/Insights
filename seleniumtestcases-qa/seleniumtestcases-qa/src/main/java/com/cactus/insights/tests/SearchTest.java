package com.cactus.insights.tests;

import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cactus.insights.actions.SearchPageActions;
import com.cactus.insights.pages.LoginPage;
import com.cactus.utils.ExcelUtil;

public class SearchTest extends BaseTest {
	private SearchPageActions searchActions;
	private LoginPage loginPage;

	// Search Valid data
	@Test
	public void searchResultValid() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchActions = new SearchPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					searchActions.searchValidData(testData.get("SearchData").trim());
					// megaNavActions.linkVerification("Interactive Learning",
					// "Videos & Slideshare", "mn-megamenu-column-40",
					// "mn-megamenu-column-41");

				}
			}
		}

	}
	
	
	@Test
	public void searchResultValidList() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchActions = new SearchPageActions(driver, test, wait);
		Object[][] testData1 = menuformData();
		for (Object[] obj1 : testData1) {
			for (Object obj : obj1) {
				Map<String, String> testData = (Map) obj;
				if (testData.get("Flag").equalsIgnoreCase("yes")) {
					searchActions.searchValidDataList(testData.get("SearchDataList").trim());
					// megaNavActions.linkVerification("Interactive Learning",
					// "Videos & Slideshare", "mn-megamenu-column-40",
					// "mn-megamenu-column-41");

				}
			}
		}

	}

	// Verify Search Filter on basis of Filter By Format
	@Test
	public void searchFilterByFormat() {
		searchActions = new SearchPageActions(driver, test, wait);
		searchActions.searchFilterFormat();
	}

	// Verify Search Filter on basis of Filter By Date
	@Test
	public void searchFilterByDate() {
		searchActions = new SearchPageActions(driver, test, wait);
		searchActions.searchFilterDate();
	}

	// Verify that when clicked on any search results we are redirected to
	// appropriate detailed page
	@Test
	public void searchRedirectDetailPage() {
		searchActions = new SearchPageActions(driver, test, wait);
		searchActions.searchDetailedPage();
	}

	// Verify when we click on Ask community link we are redirected to Ask A
	// Question page
	@Test
	public void askCommunityLink() {
		searchActions = new SearchPageActions(driver, test, wait);
		searchActions.askQuestionPage();
	}

	// Verify proper message is shown when no results are found.
	// Question page
	@Test
	public void noSearchResultsFound() {
		searchActions = new SearchPageActions(driver, test, wait);
		searchActions.noSearchpage();
	}
	
	@DataProvider // (parallel=true)
	public Object[][] menuformData() {
		return new ExcelUtil().getUserDataFromExcel("Menu.xlsx", "menu5");
	}

}
