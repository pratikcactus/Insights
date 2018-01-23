package com.cactus.insights.actions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.FooterPage;
import com.cactus.insights.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

public class FooterActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;
	private FooterPage footerPage;
	private LoginPage loginPage;

	public FooterActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}
	
	public void footerLinksVerification() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		footerPage = new FooterPage(driver, test, wait);
		footerPage.footerLinksCheck();
	}
	
	public void aboutUsCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		footerPage = new FooterPage(driver, test, wait);
		footerPage.aboutUsLink();
	}
	
	public void socialMediaCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		footerPage = new FooterPage(driver, test, wait);
		footerPage.socialMediaIcons();
	}
}
