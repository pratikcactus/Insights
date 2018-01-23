package com.cactus.insights.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.cactus.insights.tests.BaseTest;
import com.cactus.insights.actions.LoginFormActions;
import com.cactus.insights.actions.RegisterFormActions;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.RegisterPage;
import com.cactus.insights.pages.SearchPage;

public class RegisterTest extends BaseTest {

	private RegisterFormActions registerAction;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private SearchPage searchPage;

	// Register from Homepage Top Section
	@Test
	public void registerFromHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormHomepage();
	}

	@Test
	public void registerFromMainHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormMainHomepage();
	}

	// Register Free button clicked
	@Test(enabled=false)
	public void registerForFree() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerForFree();
	}

	// Register from Access Denied Redirection
	@Test(enabled=false)
	public void registerRedirectionAccessDenied() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationAcessDeniedVerification();
	}

	// Register Free button on Register Pop-up
	@Test(enabled=false)
	public void registerPopUpButton() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerPopupCLick();
	}

	// Register from Q&A page
	@Test
	public void registerFromQA() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormQA();
	}

	// Register from Access Denied Page
	@Test
	public void registerFromAcccessDenied() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormAccessDenied();
	}

	@Test
	public void registerFromArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.ArticlePageRegister();
	}

	@Test
	public void registerFromQAForumPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.QAForumPageRegister();
	}

	@Test
	public void registerFromResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.ResearchPageRegister();
	}

	@Test
	public void registerFromVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.VideoPageRegister();
	}

	@Test
	public void registerFromInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.InterviewPageRegister();
	}

	@Test
	public void registerFromEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.EventPageRegister();
	}

	@Test
	public void registerFromSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.SlidesharePageRegister();
	}

	@Test
	public void RegisterFromDownloadPopup() {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.RegisterDownloadPopup();
	}

	// Register from HomePage Error Messages
	@Test
	public void registerErrorHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorHomepageCheck();
	}

	// Register from Q&A Error Messages
	@Test
	public void registerErrorQA() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorQACheck();
	}

	// Register from Access Denied Error Messages
	@Test
	public void registerErrorAccessDenied() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorAccessDeniedCheck();
	}

	@Test
	public void registerErrorMainHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationErrorMainHomepage();
	}

	@Test
	public void RegisterErrorDownloadPopup() {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.RegisterErrorDownloadPopup();
	}

	@Test
	public void registerErrorArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.ArticlePageRegisterError();
	}

	@Test
	public void registerErrorQAForumPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.QAForumPageRegisterError();
	}

	@Test
	public void registerErrorResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.ResearchPageRegisterError();
	}

	@Test
	public void registerErrorVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.VideoPageRegisterError();
	}

	@Test
	public void registerErrorInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.InterviewPageRegisterError();
	}

	@Test
	public void registerErrorEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.EventPageRegisterError();
	}

	@Test
	public void registerErrorSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.SlidesharePageRegisterError();
	}

	@Test
	public void registerFromFacebookRegistration() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerFromFacebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistration() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerFromTwitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistration() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerFromLinkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistration() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerFromOrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationMainHomepage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationMainHomepage() throws InterruptedException, AWTException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationMainHomepage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationMainHomepage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationQA() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationQA() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationQA() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationQA() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationAccessDenied() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationAccessDenied() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationAccessDenied() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationAccessDenied() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationDownloadPopup() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationDownloadPopup() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationDownloadPopup() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationDownloadPopup() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationQAPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationQAPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationQAPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationQAPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Event  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Event  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Event  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationEventPage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Event  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	@Test
	public void registerFromFacebookRegistrationSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Slideshare  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.facebookRegistration();
	}

	@Test
	public void registerFromTwitterRegistrationSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Slideshare  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.twitterRegistration();
	}

	@Test
	public void registerFromLinkedinRegistrationSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Slideshare  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.linkedinRegistration();
	}

	@Test
	public void registerFromOrcidRegistrationSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		registerAction = new RegisterFormActions(driver, test, wait);
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage = new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Slideshare  checkbox clicked");
		loginPage = new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.OrcidRegistration();
	}

	// Register from Homepage Top Section
	@Test
	public void registerFromHomepageOrcid() throws InterruptedException {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.additionalInformationForm();
	}

	// Register from Homepage Top Section
	@Test
	public void registerFromHomepageTwitter() throws InterruptedException {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.additionalInformationFormTwitter();
	}

}
