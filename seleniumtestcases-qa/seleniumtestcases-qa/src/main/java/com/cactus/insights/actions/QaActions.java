package com.cactus.insights.actions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.ListingPage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.QaPage;
import com.cactus.insights.pages.SearchPage;
import com.relevantcodes.extentreports.ExtentTest;

public class QaActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private LoginPage loginPage;
	private ListingPage listingPage;
	private QaPage qaPage;
	private SearchPage searchPage;
	private Executioner executor;

	public QaActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void QAPageValidation(String mainCategory, String subCategory, String menuName) {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		qaPage = new QaPage(driver, test, wait);
		qaPage.askAQuestionPage();
	}

	public void QAUnauthenticatedCheck(String mainCategory, String subCategory, String menuName) {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		qaPage = new QaPage(driver, test, wait);
		qaPage.unauthenticatedUser();
	}

	public void QAauthenticatedUserQuestionCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		qaPage = new QaPage(driver, test, wait);
		qaPage.authenticatedUserQuestion();
	}

	public void QAanonymousdUserQuestionCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		qaPage = new QaPage(driver, test, wait);
		qaPage.anonymousUserQuestion();
	}

	public void QAErrorMessageCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		qaPage = new QaPage(driver, test, wait);
		qaPage.authenticatedUserQuestionErrorMessage();
	}

	public void QAReplyCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest");
		searchPage = new SearchPage(driver, test, wait);
		searchPage.searchQA();
		qaPage = new QaPage(driver, test, wait);
		qaPage.replyAuthenticatedUser();
	}

	public void QAUnauthenticatedReplyCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.searchQA();
		qaPage = new QaPage(driver, test, wait);
		qaPage.replyUnAuthenticatedUser();
	}

}
