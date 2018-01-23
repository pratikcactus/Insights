package com.cactus.insights.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.HeaderActions;
import com.cactus.insights.actions.HomePageActions;
import com.cactus.insights.pages.HeaderPage;

public class HeaderTest extends BaseTest {
	
	private HeaderActions headerActions;

	@Test
	public void headerSection() throws MalformedURLException, Exception{
		headerActions = new HeaderActions(driver, test, wait);
		headerActions.headerCheck();
	}
	
	@Test
	public void headerSectionLinkValidation() throws MalformedURLException, Exception{
		headerActions = new HeaderActions(driver, test, wait);
		headerActions.headerLinksCheck();
	}

}
