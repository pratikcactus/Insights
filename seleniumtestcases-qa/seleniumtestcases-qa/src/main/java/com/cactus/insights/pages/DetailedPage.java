package com.cactus.insights.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class DetailedPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage loginPage;

	@FindBy(css = "span.content-listing-type")
	List<WebElement> listingTypes;

	@FindBy(css = "div.content-listing-title a")
	List<WebElement> listingHeaderTypes;

	@FindBy(css = "div.node-title-q-a")
	WebElement qAndATitle;

	@FindBy(css = "h1")
	WebElement articleTitle;

	/************************* Article Elements **************/
	@FindBy(css = "div.views-field-field-categories a")
	List<WebElement> feildCategories_lnk;

	By feildCategoriesElement_lnk = By.cssSelector("div.field-content a");

	@FindBy(css = "span.author-info>a")
	WebElement author_lnk;

	By authorElement_lnk = By.cssSelector("span.author-info>a");

	@FindBy(css = "span.posted-date")
	WebElement postedDate_txt;

	By postedDateElement_txt = By.cssSelector("span.posted-date");

	@FindBy(css = "span.global-count")
	WebElement globalCount_txt;

	By globalCountElement_txt = By.cssSelector("span.global-count");

	/***
	 * panel reflection for links ("Remove from reading list","Add a
	 * comment,"Republish your website","Print")
	 ***/

	By panelRegion1 = By.cssSelector("div.panel-region-preface div.panel-col a");

	@FindBy(css = "div.panel-region-preface div.panel-col a")
	List<WebElement> panelRegionList1_lnk;

	By panelRegionSaveToReadLater = By
			.xpath("//div[@id='mini-panel-top_toolbar']//a[contains(text(),'Save to read later')]");

	By panelRegionRemoveFromReadingList = By
			.xpath("//div[@id='mini-panel-top_toolbar']//a[@title='Remove from reading list']");

	By panelRegionRepublishOnYourWebsite = By
			.xpath("//div[@id='mini-panel-top_toolbar']//a[(contains(text(),'Republish on your website '))]");

	@FindBy(xpath = "//*[@id='mini-panel-top_toolbar']//a[text()='Add a comment ']")
	WebElement panelAddAComment_lnk;

	By panelAddACommentElement = By.xpath("//*[@id='mini-panel-top_toolbar']//a[text()='Add a comment ']");

	@FindBy(xpath = "//*[@id='mini-panel-top_toolbar']//a[text()='Print ']")
	WebElement panelPrint_lnk;

	By panelPrintElement = By.xpath("//*[@id='mini-panel-top_toolbar']//a[text()='Print ']");

	By panelRegion2 = By.cssSelector("div.pane-panels-mini.pane-footer-toolbar a");

	By tagLinksElement = By.cssSelector(".field--label-inline a");

	@FindBy(css = ".field--label-inline a")
	List<WebElement> tagLinks;

	@FindBy(css = "div.panel-region-preface div.panel-col a")
	List<WebElement> panelRegionList2_lnk;

	By republishOnyourWebsiteTitleElement = By.cssSelector("div.overlay.republish-block h2");
	@FindBy(css = "div.overlay.republish-block h2")
	WebElement republishOnyourWebsiteTitle;

	@FindBy(css = "#txtarea")
	WebElement republishTextArea;

	@FindBy(css = "div.overlay.republish-block a.close-button")
	WebElement republishCloseIcon;
	/***************************************************************************************/
	@FindBy(css = "#md1>div.field__item.even>img[src]")
	WebElement imageIElement;

	By imageElementPresent = By.cssSelector("#md1>div.field__item.even>img[src]");

	@FindBy(css = "article[role='article'] div.pane-content p")
	List<WebElement> articleParagraphsTxt;

	By articleParagraphElement = By.cssSelector("article[role='article']");

	/***********************
	 * Q and A Elements
	 *****************************************/

	@FindBy(css = "span.views-count-text")
	WebElement qandAViews;

	@FindBy(css = "#md2 a")
	WebElement grammerAndWriting;

	By grammerAndWritingElement = By.cssSelector("#md2 a");

	@FindBy(css = "#md4 p")
	List<WebElement> qandAParagraphs1;

	@FindBy(css = "div.node-user-profile-picture img")
	WebElement qandAUserImage;

	@FindBy(xpath = "((//div[@class='node-user-profile-submitted'])//a)[1]")
	WebElement qandAUserName;

	@FindBy(css = "span.submitted-date")
	WebElement qandASubmittedDate;

	By qandAReplyElement = By.cssSelector("a.answer-reply");
	@FindBy(css = "a.answer-reply")
	WebElement qandAReply;

	@FindBy(css = "a[title='View user profile.'] img")
	WebElement editageInsightimage;

	By qandAEditageInsightsLinkElement = By.xpath("(//div[@class='node-user-profile-submitted']//a)[2]");
	@FindBy(xpath = "(//div[@class='node-user-profile-submitted']//a)[2]")
	WebElement qandAEditageInsightsLink;

	By editageInsightsQandASubmittedDateLinkElement = By.xpath("//footer[@class='node__submitted']//div[@class='node-submitted-date']");
	@FindBy(css = "article div.node-submitted-date")
	WebElement editageInsightsQandASubmittedDate;

	@FindBy(css = "article p")
	List<WebElement> qandAParagraphs2;

	@FindBy(css = "a#rate-button-1")
	WebElement qandALikeButton;

	By labelJoinTheDiscussionElement = By.cssSelector("label[for='edit-field-answer-und-0-value--2']");

	@FindBy(css = "label[for='edit-field-answer-und-0-value--2']")
	WebElement labelJoinTheDiscussion;

	By joinTheDiscussionTextAreaElement = By.cssSelector("#edit-field-answer-und-0-value--2");

	@FindBy(css = "#edit-field-answer-und-0-value--2")
	WebElement joinTheDiscussionTextArea;

	By replyForJoinTheDiscussionElement = By.xpath("(//div[@class='form-actions form-wrapper']/input)[2]");

	@FindBy(xpath = "(//div[@class='form-actions form-wrapper']/input)[2]")
	WebElement replyForJoinTheDiscussion;

	public DetailedPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {

		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
	}

	public void verifyPageArticlesAndImage() throws InterruptedException {

		DetailedPageRightsideElementsPage detailedPageRightsideElements = new DetailedPageRightsideElementsPage(driver,
				test, wait);

		boolean flag1 = false, flag2 = false;
		;
		for (int i = 0; i < listingTypes.size(); i++) {

			if (listingTypes.get(i).getText().equalsIgnoreCase("Q&A FORUM")) {
				String str = listingHeaderTypes.get(i).getText();
				executor.moveToElement(listingHeaderTypes.get(i));
				executor.softWaitforVisibilityOfWebElement(listingHeaderTypes.get(i),
						"wait for this element to be visible");
				String oldTab = driver.getWindowHandle();
				JavascriptExecutor jse = ((JavascriptExecutor) driver);
				jse.executeScript("arguments[0].scrollIntoView(true);", listingHeaderTypes.get(i));
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
				listingHeaderTypes.get(i).sendKeys(selectLinkOpeninNewTab);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				driver.switchTo().window((newTab).get(0));
				executor.softWaitforVisibilityOfWebElement(qAndATitle, "wait for Q and A Title");

				executor.verifyTrue(qandAViews.isDisplayed(),
						"verify 'view' is displayed:" + " " + qandAViews.getText());

				if (executor.isElementPresent(grammerAndWritingElement)) {
					executor.verifyTrue(grammerAndWriting.isDisplayed(),
							"verify 'grammer and writing' is displayed:" + " " + grammerAndWriting.getText());
				}

				for (WebElement qandAParagraph : qandAParagraphs1) {
					executor.verifyTrue(qandAParagraph.isDisplayed(),
							"verify q and a pragraph:" + "" + qandAParagraph.getText());
				}

				executor.softWaitforVisibilityOfWebElement(qandAUserImage, "wait for visibility of Image");
				util.imageChecker(qandAUserImage, driver);

				executor.verifyTrue(qandAUserName.isDisplayed(),
						"verify 'User Name' is displayed:" + " " + qandAUserName.getText());

				executor.verifyTrue(qandASubmittedDate.isDisplayed(),
						"verify 'Submitted date' is displayed:" + " " + qandASubmittedDate.getText());

				if (executor.isElementPresent(qandAReplyElement) && qandAReply.isDisplayed()) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(qandAReply)));
					executor.verifyTrue(qandAReply.isDisplayed(),
							"verify 'Reply button' is displayed:" + " " + qandAReply.getText());
				}

				executor.verifyTrue(editageInsightimage.isDisplayed(),
						"verify 'editage Insight Image' is displayed:" + " " + editageInsightimage.getText());

				if (executor.isElementPresent(qandAEditageInsightsLinkElement)
						&& qandAEditageInsightsLink.isDisplayed()) {
					executor.verifyTrue(qandAEditageInsightsLink.isDisplayed(),
							"verify 'editageInsights Link' is displayed:" + " " + qandAEditageInsightsLink.getText());
				}
				
				if (executor.isElementPresent(editageInsightsQandASubmittedDateLinkElement)
						&& editageInsightsQandASubmittedDate.isDisplayed()) {
				executor.verifyTrue(editageInsightsQandASubmittedDate.isDisplayed(),
						"verify 'editage Insights submitted date' is displayed:" + " "
								+ editageInsightsQandASubmittedDate.getText());
				}

				for (WebElement qandAParagraph2 : qandAParagraphs2) {
					executor.verifyTrue(qandAParagraph2.isDisplayed(),
							"verify 'editage paragraph ' is displayed:" + " " + qandAParagraph2.getText());
				}
				if (executor.isElementPresent(By.cssSelector("a#rate-button-1"))) {
				executor.verifyTrue(qandALikeButton.isDisplayed(),
						"verify 'QandA Like Button' is displayed:" + " " + qandALikeButton.getText());
				}

				if (executor.isElementPresent(labelJoinTheDiscussionElement)) {
					executor.verifyTrue(labelJoinTheDiscussion.isDisplayed(),
							"verify 'label Join The Discussion' is displayed:" + " "
									+ labelJoinTheDiscussion.getText());
				}

				if (executor.isElementPresent(joinTheDiscussionTextAreaElement)) {
					executor.verifyTrue(joinTheDiscussionTextArea.isDisplayed(),
							"verify 'Join The Discussion text area' is displayed:" + " "
									+ joinTheDiscussionTextArea.getText());
				}
				if (executor.isElementPresent(replyForJoinTheDiscussionElement)) {
					executor.verifyTrue(replyForJoinTheDiscussion.isDisplayed(),
							"verify 'label Join The Discussion' is displayed");
				}

				detailedPageRightsideElements.rightSideQAndAElements();

				new IframeDisQus(driver, wait, test).iframeInsightsDisQusElements();

				if (!verifyLinkTitle(qAndATitle, str)) {
					break;
				}
				driver.close();
				driver.switchTo().window(oldTab);
			} else {
				String str1 = listingHeaderTypes.get(i).getText();

				executor.moveToElement(listingHeaderTypes.get(i));
				executor.softWaitforVisibilityOfWebElement(listingHeaderTypes.get(i),
						"wait for this element to be visible");
				String oldTabArticles = driver.getWindowHandle();
				JavascriptExecutor jse = ((JavascriptExecutor) driver);
				jse.executeScript("arguments[0].scrollIntoView(true);", listingHeaderTypes.get(i));
				String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
				listingHeaderTypes.get(i).sendKeys(selectLinkOpeninNewTab);
				ArrayList<String> newTabArticles = new ArrayList<String>(driver.getWindowHandles());
				newTabArticles.remove(oldTabArticles);
				driver.switchTo().window((newTabArticles).get(0));
				executor.softWaitforVisibilityOfWebElement(articleTitle, "wait for article Title");

				if (executor.isElementPresent(imageElementPresent)) {
					executor.softWaitforVisibilityOfWebElement(imageElementPresent, "wait for image to be visible");
					util.imageChecker(imageIElement, driver);
				}

				if (executor.isElementPresent(feildCategoriesElement_lnk)) {
					executor.softWaitforVisibilityOfWebElement(feildCategoriesElement_lnk,
							"wait for visiblity of the feildCategories");
					// executor.verifyTrue(feildCategories_lnk.isDisplayed(),"verify
					// the feild content:" + "" +
					// feildCategories_lnk.getText());
					new BrokenLinks(driver, wait, test).verifyLinks(feildCategories_lnk);
				}
				if (executor.isElementPresent(authorElement_lnk)) {
					executor.verifyTrue(author_lnk.isDisplayed(),
							"verify the Author content:" + "" + author_lnk.getText());
				}
				if (executor.isElementPresent(postedDateElement_txt)) {
					executor.verifyTrue(postedDate_txt.isDisplayed(),
							"verify the posted date content:" + "" + postedDate_txt.getText());
				}
				if (executor.isElementPresent(globalCountElement_txt)) {
					executor.verifyTrue(globalCount_txt.isDisplayed(),
							"verify the number of views:" + "" + postedDate_txt.getText());
				}

				if (executor.isElementPresent(panelRegionSaveToReadLater)) {
					executor.click(panelRegionSaveToReadLater, "click on save to read later");
					executor.pause(2);
				}
				if (executor.isElementPresent(panelRegionRemoveFromReadingList)) {
					executor.softWaitforVisibilityOfWebElement(panelRegionRemoveFromReadingList,
							"wait for the link to display");
					executor.click(panelRegionRemoveFromReadingList, "click on Remove from reading list");
				}
				if (executor.isElementPresent(panelRegionRepublishOnYourWebsite)) {
					executor.softWaitforVisibilityOfWebElement(panelRegionRepublishOnYourWebsite,
							"wait for Republish on your website");
					executor.click(panelRegionRepublishOnYourWebsite, "click on Republish on your website link");
					if (executor.isElementPresent(republishOnyourWebsiteTitleElement)) {
						executor.assertEquals(republishOnyourWebsiteTitle.getText(), "Republish",
								"page title did not match");
						executor.softWaitforVisibilityOfWebElement(republishTextArea,
								"wait for Republish on your website");
						executor.verifyTrue(republishTextArea.isDisplayed(), "verify text area is displayed");
					}
					executor.click(republishCloseIcon, "close out Republish button");
				}

				if (executor.isElementPresent(panelAddACommentElement)) {
					new BrokenLinks(driver, wait, test).verifyLink(panelAddAComment_lnk);
				}
				if (executor.isElementPresent(panelPrintElement)) {
					if (panelPrint_lnk.getAttribute("href").contains("/insights/print")) {
						flag2 = true;
					} else {
						flag2 = false;
					}
					executor.verifyTrue(flag2, "Print is displayed");
				}

				if (executor.isElementPresent(tagLinksElement)) {
					new BrokenLinks(driver, wait, test).verifyLinks(tagLinks);
				}

				if (executor.isElementPresent(imageElementPresent)) {
					util.imageChecker(imageIElement, driver);
				}
				if (executor.isElementPresent(articleParagraphElement)) {
					for (WebElement articleParagraph : articleParagraphsTxt) {
						executor.verifyTrue(articleParagraph.isDisplayed(),
								"verify each paragraph text in the element:" + "" + articleParagraph.getText());
					}
				}
				if (executor.isElementPresent(panelRegion2)) {
					for (WebElement panelElement2 : panelRegionList2_lnk) {
						executor.verifyTrue(panelElement2.isDisplayed(),
								"verify each panel elemnts:" + "" + panelElement2.getText());
					}
				}

				detailedPageRightsideElements.rightSideArticleElements();

				new IframeDisQus(driver, wait, test).iframeInsightsDisQusElements();

				if (!verifyLinkTitle(articleTitle, str1)) {
					break;
				}
				driver.close();
				driver.switchTo().window(oldTabArticles);
			}
		}
		if (driver.getWindowHandles().size() > 1) {
			driver.close();
			executor.findAndSwitchToAvailableWindow();
		}

	}

	public boolean verifyLinkTitle(WebElement title, String str) {
		String elementContentForTitles = title.getText();

		if (str.equalsIgnoreCase(elementContentForTitles)) {
			return true;
		} else {
			return false;
		}
	}

	public class IframeDisQus {
		@FindBy(css = "iframe[title='Disqus']")
		WebElement switchFrame;

		By switchFrameElement = By.cssSelector("iframe[title='Disqus']");

		@FindBy(css = "span.comment-count")
		WebElement commentCountTxt;

		@FindBy(css = "a#community-tab span")
		WebElement editageInsightsTxt;

		@FindBy(css = "span.notification-count")
		WebElement notificationCount;

		// By notificationCount = By.cssSelector("span.notification-count");

		@FindBy(css = "span.dropdown-toggle-wrapper")
		WebElement loginUser;

		@FindBy(css = "span.label.label-default")
		WebElement recommendTxt;

		@FindBy(css = "span.icon-export")
		WebElement iconExport;

		@FindBy(xpath = "//span[@class='label']")
		WebElement iconShare;

		@FindBy(css = "li[data-role='post-sort'] a")
		WebElement sortByNewest_lnk;

		@FindBy(css = "span.user img")
		WebElement imageUser;

		@FindBy(css = "div.textarea")
		WebElement textArea;

		By disqusElement = By.cssSelector("button[title='Disqus']");
		@FindBy(css = "button[title='Disqus']")
		WebElement socialElementDisqus;

		By facebookElement = By.cssSelector("button[title='Disqus']");

		@FindBy(css = "button[title='Facebook']")
		WebElement socialElementFacebook;

		By twitterElement = By.cssSelector("button[title='Disqus']");

		@FindBy(css = "button[title='Twitter']")
		WebElement socialElementTwitter;

		By GoogleElement = By.cssSelector("button[title='Disqus']");

		@FindBy(css = "button[title='Google']")
		WebElement socialElementGoogle;

		@FindBy(css = "input[name='display_name']")
		WebElement nameTxt;

		@FindBy(css = "input[name='email']")
		WebElement emailTxt;

		@FindBy(css = "input[name='password']")
		WebElement passwordTxt;

		@FindBy(css = "div.acceptance-wrapper.register-text")
		WebElement disqusTxt;

		@FindBy(css = "div.acceptance-wrapper.register-text a")
		List<WebElement> disqusTxt_lnks;

		@FindBy(css = "label>input")
		WebElement guestCheckBox;

		@FindBy(css = "ul.disqus-footer a")
		List<WebElement> disqusIframeFooter;

		public IframeDisQus(WebDriver driver, WebDriverWait wait, ExtentTest test) {
			PageFactory.initElements(driver, this);
		}

		public void iframeInsightsDisQusElements() {

			if (executor.isElementPresent(switchFrameElement)) {
				executor.softWaitforVisibilityOfWebElement(switchFrame, "wait for switchFrame element");
				driver.switchTo().frame(switchFrame);

				executor.softWaitforVisibilityOfWebElement(commentCountTxt, "wait for comment-count to be visible");
				executor.verifyTrue(commentCountTxt.isDisplayed(),
						"verify comment count:" + " " + commentCountTxt.getText());

				executor.verifyTrue(editageInsightsTxt.isDisplayed(),
						"verify editage insights:" + " " + editageInsightsTxt.getText());
				// executor.softWaitforCondition(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notificationCount)),
				// "");
				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(notificationCount)));
				executor.verifyTrue(notificationCount.isDisplayed(),
						"verify notification count icon displays with no issues");

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(loginUser)));
				//executor.softWaitforCondition(ExpectedConditions.stalenessOf(loginUser),
				//		"Wait for stalness of login users");
				executor.verifyTrue(loginUser.isDisplayed(),
						"verify login users displays:" + " " + loginUser.getText());

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(recommendTxt)));
				executor.verifyTrue(recommendTxt.isDisplayed(),
						"verify recomment text displays:" + " " + recommendTxt.getText());

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(iconExport)));
				executor.verifyTrue(iconExport.isDisplayed(), "verify export icon is displaying");

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(iconShare)));
				executor.verifyTrue(iconShare.isDisplayed(), "verify share icon is displaying");

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(sortByNewest_lnk)));
				executor.verifyTrue(sortByNewest_lnk.isDisplayed(),
						"verify sort by newest link:" + " " + sortByNewest_lnk.getText());

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(imageUser)));
				executor.verifyTrue(imageUser.isDisplayed(), "wait for image to be displayed");

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(textArea)));
				executor.verifyTrue(textArea.isDisplayed(), "verify text area is displayed");

				if (executor.isElementPresent(disqusElement)) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(textArea)));
					executor.verifyTrue(socialElementDisqus.isDisplayed(),
							"verify disqus element :" + socialElementDisqus.getAttribute("title"));
				}

				if (executor.isElementPresent(facebookElement)) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(textArea)));
					executor.verifyTrue(socialElementFacebook.isDisplayed(),
							"verify facebook element :" + socialElementFacebook.getAttribute("title"));
				}

				if (executor.isElementPresent(twitterElement)) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(textArea)));
					executor.verifyTrue(socialElementTwitter.isDisplayed(),
							"verify twitter element :" + socialElementTwitter.getAttribute("title"));
				}

				if (executor.isElementPresent(GoogleElement)) {
					wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(textArea)));
					executor.verifyTrue(socialElementGoogle.isDisplayed(),
							"verify google element :" + socialElementGoogle.getAttribute("title"));
				}

				wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(nameTxt)));
				executor.verifyTrue(nameTxt.isDisplayed(), "verify Name text area is displayed");
				executor.sendkeys(nameTxt, "Test testing", "input test data for other text elements to appear");

				executor.softWaitforVisibilityOfWebElement(emailTxt, "wait for visiblity of email text area");
				executor.verifyTrue(emailTxt.isDisplayed(), "verify the email text afrea is displayed");

				executor.softWaitforVisibilityOfWebElement(passwordTxt, "wait for visiblity of password text area");
				executor.verifyTrue(passwordTxt.isDisplayed(), "verify the password text afrea is displayed");

				executor.softWaitforVisibilityOfWebElement(disqusTxt, "wait for disqus element to be visible");
				executor.verifyTrue(disqusTxt.isDisplayed(),
						"verify the text below  password element:" + " " + disqusTxt.getText());

				new BrokenLinks(driver, wait, test).verifyLinks(disqusTxt_lnks);

				executor.softWaitforVisibilityOfWebElement(guestCheckBox, "wait for visiblity of guest Check Box");
				executor.verifyTrue(guestCheckBox.isDisplayed(), "verify guest Check Box is displayed");

				new BrokenLinks(driver, wait, test).verifyLinks(disqusIframeFooter);

				driver.switchTo().defaultContent();
			}
		}
	}

}
