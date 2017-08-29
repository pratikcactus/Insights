package com.cactus.insights.tests;

import org.testng.annotations.Test;

import com.cactus.insights.actions.SearchPageActions;

public class SearchTest extends BaseTest {
	private SearchPageActions searchActions;
	
	
	// Search Valid data
		@Test
		public void searchResultValid() {
			searchActions = new SearchPageActions(driver, test, wait);
			searchActions.searchValidData();
		}
	
}
