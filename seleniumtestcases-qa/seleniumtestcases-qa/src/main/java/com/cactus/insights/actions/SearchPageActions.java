package com.cactus.insights.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.SearchPage;
import com.relevantcodes.extentreports.ExtentTest;

public class SearchPageActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;
	private SearchPage searchPage;
	private LoginPage loginPage;

	public SearchPageActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
	}

	public void searchValidData(String input) {
		searchPage = new SearchPage(driver, test, wait);
		searchPage.validSearchData(input);
	}
	
	public void searchValidDataList(String input) {
		searchPage = new SearchPage(driver, test, wait);
		searchPage.validSearchDataList(input);
	}

	public void searchFilterFormat() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.searchFiltersFormat();
	}

	public void searchFilterDate() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.searchFiltersDate();
	}

	public void searchDetailedPage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.detailPageSearch();
	}
	
	public void askQuestionPage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.askQuestion();
	}
	
	public void noSearchpage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		searchPage = new SearchPage(driver, test, wait);
		searchPage.noSearch();
	}

}
