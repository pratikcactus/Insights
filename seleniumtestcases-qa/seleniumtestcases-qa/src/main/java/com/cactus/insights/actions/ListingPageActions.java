package com.cactus.insights.actions;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.HomePage;
import com.cactus.insights.pages.ListingPage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.RegisterPage;
import com.relevantcodes.extentreports.ExtentTest;

public class ListingPageActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;
	private LoginPage loginPage;
	private ListingPage listingPage;

	public ListingPageActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void descriptionCheck(String mainCategory, String subCategory, String menuName) {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.menuContent(mainCategory, subCategory, menuName);
	}

	public void detailedPageClick(String mainCategory, String subCategory, String menuName)
			throws InterruptedException {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.detailedPage(mainCategory, subCategory, menuName);
	}

	public void detailedPageResearch() throws InterruptedException {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		listingPage = new ListingPage(driver, test, wait);
		listingPage.detailedPageValidation();
	}

	public void tabValidation(String mainCategory, String subCategory, String menuName) {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.tabVerification(mainCategory, subCategory, menuName);
	}

	public void newToOldSort(String mainCategory, String subCategory, String menuName) throws ParseException {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.newToOldListing(mainCategory, subCategory, menuName);
	}

	public void paginationValidation(String mainCategory, String subCategory, String menuName) throws ParseException {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.pagination(mainCategory, subCategory, menuName);
	}

	public void pageSizeCheck(String mainCategory, String subCategory, String menuName)
			throws ParseException, InterruptedException {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.sizeCheck(mainCategory, subCategory, menuName);
	}

	public void rightHandSideValidation(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.rightSectionVerify(mainCategory, subCategory, menuName);
	}

	public void contentVerification(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.contentCheck(mainCategory, subCategory, menuName);
	}

	public void headerValidation(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.headerCheck(mainCategory, subCategory, menuName);
	}

	public void footerValidation(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		listingPage = new ListingPage(driver, test, wait);
		listingPage.footerCheck(mainCategory, subCategory, menuName);
	}

}
