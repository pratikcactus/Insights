package com.cactus.insights.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.YourLibraryActions;

public class YourLibraryTest extends BaseTest {
	
	private YourLibraryActions yourLibraryActions;

	@Test
	public void youLibraryVerification(){
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.youLibraryCheck();
	}
	
	@Test
	public void yourLibraryContentCheck() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibraryContent();
	}
	
	@Test
	public void yourLibrarySavedContentCheck() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibrarySavedContent();
	}
	
	@Test
	public void yourLibraryDetailedContentVerification() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibraryDetailedContent();
	}
	
	@Test
	public void yourLibrarySubscriptionPage() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibrarySubscriptionPageVerify();
	}
	
	@Test
	public void yourLibraryHeaderVerification() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibraryHeaderVerify();
	}
	
	@Test
	public void yourLibraryFooterVerification() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.yourLibraryFooterVerify();
	}
	
	@Test
	public void contentPreferencesVerification() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.contentPreferencesValidation();
	}
	
	@Test
	public void subscriptionPreferencesVerification() throws MalformedURLException, Exception{
		yourLibraryActions = new YourLibraryActions(driver, test, wait);
		yourLibraryActions.subscriptionPreferencesValidation();
	}


}
