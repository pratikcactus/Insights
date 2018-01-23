package com.cactus.insights.actions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.YourLibraryPage;
import com.relevantcodes.extentreports.ExtentTest;

public class YourLibraryActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private LoginPage loginPage;
	private YourLibraryPage yourLibraryPage;
	private Executioner executor;

	public YourLibraryActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void youLibraryCheck() {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.youLibraryVerify();

	}
	
	public void yourLibraryContent() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.yourLibraryCheck();

	}
	
	public void yourLibrarySavedContent() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.yourLibrarySavedContentCheck();

	}
	
	public void yourLibraryDetailedContent() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.yourLibraryDetailCheck();

	}
	
	public void yourLibrarySubscriptionPageVerify() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.subscriptionPage();
	}
	
	public void yourLibraryHeaderVerify() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.yourLibraryHeader();
	}
	
	public void yourLibraryFooterVerify() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.yourLibraryFooter();
	}
	
	public void contentPreferencesValidation() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.contentPreferences();
	}
	
	public void subscriptionPreferencesValidation() throws MalformedURLException, Exception {
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginUser("authenticated-user-test@mailinator.com", "Ye@r2o17AwsTeSt_1", "authenticatedusertest" );
		yourLibraryPage=new YourLibraryPage(driver, test, wait);
		yourLibraryPage.subscriptionPreferences();
	}
}
