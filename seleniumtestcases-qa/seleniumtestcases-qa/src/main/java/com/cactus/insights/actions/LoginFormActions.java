package com.cactus.insights.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.SearchPage;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginFormActions {
	

	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage 	loginPage;
	private SearchPage 	searchPage;

	public LoginFormActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);

	}
	
	public void HomePageLogin(String username, String staging_password, String live_password){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
	}
	
	public void DownloadPopup(String username, String staging_password, String live_password){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
	}
	
	
	public void QAlogin(String username, String staging_password, String live_password){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
	}
	
	public void saveToLibraryLogin(String username, String staging_password, String live_password){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoSaveLibrary();
		loginPage.login(username, staging_password, live_password);
	}
	
	public void AccessDeniedlogin(String username, String staging_password, String live_password){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void ArticlePageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void QAForumPageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void ResearchPageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void VideoPageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void InterviewPageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	
	public void EventPageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	
	public void SlidesharePageLogin(String username, String staging_password, String live_password) throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		loginPage.signInClick();
		loginPage.login(username, staging_password, live_password);
		
	}
	
	public void accessDeniedFirst(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotofirstAccessDeniedPage();
		loginPage.loginPopup();
	}

	
}
