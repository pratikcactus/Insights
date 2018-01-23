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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author swapnil.raut
 *
 */
public class AboutUsExtendedPage1 {
	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private AboutUsPage aboutUsPage;

	@FindBy(css = ".panels-ajax-tab li.list-4 a")
	WebElement ourTeam_lnk;

	@FindBy(xpath = "//iframe[contains(@src,'youtube')]")
	WebElement iframeforVideo;

	@FindBy(css = "#player")
	WebElement veriFyIframeVideo;

	@FindBy(xpath = "//h2[text()='Core Team']")
	WebElement coreTeamHeading;

	@FindBy(xpath = "//h4[text()='Contributors']")
	WebElement contributorHeading;

	@FindBy(css = "p.ot-text-a")
	WebElement coreTeamPAragraph;

	@FindBy(css = "p.ot-text-b")
	List<WebElement> contributorParagraphs;

	@FindBy(css = ".ot-profile-top li img")
	List<WebElement> ourTeamMembers;

	@FindBy(css = ".ot-profile-top li h3 a")
	List<WebElement> ourTeamMembersNameLinks;

	@FindBy(xpath = "//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//a[text()='View posts']")
	WebElement ourTeamViewPosts;
	By ourTeamViewPostsElement = By.xpath("//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//a[text()='View posts']");

	@FindBy(xpath = "//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//p")
	WebElement ourTeamPostContent;
	
	@FindBy(xpath="//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//a[@class='ot-modal-close']")
	WebElement closeViewPost;

	@FindBy(css = "#abtus-page")
	WebElement aboutUsPageEle;
	
	@FindBy(xpath="(//a[@title='View user profile.'])[1]")
	WebElement userTitle;
	
	@FindBy(xpath="//*[@title='View user profile.']/img")
	WebElement userImage;
	
	@FindBy(css = ".views-field-field-byline p")
	List<WebElement> userIntrductionParagraphs;
	
	@FindBy(css=".ot-profile-bot ul li img")
	List<WebElement> ourTeamContributors;
	
	@FindBy(css=".ot-profile-bot ul li h3 a")
	List<WebElement> Contributors_lnk;
	
	By contributorViewPostLinkElement = By.xpath("//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//p[@class='ot-profile-tt-header-p']//a");
	@FindBy(xpath="//*[@class='ot-profile-tt-hide' and contains(@style,'display: block;')]//p[@class='ot-profile-tt-header-p']//a")
	WebElement contributorViewPostLink;
	
	@FindBy(xpath="//h2[text()='Contribute as a Guest']")
	WebElement contributeAsAGuestTitle;
	
	@FindBy(css="p.cag-text-a")
	List<WebElement> guestParagraphs1;
	
	@FindBy(css="div.cag-text-b")
	WebElement shareUrViewsparagraph;
	
	@FindBy(css="#panels-ajax-tab-container-aboutus .pane-content span")
	List<WebElement> guestParagraphs2;
	
	@FindBy(css="#panels-ajax-tab-container-aboutus .cag-text-d a")
	WebElement editageInsightLink;
	
	@FindBy(css="#panels-ajax-tab-container-aboutus .cag-text-d")
	WebElement guestParagraphs3;
	
	@FindBy(css=".cag-text-list li")
	List <WebElement> guestParagraphs4;
	
	By addYourSelfElement_lnk = By.xpath("//a[@href='/insights/about_us/contribute-as-a-guest']//h3");
	@FindBy(xpath="//a[@href='/insights/about_us/contribute-as-a-guest']//h3")
	WebElement addYourSelf_lnk;
	
	@FindBy(css = ".panels-ajax-tab li.list-5 a")
	WebElement contributeAsAGuest_lnk;
	
	public AboutUsExtendedPage1(WebDriver driver, ExtentTest test,WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
	}

	public void aboutUsOurTeam() {
		clickOurteam();
		verifyVideo();
		ourTeamHeadingsAndParagraph();
		ourteamPeopleAndtheirDetails();
		
	}
	public void teamContributorsforInsights(){
		clickContributeAsAGuest();
		ourteamContributorDetails();
	}	

	public void validateUserInfo(){
		executor.softWaitforVisibilityOfWebElement(userTitle, "wait for user title");
		executor.verifyTrue(userTitle.isDisplayed(), "verify user titlke is :"+" "+userTitle.getAttribute("href"));
		
		for(WebElement userIntrductionParagraph:userIntrductionParagraphs){
			executor.softWaitforVisibilityOfWebElement(userIntrductionParagraph, "wait for user introduction paragraph");
			executor.verifyTrue(userIntrductionParagraph.isDisplayed(), "wait for user introduction paragraph"+userIntrductionParagraph.getText());
		}
		
			executor.verifyTrue(userImage.isDisplayed(), "verify Image is displayed");
	}

	private void clickOurteam() {
		executor.softWaitforVisibilityOfWebElement(ourTeam_lnk,"Wait for element ourTeam_lnk");
		executor.actionClick(ourTeam_lnk, "click on our team link");
		executor.softWaitforVisibilityOfWebElement(coreTeamHeading, "wait for assertion of this page");
		executor.assertTrue(coreTeamHeading.getText().contains("Core Team"), "assertion for 'Our Team' page'");
	}


	private void verifyVideo() {
		executor.softWaitforVisibilityOfWebElement(iframeforVideo,"Wait for visibility of the video");
		driver.switchTo().frame(iframeforVideo);
		executor.softWaitforVisibilityOfWebElement(veriFyIframeVideo,"wait for Video to be visible");
		executor.verifyTrue(veriFyIframeVideo.isDisplayed(),"verify you tube window is displayed");
		driver.switchTo().defaultContent();
	}
	private void ourTeamHeadingsAndParagraph() {
		executor.softWaitforVisibilityOfWebElement(coreTeamHeading,"wait for coreTeamHeading");
		executor.verifyTrue(coreTeamHeading.isDisplayed(),"verify" + " " + coreTeamHeading.getText());

		executor.softWaitforVisibilityOfWebElement(coreTeamPAragraph,"wait for coreTeamPAragraph");
		executor.verifyTrue(coreTeamPAragraph.isDisplayed(),"verify" + " " + coreTeamPAragraph.getText());

		executor.softWaitforVisibilityOfWebElement(contributorHeading,"wait for contributorHeading");
		executor.verifyTrue(contributorHeading.isDisplayed(),"verify" + " " + contributorHeading.getText());

		for (WebElement contributorParagraph : contributorParagraphs) {
			executor.softWaitforVisibilityOfWebElement(contributorParagraph,"wait for contributorParagraph");
			executor.verifyTrue(contributorParagraph.isDisplayed(),"verify" + " " + contributorParagraph.getText());
			executor.pause(3);
		}

	}
	
	private void ourteamPeopleAndtheirDetails() {

		for (WebElement ourTeamMember : ourTeamMembers) {
			executor.softWaitforVisibilityOfWebElement(ourTeamMember,"wait for ourTeamMember ");
			executor.verifyTrue(ourTeamMember.isDisplayed(),"verify Team members are displayed:"+ ourTeamMember.getAttribute("alt"));
		}

		for (WebElement ourTeammemberLink : ourTeamMembersNameLinks) {
			executor.softWaitforVisibilityOfWebElement(ourTeammemberLink,"wait for ourTeammemberLink");
			executor.scrollIntoView(ourTeammemberLink);
			executor.clickJS(ourTeammemberLink,"click on the our" + "" + ourTeammemberLink.getText());
			String windowHandle = driver.getWindowHandle();
			
				if (executor.isElementPresent(ourTeamViewPostsElement)) 
				{			
					//executor.verifyTrue(ourTeamPostContent.isDisplayed(),"verify post content"+ourTeamPostContent.getText());			
					executor.softWaitforVisibilityOfWebElement(ourTeamViewPosts,"wait for view post to be visible");
					String url = ourTeamViewPosts.getAttribute("href");
					executor.openSeperateBlankWindow();
					executor.navigateToURL(url);
					validateUserInfo();
					executor.closeBrowser();
					driver.switchTo().window(windowHandle);
					executor.clickJS(closeViewPost,"Close the webElement");		
				}
				else{
				executor.clickJS(closeViewPost,"Close the webElement");		
				}
			}	
		}

		private void clickContributeAsAGuest() {
			executor.softWaitforVisibilityOfWebElement(contributeAsAGuest_lnk,"Wait for element contributeAsAGuest_lnk");
			executor.actionClick(contributeAsAGuest_lnk, "click oncontributeAsAGuest_lnk");
			executor.softWaitforVisibilityOfWebElement(contributeAsAGuestTitle, "wait for assertion of this page");
			executor.assertTrue(contributeAsAGuestTitle.getText().contains("Contribute as a Guest"), "assertion for 'Contribute as a Guest' page'");
		}
	private void ourteamContributorDetails() {
		
		for (WebElement teamContributor :ourTeamContributors){
			executor.softWaitforVisibilityOfWebElement(teamContributor, "Wait for team contributor");
			executor.scrollIntoView(teamContributor);
			executor.verifyTrue(teamContributor.isDisplayed(), "verify team contributor link is"+teamContributor.getAttribute("src"));
			}
		for(WebElement contributorLink:Contributors_lnk){
			executor.softWaitforVisibilityOfWebElement(contributorLink, "wait for contributorLink");
			executor.actionClick(contributorLink,"click on contributor link");
			String windowHandle2 = driver.getWindowHandle();
			if(executor.isElementPresent(contributorViewPostLinkElement)){
				executor.softWaitforVisibilityOfWebElement(contributorViewPostLinkElement, "wait for the contributor link to be visible");
				executor.verifyTrue(contributorViewPostLink.isDisplayed(), "verify contributorPostLink"+contributorLink.getAttribute("href"));
				String url = contributorViewPostLink.getAttribute("href");
				executor.openSeperateBlankWindow();
				executor.navigateToURL(url);
				validateUserInfo();
				executor.closeBrowser();
				driver.switchTo().window(windowHandle2);
				executor.clickJS(closeViewPost,"Close the webElement");
			}
		}
		
		if(executor.isElementPresent(addYourSelfElement_lnk)){
			executor.softWaitforVisibilityOfWebElement(addYourSelf_lnk, "wait for addYourSelf_lnk");
			executor.actionClick(addYourSelf_lnk,"click on addYourSelf link");
			executor.softWaitforVisibilityOfWebElement(contributeAsAGuestTitle, "wait for contributorLink");
			executor.verifyTrue(contributeAsAGuestTitle.isDisplayed(),"verify Team members are displayed:"+ contributeAsAGuestTitle.getText());
			for(WebElement guestParagraph1:guestParagraphs1){
				executor.softWaitforVisibilityOfWebElement(guestParagraph1, "wait for visibility of guest paragraph");
				executor.verifyTrue(guestParagraph1.isDisplayed(), "verify team contributor link is"+guestParagraph1.getText());
			}
			executor.softWaitforVisibilityOfWebElement(shareUrViewsparagraph, "wait for shareUrViewsparagraph");
			executor.verifyTrue(shareUrViewsparagraph.isDisplayed(),"verify shareUrViewsparagraph"+ shareUrViewsparagraph.getText());
			for(WebElement guestListOfParagraph :guestParagraphs2){
				executor.softWaitforVisibilityOfWebElement(guestListOfParagraph, "wait for guestListOfParagraph");
				executor.verifyTrue(guestListOfParagraph.isDisplayed(),"verify guestListOfParagraph"+ guestListOfParagraph.getText());
			}
			executor.verifyTrue(guestParagraphs3.isDisplayed(), "guest paragraph3 is verified"+guestParagraphs3.getText());
			for(WebElement guestParagraph4 :guestParagraphs4){
				executor.softWaitforVisibilityOfWebElement(guestParagraph4, "wait for guestParagraphs4");
				executor.verifyTrue(guestParagraph4.isDisplayed(),"verify guestParagraphs4"+ guestParagraph4.getText());
			}
		}
	}
		
}
