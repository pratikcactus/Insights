package com.cactus.insights.tests;

import org.testng.annotations.Test;

import com.cactus.insights.actions.LoginFormActions;
import com.cactus.insights.pages.LoginPage;

public class LoginTest extends BaseTest {

	private LoginFormActions loginformAction;
	private LoginPage loginPage;

	// Login from Homepage Top Section
	@Test
	public void loginFromHomepage() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginHomePageClick();
		loginPage.login("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
	}

	@Test
	public void loginFromHomePageLogin() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.HomePageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}
	
	@Test
	public void loginFromDownloadPopup() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.DownloadPopup("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromQA() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.QAlogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
	}

	@Test
	public void loginFromSaveToLibrary() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.saveToLibraryLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test(enabled=false)
	public void loginFromAccessDeniedFirst() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.accessDeniedFirst();
	}

	@Test
	public void loginFromAccessDenied() {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.AccessDeniedlogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromArticlePage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.ArticlePageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromQAForumPage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.QAForumPageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromResearchPage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.ResearchPageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromVideoPage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.VideoPageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromInterviewPage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.InterviewPageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromEventPage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.EventPageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromSlidesharePage() throws InterruptedException {
		driver.navigate().refresh();
		loginformAction = new LoginFormActions(driver, test, wait);
		loginformAction.SlidesharePageLogin("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1",
				"authenticatedusertest");
	}

	@Test
	public void loginFromHomepageErrorCheck() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.errorcheckhomepage();
	}

	@Test
	public void loginFromHomepageErrorCheckQA() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		loginPage.signInClick();
		loginPage.errorcheckSignin();
	}

	@Test
	public void loginFromHomepageErrorCheckLibrary() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.errorcheckLibrary();
	}

	@Test
	public void loginFromHomepageErrorCheckAccessDenied() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.errorcheckAccessDenied();
	}
	
	@Test
	public void loginFromHomepageErrorCheckEbook() {
		driver.navigate().refresh();
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		loginPage.errorcheckSignin();
	}

}
