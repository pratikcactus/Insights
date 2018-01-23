package com.cactus.insights.tests;

import java.net.MalformedURLException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.cactus.insights.actions.HomePageActions;

public class HomePageTest extends BaseTest {
	
	private HomePageActions homePageAction;

	@Test
	public void getYourCopyUnauthorisedVerification(){
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.getYourCopyCheck();
	}
	
	@Test
	public void updateEventsLatestContent() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.updateEventSort();
	}
	
	@Test
	public void updateEventsHomePagenavigation() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.updateEventNavigate();
	}
	
	@Test
	public void recentArticlesLatestContent() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.recentArticlesSort();
	}
	
	@Test
	public void recentArticlesUICheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.recentArticlesStructure();
	}
	
	@Test
	public void recentArticlesHomePagenavigation() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.recentArticlesNavigate();
	}
	
	@Test
	public void recentArticlesReadMoreHomePagenavigation() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.recentArticlesReadMoreNavigate();
	}
	
	@Test
	public void mostPopularSectionTabCheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.mostPopularSection();
	}
	
	@Test
	public void mostPopularSectionTabUICheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.mostPopularUIValidation();
	}
	
	@Test
	public void mostPopularDetailedpageDirectionCheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.mostPopularDetailedPageReDirection();
	}
	
	@Test
	public void featuredInterviewSectionCheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.featuredInterviewSection();
	}
	
	@Test
	public void featuredVideoSectionCheck() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.featuredVideoSection();
	}
	
	@Test
	public void askAQuestionPageRedirection() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.askAQuestionPage();
	}
	
	@Test
	public void researchDropDown() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.dropDownCheck();
	}
	
	@Test
	public void sliderCaraouselVerification() throws MalformedURLException, Exception{
		homePageAction = new HomePageActions(driver, test, wait);
		homePageAction.sliderCheck();
	}
	
}
