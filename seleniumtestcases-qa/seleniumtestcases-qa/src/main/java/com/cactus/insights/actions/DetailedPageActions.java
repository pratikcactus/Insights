/**
 * 
 */
package com.cactus.insights.actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.DetailedPage;
import com.cactus.insights.pages.ListingPage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.SearchPage;
import com.cactus.utils.BrokenLinks;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author swapnil.raut
 *
 */
public class DetailedPageActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private Util util;
	
	private Executioner executor;
	private SearchPage searchPage;
	private LoginPage loginPage;
	private ListingPage listingPage;
	private DetailedPage detailedPage;
	
	
	
	
	public DetailedPageActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}
	
	public void verificationDetailedPage(String mainCategory, String subCategory, String menuName) throws InterruptedException{
		listingPage=new ListingPage(driver, test, wait);
		listingPage.menuCLick(mainCategory, subCategory, menuName);
		detailedPage=new DetailedPage(driver, test, wait);
		detailedPage.verifyPageArticlesAndImage();	
	}
	
	
}
