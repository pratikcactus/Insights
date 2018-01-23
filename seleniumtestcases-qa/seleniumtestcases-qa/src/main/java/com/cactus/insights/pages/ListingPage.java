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
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class ListingPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;
	private HeaderPage headerPage;
	private FooterPage footerPage;

	public ListingPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	// Main Category Name
	@FindBy(xpath = "//h1")
	public WebElement categoryTitle;

	// Pagination
	@FindBy(xpath = "//ul[@class='pager']")
	public WebElement paginationSection;

	// Pagination
	@FindBy(xpath = "//ul[@class='pager']//li[contains(., 'Next')]")
	public WebElement nextPager;

	// Menu Text
	@FindBy(xpath = "//div[@class='views-field views-field-description']/div")
	public WebElement categoryText;

	// Content Type
	@FindBy(xpath = "//div[@class='views-row views-row-1']//span[@class='content-listing-type']/a")
	public WebElement contentType;

	// Content Text
	@FindBy(xpath = "//div[@class='views-row views-row-1']//div[@class='content-listing-title']/a")
	public WebElement contentText;

	// Banner Image
	@FindBy(xpath = "//div[@id='block-block-22']//img")
	public WebElement bannerImage;

	// Question text
	@FindBy(xpath = "//div[@class='node-title-q-a']")
	public WebElement questionText;

	// Upcoming events
	@FindBy(xpath = "//div[@class='panel-panel grid-8 panel-region-content']//div[@class='views-field views-field-title']//a")
	public WebElement upcomingEventsArticle;

	// Multimedia Gallery
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-video-panel-pane-3']//div[@class='views-row views-row-1 views-row-odd views-row-first']//div[@class='views-field views-field-title']/span/a")
	public WebElement videoContent;

	// Slideshare
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-slideshare-panel-pane-3']//div[@class='views-row views-row-1 views-row-odd views-row-first']//div[@class='views-field views-field-title']/span/a")
	public WebElement slideshareContent;

	// Industry Experts
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-experts-panel-pane-6 pane-experts-panel-pane-2']//div[@class='views-row views-row-1 views-row-odd views-row-first']//div[@class='views-field views-field-title']/span/a")
	public WebElement industryExperts;

	// Editage Experts
	@FindBy(xpath = "//div[@class='panel-pane pane-views-panes pane-experts-panel-pane-2']//div[@class='views-row views-row-1 views-row-odd views-row-first']//div[@class='views-field views-field-title']/span/a")
	public WebElement editageExperts;

	// Upcoming event title
	@FindBy(xpath = "//div[@class='views-field views-field-title']/h2")
	public WebElement upcomingEventTitle;

	// Old To new Tab
	@FindBy(xpath = "//div[@class='panel-pane pane-panels-ajax-tab-tabs']//li[@class='list-2']/a")
	public WebElement oldToNewTab;

	// Old To new Tab
	@FindBy(xpath = "//div[@class='panel-pane pane-panels-ajax-tab-tabs']//li[@class='list-3']/a")
	public WebElement mostPopularTab;

	// Slideshare tab
	@FindBy(xpath = "//ul[@class='tabs inline panels-ajax-tab']//li[@class='list-2']")
	public WebElement slideshareTab;

	// Related Categories
	@FindBy(xpath = "//h2[contains(text(),'Related Categories')]")
	public WebElement relatedCategories;

	// Get more from editage
	@FindBy(xpath = "//h2[contains(text(),'Get more from Editage')]")
	public WebElement moreEditage;

	// Q&A
	@FindBy(xpath = "//h2[contains(text(),'Q&A')]")
	public WebElement QandA;

	// Q&A link
	@FindBy(xpath = "//div[@class='panel-pane pane-block pane-block-4 sidebar-content-block margintop']//a")
	public WebElement QandAlink;

	// Q&A image
	@FindBy(xpath = "//div[@class='panel-pane pane-block pane-block-4 sidebar-content-block margintop']//img")
	public WebElement QandAimage;

	// Editing link
	@FindBy(xpath = "//div[@class='panel-pane pane-custom pane-2 sidebar-content-block']//a")
	public WebElement editingLink;

	// Editing image
	@FindBy(xpath = "//div[@class='panel-pane pane-custom pane-2 sidebar-content-block']//img")
	public WebElement editingImage;

	// Titles
	@FindBy(xpath = "//div[@class='content-listing-title']/a")
	public List<WebElement> titles;

	// Description
	@FindBy(xpath = "//div[@class='content-listing-synopsis']")
	public List<WebElement> description;

	// Images
	@FindBy(xpath = "//div[@class='thumbnail']//img")
	public List<WebElement> images;

	// Usernames
	@FindBy(xpath = "//li[@class='first list-1']")
	public List<WebElement> usernames;

	// Date
	@FindBy(xpath = "//li[@class='middle list-2']")
	public List<WebElement> dates;

	// Views
	@FindBy(xpath = "//li[@class='last list-3']")
	public List<WebElement> Views;

	// Fields
	@FindBy(xpath = "//div[@class='views-field-ops anonymous-user']/a")
	public List<WebElement> saveFields;

	public void menuCLick(String mainCategory, String subCategory, String menuName) {
		executor.mouseHover(By.xpath(
				"//li[@data-level='1']//a[@class='dropdown-toggle' and contains(text(), '" + mainCategory + "')]"));
		executor.mouseHover(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"));
		executor.actionClick(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"),
				"Submenu Category clicked");
		executor.softWaitforVisibilityOfWebElement(categoryTitle, "Wait for page to load");
	}

	public void menuContent(String mainCategory, String subCategory, String menuName) {
		menuCLick(mainCategory, subCategory, menuName);
		String title = categoryTitle.getText().trim();
		executor.assertTrue(menuName.equalsIgnoreCase(title) && categoryText.getText() != null,
				"Description of that particular menu/sub-menu is displayed:" + menuName);
	}

	public void detailedPage(String mainCategory, String subCategory, String menuName) throws InterruptedException {
		menuCLick(mainCategory, subCategory, menuName);
		String title = categoryTitle.getText().trim();
		String mainContent = contentText.getText();
		executor.scrollDown(300);
		System.out.println(menuName);
		if (contentType.getText().trim().equalsIgnoreCase("Q&A Forum")) {
			executor.clickJS(contentText, "Content Type clicked(Article, Q&A etc...)");
			executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
			executor.assertTrue(
					menuName.equalsIgnoreCase(title) && mainContent.equalsIgnoreCase(questionText.getText()),
					"User is able to access detailed page");

		} else {
			executor.click(contentText, "Content Type clicked(Article, Q&A etc...)");
			executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
			executor.assertTrue(
					menuName.equalsIgnoreCase(title) && mainContent.equalsIgnoreCase(categoryTitle.getText()),
					"User is able to access detailed page");
		}
	}

	public void sizeCheck(String mainCategory, String subCategory, String menuName) throws InterruptedException {
		menuCLick(mainCategory, subCategory, menuName);
		List<WebElement> articles = driver.findElements(By.xpath("//div[@class='content-listing-title']"));
		if (articles.size() <= 10) {
			executor.assertTrue(true, "10 articles are displayed on the listing page");
		} else {
			executor.assertTrue(false, "10 articles are displayed on the listing page");
		}
	}

	public void rightSectionVerify(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		boolean flag1 = false;
		menuCLick(mainCategory, subCategory, menuName);
		flag1 = rightSideSection();
		executor.assertTrue(flag1, "Right Hand Side Section is visible on all Listing Pages");

	}

	public void detailedPageValidation() {
		boolean flag1 = false, flag2 = false, flag3 = false;
		flag1 = upcomingEvents();
		flag2 = videosSlideshare();
		flag3 = research();
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "User is able to access detailed page");
		} else {
			executor.assertTrue(false, "User is not able to access detailed page");
		}
	}

	public boolean upcomingEvents() {
		boolean flag1 = false;
		menuCLick("Interactive Learning", "Upcoming Events", "Upcoming Events");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		executor.scrollDown(100);
		List<WebElement> titles = driver.findElements(By.xpath("//div[@class='panel-panel grid-8 panel-region-content']//div[@class='views-field views-field-title']//a"));
		if(titles.size()!=0){
		String title = upcomingEventsArticle.getText();
		executor.clickJS(upcomingEventsArticle, "Click on the event");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		String mainTitle = upcomingEventTitle.getText();
		if (title.equalsIgnoreCase(mainTitle)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		}else{
			flag1 = true;
		}
		return flag1;

	}

	public boolean videosSlideshare() {
		boolean flag1 = false;
		menuCLick("Interactive Learning", "Videos & Slideshare", "Videos & Slideshare");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		executor.scrollDown(100);
		String video = videoContent.getText();
		executor.clickJS(videoContent, "Click on the first Video");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		String firstVideo = categoryTitle.getText();
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		executor.actionClick(slideshareTab, "Click on Slideshare Tab");
		executor.softWaitforVisibilityOfWebElement(slideshareContent, "Wait for Page to Load");
		String slideshare = slideshareContent.getText();
		executor.clickJS(slideshareContent, "Click on the first slideshare");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		String firstSlideshare = categoryTitle.getText();
		if (video.equalsIgnoreCase(firstVideo) && slideshare.equalsIgnoreCase(firstSlideshare)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;

	}

	public boolean research() {
		boolean flag1 = false;
		menuCLick("Community", "Expert Interviews", "Expert Interviews");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		executor.scrollDown(100);
		String industryTitle = industryExperts.getText();
		executor.clickJS(industryExperts, "Click on the first title");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		String industryMainTitle = categoryTitle.getText();
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		executor.actionClick(slideshareTab, "Click on Editage Experts Tab");
		executor.softWaitforVisibilityOfWebElement(editageExperts, "Wait for Page to Load");
		String expertTitle = editageExperts.getText();
		executor.clickJS(editageExperts, "Click on the first editage expert title");
		executor.softWaitforVisibilityOfWebElement(bannerImage, "Wait for Page to Load");
		String mainExpertTitle = categoryTitle.getText();
		if (industryTitle.equalsIgnoreCase(industryMainTitle) && expertTitle.equalsIgnoreCase(mainExpertTitle)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;

	}

	public void tabVerification(String mainCategory, String subCategory, String menuName) {
		menuCLick(mainCategory, subCategory, menuName);
		List<String> list = Arrays.asList("New To Old", "Old To New", "Most Popular");
		List<String> sortList = new ArrayList<String>();
		List<WebElement> tabs = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-panels-ajax-tab-tabs']//li/a"));
		for (WebElement cell : tabs) {
			sortList.add(cell.getText());
		}
		executor.assertTrue(list.equals(sortList),
				"Listing page is divided into three sections: New to Old, Old to New and Most Popular ");
	}

	public void pagination(String mainCategory, String subCategory, String menuName) {
		menuCLick(mainCategory, subCategory, menuName);
		System.out.print(subCategory);
		boolean flag1 = false;
		// executor.scrollDown(3500);
		List<WebElement> tabs = driver
				.findElements(By.xpath("//ul[@class='pager']/li[contains(@class, 'pager__item list')]"));
		List<WebElement> pager = driver.findElements(By.xpath("//ul[@class='pager']//li[contains(., 'Next')]"));

		System.out.println(tabs.size());
		// for(int i=0;i<tabs.size();i++)
		try {
			while (executor.isElementPresent(By.xpath("//ul[@class='pager']//li[contains(., 'Next')]"))) {
				executor.pause(3);
				WebElement view = driver
						.findElement(By.xpath("//div[@class='views-row views-row-10']"));
				executor.scrollIntoView(view);
				executor.pause(1);
				// executor.softWaitforCondition(ExpectedConditions.stalenessOf(contentText),
				// "Statleness of context text");

				By xpath = By.xpath("//ul[@class='pager']//li[contains(., 'Next')]");
				// contentText.sendKeys(Keys.chord(Keys.HOME, Keys.END));

				// executor.moveToElement(xpath);
				executor.softWaitforElementToBeClickable(xpath, "Clickable Next");
				WebElement el = driver.findElement(xpath);
				tabs = driver.findElements(By.xpath("//ul[@class='pager']/li[contains(@class, 'pager__item list')]"));
				if (!executor.clickAndReturnValue(el, "click on next")) {
					boolean flag = false;
					int i1 = 0;

					executor.pause(1);
					executor.scrollIntoView(view);
					while (i1 < 7 && !flag) {
						executor.pause(1);
						// contentText.sendKeys(Keys.chord(Keys.HOME,Keys.END));
						// executor.scrollUp();
						executor.softWaitforElementToBeClickable(xpath, "Clickable Next");
						flag = executor.clickAndReturnValue(el, "click on next");
						i1++;
					}
				}
				executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
				executor.pause(1);
				/*
				 * if (!executor.clickAndReturnValue(el, "click on next")) {
				 * boolean flag = false; int i1 = 0;
				 * 
				 * executor.pause(1); contentText.sendKeys(Keys.chord(Keys.HOME,
				 * Keys.END)); while (i1 < 7 && !flag) { executor.pause(1); //
				 * contentText.sendKeys(Keys.chord(Keys.HOME,Keys.END));
				 * executor.scrollUp();
				 * executor.softWaitforElementToBeClickable(xpath,
				 * "Clickable Next"); flag = executor.clickAndReturnValue(el,
				 * "click on next"); i1++; }
				 */

			}

			/*
			 * executor.actionClick(tabs.get(i), "Click on Pagination");
			 * 
			 */executor.pause(1);
			// executor.softWaitforCondition(ExpectedConditions.stalenessOf(contentText),
			// "Statleness of context text");

		} catch (Exception e) {
			executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
		}
		executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
		if (contentText.isDisplayed()) {
			flag1 = true;
		} else {
			flag1 = false;
			// break;
		}
		executor.assertTrue(flag1, "Pagination functioning correctly");
		// executor.scrollDown(2800);
	}

	public void newToOldListing(String mainCategory, String subCategory, String menuName) throws ParseException {
		boolean flag1 = false, flag2 = false, flag3 = false;
		menuCLick(mainCategory, subCategory, menuName);
		List<WebElement> elementList = driver.findElements(By.xpath("//li[@class='middle list-2']"));
		flag1 = dateSortDesc(elementList);
		executor.clickJS(oldToNewTab, "Click on the Old To new Tab section");
		executor.softWaitforVisibilityOfWebElement(contentText, "Wait for page to Load");
		executor.softWaitforVisibilityOfWebElement(
				By.xpath("//div[@class='panel-pane pane-panels-ajax-tab-tabs']//li[@class='list-2 active']"),
				"Wait for page to Load");
		List<WebElement> oldelementList = driver.findElements(By.xpath("//li[@class='middle list-2']"));
		flag2 = dateSortAsc(oldelementList);
		executor.clickJS(mostPopularTab, "Click on the Most Popular Tab section");
		executor.softWaitforVisibilityOfWebElement(contentText, "Wait for page to Load");
		executor.softWaitforVisibilityOfWebElement(
				By.xpath("//div[@class='panel-pane pane-panels-ajax-tab-tabs']//li[@class='list-3 active']"),
				"Wait for page to Load");
		List<WebElement> viewsSort = driver.findElements(By.xpath("//li[@class='last list-3']"));
		flag3 = views(viewsSort);
		System.out.println(flag2);
		if (flag1 && flag2) {
			executor.assertTrue(true, "New to Old tab is sorted according to recently published date");
		} else {
			executor.assertTrue(false, "New to Old tab is not sorted according to recently published date");
		}
	}

	public boolean dateSortDesc(List<WebElement> elementList) throws ParseException {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		boolean flag1 = false;
		List<Date> listDates = new ArrayList<Date>();
		List<Date> sortDates = new ArrayList<Date>();
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
				flag1 = true;
			} else {
				flag1 = false;
				System.err.println("Date is not sorted");
				break;
			}
		}
		return flag1;
	}

	public boolean dateSortAsc(List<WebElement> elementList) throws ParseException {
		DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
		boolean flag1 = false;
		List<Date> listDates = new ArrayList<Date>();
		List<Date> sortDates = new ArrayList<Date>();
		for (WebElement we : elementList) {
			Date date = format.parse(we.getText());
			listDates.add(date);
			sortDates.add(date);
		}
		// Sort based on collections
		Collections.reverse(sortDates);
		Collections.sort(sortDates);
		// Use iterator for checking values
		Iterator<Date> firstDate = listDates.iterator();
		Iterator<Date> secondDate = sortDates.iterator();
		while (firstDate.hasNext()) {
			Date date = firstDate.next();
			// recreate iterator for second list

			Date sdate = secondDate.next();
			if (date.equals(sdate)) {
				flag1 = true;
			} else {
				flag1 = false;
				System.err.println("Date is not sorted");
				break;
			}
		}
		return flag1;
	}

	public boolean views(List<WebElement> elementList) throws ParseException {
		boolean flag1 = false;
		List<Integer> listDates = new ArrayList<Integer>();
		List<Integer> sortDates = new ArrayList<Integer>();
		for (WebElement we : elementList) {
			String text = we.getText();
			text = text.replace("views", "");
			text = text.replace(",", "");
			listDates.add(Integer.parseInt(text.trim()));
			sortDates.add(Integer.parseInt(text.trim()));
		}
		// Sort based on collections
		Collections.sort(sortDates);
		Collections.reverse(sortDates);
		// Use iterator for checking values
		Iterator<Integer> firstDate = listDates.iterator();
		Iterator<Integer> secondDate = sortDates.iterator();
		while (firstDate.hasNext()) {
			if (firstDate.next().equals(secondDate.next())) {
				flag1 = true;
			} else {
				flag1 = false;
				System.err.println("Date is not sorted");
				break;
			}
		}
		return flag1;
	}

	public boolean rightSideSection() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false;
		if (relatedCategories.getText().equalsIgnoreCase("Related Categories")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		List<WebElement> categories = driver
				.findElements(By.xpath("//div[@class='panel-pane pane-term-list sidebar-content-block']//li/a"));
		for (WebElement we : categories) {
			if (we.getText() != null && util.isLinkBroken(new URL(we.getAttribute("href"))).equals("OK")) {
				flag2 = true;
			} else {
				flag2 = false;
			}
		}
		/*
		if (moreEditage.getText().equalsIgnoreCase("Get more from Editage")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		List<WebElement> moreCategories = driver.findElements(
				By.xpath("//div[@class='panel-pane pane-block pane-block-3 sidebar-content-block']//li/a"));
		for (WebElement we : moreCategories) {
			if (we.getText() != null && moreCategories.size() == 3) {
				flag4 = true;
			} else {
				flag4 = false;
			}
		}
		if (QandA.getText().equalsIgnoreCase("Q&A")) {
			flag3 = true;
		} else {
			flag3 = false;
		}*/
		if (QandAlink.getAttribute("href").contains("insights/ask-a-question")
				&& util.imageChecker(QandAimage, driver) == true) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (editingLink.getAttribute("href").contains("editage") && util.imageChecker(editingImage, driver) == true) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src,'facebook.com')]")));
		if (executor.isElementDisplayed(By.xpath("//body[@class='plugin chrome webkit win x1 Locale_en_GB']"),
				"Facebook Section Display")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("twitter-widget-0");
		if (executor.isElementDisplayed(
				By.xpath("//div[@class='timeline-Widget timeline-Widget--edge']"),
				"Tweet Section Display")) {
			flag6 = true;
		} else {
			flag6 = false;
		}
		driver.switchTo().defaultContent();
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
			flag7 = true;
		} else {
			flag7 = false;
		}
		return flag7;

	}

	public void contentCheck(String mainCategory, String subCategory, String menuName) {
		menuCLick(mainCategory, subCategory, menuName);
		System.out.print(subCategory);
		boolean flag1 = false, flag2 = false;
		// executor.scrollDown(3500);
		List<WebElement> tabs = driver
				.findElements(By.xpath("//ul[@class='pager']/li[contains(@class, 'pager__item list')]"));
		List<WebElement> pager = driver.findElements(By.xpath("//ul[@class='pager']//li[contains(., 'Next')]"));
		flag1 = check();
		System.out.println(tabs.size());
		// for(int i=0;i<tabs.size();i++)
		try {
			while (executor.isElementPresent(By.xpath("//ul[@class='pager']//li[contains(., 'Next')]"))) {
				executor.pause(3);
				WebElement view = driver
						.findElement(By.xpath("//div[@class='views-row views-row-10']//div[@class='content-listing']"));
				executor.scrollIntoView(view);
				executor.pause(1);
				// executor.softWaitforCondition(ExpectedConditions.stalenessOf(contentText),
				// "Statleness of context text");

				By xpath = By.xpath("//ul[@class='pager']//li[contains(., 'Next')]");
				// contentText.sendKeys(Keys.chord(Keys.HOME, Keys.END));

				// executor.moveToElement(xpath);
				executor.softWaitforElementToBeClickable(xpath, "Clickable Next");
				WebElement el = driver.findElement(xpath);
				tabs = driver.findElements(By.xpath("//ul[@class='pager']/li[contains(@class, 'pager__item list')]"));
				if (!executor.clickAndReturnValue(el, "click on next")) {
					boolean flag = false;
					int i1 = 0;

					executor.pause(1);
					executor.scrollIntoView(view);
					while (i1 < 7 && !flag) {
						executor.pause(1);
						// contentText.sendKeys(Keys.chord(Keys.HOME,Keys.END));
						// executor.scrollUp();
						executor.softWaitforElementToBeClickable(xpath, "Clickable Next");
						flag = executor.clickAndReturnValue(el, "click on next");
						i1++;
					}
				}
				executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
				executor.pause(1);
				flag1 = check();
				if(flag1=false){
					break;
				}
				/*
				 * if (!executor.clickAndReturnValue(el, "click on next")) {
				 * boolean flag = false; int i1 = 0;
				 * 
				 * executor.pause(1); contentText.sendKeys(Keys.chord(Keys.HOME,
				 * Keys.END)); while (i1 < 7 && !flag) { executor.pause(1); //
				 * contentText.sendKeys(Keys.chord(Keys.HOME,Keys.END));
				 * executor.scrollUp();
				 * executor.softWaitforElementToBeClickable(xpath,
				 * "Clickable Next"); flag = executor.clickAndReturnValue(el,
				 * "click on next"); i1++; }
				 */

			}

			/*
			 * executor.actionClick(tabs.get(i), "Click on Pagination");
			 * 
			 */executor.pause(1);
			// executor.softWaitforCondition(ExpectedConditions.stalenessOf(contentText),
			// "Statleness of context text");

		} catch (Exception e) {
			executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
		}
		executor.softWaitforElementToBeClickable(contentText, "Wait for page to Load");
		flag2 = check();
		if(flag1 && flag2){
			executor.assertTrue(true, "Content Validated successfully");
		}
	}

	public boolean check() {
		boolean flag1 = false;
		int value = titles.size();
		try {
			for (int i = 0; i < titles.size(); i++) {
				String a = titles.get(i).getText();
				String x = description.get(i).getText();
				boolean c = util.imageChecker(images.get(i), driver);
				String d = usernames.get(i).getText();
				String g = dates.get(i).getText();
				String h = Views.get(i).getText();
				String m = saveFields.get(i).getText();
				
				if (!titles.get(i).getText().isEmpty() && !description.get(i).getText().isEmpty()
						&& util.imageChecker(images.get(i), driver) == true && !usernames.get(i).getText().isEmpty()
						&& !dates.get(i).getText().isEmpty() && !Views.get(i).getText().isEmpty()
						&& !saveFields.get(i).getText().isEmpty()) {
					flag1 = true;
				} else {
					flag1 = false;
					break;
				}
			}
		} catch (Exception e) {
		}
		return flag1;
	}

	public void headerCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		menuCLick(mainCategory, subCategory, menuName);
		headerPage = new HeaderPage(driver, test, wait);
		flag1 = headerPage.headerOptionsCheck();
		flag2 = headerPage.headerLinksCheck();
		if (flag1 && flag2) {
			executor.assertTrue(true, "Header includes Logo, Login, register and search ");
		} else {
			executor.assertTrue(false, "Header does not includes Logo, Login, register and search ");
		}

	}

	public void footerCheck(String mainCategory, String subCategory, String menuName)
			throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		menuCLick(mainCategory, subCategory, menuName);
		footerPage = new FooterPage(driver, test, wait);
		flag1 = footerPage.footerLinks();
		flag2 = footerPage.aboutUs();
		flag3 = footerPage.socialMediaCheck();
		flag4 = footerPage.footerHeadingCheck();
		if (flag1 && flag2 && flag3 && flag4) {
			executor.assertTrue(true, "Footer Section is successfully displayed");
		} else {
			executor.assertTrue(false, "Footer Section is not successfully displayed");
		}

	}

}
