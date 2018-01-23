package com.cactus.insights.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
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

public class LoginPage {// extends AbstractPage
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;

	// Login Button
	@FindBy(xpath = "//div[@class='anonymous-login anonymous-text']/a")
	public WebElement logIn;

	// Popup Button
	@FindBy(xpath = "//div[@id='block-block-22']//img")
	public WebElement popup;

	// Facebook link
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Facebook']")
	public WebElement fblink;

	// Facebook button
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Facebook']/div/span")
	public WebElement fbicon;

	// Twitter link
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Twitter']")
	public WebElement twitterlink;

	// Twitter button
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Twitter']/div/span")
	public WebElement twittericon;

	// LinkedIn link
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='LinkedIn']")
	public WebElement LinkedinLink;

	// LinkedIn button
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='LinkedIn']/div/span")
	public WebElement LinkedinIcon;

	// Orcid link
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Orcid']")
	public WebElement OrcidLink;

	// Orcid button
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//a[@title='Orcid']/span")
	public WebElement OrcidIcon;

	// Search Box
	@FindBy(id = "edit-apachesolr-panels-search-form")
	public WebElement searchBox;

	// Search Box
	@FindBy(xpath = "//div[@class='views-field views-field-description']")
	public WebElement description;

	// Search Icon
	@FindBy(xpath = "//form[@id='apachesolr-panels-search-block']//input[contains(@id,'edit-submit')]")
	public WebElement searchIcon;

	// Login Pop-Up
	@FindBy(xpath = "//div[@id='mini-panel-register_popup']")
	public WebElement popUpFrame;

	// Sign In Link
	@FindBy(xpath = "//a[@class='anonymous-login anonymous-text']")
	public WebElement signInLinkReg;

	// Email ID in Login
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//input[contains(@id,'edit-name')]")
	public WebElement EmailId;

	// Password in Login
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//input[contains(@id,'edit-pass')]")
	public WebElement password;

	// Add This
	@FindBy(id = "at4-share")
	public WebElement addThis;

	// Ask the community link on Search page
	@FindBy(xpath = "//div[@class='q-a-link_SRP']/a")
	public WebElement askCommunityLink;

	// Login Button
	@FindBy(xpath = "//div[contains(@class,'overlay register-block')]/div[contains(@id,'mini-panel-register')]//input[contains(@id,'edit-submit')]")
	public WebElement loginButton;

	// Save to Library Login Button
	@FindBy(xpath = "//div[@class='overlay-close']//input[@id='edit-submit--2']")
	public WebElement libraryLoginButton;

	// Login Button
	@FindBy(id = "edit-submit")
	public WebElement loginButtonQA;

	// Email ID QA in Login
	@FindBy(id = "edit-name")
	public WebElement EmailIdQA;

	// FirstName Field
	@FindBy(id = "edit-firstname")
	public WebElement firstName;

	// Password QA in Login
	@FindBy(id = "edit-pass")
	public WebElement passwordQA;

	// Email ID Save to Library in Login
	@FindBy(xpath = "//div[@class='overlay-close']//input[@id='edit-name']")
	public WebElement EmailIdLibrary;

	// Password Save to Library in Login
	@FindBy(xpath = "//div[@class='overlay-close']//input[@id='edit-pass']")
	public WebElement passwordLibrary;

	// Banner Pop-up
	@FindBy(id = "at-cv-lightbox-message")
	public WebElement bannerpopup;

	// Banner Pop-up Save to Library
	@FindBy(xpath = "//div[@class='panel-pane pane-block pane-insight-client-custom-user-login-custom']")
	public WebElement bannerPopupLibrary;

	// Username block
	@FindBy(xpath = "//div[@class='user-name']")
	public WebElement username;

	// Filter By Date 2016
	@FindBy(xpath = "//a[contains(@href,'5B2016-01')]")
	public WebElement date2016;

	// Username block
	@FindBy(xpath = "//a[@class='at-cv-button at-cv-lightbox-yesno at-cm-no-button']")
	public WebElement bannerButton;

	// Community Menu block
	@FindBy(xpath = "//li[@class='mn-megamenu-item level-1 mega mega-align-justify dropdown list-5']")
	public WebElement communityMenu;

	// Q&A menu link
	@FindBy(xpath = "//li[@class='mn-megamenu-item level-2 mega level-2-item dropdown-submenu list-1 default-selection open']")
	public WebElement qaMenuLink;

	// Save to Read Later 1st article
	@FindBy(xpath = "//div[@class='views-row views-row-1']//a[contains(@title, 'Save to read later')]")
	public WebElement saveToReadLater;

	// Iframe Login
	@FindBy(id = "rufous-sandbox")
	public WebElement iframeLogin;

	// Click on Article Checkbox
	@FindBy(xpath = "//a[contains(@href,'3Aarticle')]")
	public WebElement articleCheckbox;

	// Click on Logout link
	@FindBy(xpath = "//a[contains(@href,'/user/logout')]")
	public WebElement logoutLink;

	// Search Result 1st result
	@FindBy(xpath = "//section[@class='search-results']/article[1]//h3//a")
	public WebElement firstSearchResults;

	// Login Link Access Denied
	@FindBy(xpath = "//span[@class='login-editage-account-metered']/a")
	public WebElement signInLink;

	// Error Message Email
	@FindBy(xpath = "//div[@class='messages messages--error']//li[1]")
	public WebElement emailerrorMessage;

	// Error Message
	@FindBy(xpath = "//div[@class='messages messages--error']//li[2]")
	public WebElement passworderrorMessage;

	// Main Error Message
	@FindBy(xpath = "//div[@class='messages messages--error']")
	public WebElement mainErrorMessage;

	// Login Button
	@FindBy(xpath = "//div[@id='registration-prompt']//span[@class='anonymous-login GoogleAnalyticsET-processed']/a")
	public WebElement logInPopup;

	// Backend Email Address
	@FindBy(id = "edit-mail")
	public WebElement emailAddressbackend;

	// Apply button
	@FindBy(id = "edit-submit-admin-views-user")
	public WebElement applyButtonBackend;

	// Email ID search
	@FindBy(xpath = "//form[@id='views-form-admin-views-user-system-1']//tbody/tr[contains(@class,'views-row-last')]//td[contains(@class,'views-field-name')]")
	public WebElement searchEmailID;

	// Cancel Button search
	@FindBy(xpath = "//form[@id='views-form-admin-views-user-system-1']//tbody/tr[contains(@class,'views-row-last')]/td/following-sibling::td[contains(@class,' views-field-edit-node')]/a[2]")
	public WebElement searchCancelButton;

	// Delete User button
	@FindBy(xpath = "//input[@id='edit-user-cancel-method--5']")
	public WebElement deleteUserRadioButton;

	// Save Button Search
	@FindBy(id = "edit-submit")
	public WebElement saveButtonSearch;

	// No user Found search
	@FindBy(xpath = "//form[@id='views-form-admin-views-user-system-1']//tbody/tr[contains(@class,'views-row-last')]/td")
	public WebElement noUserSearch;

	// new Banner
	@FindBy(xpath = "//div[@id='lp-pom-root-color-overlay']")
	public WebElement newBannerpopup;

	// new Banner Close button
	@FindBy(xpath = "//div[@id='lp-pom-root-color-overlay']")
	public WebElement newBannerClosebtn;

	// Login Page/ HomePage Conditions
	public LoginPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);

	}

	public void bannerWait() {
		/*
		 * executor.softWaitforVisibilityOfWebElement(bannerpopup,
		 * "Wait until Banner is displayed"); if
		 * (executor.isElementDisplayed(bannerpopup, "banner pop-up") == true) {
		 * executor.click(bannerButton,
		 * "No Thanks button for banner pop-up clicked"); } else { throw new
		 * IllegalStateException("Fail to Detect banner"); }
		 */
		/*executor.softWaitforVisibilityOfWebElement(newBannerpopup, "Wait for banner to be visible");
		executor.softWaitforVisibilityOfWebElement(newBannerpopup, "Wait for banner to be visible");
		if (executor.isElementDisplayed(newBannerpopup, "New banner displayed") == true) {
			executor.click(newBannerClosebtn, "Closing the banner");
		} else {
			throw new IllegalStateException("Fail to Detect banner");
		}*/
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Check Login button is displayed");
		executor.softWaitforVisibilityOfWebElement(addThis, "Wait until Check Add This is displayed");
		if (!driver.getTitle().trim().toLowerCase().contains(Config.ROW_TEST_SITE.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Staging  site Page");
		}
	}

	// Homepage Login button clicked
	public void loginHomePageClick() {
		executor.click(logIn, "Login button clicked");
	}

	public void logoutClick() {
		executor.clickJS(logoutLink, "Logout link clicked");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Login button is present");
	}

	public void loginUser(String newUser, String staging_password, String live_password) {
		boolean flag1 = false, flag2 = false;
		loginHomePageClick();
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.type(EmailId, newUser, "Entered username in login pop-up");
		if (driver.getCurrentUrl().contains("ei")) {
			executor.type(password, staging_password, "Entered password  in login pop-up");
		} else {
			executor.type(password, live_password, "Entered password in login pop-up");
		}
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(username, "Wait for user to get logged in");
	}

	public void signInClick() {
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait for Sign In to be visible");
		executor.scrollIntoView(firstName);
		executor.click(signInLinkReg, "Click on Sign Link");
	}

	// HomePage Top Section Login
	public void login(String username, String staging_password, String live_password) {
		boolean flag1 = false, flag2 = false, flag3 = false;
		// loginHomePageClick();
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		flag1 = socialMediaIconsVerification(fblink, fbicon, twitterlink, twittericon, LinkedinLink, LinkedinIcon,
				OrcidLink, OrcidIcon);
		executor.type(EmailId, username, "Entered username in login pop-up");
		if (driver.getCurrentUrl().contains("ei")) {
			executor.type(password, staging_password, "Entered password  in login pop-up");
		} else {
			executor.type(password, live_password, "Entered password in login pop-up");
		}
		executor.click(loginButton, "Login Button clicked");
		String login_username = executor.getText(By.xpath("//div[@class='user-name']"));
		if (login_username.contains("Hello, ") && driver.getCurrentUrl().contains("loginform=loggedin-normal")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.clickJS(logoutLink, "Logout link clicked");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Login button is present");
		String login = logIn.getText();
		if (login.equalsIgnoreCase("Login")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Login and Logout successful");
		} else {
			executor.assertTrue(false, "Login and Logout unsuccessful");
		}
	}

	public boolean socialMediaIconsVerification(WebElement fblink, WebElement fbicon, WebElement twitterlink,
			WebElement twittericon, WebElement linkedinlink, WebElement linkedinicon, WebElement orcidlink,
			WebElement orcidicon) {
		boolean flag1 = false;
		if (fblink.getAttribute("href").contains("/insights/hybridauth/window/Facebook?") && fbicon.isDisplayed()
				&& twitterlink.getAttribute("href").contains("/insights/hybridauth/window/Twitter?")
				&& twittericon.isDisplayed()
				&& linkedinlink.getAttribute("href").contains("/insights/hybridauth/window/LinkedIn?")
				&& linkedinicon.isDisplayed()
				&& orcidlink.getAttribute("href").contains("orcid.org/oauth/authorize?client_id")) {
			flag1 = true;

		} else {
			flag1 = false;
		}
		return flag1;
	}

	// Go to Q&A page
	public void gotoQAPage() {
		String url = driver.getCurrentUrl() + "ask-a-question";
		executor.navigateToURL(url);
	}

	// Login from Q&A page
	public void loginQA() {
		boolean flag1 = false, flag2 = false;
		executor.softWaitforElementToBeClickable(loginButtonQA, "Login Button on Q&A visible");
		executor.type(EmailIdQA, "authenticated-user-test@mailinator.com", "Entered username in login pop-up");
		if (driver.getCurrentUrl().contains("ei")) {
			executor.type(passwordQA, "Ye@r2o17AwsTeSt_1", "Entered password  in login pop-up");
		} else {
			executor.type(passwordQA, "authenticatedusertest", "Entered password in login pop-up");
		}
		executor.click(loginButtonQA, "Login Button clicked");
		executor.softWaitforInvisibilityOFWebElement(EmailIdQA, "Waiting for Email ID field to be invisible");
		executor.waitForPageLoadJS();
		String username = executor.getText(By.xpath("//div[@class='user-name']"));
		if (username.equalsIgnoreCase("Hello, Dr. Authenticated")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.clickJS(logoutLink, "Logout link clicked");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Login button is present");
		String login = logIn.getText();
		if (login.equalsIgnoreCase("Login")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Login and Logout successful");
		} else {
			executor.assertTrue(false, "Login and Logout unsuccessful");
		}
	}

	// Go to save to Library
	public void gotoSaveLibrary() {
		String url = driver.getCurrentUrl() + "categories/grammar-and-writing";
		executor.navigateToURL(url);
		executor.scrollIntoView(description);
		executor.softWaitforElementToBeClickable(saveToReadLater, "Wait for Save to Library button");
		executor.clickJS(saveToReadLater, "Save to Library button clicked");
	}

	// Login From Save to Library Click
	public void clickSavetoLibrary() {
		boolean flag1 = false, flag2 = false;
		executor.softWaitforVisibilityOfWebElement(libraryLoginButton, "Wait until Check Login button is displayed");
		executor.type(EmailIdLibrary, "authenticated-user-test@mailinator.com", "Entered username in login pop-up");
		if (driver.getCurrentUrl().contains("ei")) {
			executor.type(passwordLibrary, "Ye@r2o17AwsTeSt_1", "Entered password  in login pop-up");
		} else {
			executor.type(passwordLibrary, "authenticatedusertest", "Entered password in login pop-up");
		}
		executor.click(libraryLoginButton, "Login Button clicked");
		executor.softWaitforInvisibilityOFWebElement(libraryLoginButton, "Waiting for Email ID field to be invisible");
		driver.switchTo().defaultContent();
		executor.waitForPageLoadJS();
		String username = executor.getText(By.xpath("//div[@class='user-name']"));
		if (username.equalsIgnoreCase("Hello, Dr. Authenticated")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.clickJS(logoutLink, "Logout link clicked");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Login button is present");
		String login = logIn.getText();
		if (login.equalsIgnoreCase("Login")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Login and Logout successful");
		} else {
			executor.assertTrue(false, "Login and Logout unsuccessful");
		}
	}

	public void searchIconClick(String input) {
		executor.type(searchBox, input, "Text entered to search");
		executor.click(searchIcon, "Search ICon clicked to search");
		executor.softWaitforVisibilityOfWebElement(askCommunityLink, "Wait for the page to get displayed");
	}

	public void searchResultWait() {
		executor.softWaitforElementToBeClickable(firstSearchResults, "Wait for first Search Result to be clickable");
	}

	public void searchResultClick() {
		executor.softWaitforElementToBeClickable(firstSearchResults, "Wait for first Search Result to be clickable");
		executor.click(firstSearchResults, "click on first result");
		executor.waitForPageLoadJS();
		executor.softWaitforElementToBeClickable(signInLinkReg, "Wait for SignIn Link");
	}

	// go to Access Denied Page
	public void gotoAccessDeniedPage() {
		// executor.click(loginButtonQA, "Search Icon CLick");
		searchIconClick("International Journal of Industrial Ergonomics: Quick facts and submission tips");
		executor.softWaitforElementToBeClickable(firstSearchResults, "Wait for first Search Result to be clickable");
		executor.click(firstSearchResults, "click on first result");
		do {
			driver.navigate().refresh();
		} while (!executor.isElementPresent(
				By.xpath("//div[@class='panel-pane pane-block pane-new-reg-form-access-denied-page-heading']")));
		// while(!driver.findElement(By.xpath("//div[@class='panel-pane
		// pane-block
		// pane-new-reg-form-access-denied-page-heading']")).isDisplayed());
		executor.waitForPageLoadJS();
		executor.softWaitforElementToBeClickable(signInLinkReg, "Wait for SignIn Link");
	}

	public void signClick() {
		executor.scrollDown(500);
		executor.actionClick(signInLink, "Sign In link Clicked");
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
	}

	public void popUpClick() {
		executor.click(popup, "Popup Clicked");
		executor.softWaitforVisibilityOfWebElement(signInLinkReg, "Wait until signIn link is displayed");
	}

	// Login from Access Denied page
	public void accessDeniedpage() {
		boolean flag1 = false, flag2 = false, flag3 = false;
		String title = executor.getText(By.xpath("//h1"));
		executor.type(EmailId, "authenticated-user-test@mailinator.com", "Entered username in login pop-up");
		if (driver.getCurrentUrl().contains("ei")) {
			executor.type(password, "Ye@r2o17AwsTeSt_1", "Entered password  in login pop-up");
		} else {
			executor.type(password, "authenticatedusertest", "Entered password in login pop-up");
		}
		executor.click(loginButton, "Login Button clicked");
		String mainTitle = executor.getText(By.xpath("//h1"));
		if (title.equalsIgnoreCase(mainTitle)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		String username = executor.getText(By.xpath("//div[@class='user-name']"));
		if (username.equalsIgnoreCase("Hello, Dr. Authenticated")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.clickJS(logoutLink, "Logout link clicked");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait until Login button is present");
		String login = logIn.getText();
		if (login.equalsIgnoreCase("Login")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Login and Logout successful");
		} else {
			executor.assertTrue(false, "Login and Logout unsuccessful");
		}

	}

	// Homepage Login button error messages check
	public void errorcheckhomepage() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		executor.click(logIn, "Login button clicked");
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(emailerrorMessage, "Wait until Error is displayed");
		String emailerror_message = emailerrorMessage.getText();
		String passworderror_message = passworderrorMessage.getText();
		if (emailerror_message.equalsIgnoreCase("Email field is required.")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (passworderror_message.equalsIgnoreCase("Password field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.click(logIn, "Login button clicked");
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		String commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Password field is required.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.click(logIn, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Email field is required.")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.click(logIn, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message
				.contains("We do not recognize this username and password combination. Please try again.")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Error messages displayed successfully");
		} else {
			executor.assertTrue(false, "Error messages are not displayed");
		}
	}

	// Homepage Login button error messages check
	public void errorcheckSignin() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait for Sign In to be visible");
		executor.scrollIntoView(firstName);
		executor.click(signInLinkReg, "Click on Sign Link");
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(emailerrorMessage, "Wait until Error is displayed");
		String emailerror_message = emailerrorMessage.getText();
		String passworderror_message = passworderrorMessage.getText();
		if (emailerror_message.equalsIgnoreCase("Email field is required.")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (passworderror_message.equalsIgnoreCase("Password field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait for Sign In to be visible");
		executor.scrollIntoView(firstName);
		executor.click(signInLinkReg, "Click on Sign Link");
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		String commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Password field is required.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait for Sign In to be visible");
		executor.scrollIntoView(firstName);
		executor.click(signInLinkReg, "Click on Sign Link");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Email field is required.")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.softWaitforVisibilityOfWebElement(searchIcon, "Wait for Sign In to be visible");
		executor.scrollIntoView(firstName);
		executor.click(signInLinkReg, "Click on Sign Link");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.click(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message
				.contains("We do not recognize this username and password combination. Please try again.")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Error messages displayed successfully");
		} else {
			executor.assertTrue(false, "Error messages are not displayed");
		}
	}

	// Q&A section Login error messages check
	public void errorcheckQA() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		executor.softWaitforElementToBeClickable(loginButtonQA, "Login Button on Q&A visible");
		executor.scrollDown(500);
		executor.actionClick(loginButtonQA, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(emailerrorMessage, "Wait until Error is displayed");
		String emailerror_message = emailerrorMessage.getText();
		String passworderror_message = passworderrorMessage.getText();
		if (emailerror_message.equalsIgnoreCase("Email field is required.")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (passworderror_message.equalsIgnoreCase("Password field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.scrollDown(500);
		executor.type(EmailIdQA, "aasd", "Entered wrong username in login pop-up");
		executor.actionClick(loginButtonQA, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		String commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Password field is required.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.scrollDown(500);
		executor.clear(EmailIdQA, "Email field clearing");
		executor.clear(passwordQA, "Password field clearing");
		executor.type(passwordQA, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButtonQA, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Email field is required.")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.scrollDown(500);
		executor.clear(EmailIdQA, "Email field clearing");
		executor.clear(passwordQA, "Password field clearing");
		executor.type(EmailIdQA, "aasd", "Entered wrong username in login pop-up");
		executor.type(passwordQA, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButtonQA, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message
				.contains("We do not recognize this username and password combination. Please try again.")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Error messages displayed successfully");
		} else {
			executor.assertTrue(false, "Error messages are not displayed");
		}
	}

	// Save to Library Login error messages check
	public void errorcheckLibrary() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		gotoSaveLibrary();
		executor.softWaitforElementToBeClickable(loginButton, "Login Button on Q&A visible");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(emailerrorMessage, "Wait until Error is displayed");
		String emailerror_message = emailerrorMessage.getText();
		String passworderror_message = passworderrorMessage.getText();
		if (emailerror_message.equalsIgnoreCase("Email field is required.")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (passworderror_message.equalsIgnoreCase("Password field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.scrollIntoView(description);
		executor.softWaitforElementToBeClickable(saveToReadLater, "Wait for Save to Library to be clickable");
		executor.clickJS(saveToReadLater, "Save to Library button clicked");
		executor.softWaitforElementToBeClickable(loginButton, "Login Button on Q&A visible");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		String commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Password field is required.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.scrollIntoView(description);
		executor.softWaitforElementToBeClickable(saveToReadLater, "Wait for Save to Library to be clickable");
		executor.clickJS(saveToReadLater, "Save to Library button clicked");
		executor.softWaitforElementToBeClickable(loginButton, "Login Button on Q&A visible");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Email field is required.")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.scrollIntoView(description);
		executor.softWaitforElementToBeClickable(saveToReadLater, "Wait for Save to Library to be clickable");
		executor.clickJS(saveToReadLater, "Save to Library button clicked");
		executor.softWaitforElementToBeClickable(libraryLoginButton, "Login Button on Q&A visible");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message
				.contains("We do not recognize this username and password combination. Please try again.")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Error messages displayed successfully");
		} else {
			executor.assertTrue(false, "Error messages are not displayed");
		}
	}

	// Access Denied Login error messages check
	public void errorcheckAccessDenied() {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false;
		gotoAccessDeniedPage();
		// executor.scrollDown(500);
		signInClick();
		executor.softWaitforElementToBeClickable(loginButton, "Login Button on Q&A visible");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(emailerrorMessage, "Wait until Error is displayed");
		String emailerror_message = emailerrorMessage.getText();
		String passworderror_message = passworderrorMessage.getText();
		if (emailerror_message.equalsIgnoreCase("Email field is required.")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (passworderror_message.equalsIgnoreCase("Password field is required.")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		signInClick();
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		String commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Password field is required.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		signInClick();
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message.contains("Email field is required.")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		signInClick();
		executor.softWaitforVisibilityOfWebElement(popUpFrame, "Wait until Check Login button is displayed");
		executor.clear(EmailId, "Email field clearing");
		executor.clear(password, "Password field clearing");
		executor.type(EmailId, "aasd", "Entered wrong username in login pop-up");
		executor.type(password, "aasd", "Entered wrong password in login pop-up");
		executor.actionClick(loginButton, "Login Button clicked");
		executor.softWaitforVisibilityOfWebElement(mainErrorMessage, "Wait until Error is displayed");
		commonerror_message = mainErrorMessage.getText();
		if (commonerror_message
				.contains("We do not recognize this username and password combination. Please try again.")) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		if (flag1 && flag2 && flag3 && flag4 && flag5) {
			executor.assertTrue(true, "Error messages displayed successfully");
		} else {
			executor.assertTrue(false, "Error messages are not displayed");
		}
	}

	// go to Access Denied Page
	public void gotofirstAccessDeniedPage() {
		executor.click(loginButtonQA, "Search Icon CLick");
		searchIconClick("International Journal of Industrial Ergonomics: Quick facts and submission tips");
		executor.softWaitforElementToBeClickable(firstSearchResults, "Wait for first Search Result to be clickable");
		executor.click(firstSearchResults, "click on first result");
		do {
			driver.navigate().refresh();
		} while (!driver
				.findElement(
						By.xpath("//div[@class='panel-pane pane-block pane-new-reg-form-access-denied-page-heading']"))
				.isDisplayed());
		executor.waitForPageLoadJS();
	}

	public void loginPopup() {
		executor.softWaitforElementToBeClickable(logInPopup, "Wait for login popup to be clickable");
		executor.clickJS(logInPopup, "login popup clicked");
		boolean loginpopup = executor.isElementDisplayed(loginButton, "Question textbox is displayed");
		boolean username = executor.isElementDisplayed(EmailId, "Question textbox is displayed");
		boolean pass = executor.isElementDisplayed(password, "Question textbox is displayed");

		if (loginpopup && username && pass) {
			executor.assertTrue(true, "Login popup is displayed");
		} else {
			executor.assertTrue(false, "Login popup is not displayed");
		}
	}

	public boolean deleteUser(String newUser, String staging_password, String live_password, String delete_user) throws InterruptedException {
		boolean flag1 = false, flag2 = false, flag3=false, flag4=false;
		executor.clickJS(logoutLink, "User should be logged out");
		executor.softWaitforVisibilityOfWebElement(logIn, "Wait for login button");
		loginUser(newUser, staging_password, live_password);
		if (driver.getCurrentUrl().contains("ei.editage.com")) {
			executor.navigateToURL("https://ei.editage.com/insights/admin/people");
		} else {
			executor.navigateToURL("https://www.editage.com/insights/admin/people");
		}

		executor.softWaitforVisibilityOfWebElement(emailAddressbackend, "Wait for Email ID at the backend");
		executor.type(emailAddressbackend, delete_user, "wait for the email to be searched");
		executor.click(applyButtonBackend, "CLick on apply button");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//input[@class='form-submit progress-disabled']"), "Wait for Email ID to appear");
		executor.softWaitforVisibilityOfWebElement(searchEmailID, "Wait for Email ID to appear");
		executor.softWaitforElementToBeClickable(searchEmailID, "Wait for Cancel button to be clickable");
		if (searchEmailID.getText().contains(delete_user)) {
			flag1 = true;
			executor.log(searchEmailID.getText());
		} else {
			flag1 = false;
			throw new IllegalStateException("This is not  the  Email ID to be deleted");
		}
		executor.clickJS(searchCancelButton, "CLick on Cancel button");
		executor.softWaitforElementToBeClickable(deleteUserRadioButton, "Wait for page to load");
		if(driver.findElement(By.xpath("//h1[@class='page-title']/em")).getText().contains(delete_user)){
			flag2=true;
			executor.log(driver.findElement(By.xpath("//h1[@class='page-title']/em")).getText());
		}else{
			flag2 = false;
			throw new IllegalStateException("This is not  the  Email ID to be deleted");
		}
		executor.click(deleteUserRadioButton, "Select the radio button");
		executor.actionClick(saveButtonSearch, "Click on the save button");
		executor.softWaitforVisibilityOfWebElement(applyButtonBackend, "Wait for apply button");
		executor.softWaitforElementToBeClickable(applyButtonBackend, "Wait for apply button to be clickable");
		driver.navigate().refresh();
		executor.softWaitforElementToBeClickable(applyButtonBackend, "Wait for apply button to be clickable");
		executor.clear(emailAddressbackend, "Clear the email Address field");
		executor.type(emailAddressbackend, delete_user, "wait for the email to be searched");
		executor.actionClick(applyButtonBackend, "CLick on apply button");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//input[@class='form-submit progress-disabled']"), "Wait for Email ID to appear");
		executor.softWaitforVisibilityOfWebElement(noUserSearch, "Wait for the search results");
		executor.softWaitforVisibilityOfWebElement(noUserSearch, "Wait for the search results");
		if (noUserSearch.getText().contains("No users available.")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if(flag1 && flag2 && flag3){
			flag4=true;
		}else{
			flag4=false;
		}
		return flag4;
	}

}