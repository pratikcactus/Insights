package com.cactus.insights.tests;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.AboutUsActions;
import com.cactus.insights.pages.AboutUsExtendedPage1;
import com.cactus.insights.pages.AboutUsExtendedPage2;
import com.cactus.insights.pages.AboutUsPage;
import com.cactus.insights.pages.LoginPage;

public class AboutUsTest extends BaseTest {
	LoginPage loginPage;
	AboutUsPage aboutUsPage;
	AboutUsActions aboutUsActions;
	AboutUsExtendedPage1 aboutUsExtendedPage1;
	AboutUsExtendedPage2 aboutUsExtendedPage2;

	@Test
	public void detailedPageValidationWhatIseditageInsights() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsPage = new AboutUsPage(driver, test, wait);
		aboutUsPage.aboutUsWhatIsEditageInsights();
	}

	@Test
	public void detailedPageValidationWhoIsItFor() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsPage = new AboutUsPage(driver, test, wait);
		aboutUsPage.aboutUsWhoIsItFor();
	}

	@Test
	public void detailedPageValidationSpecialFeature() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsPage = new AboutUsPage(driver, test, wait);
		aboutUsPage.aboutUsSpecialFeature();
	}

	@Test
	public void detailedPageValidationOurTeam() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsExtendedPage1 = new AboutUsExtendedPage1(driver, test, wait);
		aboutUsExtendedPage1.aboutUsOurTeam();
	}

	@Test
	public void detailedPageValidationContributeAsGuest() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsExtendedPage1 = new AboutUsExtendedPage1(driver, test, wait);
		aboutUsExtendedPage1.teamContributorsforInsights();
	}

	@Test
	public void detailedPageValidationBecomeAnAmbassador() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsExtendedPage2 = new AboutUsExtendedPage2(driver, test, wait);
		aboutUsExtendedPage2.verifybecomeAnAmbassador();
	}

	@Test
	public void detailedPageValidationOurStory() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsExtendedPage2 = new AboutUsExtendedPage2(driver, test, wait);
		aboutUsExtendedPage2.verifyOurStory();
	}

	@Test
	public void detailedPageValidationContactUs() throws MalformedURLException, Exception {
		aboutUsActions = new AboutUsActions(driver, test, wait);
		aboutUsActions.AboutUs();
		aboutUsExtendedPage2 = new AboutUsExtendedPage2(driver, test, wait);
		aboutUsExtendedPage2.verifyContactUs();
	}

}
