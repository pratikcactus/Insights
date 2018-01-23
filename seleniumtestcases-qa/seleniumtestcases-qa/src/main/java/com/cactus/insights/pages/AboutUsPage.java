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
import com.cactus.inits.Config;
import com.cactus.utils.BrokenLinks;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author swapnil.raut
 *
 */
public class AboutUsPage {
	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private AboutUsPage aboutUsPage;

	@FindBy(css = "#userbar ul li.list-2 a")
	WebElement aboutUs_lnk;

	@FindBy(xpath = "//h1[text()='About Editage Insights']")
	WebElement aboutEditageInsights_heading;

	public WebElement getAboutEditageInsights_heading() {
		return aboutEditageInsights_heading;
	}

	@FindBy(xpath = "//h2[text()='What is Editage Insights?']")
	WebElement whatIsEditageInsights_heading;

	@FindBy(xpath = "//h3[text()='Our vision']")
	WebElement ourVision_heading;

	@FindBy(xpath = "//h3[text()='Global reach']")
	WebElement globalReach_heading;

	@FindBy(xpath = "//h2[text()='Ask a question']")
	WebElement askAQuestion_heading;

	@FindBy(css = ".pane-custom.pane-3 p:nth-child(1) iframe")
	WebElement videoInIframe;

	@FindBy(css = "div.ytp-cued-thumbnail-overlay-image")
	WebElement youTubeInsightsVideo;

	@FindBy(css = "p.content-a")
	List<WebElement> aboutUsParagraphList1;

	@FindBy(css = ".content-b")
	List<WebElement> aboutUsParagraphList2;

	@FindBy(css = ".dr-eddy-text")
	WebElement aboutUsParagraph3;

	@FindBy(css = "#mini-panel-bottom_block_ .panel-panel.panel-col a ")
	List<WebElement> miscLinksAtBottom_lnk;

	@FindBy(css = ".publication-cycle-img")
	WebElement publicationCycleImg;

	@FindBy(css = ".languages-wrap a")
	List<WebElement> languageWrapperList_lnk;

	@FindBy(css = ".panels-ajax-tab li a[href='/insights/about-us/who-is-it-for']")
	WebElement whoIsItFor_lnk;

	@FindBy(xpath = "//h2[text()='Who is it for?']")
	WebElement whoIsItFor_heading;

	@FindBy(css = "p.wei-text-a")
	WebElement whoIsItForParagraph;

	@FindBy(css = "ul[role='tablist'] li")
	List<WebElement> responsiveTabParagraphs;

	By tablistParagraph1Element = By.cssSelector("#tablist1-panel1>p");
	@FindBy(css = "#tablist1-panel1>p")
	WebElement tablistParagraph1;

	@FindBy(xpath = "//div[text()='Resources on manuscript preparation']")
	WebElement earlyCareerResearcherHeading1;

	@FindBy(xpath = "//div[text()='Understanding journal publication']")
	WebElement earlyCareerResearcherHeading2;

	@FindBy(css = "div#tablist1-panel1 ul a")
	List<WebElement> tablistParagraph1_lnk;

	@FindBy(css = "#tablist1-panel1 .wei-tabs-content-link a")
	List<WebElement> tablistParagraph1Explore_lnk;

	By tablistParagraph2Element = By.cssSelector("#tablist1-panel2>p");
	@FindBy(css = "#tablist1-panel2>p")
	WebElement tablistParagraph2;

	@FindBy(xpath = "//div[text()='Publication ethics']")
	WebElement seniorResearchersHeading1;

	@FindBy(xpath = "//div[text()='Global trends']")
	WebElement seniorResearchersHeading2;

	@FindBy(css = "div#tablist1-panel2 ul a")
	List<WebElement> tablistParagraph2_lnk;

	@FindBy(css = "#tablist1-panel2 .wei-tabs-content-link a")
	List<WebElement> tablistParagraph2Explore_lnk;

	By tablistParagraph3Element = By.cssSelector("#tablist1-panel3>p");
	@FindBy(css = "#tablist1-panel3>p")
	WebElement tablistParagraph3;

	@FindBy(xpath = "//div[text()='Industry hot topics for discussion']")
	WebElement journalAndPublisherHeading1;

	@FindBy(xpath = "//div[text()='Interviews with industry experts']")
	WebElement journalAndPublisherHeading2;

	@FindBy(css = "div#tablist1-panel3 ul a")
	List<WebElement> tablistParagraph3_lnk;

	@FindBy(css = "#tablist1-panel3 .wei-tabs-content-link a")
	List<WebElement> tablistParagraph3Explore_lnk;

	By tablistParagraph4Element = By.cssSelector("#tablist1-panel4>p:nth-child(1)");
	@FindBy(css = "#tablist1-panel4>p:nth-child(1)")
	WebElement tablistParagraph4;

	@FindBy(css = "#tablist1-panel4>p")
	List<WebElement> tablistParagraphs4;

	@FindBy(xpath = "//div[text()='How the Editage Insights plug-in can help your institution:']")
	WebElement AcademicInstitutionsAndGroupHeading;

	@FindBy(css = "#tablist1-panel4 .wei-tabs-content-list")
	WebElement AcademicInstitutionParagraph;

	@FindBy(css = ".last-tab a")
	WebElement contactUs_lnk;

	@FindBy(xpath = "//div[@class='wei-tabs-content-link last-tab']")
	WebElement contactUswithText;

	@FindBy(css = ".panels-ajax-tab li.list-3 a")
	WebElement specialFeature_lnk;

	@FindBy(xpath = "//h2[text()='Special Features']")
	WebElement specialFeatureHeading;

	@FindBy(css = "p.os-text-a")
	WebElement specialFeatureParagraph;

	@FindBy(xpath = "//div[text()='Great benefits of registration']")
	WebElement greatBenifitOfregistration;

	@FindBy(css = ".eie-benefits-lft-img")
	WebElement yourLibraryImage;

	@FindBy(css = ".eie-benefits-mid-img")
	WebElement askAQuestionImage;

	@FindBy(css = ".eie-benefits-rgt-img")
	WebElement webinarHighlightsImage;

	@FindBy(css = ".eie-benefits-lft h3")
	WebElement yourLibraryTxt;

	@FindBy(css = ".eie-benefits-mid h3")
	WebElement askAQuestionTxt;

	@FindBy(css = ".eie-benefits-rgt h3")
	WebElement webinarHighlightsTxt;

	@FindBy(css = ".eie-features-box-lft")
	List<WebElement> featureBoxes_left;

	@FindBy(css = ".eie-features-box-rgt")
	List<WebElement> featureBoxes_right;

	@FindBy(css = ".eie-btn-submit a")
	WebElement registerNow_Lnk;

	@FindBy(css = ".eie-btn-text")
	WebElement registerNowTxt;

	public AboutUsPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
	}

	public void aboutUsWhatIsEditageInsights() {
		clickAboutUsLink();
		verifyWhatIsEditageInsights();
		iframeForAboutUs();
		aboutUsParagraph();
		aboutUsLinksandImage();
	}

	public void aboutUsWhoIsItFor() {
		clickWhoIsItFor();
		verifyWhoIsItForHeadings();
		whoIsItForParagraph();
	}

	public void aboutUsSpecialFeature() {
		clickSpecialFeature();
		verifySpecialFeatureHeadings();
		verifySpecialFeatureParagrapgAndImages();
	}

	public void clickAboutUsLink() {
		executor.softWaitforVisibilityOfWebElement(aboutUs_lnk, "wait for about us link");
		executor.click(aboutUs_lnk, "click on aboutUs link");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_ABOUT_US.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Check Services  Page");
		}
	}

	private void verifyWhatIsEditageInsights() {
		aboutUsPage = new AboutUsPage(driver, test, wait);

		executor.softWaitforVisibilityOfWebElement(aboutUsPage.getAboutEditageInsights_heading(),
				"wait for aboutEditageInsights_heading to be visible");
		executor.verifyTrue(aboutUsPage.getAboutEditageInsights_heading().isDisplayed(),
				"verify the Heading:" + aboutEditageInsights_heading.getText());

		executor.softWaitforVisibilityOfWebElement(whatIsEditageInsights_heading,
				"wait for whatIsEditageInsights_heading");
		executor.verifyTrue(whatIsEditageInsights_heading.isDisplayed(),
				"verify the Heading:" + whatIsEditageInsights_heading.getText());

		executor.softWaitforVisibilityOfWebElement(globalReach_heading, "wait for globalReach_heading");
		executor.verifyTrue(globalReach_heading.isDisplayed(), "verify the Heading:" + globalReach_heading.getText());

		executor.softWaitforVisibilityOfWebElement(ourVision_heading, "wait for ourVision_heading");
		executor.verifyTrue(ourVision_heading.isDisplayed(), "verify the Heading:" + ourVision_heading.getText());

		executor.softWaitforVisibilityOfWebElement(askAQuestion_heading, "wait for askAQuestion_heading");
		executor.verifyTrue(askAQuestion_heading.isDisplayed(), "verify the Heading:" + askAQuestion_heading.getText());
	}

	private void iframeForAboutUs() {
		driver.switchTo().frame(videoInIframe);
		executor.verifyTrue(youTubeInsightsVideo.isDisplayed(), "verify the you tube video is displayed");
		driver.switchTo().defaultContent();
	}

	private void aboutUsParagraph() {
		for (WebElement aboutUsParagraph : aboutUsParagraphList1) {
			executor.softWaitforVisibilityOfWebElement(aboutUsParagraph, "wait for each paragraph to be visible");
			executor.verifyTrue(aboutUsParagraph.isDisplayed(), "verify each aboutUS paragraph");

		}

		for (WebElement aboutUsParagraph2 : aboutUsParagraphList2) {
			executor.softWaitforVisibilityOfWebElement(aboutUsParagraph2, "wait for each paragraph to be visible");
			executor.verifyTrue(aboutUsParagraph2.isDisplayed(), "verify each aboutUS paragraph");
		}

		executor.softWaitforVisibilityOfWebElement(aboutUsParagraph3, "wait for aboutUsParagraph3");
		executor.verifyTrue(aboutUsParagraph3.isDisplayed(), "verify aboutUsParagraph3");
	}

	private void aboutUsLinksandImage() {

		new BrokenLinks(driver, wait, test).verifyLinks(miscLinksAtBottom_lnk);

		new BrokenLinks(driver, wait, test).verifyLinks(languageWrapperList_lnk);

		executor.softWaitforVisibilityOfWebElement(publicationCycleImg, "wait for image to be displayed");
		executor.verifyTrue(publicationCycleImg.isDisplayed(), "wait for the Image to be displayed");
		// util.imageChecker(publicationCycleImg, driver);
	}

	private void clickWhoIsItFor() {

		executor.softWaitforVisibilityOfWebElement(whoIsItFor_lnk, "wait for whoIsItFor_lnk");
		executor.clickJS(whoIsItFor_lnk, "click on Who Is It For link");
		executor.softWaitforVisibilityOfWebElement(whoIsItFor_heading, "wait for the web element to be visible");
		executor.assertTrue(whoIsItFor_heading.getText().contains("Who is it for?"), "assertion for 'Who is it for page'");

	}

	private void verifyWhoIsItForHeadings() {
		aboutUsPage = new AboutUsPage(driver, test, wait);

		executor.softWaitforVisibilityOfWebElement(aboutUsPage.getAboutEditageInsights_heading(),
				"wait for aboutEditageInsights_heading to be visible");
		executor.verifyTrue(aboutUsPage.getAboutEditageInsights_heading().isDisplayed(),
				"verify the Heading:" + aboutEditageInsights_heading.getText());

		executor.softWaitforVisibilityOfWebElement(whoIsItFor_heading, "wait for whoIsItFor_heading");
		executor.verifyTrue(whoIsItFor_heading.isDisplayed(),
				"verify whoIsItFor_heading" + whoIsItFor_heading.getText());
	}

	private void whoIsItForParagraph() {
		executor.softWaitforVisibilityOfWebElement(whoIsItForParagraph, "Wait for whoIsItForParagraph");
		executor.verifyTrue(whoIsItForParagraph.isDisplayed(),
				"verify whoIsItForParagraph:" + whoIsItForParagraph.getText());

		for (WebElement responsiveTab : responsiveTabParagraphs) {

			executor.softWaitforVisibilityOfWebElement(responsiveTab,
					"wait for the responsive tab to be visible from list:" + responsiveTab.getAttribute("id"));
			executor.actionClick(responsiveTab,
					"click on responsive tab to display its paragraph" + responsiveTab.getAttribute("Id"));

			if (executor.isElementPresent(tablistParagraph1Element) && tablistParagraph1.isDisplayed()) {
				executor.softWaitforVisibilityOfWebElement(tablistParagraph1, "wait for aboutUsParagraphList1");
				executor.verifyTrue(tablistParagraph1.isDisplayed(),
						"verify tablistParagraph1" + tablistParagraph1.getText());

				executor.softWaitforVisibilityOfWebElement(earlyCareerResearcherHeading1,
						"wait for element earlyCareerResearcherHeading1");
				executor.verifyTrue(earlyCareerResearcherHeading1.isDisplayed(),
						"verify senorResearchersHeading1" + earlyCareerResearcherHeading1.getText());

				executor.softWaitforVisibilityOfWebElement(earlyCareerResearcherHeading1,
						"wait for element earlyCareerResearcherHeading1");
				executor.verifyTrue(earlyCareerResearcherHeading2.isDisplayed(),
						"verify earlyCareerResearcherHeading" + earlyCareerResearcherHeading2.getText());

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph1_lnk);

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph1Explore_lnk);
			}
			if (executor.isElementPresent(tablistParagraph2Element) && tablistParagraph2.isDisplayed()) {

				executor.softWaitforVisibilityOfWebElement(tablistParagraph2, "wait for tablistParagraph2");
				executor.verifyTrue(tablistParagraph2.isDisplayed(),
						"verify tablistParagraph2" + tablistParagraph2.getText());

				executor.softWaitforVisibilityOfWebElement(seniorResearchersHeading1,
						"wait for element seniorResearchersHeading1");
				executor.verifyTrue(seniorResearchersHeading1.isDisplayed(),
						"verify senorResearchersHeading1" + seniorResearchersHeading1.getText());

				executor.softWaitforVisibilityOfWebElement(seniorResearchersHeading2,
						"wait for element seniorResearchersHeading2");
				executor.verifyTrue(seniorResearchersHeading2.isDisplayed(),
						"verify senorResearchersHeading2" + seniorResearchersHeading2.getText());

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph2_lnk);

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph2Explore_lnk);
			}
			if (executor.isElementPresent(tablistParagraph3Element) && tablistParagraph3.isDisplayed()) {
				executor.softWaitforVisibilityOfWebElement(tablistParagraph3, "wait for tablistParagraph3");
				executor.verifyTrue(tablistParagraph3.isDisplayed(),
						"verify tablistParagraph3" + tablistParagraph3.getText());

				executor.softWaitforVisibilityOfWebElement(journalAndPublisherHeading1,
						"wait for element journalAndPublisherHeading1");
				executor.verifyTrue(journalAndPublisherHeading1.isDisplayed(),
						"verify journalAndPublisherHeading1" + journalAndPublisherHeading1.getText());

				executor.softWaitforVisibilityOfWebElement(journalAndPublisherHeading2,
						"wait for element journalAndPublisherHeading2");
				executor.verifyTrue(journalAndPublisherHeading2.isDisplayed(),
						"verify journalAndPublisherHeading2" + journalAndPublisherHeading2.getText());

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph3_lnk);

				new BrokenLinks(driver, wait, test).verifyLinks(tablistParagraph3Explore_lnk);

			}
			if (executor.isElementPresent(tablistParagraph4Element) && tablistParagraph4.isDisplayed()) {

				for (WebElement tablistParagraph : tablistParagraphs4) {
					executor.softWaitforVisibilityOfWebElement(tablistParagraph, "wait for tablistParagraph3");
					executor.verifyTrue(tablistParagraph.isDisplayed(),
							"verify tablistParagraph" + tablistParagraph.getText());
				}
				executor.verifyTrue(AcademicInstitutionsAndGroupHeading.isDisplayed(),
						"verify AcademicInstitutionsAndGroupHeading" + AcademicInstitutionsAndGroupHeading.getText());

				executor.verifyTrue(AcademicInstitutionParagraph.isDisplayed(),
						"verify AcademicInstitutionParagraph" + AcademicInstitutionParagraph.getText());

				new BrokenLinks(driver, wait, test).verifyLink(contactUs_lnk);

				executor.verifyTrue(contactUswithText.isDisplayed(),
						"verify contactUswithText" + contactUswithText.getText());
				break;
			}
		}

		new BrokenLinks(driver, wait, test).verifyLinks(miscLinksAtBottom_lnk);
	}

	private void clickSpecialFeature() {
		executor.softWaitforVisibilityOfWebElement(specialFeature_lnk, "wait for whoIsItFor_lnk");
		executor.clickJS(specialFeature_lnk, "click on specialFeature_lnk");
		executor.softWaitforVisibilityOfWebElement(specialFeatureHeading, "wait for the web element to be visible");
		executor.assertTrue(specialFeatureHeading.getText().contains("Special Features"), "assertion for 'Special Features page'");
	}

	private void verifySpecialFeatureHeadings() {
		aboutUsPage = new AboutUsPage(driver, test, wait);

		executor.softWaitforVisibilityOfWebElement(aboutUsPage.getAboutEditageInsights_heading(),
				"wait for aboutEditageInsights_heading to be visible");
		executor.verifyTrue(aboutUsPage.getAboutEditageInsights_heading().isDisplayed(),
				"verify the Heading:" + aboutEditageInsights_heading.getText());

		executor.softWaitforVisibilityOfWebElement(specialFeatureHeading,
				"wait for specialFeatureHeading to be visible");
		executor.verifyTrue(specialFeatureHeading.isDisplayed(),
				"verify the Heading:" + specialFeatureHeading.getText());

	}

	private void verifySpecialFeatureParagrapgAndImages() {
		executor.softWaitforVisibilityOfWebElement(greatBenifitOfregistration,
				"wait for element greatBenifitOfregistration");
		executor.verifyTrue(greatBenifitOfregistration.isDisplayed(),
				"verify" + " " + greatBenifitOfregistration.getText());

		executor.softWaitforVisibilityOfWebElement(specialFeatureParagraph, "wait for element specialFeatureParagraph");
		executor.verifyTrue(specialFeatureParagraph.isDisplayed(), "verify" + " " + specialFeatureParagraph.getText());

		executor.softWaitforVisibilityOfWebElement(yourLibraryImage, "wait for element yourLibraryImage");
		executor.verifyTrue(yourLibraryImage.isDisplayed(), "verify yourLibraryImage");

		executor.softWaitforVisibilityOfWebElement(askAQuestionImage, "wait for element greatBenifitOfregistration");
		executor.verifyTrue(askAQuestionImage.isDisplayed(), "verify askAQuestionImage");

		executor.softWaitforVisibilityOfWebElement(webinarHighlightsImage, "wait for element webinarHighlightsImage");
		executor.verifyTrue(webinarHighlightsImage.isDisplayed(), "verify webinarHighlightsImage");

		executor.softWaitforVisibilityOfWebElement(yourLibraryTxt, "wait for element yourLibraryTxt");
		executor.verifyTrue(yourLibraryTxt.isDisplayed(), "verify" + " " + yourLibraryTxt.getText());

		executor.softWaitforVisibilityOfWebElement(askAQuestionTxt, "wait for element askAQuestionTxt");
		executor.verifyTrue(askAQuestionTxt.isDisplayed(), "verify" + " " + askAQuestionTxt.getText());

		executor.softWaitforVisibilityOfWebElement(webinarHighlightsTxt, "wait for element greatBenifitOfregistration");
		executor.verifyTrue(webinarHighlightsTxt.isDisplayed(), "verify" + " " + webinarHighlightsTxt.getText());

		for (WebElement featureBoxLft : featureBoxes_left) {
			executor.softWaitforVisibilityOfWebElement(featureBoxLft, "Wait for element featureBoxLft");
			executor.verifyTrue(featureBoxLft.isDisplayed(), "verify left feature box");
		}
		for (WebElement featureBoxRgt : featureBoxes_right) {
			executor.softWaitforVisibilityOfWebElement(featureBoxRgt, "Wait for element featureBoxRgt");
			executor.verifyTrue(featureBoxRgt.isDisplayed(), "verify right feature box");
		}

		new BrokenLinks(driver, wait, test).verifyLink(registerNow_Lnk);

		executor.softWaitforVisibilityOfWebElement(registerNowTxt, "wait for regiterNow text");
		executor.verifyTrue(registerNowTxt.isDisplayed(), "verify :" + " " + registerNowTxt.getText());

		new BrokenLinks(driver, wait, test).verifyLinks(miscLinksAtBottom_lnk);
	}
}
