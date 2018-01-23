package com.cactus.insights.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.Config;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class SearchPage {
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage loginPage;

	// Search Box
	@FindBy(id = "edit-apachesolr-panels-search-form")
	public WebElement searchBox;

	// Question Box
	@FindBy(id = "edit-question")
	public WebElement questionTextbox;

	// Description Box
	@FindBy(id = "edit-description")
	public WebElement descriptionTextbox;

	// Checkbox Question
	@FindBy(id = "edit-visibility")
	public WebElement questionCheckbox;

	// Search Icon
	@FindBy(id = "edit-submit")
	public WebElement searchIcon;

	// Filter By Format Article
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aarticle')]")
	public WebElement articleFilter;

	// Filter By Format Q&A Forum
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aq_and_a')]")
	public WebElement QAFilter;

	// Filter By Format Research
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aresearch')]")
	public WebElement researchFilter;

	// Filter By Format Interview
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aexperts')]")
	public WebElement interviewFilter;

	// Filter By Format Video
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Avideo')]")
	public WebElement videoFilter;

	// Filter By Format Event
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aevents')]")
	public WebElement eventFilter;

	// Filter By Format Slideshare
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Aslideshare')]")
	public WebElement slideshareFilter;

	// Filter By Format Interactive
	@FindBy(xpath = "//a[contains(@href,'=bundle%3Acomic_strip')]")
	public WebElement interactiveFilter;

	// Filter By Date 2013
	@FindBy(xpath = "//a[contains(@href,'5B2013-01')]")
	public WebElement date2013;

	// Filter By Date 2014
	@FindBy(xpath = "//a[contains(@href,'5B2014-01')]")
	public WebElement date2014;

	// Filter By Date 2015
	@FindBy(xpath = "//a[contains(@href,'5B2015-01')]")
	public WebElement date2015;

	// Filter By Date 2016
	@FindBy(xpath = "//a[contains(@href,'5B2016-01')]")
	public WebElement date2016;

	// Filter By Date 2017
	@FindBy(xpath = "//a[contains(@href,'5B2017-01')]")
	public WebElement date2017;

	// Search Result 1st result
	@FindBy(xpath = "//section[@class='search-results']/article[1]//h3//a")
	public WebElement firstSearchResults;

	// Main title Search Result Detail page
	@FindBy(xpath = "//h1[@class='field-content']")
	public WebElement titleDetailPage;

	// Ask the community link on Search page
	@FindBy(xpath = "//div[@class='q-a-link_SRP']/a")
	public WebElement askCommunityLink;

	// Ask the Community Page heading
	@FindBy(xpath = "//h1")
	public WebElement askCommunityHeading;

	// No Search Results Title
	@FindBy(xpath = "//div[@class='panel-pane pane-apachesolr-result']//h2")
	public WebElement noResultTitle;

	// Search Results Title
	@FindBy(xpath = "//div[@class='panel-pane pane-apachesolr-result']/div[1]/h2[1]")
	public WebElement searchResultTitle;

	// Q&A Title
	@FindBy(xpath = "//div[@class='node-title-q-a']")
	public WebElement QATitle;

	// Search Page Conditions
	public SearchPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait until Search button is displayed");
		executor.click(searchIcon, "Search button is clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.ROW_TEST_SITE_Search_Result.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Staging  site Page");
		}
	}

	public void searchIconClick(String input) {
		executor.type(searchBox, input, "Text entered to search");
		executor.click(searchIcon, "Search ICon clicked to search");
		executor.softWaitforVisibilityOfWebElement(askCommunityLink, "Wait for the page to get displayed");
	}

	public void validSearchData(String input) {
		boolean flag1 = false;
		searchIconClick(input);
		List<WebElement> noOfColumns;
		noOfColumns = driver.findElements(By.xpath("//p[@class='search-result__snippet']/strong"));
		List<WebElement> titleColumns;
		titleColumns = driver.findElements(By.xpath("//article[@class='search-result']//h3/a"));
		

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns) {
			// set flag when title is found
			if (cell.getText().contains(input)) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		if (flag1) {
			executor.assertTrue(true, "Search displayed Correctly");
		} else {
			executor.assertTrue(false, "Search is not  displayed Correctly");
		}
	}
	
	public void validSearchDataList(String input) {
		boolean flag1 = false;
		searchIconClick(input);
		List<WebElement> titleColumns;
		titleColumns = driver.findElements(By.xpath("//article[@class='search-result']//h3/a"));
		List<String> sortList = new ArrayList<String>();
		for (WebElement cell : titleColumns) {
			sortList.add(cell.getText());
		}
		
			if (sortList.contains(input)) {
				flag1 = true;
			} else {
				flag1 = false;
			}
		if (flag1) {
			executor.assertTrue(true, "Search displayed Correctly");
		} else {
			executor.assertTrue(false, "Search is not  displayed Correctly");
		}
	}

	public void searchFiltersFormat() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false;
		executor.scrollDown(500);
		executor.actionClick(articleFilter, "Article checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsArticle;
		noOfColumnsArticle = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsArticle) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("article")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(QAFilter, "Q&A checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsQA;
		noOfColumnsQA = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsQA) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("Q&A FORUM")) {
				flag2 = true;
			} else {
				flag2 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(researchFilter, "Research checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsResearch;
		noOfColumnsResearch = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsResearch) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("research")) {
				flag3 = true;
			} else {
				flag3 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(interviewFilter, "Interview checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsInterview;
		noOfColumnsInterview = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsInterview) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("interview")) {
				flag4 = true;
			} else {
				flag4 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(videoFilter, "Video checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsVideos;
		noOfColumnsVideos = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsVideos) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("video")) {
				flag5 = true;
			} else {
				flag5 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(eventFilter, "Event checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsEvent;
		noOfColumnsEvent = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsEvent) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("event")) {
				flag6 = true;
			} else {
				flag6 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(slideshareFilter, "Slideshare checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsSlideshare;
		noOfColumnsSlideshare = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsSlideshare) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("slideshare")) {
				flag7 = true;
			} else {
				flag7 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(interactiveFilter, "Interactive checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//h2[contains(text(),'Filter by Date')]"), "Wait for the filter to get displayed");
		List<WebElement> noOfColumnsInteractive;
		noOfColumnsInteractive = driver.findElements(By.xpath("//article[@class='search-result']/span"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumnsInteractive) {
			// set flag when title is found
			if (cell.getText().equalsIgnoreCase("interactive")) {
				flag8 = true;
			} else {
				flag8 = false;
				break;
			}
		}
		searchIconClick("");
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8) {
			executor.assertTrue(true, "Filter By Format functioning correctly");
		} else {
			executor.assertTrue(false, "Filter By Format was not functioning correctly");
		}
	}

	public void searchFiltersDate() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		executor.scrollDown(500);
		executor.actionClick(date2013, "2013 date checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		List<WebElement> noOfColumns2013;
		noOfColumns2013 = driver.findElements(By.xpath("//footer[@class='search-result__info']"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns2013) {
			// set flag when title is found
			if (cell.getText().contains("2013")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(date2014, "2014 date checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		List<WebElement> noOfColumns2014;
		noOfColumns2014 = driver.findElements(By.xpath("//footer[@class='search-result__info']"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns2014) {
			// set flag when title is found
			if (cell.getText().contains("2014")) {
				flag2 = true;
			} else {
				flag2 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(date2015, "2015 date checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		List<WebElement> noOfColumns2015;
		noOfColumns2015 = driver.findElements(By.xpath("//footer[@class='search-result__info']"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns2015) {
			// set flag when title is found
			if (cell.getText().contains("2015")) {
				flag3 = true;
			} else {
				flag3 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(date2016, "2016 date checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		List<WebElement> noOfColumns2016;
		noOfColumns2016 = driver.findElements(By.xpath("//footer[@class='search-result__info']"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns2016) {
			// set flag when title is found
			if (cell.getText().contains("2016")) {
				flag4 = true;
			} else {
				flag4 = false;
				break;
			}
		}
		searchIconClick("");
		executor.scrollDown(500);
		executor.actionClick(date2017, "2017 date checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(QAFilter, "Wait for the filter to get displayed");
		List<WebElement> noOfColumns2017;
		noOfColumns2017 = driver.findElements(By.xpath("//footer[@class='search-result__info']"));

		// Loop will rotate till expected title is found.
		for (WebElement cell : noOfColumns2017) {
			// set flag when title is found
			if (cell.getText().contains("2017")) {
				flag5 = true;
			} else {
				flag5 = false;
				break;
			}
		}
		searchIconClick("");
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Filter By Date functioning correctly");
		} else {
			executor.assertTrue(false, "Filter By Date was not functioning correctly");
		}
	}

	public void detailPageSearch() {
		searchIconClick("article");
		String searchResult = firstSearchResults.getText();
		executor.click(firstSearchResults, "First Search Result Clicked");
		executor.softWaitforVisibilityOfWebElement(titleDetailPage, "Wait for the title to get displayed");
		// Store the Content Title on the Detailed page
		String mainTitle = titleDetailPage.getText();
		executor.assertEquals(searchResult, mainTitle, "We are directed to the Detailed Page");

	}

	public void askQuestion() {
		executor.click(askCommunityLink, "Ask the community link clicked");
		executor.softWaitforVisibilityOfWebElement(askCommunityHeading, "Wait for the page to get displayed");
		String heading = askCommunityHeading.getText();
		boolean questionBox = executor.isElementDisplayed(questionTextbox, "Question textbox is displayed");
		boolean descriptionBox = executor.isElementDisplayed(questionTextbox, "Description textbox is displayed");
		boolean checkBox = executor.isElementDisplayed(questionTextbox, "Checkbox textbox is displayed");
		if (heading.equalsIgnoreCase("Ask a question") && questionBox && descriptionBox && checkBox) {
			executor.assertTrue(true, "On clicking ask the Community link  user is directed to Q&A forum page");
		} else {
			executor.assertTrue(false, "On clicking ask the Community link  user is not  directed to Q&A forum page");
		}
	}

	public void noSearch() {
		searchIconClick("asdadsasdsadasdasdasd");
		executor.softWaitforVisibilityOfWebElement(noResultTitle, "Wait for the page to get displayed");
		String noSearchResult = noResultTitle.getText();
		if (noSearchResult.contains("no results")) {
			executor.assertTrue(true, "Proper Message is shown when no results are found");
		} else {
			executor.assertTrue(false, "Proper Message is not shown when no results are found");
		}
	}

	public void searchQA() {
		boolean flag1 = false;
		executor.scrollDown(500);
		executor.actionClick(QAFilter, "Q&A checkbox clicked");
		executor.softWaitforVisibilityOfWebElement(date2013, "Wait for the filter to get displayed");
		String text = firstSearchResults.getText();
		executor.click(firstSearchResults, "Click on first Element");
		executor.softWaitforVisibilityOfWebElement(QATitle, "Wait for the title to get displayed");
	}

}
