package com.cactus.insights.tests;

import org.testng.annotations.Test;

import com.cactus.insights.actions.LoginFormActions;
import com.cactus.insights.pages.LoginPage;



public class LoginTest extends BaseTest {
	
	private LoginFormActions loginformAction;
	private LoginPage 	loginPage;
	
	//Login from Homepage Top Section
	@Test
	public void loginFromHomepage() {
		driver.navigate().refresh();
		loginPage=new LoginPage(driver, test, wait);
		loginPage.login();
	}
	
	@Test
	public void loginFromQA() {
		driver.navigate().refresh();
		loginformAction=new LoginFormActions(driver, test, wait);
		loginformAction.QAlogin();
	}
	
	@Test
	public void loginFromSaveToLibrary() {
		driver.navigate().refresh();
		loginformAction=new LoginFormActions(driver, test, wait);
		loginformAction.saveToLibraryLogin();
	}
	
	@Test
	public void loginFromAccessDenied() {
		driver.navigate().refresh();
		loginformAction=new LoginFormActions(driver, test, wait);
		loginformAction.AccessDeniedlogin();
	}
	
	@Test
	public void loginFromHomepageErrorCheck() {
		driver.navigate().refresh();
		loginPage=new LoginPage(driver, test, wait);
		loginPage.errorcheckhomepage();
	}
	
	@Test
	public void loginFromHomepageErrorCheckQA() {
		driver.navigate().refresh();
		loginPage=new LoginPage(driver, test, wait);
		loginPage.gotoQAPage();
		loginPage.errorcheckQA();
	}
	
	@Test
	public void loginFromHomepageErrorCheckLibrary() {
		driver.navigate().refresh();
		loginPage=new LoginPage(driver, test, wait);
		loginPage.errorcheckLibrary();
	}
	
	@Test
	public void loginFromHomepageErrorCheckAccessDenied() {
		driver.navigate().refresh();
		loginPage=new LoginPage(driver, test, wait);
		loginPage.errorcheckAccessDenied();
	}
	
}
