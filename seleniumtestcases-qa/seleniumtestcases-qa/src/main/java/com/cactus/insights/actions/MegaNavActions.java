package com.cactus.insights.actions;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.ListingPage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.MegaNavPage;
import com.cactus.insights.pages.QaPage;
import com.cactus.insights.pages.SearchPage;
import com.relevantcodes.extentreports.ExtentTest;

public class MegaNavActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private LoginPage loginPage;
	private ListingPage listingPage;
	private QaPage qaPage;
	private MegaNavPage meganavpage;
	private Executioner executor;

	public MegaNavActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void megaNavCheck() throws MalformedURLException, Exception {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		meganavpage = new MegaNavPage(driver, test, wait);
		meganavpage.menuCheck();
	}

	public void linkVerification(String mainCategory, String subCategory, String leftmenulinks, String rightmenulinks)
			throws MalformedURLException, Exception {
		meganavpage = new MegaNavPage(driver, test, wait);
		meganavpage.subCategoriesLinks(mainCategory, subCategory, leftmenulinks, rightmenulinks);
	}

	public void sublinkVerification(String mainCategory, String subCategory, String rightmenulinks)
			throws MalformedURLException, Exception {
		meganavpage = new MegaNavPage(driver, test, wait);
		meganavpage.subCategoriesLinksAll(mainCategory, subCategory, rightmenulinks);
	}

	public void sublinkVerification() throws MalformedURLException, Exception {
		meganavpage = new MegaNavPage(driver, test, wait);
		meganavpage.shopCourses();
	}
}
