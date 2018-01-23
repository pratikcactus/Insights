package com.cactus.insights.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class YourLibraryPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;
	private FooterPage footerPage;
	private HeaderPage headerPage;

	public YourLibraryPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	// username tab
	@FindBy(xpath = "//span[@class='name-of-the-user']")
	public WebElement usernameTab;

	// Your Library Heading
	@FindBy(xpath = "//h1")
	public WebElement heading;

	// Save Button
	@FindBy(id = "edit-submit")
	public WebElement saveButton;
	
	// Arts Information checkbox
		@FindBy(id = "edit-arts-humanities-and-social-science")
		public WebElement artsHumanities;

	// Grammar and Writing button
	@FindBy(id = "edit-grammar-and-writing")
	public WebElement grammarAndWritingCheckbox;

	// Q&A title
	@FindBy(xpath = "//div[@class='node-title-q-a']")
	public WebElement QAtitle;

	// Block
	@FindBy(xpath = "//ul[@class='menu' and contains(@style,'display: none')]")
	public WebElement blockLoad;

	// Your Library Tab
	@FindBy(xpath = "//li[@class='first leaf list-2']/a")
	public WebElement yourLibrarytab;

	// Content Preferences
	@FindBy(xpath = "//a[contains(text(), 'Content')]")
	public WebElement contentPreferences;


	// Subscription Preferences
	@FindBy(xpath = "//a[contains(text(), 'Subscription')]")
	public WebElement subscriptionPreferences;

	// Preferences Tab
	@FindBy(xpath = "//li[@class='middle leaf list-3']/a")
	public WebElement preferencestab;

	// Recommended Image
	@FindBy(xpath = "//span[@class='recommended-image']")
	public WebElement recommendedImage;

	// Recommended Title
	@FindBy(xpath = "//span[@class='recommended-title']/h2/a")
	public WebElement recommendedTitle;

	// Saved Image
	@FindBy(xpath = "//span[@class='bookmark-image']")
	public WebElement savedImage;
	
	// Advice for you
		@FindBy(xpath = "//span[@class='advice-for-you-title']")
		public WebElement adviceForYou;

	// Saved Content Title
	@FindBy(xpath = "//span[@class='bookmark-title']/h2/a")
	public WebElement savedTitle;

	// Advice for You title
	@FindBy(xpath = "//span[@class='advice-for-you-title']/h2/a")
	public WebElement advice;

	// Subscribe Today Image
	@FindBy(xpath = "//div[@class='user-dashboard-block-title']/div")
	public WebElement subscribeImage;

	// Subscribe Today Title
	@FindBy(xpath = "//div[@class='user-dashboard-block-title']//h2")
	public WebElement subscribeTitle;

	// Recommended Section Images
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//div[@class='recommended-for-you-image']//img")
	public List<WebElement> recommendImages;

	// Recommended Section Title
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//div[@class='recommended-for-you-title']/a")
	public List<WebElement> recommendtitles;

	// Recommended Section Read More
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//div[@class='recommended-for-you-synopsis']/a")
	public List<WebElement> recommendReadMoreLinks;

	// Recommended Section Description
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//div[@class='recommended-for-you-synopsis']")
	public List<WebElement> recommendedSectionDescription;

	// Recommended Section Views
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//span[@class='recommended-for-you-count']")
	public List<WebElement> recommendedViews;

	// Recommended Section Categories
	@FindBy(xpath = "//div[@class='panel-pane pane-recommended-dashboard']//span[@class='recommended-for-you-category']")
	public List<WebElement> recommendedCategories;
	
	// Recommended Section Content
		@FindBy(xpath = "//div[@class='views-field-type-1']/span")
		public List<WebElement> recommendedContent;
		
		// Saved Section Content
				@FindBy(xpath = "//div[@class='views-field views-field-type-1']/span")
				public List<WebElement> savedContentType;

	// Saved Content Images
	@FindBy(xpath = "//div[@class='panel-panel grid-4 panel-region-sidebar-first']//div[@class='views-field views-field-field-thumbnail']//img")
	public List<WebElement> savedContentImages;

	// Saved Content Title
	@FindBy(xpath = "//div[@class='panel-panel grid-4 panel-region-sidebar-first']//div[@class='views-field views-field-title']//a")
	public List<WebElement> savedContentTitles;

	// Recommended articles link
	@FindBy(xpath = "//div[@class='block--views-dashboard-block-1']//div[@class='view-bookmarked']//a")
	public WebElement recommendBookmark;

	// Saved Content link
	@FindBy(xpath = "//div[@class='panel-pane pane-views pane-dashboard']//div[@class='view-bookmarked']//a")
	public WebElement savedContentBookmark;

	// Subscription Content link
	@FindBy(xpath = "//div[@class='panel-pane pane-custom pane-4 subscribe-today-block']//a")
	public WebElement subscriptionLink;

	// Recommended articles Images
	@FindBy(xpath = "//span[@class='thumbnail']//img")
	public List<WebElement> recommendBookmarkImages;

	// Recommended articles Titles
	@FindBy(xpath = "//div[@class='views-field-title']//a")
	public List<WebElement> recommendBookmarkTitle;

	// Saved Content articles Titles
	@FindBy(xpath = "//div[@class='panel-panel grid-8 panel-region-content']//div[@class='views-field views-field-title']/span/a")
	public List<WebElement> savedContentTitle;

	// Preferences Title
	@FindBy(xpath = "//div[@class='preferences-title']")
	public WebElement preferencesTitle;

	// Preferences Description
	@FindBy(xpath = "//div[@class='preferences-description']")
	public WebElement preferencesDescription;

	// Manuscript Preparation Inputbox
	@FindBy(xpath = "//form[@id='content-preferences']/div/div//input[@name='Manuscript Preparation']")
	public WebElement inputManuscriptPreparation;
	
	// Manuscript Preparation Inputbox
		@FindBy(xpath = "//form[@id='subscription-preferences']/div/div//input[@name='Manuscript Preparation']")
		public WebElement inputManuscriptPreparationSubscription;

	public void navigate() {
		executor.scrollIntoView(usernameTab);
		executor.mouseHover(usernameTab);
		executor.softWaitforInvisibilityOFWebElement(blockLoad, "Wait for block to load");
		executor.mouseHover(yourLibrarytab);
		executor.click(yourLibrarytab, "Click on Your Library Tab");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
	}

	public void navigatePreferences() {
		executor.scrollIntoView(usernameTab);
		executor.mouseHover(usernameTab);
		executor.softWaitforInvisibilityOFWebElement(blockLoad, "Wait for block to load");
		executor.mouseHover(preferencestab);
		executor.click(preferencestab, "Click on Preferences Tab");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
	}

	public void youLibraryVerify() {
		boolean flag1 = false, flag2 = false, flag3 = false;
		navigate();
		if (heading.getText().equalsIgnoreCase("your Library")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		List<WebElement> articlesList = driver
				.findElements(By.xpath("//div[@id='mini-panel-dashboard_header']//div[@class='dashboard-stats-text']"));
		List<WebElement> articlesNumbers = driver.findElements(
				By.xpath("//div[@id='mini-panel-dashboard_header']//div[@class='dashboard-stats-number']"));
		List<String> list = Arrays.asList("Articles recommended for you", "Articles saved", "Your published questions");
		if (executor.isElementPresent(By.xpath("//div[@id='mini-panel-dashboard_header']"))) {
			for (int i = 0; i < articlesList.size(); i++) {
				if (articlesList.get(i).getText().equalsIgnoreCase(list.get(i))
						&& !articlesNumbers.get(i).getText().isEmpty()) {
					flag2 = true;
				} else {
					flag2 = false;
					break;
				}
			}
			if (executor.isElementExist(recommendedImage) && recommendedTitle.getText().contains("Recommended for you")
					&& executor.isElementExist(savedImage) && savedTitle.getText().contains("Your saved content")
					&& advice.getText().contains("advice for you") && executor.isElementExist(subscribeImage)
					&& subscribeTitle.getText().contains("Subscribe today!")) {
				flag3 = true;
			} else {
				flag3 = false;
			}
			executor.assertTrue(flag1 && flag2 && flag3, "Your Library UI is displayed successfully");
		} else {
			executor.assertTrue(false, "Your Library UI is not displayed successfully");
		}
	}

	public void yourLibraryCheck() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		navigate();
		flag1 = imagesCheck(recommendImages, recommendtitles);
		flag2 = readMore(recommendReadMoreLinks);
		flag3 = views(recommendedViews);
		flag4 = categoriesPreview(recommendedCategories);
		flag5 = description(recommendedSectionDescription);
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Content on Your Library page is functioning correctly");
		} else {
			executor.assertTrue(false, "Content on Your Library page is not functioning correctly");
		}
	}

	public void yourLibrarySavedContentCheck() throws MalformedURLException, Exception {
		boolean flag1 = false;
		navigate();
		flag1 = imagesCheck(savedContentImages, savedContentTitles);
		if (flag1) {
			executor.assertTrue(true, "Content on Your Library page is functioning correctly");
		} else {
			executor.assertTrue(false, "Content on Your Library page is not functioning correctly");
		}
	}

	public void yourLibraryDetailCheck() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		flag1 = recommendedPageCheck();
		flag2 = savedContentCheck();
		if (flag1 && flag2) {
			executor.assertTrue(true, "Content on Your Library page is functioning correctly");
		} else {
			executor.assertTrue(false, "Content on Your Library page is not functioning correctly");
		}
	}

	public void subscriptionPage() {
		boolean flag1 = false, flag2 = false;
		flag1 = adviceCheck();
		flag2 = subscriptionPageCheck();
		if (flag1 && flag2) {
			executor.assertTrue(true, "Content on Your Library page is functioning correctly");
		} else {
			executor.assertTrue(false, "Content on Your Library page is not functioning correctly");
		}
	}

	public boolean recommendedPageCheck() {
		boolean flag1 = false;
		navigate();
		executor.click(recommendedTitle, "Click on Recommended Title");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		String title = heading.getText();
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		executor.scrollIntoView(adviceForYou);
		executor.click(recommendBookmark, "CLick on View all Recommended Articles");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		flag1 = imagesCheckList(recommendBookmarkImages, recommendBookmarkTitle, recommendedContent);
		return flag1;

	}

	public boolean savedContentCheck() {
		boolean flag1 = false;
		navigate();
		executor.click(savedTitle, "Click on Saved Content Title");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		String title = heading.getText();
		driver.navigate().back();
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		executor.scrollDown(500);
		executor.click(savedContentBookmark, "CLick on View all Saved Content Articles");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for Page to Load");
		flag1 = imagesCheckList(recommendBookmarkImages, savedContentTitle, savedContentType);
		return flag1;
	}

	public boolean adviceCheck() {
		boolean flag1 = false;
		navigate();
		executor.scrollDown(500);
		executor.click(advice, "Click on Advice");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for page to load");
		if (heading.getText().equalsIgnoreCase("Advice for you")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

	public boolean subscriptionPageCheck() {
		boolean flag1 = false;
		navigate();
		executor.scrollIntoView(advice);
		executor.click(subscriptionLink, "Subscription Link Clicked");
		executor.softWaitforVisibilityOfWebElement(heading, "Wait for page to load");
		if (heading.getText().equalsIgnoreCase("Preferences")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;

	}

	public boolean imagesCheck(List<WebElement> images, List<WebElement> title) {
		boolean flag1 = false;
		String oldTab = driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		List<String> mainTitle = new ArrayList<String>();
		List<String> detailTitle = new ArrayList<String>();
		for (int i = 0; i < images.size(); i++) {
			mainTitle.add(title.get(i).getText());
			if (util.imageChecker(images.get(i), driver) == true) {
				title.get(i).sendKeys(selectLinkOpeninNewTab);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				driver.switchTo().window(newTab.get(0));
				executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@id='block-block-22']//img"), "Wait for page to Load");
				List<WebElement> pageTitle = driver.findElements(By.xpath("//div[@class='node-title-q-a']")); 
				if(pageTitle.size()!=0){
				detailTitle.add(QAtitle.getText());
				}else{
					detailTitle.add(heading.getText());
				}
				driver.close();
				driver.switchTo().window(oldTab);

			} else {
				break;
			}
		}
		if (mainTitle.equals(detailTitle)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}
	
	public boolean imagesCheckList(List<WebElement> images, List<WebElement> title, List<WebElement> content) {
		boolean flag1 = false;
		String oldTab = driver.getWindowHandle();
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
		List<String> mainTitle = new ArrayList<String>();
		List<String> detailTitle = new ArrayList<String>();
		for (int i = 0; i < images.size(); i++) {
			mainTitle.add(title.get(i).getText());
			if (util.imageChecker(images.get(i), driver) == true
					&& content.get(i).getText().contains("Q&A")) {
				title.get(i).sendKeys(selectLinkOpeninNewTab);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				driver.switchTo().window(newTab.get(0));
				executor.softWaitforVisibilityOfWebElement(QAtitle, "Wait for page to Load");
				detailTitle.add(QAtitle.getText());
				driver.close();
				driver.switchTo().window(oldTab);

			} else if (util.imageChecker(images.get(i), driver) == true) {
				title.get(i).sendKeys(selectLinkOpeninNewTab);
				ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
				newTab.remove(oldTab);
				driver.switchTo().window(newTab.get(0));
				executor.softWaitforVisibilityOfWebElement(heading, "Wait for page to Load");
				detailTitle.add(heading.getText());
				driver.close();
				driver.switchTo().window(oldTab);

			} else {
				break;
			}
		}
		if (mainTitle.equals(detailTitle)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

	public boolean readMore(List<WebElement> readMore) throws MalformedURLException, Exception {
		boolean flag1 = false;
		for (WebElement cell : readMore) {
			if (util.isLinkBroken(new URL(cell.getAttribute("href"))).equals("OK")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean views(List<WebElement> readMore) throws MalformedURLException, Exception {
		boolean flag1 = false;
		for (WebElement cell : readMore) {
			if (cell.getText().contains("Views")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean categoriesPreview(List<WebElement> categories) throws MalformedURLException, Exception {
		boolean flag1 = false;
		for (WebElement cell : categories) {
			if (cell.getText().contains("Under")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public boolean description(List<WebElement> description) throws MalformedURLException, Exception {
		boolean flag1 = false;
		for (WebElement cell : description) {
			if (!cell.getText().isEmpty()) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		return flag1;
	}

	public void yourLibraryFooter() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		navigate();
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

	public void yourLibraryHeader() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		navigate();
		headerPage = new HeaderPage(driver, test, wait);
		flag1 = headerPage.headerOptionsCheckLoggedIn();
		flag2 = headerPage.headerLinksCheck();
		if (flag1 && flag2) {
			executor.assertTrue(true, "Header includes Logo, Login, register and search ");
		} else {
			executor.assertTrue(false, "Header does not includes Logo, Login, register and search ");
		}
	}

	public void contentPreferences() {
		boolean flag1 = false, flag2=false;
		navigatePreferences();
		executor.click(contentPreferences, "Click on Content Preferences tab");
		executor.softWaitforVisibilityOfWebElement(preferencesTitle, "Wait for Page to Load");
		if (preferencesTitle.getText().equalsIgnoreCase("Content preferences")
				&& preferencesDescription.getText().equalsIgnoreCase("I'm interested in the following topics:")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		flag2 = preferencesCheck(inputManuscriptPreparation);
		if(flag1 && flag2){
			executor.assertTrue(true, "Content Preferences is functioning correctly");
		}else{
			executor.assertTrue(false, "Content Preferences is not functioning correctly");
		}
	}
	
	public void subscriptionPreferences() {
		boolean flag1 = false, flag2=false;
		navigatePreferences();
		executor.click(subscriptionPreferences, "Click on Subscription Preferences tab");
		executor.softWaitforVisibilityOfWebElement(preferencesTitle, "Wait for Page to Load");
		if (preferencesTitle.getText().equalsIgnoreCase("Email alert preferences")
				&& preferencesDescription.getText().equalsIgnoreCase("I'm interested in email alerts on the following topics:")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		flag2 = preferencesCheck(inputManuscriptPreparationSubscription);
		if(flag1 && flag2){
			executor.assertTrue(true, "Subscription Preferences is functioning correctly");
		}else{
			executor.assertTrue(false, "Subscription Preferences is not functioning correctly");
		}
	}

	public boolean preferencesCheck(WebElement manuscriptPreparation) {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;
		if (manuscriptPreparation.isSelected()) {
			executor.click(manuscriptPreparation, "Manuscript Checkbox selected");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			List<WebElement> checkList = driver
					.findElements(By.xpath("//div[@class='extra-wrapper-manuscript extra-wrapper']//input"));
			for (WebElement cell : checkList) {
				if (!cell.isSelected()) {
					flag1 = true;
				} else {
					flag1 = false;
					break;

				}
			}
		} else {
			executor.click(manuscriptPreparation, "Manuscript Checkbox selected");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			List<WebElement> checkList = driver
					.findElements(By.xpath("//div[@class='extra-wrapper-manuscript extra-wrapper']//input"));
			for (WebElement cell : checkList) {
				if (cell.isSelected()) {
					flag1 = true;
				} else {
					flag1 = false;
					break;

				}
			}

		}
		if (!manuscriptPreparation.isSelected()) {
			executor.click(manuscriptPreparation, "Manuscript Checkbox selected");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			List<WebElement> checkList = driver
					.findElements(By.xpath("//div[@class='extra-wrapper-manuscript extra-wrapper']//input"));
			for (WebElement cell : checkList) {
				if (cell.isSelected()) {
					flag2 = true;
				} else {
					flag2 = false;
					break;

				}
			}
		}else{
			executor.click(manuscriptPreparation, "Manuscript Checkbox selected");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			List<WebElement> checkList = driver
					.findElements(By.xpath("//div[@class='extra-wrapper-manuscript extra-wrapper']//input"));
			for (WebElement cell : checkList) {
				if (!cell.isSelected()) {
					flag2 = true;
				} else {
					flag2 = false;
					break;

				}
			}
			
		}
		if (!grammarAndWritingCheckbox.isSelected()) {
			executor.click(grammarAndWritingCheckbox, "Grammar and Writing Checkbox checked");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			flag3 = grammarAndWritingCheckbox.isSelected();
		} else {
			executor.click(grammarAndWritingCheckbox, "Grammar and Writing Checkbox checked");
			executor.scrollIntoView(artsHumanities);
			executor.click(saveButton, "Click on Save button");
			executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='messages messages--status']"),
					"Wait for message to get displayed");
			flag3 = !grammarAndWritingCheckbox.isSelected();
		}

		if (flag1 && flag2 && flag3) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		return flag4;
	}

}
