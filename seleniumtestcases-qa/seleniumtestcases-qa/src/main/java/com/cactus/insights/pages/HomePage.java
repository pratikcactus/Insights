package com.cactus.insights.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class HomePage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	public HomePage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
	}

	// Get your copy image
	@FindBy(xpath = "//div[@class='regid-generator']//img")
	public WebElement getYourCopy;
	
	// Last Article recent
		@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//div[@class='views-row views-row-2 views-row-even views-row-last']")
		public WebElement lastArticle;

	// Updates and Events
	@FindBy(xpath = "//a[contains(@href,'updates-and-events')]")
	public WebElement updateEvent;

	// Recent Articles
	@FindBy(xpath = "//a[contains(@href,'recent-article')]")
	public WebElement recentArticle;

	// Shop banner
	@FindBy(id = "block-block-22")
	public WebElement shopBanner;

	// Updates and Events
	@FindBy(xpath = "//h1")
	public WebElement industryUpdatesTitle;

	// Q&A node title
	@FindBy(xpath = "//div[@class='node-title-q-a']")
	public WebElement QAtitle;

	// Most Popular Section Heading
	@FindBy(xpath = "//div[@class='panel-pane pane-panels-ajax-tab-tabs']/h2/a")
	public WebElement mostPopularSection;

	// Most Popular Listing Page
	@FindBy(xpath = "//div[@class='panel-pane pane-panels-ajax-tab-tabs']/h2")
	public WebElement mostPopularListing;

	// Most Popular Section Heading
	@FindBy(xpath = "//a[@data-panel-name='monthly']")
	public WebElement thisMonthTab;

	// Most Popular Section Heading
	@FindBy(xpath = "//a[@data-panel-name='all_time']")
	public WebElement allTimeTab;

	// Drop down
	@FindBy(id = "edit-tid")
	public WebElement dropDown;

	// Featured Interview
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-experts-panel-pane-1']//a[contains(@href,'industry-experts')]")
	public WebElement featuredInterview;

	// Featured Interview title
	@FindBy(xpath = "//div[contains(@class,'view view-experts view-id-experts view-display-id-panel_pane_1')]//h2[@class='featured_title']")
	public WebElement interviewTitle;

	// Featured video
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-video-panel-pane-1']//a[contains(text(),'Featured')]")
	public WebElement featuredVideo;

	// Featured video view more
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-video-panel-pane-1']//a[contains(text(),'View')]")
	public WebElement featuredVideoViewMore;

	// Research
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-research-panel-pane-1']//h2")
	public WebElement research;

	// Research View Content
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-research-panel-pane-1']//div[@class='view-content']")
	public WebElement researchView;

	// Ask a question image
	@FindBy(xpath = "//div[@class='panel-pane pane-block pane-block-4']//a/img")
	public WebElement askAQuestionImage;

	public void getEbookClicked() {
		executor.click(getYourCopy, "Get your copy image clicked");
	}

	public void updateEventClick() {
		executor.scrollDown(500);
		executor.actionClick(updateEvent, "Updates and Events Clicked");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for Page to be displayed");
	}

	public void recentArticleClick() {
		executor.scrollDown(500);
		executor.actionClick(recentArticle, "Recent Articles Clicked");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for Page to be displayed");
	}

	public void updateEventsSort() throws MalformedURLException, Exception {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		List<WebElement> imageList = driver.findElements(
				By.xpath("//div[@class='panel-pane pane-views-panes pane-update-and-events-panel-pane-1']//img"));
		for (WebElement cell : imageList) {
			if (util.imageChecker(cell, driver) == true) {
				flag1 = true;
			} else {
				System.err.println("Images are broken in Updates and Event Section in Homepage");
				flag1 = false;
				break;

			}
		}
		List<WebElement> articleTitle = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-update-and-events-panel-pane-1']//span[@class='field-content']/a"));
		List<String> sortList = new ArrayList<String>();
		for (WebElement cell : articleTitle) {
			sortList.add(cell.getText());
		}
		updateEventClick();
		// Store the date in list
		List<Date> listDates = new ArrayList<Date>();
		List<Date> sortDates = new ArrayList<Date>();
		List<WebElement> elementList = driver.findElements(By.xpath("//span[@class='posted-date']"));
		for (WebElement we : elementList) {
			Date date = format.parse(we.getText());
			listDates.add(date);
			sortDates.add(date);
		}
		// Sort based on collections
		Collections.sort(sortDates);
		Collections.reverse(sortDates);
		// Use iterator for checking values
		Iterator<Date> firstDate = listDates.iterator();
		Iterator<Date> secondDate = sortDates.iterator();
		while (firstDate.hasNext()) {
			Date date = firstDate.next();
			// recreate iterator for second list

			Date sdate = secondDate.next();
			if (date.equals(sdate)) {
				flag2 = true;
			} else {
				flag2 = false;
				System.err.println("Date is not sorted");
				break;
			}
		}
		List<WebElement> articleTitlemain = driver.findElements(By.xpath(
				"//div[@class='panel-panel grid-8 panel-region-content']//div[@class='views-field views-field-title']//a"));
		List<String> obtainedList = new ArrayList<String>();
		int limit = 0;
		for (WebElement cell : articleTitlemain) {
			if (limit <= 7) {
				obtainedList.add(cell.getText());
			} else {
				break;
			}
			limit++;
		}
		if (sortList.equals(obtainedList)) {
			flag3 = true;
		} else {
			flag3 = false;
			System.err.println("List is not matched");
		}

		List<WebElement> imageListmain = driver
				.findElements(By.xpath("//div[@class='panel-panel grid-8 panel-region-content']//img"));
		for (WebElement cell : imageListmain) {
			if (util.imageChecker(cell, driver) == true) {
				flag4 = true;
			} else {
				System.err.println("Images are broken in Updates and Event Listing Page");
				flag4 = false;
				break;
			}
		}
		// Final Condition
		if (flag1 && flag2 && flag3 && flag4) {
			executor.assertTrue(true, "Update Events shows the latest content");
		} else {
			executor.assertTrue(false, "Update Events does not show the latest content");
		}

	}

	public void updatesEventList() {
		boolean flag1 = false;
		executor.scrollDown(1000);
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-update-and-events-panel-pane-1']//span[@class='field-content']/a"));
		List<WebElement> images = driver.findElements(
				By.xpath("//div[@class='panel-pane pane-views-panes pane-update-and-events-panel-pane-1']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, titleList, images);
		}
		if (flag1) {
			executor.assertTrue(true, "We are getting directed to the detailed page when we click on Contents");
		} else {
			executor.assertTrue(false, "We are not getting directed to the detailed page when we click on Contents");
		}
	}

	public void recentArticlesList() {
		boolean flag1 = false;
		executor.scrollDown(1000);
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//div[@class='views-field views-field-title']//a"));
		List<WebElement> images = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, titleList, images);
		}

		if (flag1) {
			executor.assertTrue(true, "We are getting directed to the detailed page when we click on Contents");
		} else {
			executor.assertTrue(false, "We are not getting directed to the detailed page when we click on Contents");
		}
	}

	public void recentArticlesReadMoreList() {
		boolean flag1 = false;
		executor.scrollIntoView(recentArticle);
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//div[@class='views-field views-field-title']//a"));
		List<WebElement> clickList = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='views-field views-field-field-synopsis']/span/a"));
		List<WebElement> images = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (clickList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, clickList, images);
		}
		if (flag1) {
			executor.assertTrue(true, "We are getting directed to the detailed page when we click on Contents");
		} else {
			executor.assertTrue(false, "We are not getting directed to the detailed page when we click on Contents");
		}
	}

	public boolean updateEventsnavigationHomepage(List<WebElement> titleList, WebElement pageTitle,
			List<WebElement> clickList, List<WebElement> images) {
		boolean flag1 = false, flag2 = false, flag3=false;
		List<String> mainTitle = new ArrayList<String>();
		List<String> detailTitle = new ArrayList<String>();
		for (int i = 0; i < titleList.size(); i++) {
			String title = titleList.get(i).getText();
			mainTitle.add(titleList.get(i).getText());
			String img = images.get(i).getAttribute("alt");
			if (util.imageChecker(images.get(i), driver) == true){
				flag1=true;
			}else{
				flag1=false;
			}
			String oldTab = driver.getWindowHandle();
			String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
			clickList.get(i).sendKeys(selectLinkOpeninNewTab);
			ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
			newTab.remove(oldTab);
			driver.switchTo().window(newTab.get(0));
			executor.softWaitforVisibilityOfWebElement(shopBanner, "Wait for the page to Load");
			List<WebElement> qaTitle = driver.findElements(By.xpath("//div[@class='node-title-q-a']"));
			if (qaTitle.size()!=0) {
				detailTitle.add(QAtitle.getText());
			}else{
				detailTitle.add(pageTitle.getText());
			}
			driver.close();
			driver.switchTo().window(oldTab);
		}
		if(mainTitle.equals(detailTitle)){
			flag2=true;
		}else{
			flag2=false;
		}
		if (flag1 && flag2) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		return flag3;

	}

	public void recentArticlesSort() throws MalformedURLException, Exception {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		List<WebElement> imageList = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//img"));
		for (WebElement cell : imageList) {
			if (util.imageChecker(cell, driver) == true) {
				flag1 = true;
			} else {
				System.err.println("Images are broken in Recent Articles Section in Homepage");
				flag1 = false;
				break;

			}
		}
		List<WebElement> articleTitle = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-3']//div[@class='views-field views-field-title']//a"));
		List<String> sortList = new ArrayList<String>();
		for (WebElement cell : articleTitle) {
			sortList.add(cell.getText());
		}
		recentArticleClick();
		// Store the date in list
		List<Date> listDates = new ArrayList<Date>();
		List<Date> sortDates = new ArrayList<Date>();
		List<WebElement> elementList = driver.findElements(By.xpath("//span[@class='posted-date']"));
		for (WebElement we : elementList) {
			Date date = format.parse(we.getText());
			listDates.add(date);
			sortDates.add(date);
		}
		// Sort based on collections
		Collections.sort(sortDates);
		Collections.reverse(sortDates);
		// Use iterator for checking values
		Iterator<Date> firstDate = listDates.iterator();
		Iterator<Date> secondDate = sortDates.iterator();
		while (firstDate.hasNext()) {
			Date date = firstDate.next();
			// recreate iterator for second list

			Date sdate = secondDate.next();
			if (date.equals(sdate)) {
				flag2 = true;
			} else {
				System.err.println("Date is not sorted");
				flag2 = false;
				break;
			}
		}
		List<WebElement> articleTitlemain = driver.findElements(By.xpath(
				"//span[contains(text(),'Article')]/parent::div/following-sibling::div[@class='views-field views-field-title']//a"));
		List<String> obtainedList = new ArrayList<String>();
		int limit = 0;
		for (WebElement cell : articleTitlemain) {
			if (limit <= 1) {
				obtainedList.add(cell.getText());
			} else {
				break;
			}
			limit++;
		}
		if (sortList.equals(obtainedList)) {
			flag3 = true;
		} else {
			System.err.println("List is not matched");
			flag3 = false;

		}

		List<WebElement> imageListmain = driver
				.findElements(By.xpath("//div[@class='panel-panel grid-8 panel-region-content']//img"));
		for (WebElement cell : imageListmain) {
			if (util.imageChecker(cell, driver) == true) {
				flag4 = true;
			} else {
				System.err.println("Images are broken in Updates and Event Listing Page");
				flag4 = false;
				break;
			}
		}
		// Final Condition
		if (flag1 && flag2 && flag3 && flag4) {
			executor.assertTrue(true, "Update Events shows the latest content");
		} else {
			executor.assertTrue(false, "Update Events does not show the latest content");
		}

	}

	public boolean titleVerification(List<WebElement> noOfColumnsTitle) throws MalformedURLException, Exception {
		boolean flag1 = false;
		String message = "OK";
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsTitle) {
			// set flag when title is found
			if (cell.getAttribute("href").contains("/insights/")
					&& util.isLinkBroken(new URL(cell.getAttribute("href"))).equals(message)) {
				flag1 = true;
			} else {
				System.err.println("Title links not working");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean columnFeaturesUI(List<WebElement> noOfColumnsFeatures, List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsFeatures) {
			// set flag when title is found
			if (cell.getText().contains("View") && cell.getText().contains("By") && cell.getText().contains("Under")
					&& noOfColumnsTitle.size() == noOfColumnsFeatures.size()) {
				flag1 = true;
			} else {
				System.err.println("Views, By, Under not present");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean addComments(List<WebElement> noOfColumnsComment, List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsComment) {
			// set flag when title is found
			if (cell.getText().contains("omment") && noOfColumnsTitle.size() == noOfColumnsComment.size()) {
				flag1 = true;
			} else {
				System.err.println("Add a comment not visible");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean average(List<WebElement> noOfColumnsAverage, List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsAverage) {
			// set flag when title is found
			if (cell.getText().contains("Average") && noOfColumnsTitle.size() == noOfColumnsAverage.size()) {
				flag1 = true;
			} else {
				System.err.println("Average text not visible");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean ratings(List<WebElement> noOfColumnsStars) {
		boolean flag1 = false;
		// Verify Presence of Images
		// List<String> sortList = new ArrayList<String>();
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsStars) {
			// set flag when title is found
			if (cell.getText().contains("Give it")) {
				// sortList.add(cell.getText());
				flag1 = true;

			} else {
				flag1 = false;
				System.err.println("Stars not visible");
				break;
			}
		}
		return flag1;
	}

	public boolean starsCount(List<WebElement> noOfColumnsStars, List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		List<String> sortList = new ArrayList<String>();
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsStars) {
			sortList.add(cell.getText());
		}
		if (sortList.size() == noOfColumnsTitle.size() * 5) {
			flag1 = true;
		} else {
			System.err.println("Stars not visible");
			flag1 = false;
		}
		return flag1;

	}

	public boolean readMoreLinks(List<WebElement> noOfColumnsReadMore, List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		for (WebElement cell : noOfColumnsReadMore) {
			// set flag when title is found
			if (cell.getText().contains("Read More") && noOfColumnsTitle.size() == noOfColumnsReadMore.size()) {
				flag1 = true;
			} else {
				System.err.println("Read More not visible");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean socialMediaIcons(List<WebElement> noOfColumnsSocialMediaIcons, List<WebElement> noOfColumnsTitle)
			throws MalformedURLException, Exception {
		boolean flag1 = false;
		// Verify Presence of Images
		// List<String> sharingList = new ArrayList<String>();
		// Verify Presence of Images
		String message = null;
		for (WebElement cell : noOfColumnsSocialMediaIcons) {
			// set flag when title is found
			if (cell.getAttribute("href").contains("www.addthis.com/bookmark.php?v=")
					&& util.isLinkBroken(new URL(cell.getAttribute("href"))).equalsIgnoreCase("OK")) {
				// && util.isLinkBroken(new
				// URL(cell.getAttribute("href"))).equals("OK")
				message = util.isLinkBroken(new URL(cell.getAttribute("href")));
				flag1 = true;
				// sharingList.add(cell.getText());
			} else {
				System.err.println("Social Media icons links broken");
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean socialMediaIconsSize(List<WebElement> noOfColumnsSocialMediaIcons,
			List<WebElement> noOfColumnsTitle) {
		boolean flag1 = false;
		// Verify Presence of Images
		List<String> sharingList = new ArrayList<String>();
		// Verify Presence of Images
		String message = null;
		for (WebElement cell : noOfColumnsSocialMediaIcons) {
			sharingList.add(cell.getText());
		}
		if (sharingList.size() == noOfColumnsTitle.size() * 5) {
			flag1 = true;
		} else {
			System.err.println("Social Media icons not visible");
			flag1 = false;
		}

		return flag1;
	}

	public void recentArticlesUI() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false, flag9 = false;
		executor.scrollIntoView(recentArticle);
		// Verify presence of Title
		List<WebElement> noOfColumnsTitle;
		noOfColumnsTitle = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='views-field views-field-title']/span/a"));
		flag1 = titleVerification(noOfColumnsTitle);
		if (noOfColumnsTitle.size() == 0) {
			flag1 = false;
		}

		// Verify presence of Under, By, Views
		List<WebElement> noOfColumnsFeatures;
		noOfColumnsFeatures = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='views-field views-field-nothing-1']/span"));
		flag2 = columnFeaturesUI(noOfColumnsFeatures, noOfColumnsTitle);
		if (noOfColumnsFeatures.size() == 0) {
			flag2 = false;
		}

		// Verify presence of Comments
		List<WebElement> noOfColumnsComment;
		noOfColumnsComment = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//span[@class='comment-counting']/a"));
		flag3 = addComments(noOfColumnsComment, noOfColumnsTitle);
		if (noOfColumnsTitle.size() == 0) {
			flag1 = false;
		}

		// Verify presence of Average
		List<WebElement> noOfColumnsAverage;
		noOfColumnsAverage = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='fivestar-summary fivestar-summary-average-count']/span"));
		flag4 = average(noOfColumnsAverage, noOfColumnsTitle);
		if (noOfColumnsAverage.size() == 0) {
			flag4 = false;
		}
		// Verify Presence of rating
		List<WebElement> noOfColumnsStars;
		noOfColumnsStars = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[contains(@class, 'star star-')]/a"));
		flag5 = ratings(noOfColumnsStars);
		if (noOfColumnsStars.size() == 0) {
			flag5 = false;
		}
		flag6 = starsCount(noOfColumnsStars, noOfColumnsTitle);
		// Verify presence of Read More link
		List<WebElement> noOfColumnsReadMore;
		noOfColumnsReadMore = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='views-field views-field-field-synopsis']/span/a"));
		flag7 = readMoreLinks(noOfColumnsReadMore, noOfColumnsTitle);
		if (noOfColumnsReadMore.size() == 0) {
			flag7 = false;
		}

		// Verify Presence of Images
		List<WebElement> noOfColumnsSocialMediaIcons;
		noOfColumnsSocialMediaIcons = driver.findElements(By.xpath(
				"//div[contains(@class, 'view view-article view-id-article view-display-id-panel_pane_3')]//div[@class='views-field views-field-field-social-sharing']//a"));
		flag8 = socialMediaIcons(noOfColumnsSocialMediaIcons, noOfColumnsTitle);
		if (noOfColumnsSocialMediaIcons.size() == 0) {
			flag8 = false;
		}
		flag9 = socialMediaIconsSize(noOfColumnsSocialMediaIcons, noOfColumnsTitle);
		// Final Condition
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9) {
			executor.assertTrue(true,
					"Recent Article contains Title, under, By, Views, Add a comment, rating, social icons, Image and teaser with read more link");
		} else {
			executor.assertTrue(false,
					"Recent Article does not contains Title, under, By, Views, Add a comment, rating, social icons, Image and teaser with read more link");
		}
	}

	public void verifyMostpopularSectionTabs() throws InterruptedException, ParseException {
		boolean flag1 = false, flag2 = false, flag3 = false;
		executor.scrollDown(1000);
		// Store the Title
		String title = mostPopularSection.getText();
		// Verify Condition
		if (title.equalsIgnoreCase("most popular")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		// Verify number of tabs
		List<WebElement> noOfTabs;
		noOfTabs = driver.findElements(By.xpath("//div[@class='panel-pane pane-panels-ajax-tab-tabs']//ul/li"));
		int size = noOfTabs.size();
		if (size == 3) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		// Verify tab Names
		for (WebElement cell : noOfTabs) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("This Week") || cell.getText().equalsIgnoreCase("This Month")
					|| cell.getText().equalsIgnoreCase("All Time")) {
				flag3 = true;
			} else {
				flag3 = false;
				break;
			}
		}
		// Final Condition
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Most Popular section contains 3 tabs This Week, This Month and All Time");
		} else {
			executor.assertTrue(false,
					"Most Popular section does not contain 3 tabs This Week, This Month and All Time");
		}

	}

	// most popular
	public boolean mostPopuarUI(List<WebElement> noOfColumnsTitle, List<WebElement> noOfColumnsFeatures,
			List<WebElement> noOfColumnsComment, List<WebElement> noOfColumnsAverage, List<WebElement> noOfColumnsStars,
			List<WebElement> noOfColumnsSocialMediaIcons) throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false, flag9 = false, flag10 = false;
		// Verify presence of Title
		flag1 = titleVerification(noOfColumnsTitle);
		if (noOfColumnsTitle.size() == 4) {
			flag2 = true;
		} else {
			flag2 = false;
		}

		// Verify presence of Under, By, Views
		flag3 = columnFeaturesUI(noOfColumnsFeatures, noOfColumnsTitle);
		if (noOfColumnsFeatures.size() == 0) {
			flag3 = false;
		}

		// Verify presence of Comments
		flag4 = addComments(noOfColumnsComment, noOfColumnsTitle);
		if (noOfColumnsTitle.size() == 0) {
			flag4 = false;
		}

		// Verify presence of Average
		flag5 = average(noOfColumnsAverage, noOfColumnsTitle);
		if (noOfColumnsAverage.size() == 0) {
			flag5 = false;
		}
		// Verify Presence of rating
		flag6 = ratings(noOfColumnsStars);
		if (noOfColumnsStars.size() == 0) {
			flag6 = false;
		}
		flag7 = starsCount(noOfColumnsStars, noOfColumnsTitle);
		// Verify Presence of Images
		flag8 = socialMediaIcons(noOfColumnsSocialMediaIcons, noOfColumnsTitle);
		if (noOfColumnsSocialMediaIcons.size() == 0) {
			flag8 = false;
		}
		flag9 = socialMediaIconsSize(noOfColumnsSocialMediaIcons, noOfColumnsTitle);
		// Final Condition
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9) {
			flag10 = true;
		} else {
			flag10 = false;
		}
		return flag10;
	}

	public boolean mostPopularUIThisWeek() throws MalformedURLException, Exception {
		boolean flag1 = false;
		executor.scrollIntoView(mostPopularSection);
		executor.softWaitforVisibilityOfWebElement(
				By.xpath(
						"//div[@class='views-row views-row-1']//div[@class='views-field views-field-field-social-sharing']"),
				"Wait for page to Load");
		List<WebElement> noOfColumnsTitle;
		noOfColumnsTitle = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> noOfColumnsFeatures;
		noOfColumnsFeatures = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span"));
		List<WebElement> noOfColumnsComment;
		noOfColumnsComment = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span[1]/span[2]/a"));
		List<WebElement> noOfColumnsAverage;
		noOfColumnsAverage = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'fivestar-summary fivestar-summary')]/span"));
		List<WebElement> noOfColumnsStars;
		noOfColumnsStars = driver.findElements(
				By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'star star-')]/a"));
		List<WebElement> noOfColumnsSocialMediaIcons;
		noOfColumnsSocialMediaIcons = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-field-social-sharing']//a"));
		flag1 = mostPopuarUI(noOfColumnsTitle, noOfColumnsFeatures, noOfColumnsComment, noOfColumnsAverage,
				noOfColumnsStars, noOfColumnsSocialMediaIcons);
		return flag1;
	}

	public void thisMonthClick() {
		executor.softWaitforVisibilityOfWebElement(thisMonthTab, "Wait for page to Load");
		executor.scrollIntoView(mostPopularSection);
		executor.clickJS(thisMonthTab, "This month tab clicked");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//li[@class='list-2']"), "Wait for page to Load");
		executor.waitForPageLoadJS();
		executor.softWaitforVisibilityOfWebElement(
				By.xpath(
						"//div[@class='views-row views-row-1']//div[@class='views-field views-field-field-social-sharing']"),
				"Wait for social media icons to Load");
	}

	public boolean mostPopularUIThisMonth() throws MalformedURLException, Exception {
		boolean flag2 = false;
		executor.refresh();
		thisMonthClick();
		List<WebElement> noOfColumnsTitle;
		noOfColumnsTitle = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> noOfColumnsFeatures;
		noOfColumnsFeatures = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span"));
		List<WebElement> noOfColumnsComment;
		noOfColumnsComment = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span[1]/span[2]/a"));
		List<WebElement> noOfColumnsAverage;
		noOfColumnsAverage = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'fivestar-summary fivestar-summary')]/span"));
		List<WebElement> noOfColumnsStars;
		noOfColumnsStars = driver.findElements(
				By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'star star-')]/a"));
		List<WebElement> noOfColumnsSocialMediaIcons;
		noOfColumnsSocialMediaIcons = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-field-social-sharing']//a"));

		flag2 = mostPopuarUI(noOfColumnsTitle, noOfColumnsFeatures, noOfColumnsComment, noOfColumnsAverage,
				noOfColumnsStars, noOfColumnsSocialMediaIcons);
		return flag2;
	}

	public void allTimeClick() {
		executor.softWaitforVisibilityOfWebElement(allTimeTab, "Wait for page to Load");
		executor.scrollIntoView(mostPopularSection);
		executor.clickJS(allTimeTab, "All time tab clicked");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//li[@class='list-3']"), "Wait for page to Load");
		executor.waitForPageLoadJS();
		executor.softWaitforVisibilityOfWebElement(
				By.xpath(
						"//div[@class='views-row views-row-1']//div[@class='views-field views-field-field-social-sharing']"),
				"Wait for social media icons to Load");
	}

	public boolean mostPopularUIAllTime() throws MalformedURLException, Exception {
		boolean flag3 = false;
		executor.refresh();
		allTimeClick();
		List<WebElement> noOfColumnsTitle;
		noOfColumnsTitle = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> noOfColumnsFeatures;
		noOfColumnsFeatures = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span"));
		List<WebElement> noOfColumnsComment;
		noOfColumnsComment = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-nothing']/span[1]/span[2]/a"));
		List<WebElement> noOfColumnsAverage;
		noOfColumnsAverage = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'fivestar-summary fivestar-summary')]/span"));
		List<WebElement> noOfColumnsStars;
		noOfColumnsStars = driver.findElements(
				By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//div[contains(@class, 'star star-')]/a"));
		List<WebElement> noOfColumnsSocialMediaIcons;
		noOfColumnsSocialMediaIcons = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-field-social-sharing']//a"));
		flag3 = mostPopuarUI(noOfColumnsTitle, noOfColumnsFeatures, noOfColumnsComment, noOfColumnsAverage,
				noOfColumnsStars, noOfColumnsSocialMediaIcons);
		return flag3;
	}

	public void mostPopularUITest() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false;
		flag1 = mostPopularUIThisWeek();
		flag2 = mostPopularUIThisMonth();
		flag3 = mostPopularUIAllTime();
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true,
					"Most Popular section contains Title, under, By, Views, Add a comment, rating, social icons, and Images");
		} else {
			executor.assertTrue(false,
					"Most Popular section does not contain Title, under, By, Views, Add a comment, rating, social icons, and Images");
		}
	}

	public void mostPopularDetailedPage() {
		boolean flag1 = false, flag2 = false;
		executor.scrollDown(1650);
		executor.click(mostPopularSection, "MostPopular Section Clicked");
		executor.softWaitforVisibilityOfWebElement(mostPopularListing, "Wait for page to Load");
		List<WebElement> noOfColumnsTitle = driver
				.findElements(By.xpath("//ul[@class='tabs inline panels-ajax-tab']/li"));
		List<String> tabNames = new ArrayList<String>();
		for (WebElement cell : noOfColumnsTitle) {
			tabNames.add(cell.getText());
		}
		if (noOfColumnsTitle.size() == 3) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		List<String> tabNamesCheck = new ArrayList<>(Arrays.asList("All Time", "This Month", "This Week"));
		if (tabNames.equals(tabNamesCheck)) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "On clicking Most Popular we are directed to Listing Page");
		} else {
			executor.assertTrue(false, "On clicking Most Popular we are not directed to Listing Page");
		}

	}

	public boolean thisMonthRedirection() {
		boolean flag1 = false;
		executor.refresh();
		thisMonthClick();
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> clickList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> images = driver
				.findElements(By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (clickList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, clickList, images);
		}
		return flag1;
	}

	public boolean thisWeekRedirection() {
		boolean flag1 = false;
		executor.scrollIntoView(mostPopularSection);
		executor.softWaitforVisibilityOfWebElement(
				By.xpath(
						"//div[@class='views-row views-row-1']//div[@class='views-field views-field-field-social-sharing']"),
				"Wait for page to Load");
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> clickList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> images = driver
				.findElements(By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (clickList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, clickList, images);
		}
		return flag1;
	}

	public boolean allTimeRedirection() {
		boolean flag1 = false;
		executor.refresh();
		allTimeClick();
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> clickList = driver.findElements(By.xpath(
				"//div[@id='panels-ajax-tab-container-most-popular']//div[@class='views-field views-field-title']//a"));
		List<WebElement> images = driver
				.findElements(By.xpath("//div[@id='panels-ajax-tab-container-most-popular']//img"));
		if (titleList.size() == 0) {
			flag1 = false;
		} else if (clickList.size() == 0) {
			flag1 = false;
		} else if (images.size() == 0) {
			flag1 = false;
		} else {
			flag1 = updateEventsnavigationHomepage(titleList, industryUpdatesTitle, clickList, images);
		}
		return flag1;
	}

	public void mostPopularRedirection() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false;
		flag1 = thisWeekRedirection();
		flag2 = thisMonthRedirection();
		flag3 = allTimeRedirection();
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true,
					"Most Popular, This weeek, All time contents are getting successfully directed to Detailed page");
		} else {
			executor.assertTrue(false,
					"Most Popular, This weeek, All time contents are not getting successfully directed to Detailed page");
		}
	}

	public boolean tabSwitch(WebElement maintitle, WebElement detailedTitle) {
		boolean flag1 = false;
		String title = maintitle.getText();
		String oldTab = driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		maintitle.sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		driver.switchTo().window(newTab.get(0));
		executor.softWaitforVisibilityOfWebElement(shopBanner, "Wait for the page to Load");
		if (title.equalsIgnoreCase(detailedTitle.getText())) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		driver.close();
		driver.switchTo().window(oldTab);
		return flag1;
	}

	public void featuredInterview() {

		boolean flag1 = false, flag2 = false;
		executor.click(featuredInterview, "Click on featured Interview");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for page to load");
		String title = industryUpdatesTitle.getText();
		if (title.contains("Interview")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(interviewTitle, "Wait for page to load");
		String interview = interviewTitle.getText();
		executor.click(interviewTitle, "Click on featured Interview title");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for page to load");
		String newTitle = industryUpdatesTitle.getText();
		if (interview.equalsIgnoreCase(newTitle)) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Featured Interview Section is displayed");
		} else {
			executor.assertTrue(false, "Featured Interview Section is not displayed");
		}

	}

	public void featuredVideo() {

		boolean flag1 = false, flag2 = false, flag3 = false;
		executor.scrollDown(500);
		List<WebElement> videos = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-views-panes pane-video-panel-pane-1']//img"));
		for (WebElement cell : videos) {
			if (util.imageChecker(cell, driver)) {
				flag1 = true;
			} else {
				System.err.println("Video not visible");
				flag1 = false;
				break;
			}
		}
		executor.clickJS(featuredVideo, "Click on featured Video");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for page to load");
		String title = industryUpdatesTitle.getText();
		if (title.contains("Multimedia Gallery")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(featuredVideo, "Wait for page to load");
		executor.scrollDown(500);
		executor.clickJS(featuredVideoViewMore, "Click on featured Video View more");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for page to load");
		String newTitle = industryUpdatesTitle.getText();
		if (newTitle.contains("Multimedia Gallery")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Featured Interview Section is displayed");
		} else {
			executor.assertTrue(false, "Featured Interview Section is not displayed");
		}

	}

	public void askAQuestion() throws InterruptedException {
		boolean flag1 = false, flag2 = false;
		executor.scrollToElement(askAQuestionImage);
		if (util.imageChecker(askAQuestionImage, driver) == true
				&& askAQuestionImage.getAttribute("src").contains("banner")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.click(askAQuestionImage, "Ask a question image clicked");
		executor.softWaitforVisibilityOfWebElement(industryUpdatesTitle, "Wait for page to load");
		if (industryUpdatesTitle.getText().equalsIgnoreCase("Ask a question")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "We are successfully directed to Ask a Question page");
		} else {
			executor.assertTrue(false, "We are not successfully directed to Ask a Question page");
		}
	}

	public void researchDropDown() throws InterruptedException {
		boolean flag1 = false, flag2 = false;
		WebElement block = driver.findElement(By.xpath("//div[@class='panel-pane pane-block pane-block-4']//img"));
		executor.scrollToElement(block);
		if (research.getText().equalsIgnoreCase("Whats new in Research")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		Select dropDownSelect = new Select(dropDown);
		List<WebElement> alldropddvalues = dropDownSelect.getOptions();
		for (int i = 0; i < alldropddvalues.size(); i++) {
			dropDownSelect.selectByIndex(i);
			// executor.softWaitforVisibilityOfWebElement(researchView, "wait
			// for page to load");
			try {
				if (researchView.isDisplayed() == true)
					flag2 = true;
			} catch (Exception e) {
				flag2 = false;
				break;

			}
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Images and titles are present in the Research section");
		} else {
			executor.assertTrue(false, "Images and titles are not present in the Research section");
		}
	}

	public boolean imageCheck(List<WebElement> mainList) {
		boolean flag1 = false;
		for (WebElement cell : mainList) {
			if (util.imageChecker(cell, driver) == true) {
				flag1 = true;
			} else {
				System.err.println("Images are broken in Updates and Event Section in Homepage");
				flag1 = false;
				break;
			}
		}
		return flag1;

	}

	public void sliderHomepage() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false;
		List<WebElement> sliderList = driver.findElements(
				By.xpath("//div[@id='widget_pager_top_slider_homepage-block']//div[@class='views-content-counter']"));
		int size = 0;
		if (driver.getCurrentUrl().contains("ei")) {
			size = 6;
		} else {
			size = 5;
		}
		if (sliderList.size() != 0) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		for (WebElement cell : sliderList) {
			executor.mouseHover(cell);
		}
		List<WebElement> images = driver.findElements(By.xpath(
				"//div[@id='views_slideshow_cycle_main_slider_homepage-block']//div[@class='views-field views-field-field-thumbnail']//img"));
		flag2 = imageCheck(images);
		List<WebElement> titleList = driver.findElements(By.xpath(
				"//div[@id='views_slideshow_cycle_main_slider_homepage-block']//div[@class='views-field views-field-title']//a"));
		flag3 = titleVerification(titleList);
		List<WebElement> readMoreVerification = driver.findElements(
				By.xpath("//div[@id='views_slideshow_cycle_main_slider_homepage-block']//div[@class='read-more']/a"));
		flag4 = titleVerification(readMoreVerification);
		List<WebElement> mainTitle = driver.findElements(By.xpath(
				"//div[@id='views_slideshow_cycle_main_slider_homepage-block']//div[@class='views-field views-field-field-categories']/div"));
		for (WebElement cell : mainTitle) {
			if (cell.getText() != null) {
				flag5 = true;
			} else {
				flag5 = false;
			}
		}
		List<WebElement> imagesSecondary = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-1']//div[@class='views-field views-field-field-thumbnail']//img"));
		flag6 = imageCheck(imagesSecondary);
		List<WebElement> titleListSecondary = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-1']//div[@class='views-field views-field-field-categories']/div/a"));
		flag7 = titleVerification(titleListSecondary);
		List<WebElement> readMoreVerificationSecondary = driver.findElements(By.xpath(
				"//div[@class='panel-pane pane-views-panes pane-article-panel-pane-1']//div[@class='views-field views-field-title']//a"));
		flag8 = titleVerification(readMoreVerificationSecondary);
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8) {
			executor.assertTrue(true, "Images and titles are present in the Homepage/Slider Section");
		} else {
			executor.assertTrue(false, "Images and titles are not present in the Homepage/Slider Section");
		}
	}

}
