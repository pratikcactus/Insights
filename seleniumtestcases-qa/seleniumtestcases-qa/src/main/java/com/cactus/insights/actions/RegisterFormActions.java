package com.cactus.insights.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.RegisterPage;
import com.cactus.insights.pages.SearchPage;
import com.relevantcodes.extentreports.ExtentTest;

public class RegisterFormActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private SearchPage 	searchPage;

	public RegisterFormActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}

	public void registrationFormHomepage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.newUserRegistration();
	}
	
	public void registrationFormMainHomepage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
	}

	public void registrationFormQA() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
	}

	public void registrationFormAccessDenied() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
	}

	public void registerErrorHomepageCheck() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.newErrorMessages();
	}

	public void registerErrorQACheck() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoQAPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
	}

	public void registerErrorAccessDeniedCheck() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
	}

	public void registerForFree() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.loginHomePageClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.registerFree();
	}

	public void registerPopupCLick() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotofirstAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.registrationPopup();
	}

	public void registrationAcessDeniedVerification() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.gotoAccessDeniedPage();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.accessdenieduserRegistration();
	}
	
	public void ArticlePageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	public void QAForumPageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	public void ResearchPageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	public void VideoPageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	public void InterviewPageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	
	public void EventPageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	
	public void SlidesharePageRegister() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
		
	}
	
	public void RegisterDownloadPopup(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newUserRegistration();
	}
	
	public void registrationErrorMainHomepage() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
	}
	
	public void RegisterErrorDownloadPopup(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.popUpClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
	}
	
	public void ArticlePageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.articleFilter, "Article checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	public void QAForumPageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.QAFilter, "QA checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	public void ResearchPageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.researchFilter, "Research checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	public void VideoPageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.videoFilter, "Video checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	public void InterviewPageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.interviewFilter, "Interview  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	
	public void EventPageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.eventFilter, "Event  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	
	public void SlidesharePageRegisterError() throws InterruptedException{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		loginPage.searchIconClick("");
		loginPage.searchResultWait();
		searchPage=new SearchPage(driver, test, wait);
		executor.clickJS(searchPage.slideshareFilter, "Slideshare  checkbox clicked");
		loginPage=new LoginPage(driver, test, wait);
		loginPage.searchResultClick();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.newErrorMessages();
		
	}
	
	public void registerFromFacebookRegistration() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.facebookRegistration();
	}
	
	public void registerFromTwitterRegistration() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.twitterRegistration();
	}
	
	public void registerFromLinkedinRegistration() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.linkedinRegistration();
	}
	
	public void registerFromOrcidRegistration() {
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.goToRegistration();
		registerPage.OrcidRegistration();
	}

}
