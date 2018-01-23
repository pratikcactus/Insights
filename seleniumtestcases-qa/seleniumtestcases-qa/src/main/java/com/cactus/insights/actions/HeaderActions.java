package com.cactus.insights.actions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.HeaderPage;
import com.cactus.insights.pages.HomePage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.RegisterPage;
import com.relevantcodes.extentreports.ExtentTest;

public class HeaderActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private LoginPage loginPage;
	private HeaderPage headerPage;

	private Executioner executor;

	public HeaderActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}
	
	public void headerCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		headerPage=new HeaderPage(driver, test, wait);
		headerPage.headerOptions();		
	}
	
	public void headerLinksCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		headerPage=new HeaderPage(driver, test, wait);
		headerPage.headerOptions();		
	}

	
}
