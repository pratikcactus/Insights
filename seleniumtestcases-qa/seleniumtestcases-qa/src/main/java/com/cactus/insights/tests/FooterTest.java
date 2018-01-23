package com.cactus.insights.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.FooterActions;

public class FooterTest extends BaseTest {

	private FooterActions footer;
	
	@Test
	public void footerLinks() throws MalformedURLException, Exception{
		footer = new FooterActions(driver, test, wait);
		footer.footerLinksVerification();
	}
	
	@Test
	public void aboutUsLinkVerification() throws MalformedURLException, Exception{
		footer = new FooterActions(driver, test, wait);
		footer.aboutUsCheck();
	}
	
	@Test
	public void socialMediaVerification() throws MalformedURLException, Exception{
		footer = new FooterActions(driver, test, wait);
		footer.socialMediaCheck();
	}

}
