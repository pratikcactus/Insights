package com.cactus.insights.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class HeaderPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;
	private LoginPage loginPage;

	// Header Image
	@FindBy(xpath = "//div[@class='header branding inside']/a/img")
	public WebElement headerImage;

	// Header link
	@FindBy(xpath = "//div[@class='header branding inside']/a")
	public WebElement headerLink;

	// Login Button
	@FindBy(xpath = "//div[@class='anonymous-login anonymous-text']/a")
	public WebElement logIn;
	
	// Username
		@FindBy(xpath = "//div[@class='user-name']")
		public WebElement username;


	// Register button
	@FindBy(xpath = "//div[@class='anonymous-register anonymous-text']/a")
	public WebElement registerButton;

	// Search Box
	@FindBy(id = "edit-apachesolr-panels-search-form")
	public WebElement searchBox;

	@FindBy(id = "edit-submit")
	public WebElement searchIcon;
	
	@FindBy(id = "edit-submit--2")
	public WebElement searchIconLoggedIn;

	public HeaderPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	public boolean headerOptionsCheck() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false;
		String message = "OK";
		if (util.imageChecker(headerImage, driver) == true
				&& headerLink.getAttribute("href").contains("/insights/")
				&& util.isLinkBroken(new URL(headerLink.getAttribute("href"))).equals(message)) {
			flag1 = true;
		} else {
			System.err.println("Homepage icon is broken/ Link not getting directed to Homepage");
			flag1 = false;

		}
		if (logIn.isDisplayed() && registerButton.isDisplayed() && searchIcon.isDisplayed()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		return flag3;
	}

	public void headerOptions() throws MalformedURLException, Exception {
		boolean flag1 = false;
		flag1 = headerOptionsCheck();
		if (flag1) {
			executor.assertTrue(true, "Header includes Logo, Login, register and search ");
		} else {
			executor.assertTrue(false, "Header does not includes Logo, Login, register and search");
		}
	}

	public boolean headerLinksCheck() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		List<String> list = Arrays.asList("About us", "Shop", "Trending", "Ask a question", "Reading List",
				"Contact us");
		List<WebElement> headerList = driver.findElements(By.xpath("//nav[@id='block-menu-menu-top-bar']//li/a"));
		List<String> sortList = new ArrayList<String>();
		String message = "OK";
		for(int i=1;i<headerList.size();i++) {
			if (headerList.get(i).getAttribute("href").contains("/insights/")
					|| headerList.get(i).getAttribute("href").contains("shop-and-learn.editage.com")) {
				flag1 = true;
				sortList.add(headerList.get(i).getText());
			} else {
				flag1 = false;
				break;
			}
			if (!util.isLinkBroken(new URL(headerList.get(i).getAttribute("href"))).equalsIgnoreCase("Not Found") && !util.isLinkBroken(new URL(headerList.get(i).getAttribute("href"))).equalsIgnoreCase("Internal Server Error")) {
				flag2 = true;
			} else {
				flag2 = false;
				break;
			}
		}
		if (list.equals(sortList)) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (flag1 && flag2 && flag3) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		return flag4;
	}

	public void headerLinks() throws MalformedURLException, Exception {
		boolean flag1 = false;
		flag1 = headerLinksCheck();
		if (flag1) {
			executor.assertTrue(true,
					"Links in the Header Section are visible and directing to their appropriate page");
		} else {
			executor.assertTrue(false,
					"Links in the Header Section are not getting directed to their appropriate page");
		}
	}
	
	public boolean headerOptionsCheckLoggedIn() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false;
		String message = "OK";
		if (util.imageChecker(headerImage, driver) == true
				&& headerLink.getAttribute("href").contains("/insights/")
				&& util.isLinkBroken(new URL(headerLink.getAttribute("href"))).equals(message)) {
			flag1 = true;
		} else {
			System.err.println("Homepage icon is broken/ Link not getting directed to Homepage");
			flag1 = false;

		}
		if (username.getText().contains("Hello") && searchIconLoggedIn.isDisplayed()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		return flag3;
	}

}
