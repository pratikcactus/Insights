package com.cactus.insights.tests;

import org.testng.annotations.Test;

import com.cactus.insights.tests.BaseTest;
import com.cactus.insights.actions.RegisterFormActions;

public class RegisterTest extends BaseTest {

	private RegisterFormActions registerAction;

	// Register from Homepage Top Section
	@Test
	public void registerFromHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormHomepage();
	}

	// Register from Q&A page
	@Test
	public void registerFromQA() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormQA();
	}

	// Register from Access Denied Page
	@Test
	public void registerFromAcccessDenied() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registrationFormAccessDenied();
	}

	// Register from HomePage Error Messages
	@Test
	public void registerErrorHomepage() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorHomepageCheck();
	}

	// Register from Q&A Error Messages
	@Test
	public void registerErrorQA() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorQACheck();
	}

	// Register from Access Denied Error Messages
	@Test
	public void registerErrorAccessDenied() {
		registerAction = new RegisterFormActions(driver, test, wait);
		registerAction.registerErrorAccessDeniedCheck();
	}
}
