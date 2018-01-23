package com.cactus.insights.actions;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.FooterPage;
import com.cactus.insights.pages.HomePage;
import com.cactus.insights.pages.LoginPage;
import com.cactus.insights.pages.RegisterPage;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePageActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;

	private Executioner executor;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private HomePage homePage;

	public HomePageActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);

	}
	
	public void getYourCopyCheck(){
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.getEbookClicked();
		registerPage = new RegisterPage(driver, test, wait);
		registerPage.registrationFormCheck();
		
	}
	
	public void updateEventSort() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.updateEventsSort();		
	}
	
	public void updateEventNavigate() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.updatesEventList();		
	}
	
	public void recentArticlesSort() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.recentArticlesSort();		
	}
	
	public void recentArticlesStructure() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.recentArticlesUI();		
	}
	
	public void recentArticlesNavigate() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.recentArticlesList();		
	}
	
	public void recentArticlesReadMoreNavigate() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.recentArticlesReadMoreList();		
	}
	
	public void mostPopularSection() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.verifyMostpopularSectionTabs();		
	}
	
	public void mostPopularUIValidation() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.mostPopularUITest();		
	}
	
	public void mostPopularDetailedPageDirection() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.mostPopularDetailedPage();		
	}
	
	public void mostPopularDetailedPageReDirection() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.mostPopularRedirection();		
	}
	
	public void featuredInterviewSection() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.featuredInterview();		
	}
	
	public void featuredVideoSection() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.featuredVideo();		
	}
	
	public void askAQuestionPage() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.askAQuestion();		
	}
	
	public void dropDownCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.researchDropDown();		
	}
	
	public void sliderCheck() throws MalformedURLException, Exception{
		loginPage=new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		homePage=new HomePage(driver, test, wait);
		homePage.sliderHomepage();		
	}

	
}
