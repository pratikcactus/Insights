/**
 * 
 */
package com.cactus.insights.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.BrokenLinks;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author swapnil.raut
 *
 */
public class DetailedPageRightsideElementsPage{

	private DetailedPageRightsideElementsPage detailedPageRightsideElements;
	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage loginPage;
	
	
	
/**********************Article right side Elements********************************/
	By canYouAnswerTheseElement_title = By.xpath("//h2[@class='pane-title' and text()='Can you answer these?']");
	
	@FindBy(xpath="//h2[@class='pane-title' and text()='Can you answer these?']")
	WebElement canYouAnswerThese_title;
	
	@FindBy(css=".item-list ul a")
	List <WebElement> canYouAnswerThese_links;
	
	By viewAllInQandAElement_link = By.cssSelector("#article-page div.view-footer a");
	@FindBy(css="#article-page div.view-footer a")
	WebElement viewAllInQandA_link;

	@FindBy(xpath="//h2[@class='pane-title' and text()='You might also like']")
	WebElement youMightAlsoLike_title;
	
	By imageUnderYouMightAlsoLikeElement = By.cssSelector(".more-like-this-image img[src]");
	@FindBy(css=".more-like-this-image img[src]")
	List<WebElement> imageUnderYouMightAlsoLike;
	
	@FindBy(css=".more-like-this-image a")
	List<WebElement> imageUnderYouMightAlsoLike_Links;
	
	@FindBy(css=".more-like-this-title a")
	List<WebElement> youMayAlsoLike_links;
	
	@FindBy(css=".most-popular-wrapper a")
	List<WebElement> mostPopularInThisCategory_links;
	
	@FindBy(css=".pane-article-related-categories h2")
	WebElement relatedCategories_title;
	
	@FindBy(css=".pane-article-related-categories a")
	List<WebElement> relatedCategory_links;
	
	By iFrameRightSideElement = By.cssSelector("iframe#twitter-widget-0.twitter-timeline.twitter-timeline-rendered");
	@FindBy(css="iframe#twitter-widget-0.twitter-timeline.twitter-timeline-rendered")
	WebElement iFrameRightSide;
/************************************************************************/	
	@FindBy(css=".title-heading span")
	List<WebElement> qAndATitle_elements;
	
	By haveYourOwnQuestionElement = By.cssSelector("p.description-question");
	@FindBy(css="p.description-question")
	WebElement haveYourOwnQuestion;
	
	By  askTheCommunityElement_link = By.cssSelector(".q-a-link a");
	@FindBy(css=".q-a-link a")
	WebElement askTheCommunity_link ;

/******************Q and A right side elements***************************/	
	By relatedQuestionsElement = By.cssSelector("#block-q-and-a-answer-q-a-related-quetion h2");
	@FindBy(css="#block-q-and-a-answer-q-a-related-quetion h2")
	WebElement relatedQuestions;
	
	@FindBy(css="#block-q-and-a-answer-q-a-related-question a")
	List<WebElement> relatedQuestions_links;
	

	public DetailedPageRightsideElementsPage(WebDriver driver, ExtentTest test,
		WebDriverWait wait) {
		
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
	}
	
	public void rightSideArticleElements(){
		

		DetailedPageRightsideElementsPage detailedPageRightsideElements = new DetailedPageRightsideElementsPage(driver, test, wait);
		
		if(executor.isElementPresent(canYouAnswerTheseElement_title)){
		executor.softWaitforVisibilityOfWebElement(canYouAnswerThese_title, "wait for 1st h2 title on right side");
		executor.verifyTrue(canYouAnswerThese_title.isDisplayed(), "Verify this title :"+canYouAnswerThese_title.getText());
		}
		
		new BrokenLinks(driver, wait, test).verifyLinks(canYouAnswerThese_links);
		
		if(executor.isElementPresent(viewAllInQandAElement_link)){
		executor.softWaitforVisibilityOfWebElement(viewAllInQandA_link, "wait for Q and A link");
		new BrokenLinks(driver, wait, test).verifyLink(viewAllInQandA_link);
		}
		
		detailedPageRightsideElements.qAndAtitleElement();
		
		executor.verifyTrue(youMightAlsoLike_title.isDisplayed(), "verify title question:"+youMightAlsoLike_title.getText());
		
		if (executor.isElementPresent(imageUnderYouMightAlsoLikeElement)){
		for (WebElement imageUnderYouMightAlsoLikeEle : imageUnderYouMightAlsoLike){
			executor.verifyTrue(imageUnderYouMightAlsoLikeEle.isDisplayed(), "verify Images are displayed");
		}
		
		}
		
		new BrokenLinks(driver, wait, test).verifyLinks(imageUnderYouMightAlsoLike_Links);
		
		for(WebElement youMayLike : youMayAlsoLike_links){
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(youMayLike)));
			new BrokenLinks(driver, wait, test).verifyLink(youMayLike);
		}
		
		
		new BrokenLinks(driver, wait, test).verifyLinks(mostPopularInThisCategory_links);
		
		executor.verifyTrue(relatedCategories_title.isDisplayed(), "Verify this title :"+relatedCategories_title.getText());
		
		new BrokenLinks(driver, wait, test).verifyLinks(relatedCategory_links);
		
		List<WebElement> lis=driver.findElements(By.tagName("iframe"));
		
		System.out.println(lis.size());
		
		for(WebElement e:lis){
			
			System.out.println(e.getAttribute("id"));
			
			if(e.getAttribute("id").equals("twitter-widget-0")){
				executor.verifyTrue(e.getAttribute("id").equals("twitter-widget-0"), "verify twitter Iframe is displayed");
				break;
			}
			
		}
		
	}
	
	public void qAndAtitleElement(){
		for (WebElement qAndATitleElement : qAndATitle_elements){
			executor.verifyTrue(qAndATitleElement.isDisplayed(), "Verify title element is displayed :"+qAndATitleElement.getText());
		}
		
		if(executor.isElementPresent(haveYourOwnQuestionElement)){
		executor.verifyTrue(haveYourOwnQuestion.isDisplayed(), "verify description question:"+haveYourOwnQuestion.getText());
		}
		
		if(executor.isElementPresent(askTheCommunityElement_link)){
		new BrokenLinks(driver, wait, test).verifyLink(askTheCommunity_link);
		}
	}
	
	
	public void rightSideQAndAElements(){
		
		DetailedPageRightsideElementsPage detailedPageRightsideElements = new DetailedPageRightsideElementsPage(driver, test, wait);
		
		detailedPageRightsideElements.qAndAtitleElement();
		
		if(executor.isElementPresent(relatedQuestionsElement)){
		executor.verifyTrue(relatedQuestions.isDisplayed(), "verify related questions:"+relatedQuestions.getText());
		}
		
		new BrokenLinks(driver, wait, test).verifyLinks(relatedQuestions_links);
	}
}
