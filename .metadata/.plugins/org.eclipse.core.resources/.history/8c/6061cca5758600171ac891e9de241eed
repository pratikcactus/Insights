package com.cactus.insights.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.LoginPage;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginFormActions {
	

	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage 	loginPage;

	public LoginFormActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);

	}
	
	public void QAlogin(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.gotoQAPage();
		loginPage.loginQA();
	}
	
	public void saveToLibraryLogin(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.gotoSaveLibrary();
		loginPage.clickSavetoLibrary();
	}
	
	public void AccessDeniedlogin(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.gotoAccessDeniedPage();
		loginPage.accessDeniedpage();
		
	}
	
	

	
}
