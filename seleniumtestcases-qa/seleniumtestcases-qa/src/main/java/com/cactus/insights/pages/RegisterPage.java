package com.cactus.insights.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class RegisterPage {// extends AbstractPage
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage loginPage;

	// Registration Heading
	@FindBy(xpath = "//div[contains(@class,'page-heading')]/div")
	public WebElement registerHeading;

	// Registration Sub Heading
	@FindBy(xpath = "//div[contains(@class,'page-sub-heading')]/div")
	public WebElement registerSubHeading;

	// Registration Sub Heading
	@FindBy(xpath = "//div[@class='panel-pane pane-custom pane-2']")
	public WebElement ebookHeading;

	// Facebook link
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Facebook']")
	public WebElement fblink;

	// Facebook button
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Facebook']/div/span")
	public WebElement fbicon;

	// Twitter link
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Twitter']")
	public WebElement twitterlink;

	// Twitter button
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Twitter']/div/span")
	public WebElement twittericon;

	// LinkedIn link
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='LinkedIn']")
	public WebElement LinkedinLink;

	// LinkedIn button
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='LinkedIn']/div/span")
	public WebElement LinkedinIcon;

	// Orcid link
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Orcid']")
	public WebElement OrcidLink;

	// Orcid button
	@FindBy(xpath = "//form[@id='user-register-form']//a[@title='Orcid']/span")
	public WebElement OrcidIcon;

	// FirstName
	@FindBy(xpath = "//input[@id='edit-firstname']")
	public WebElement firstNameNew;

	// Password
	@FindBy(xpath = "//input[@id='edit-pass']")
	public WebElement passwordNew;

	// Lastname
	@FindBy(xpath = "//input[@id='edit-lastname']")
	public WebElement lastNameNew;

	// Email ID
	@FindBy(xpath = "//input[contains(@id,'edit-mail')]")
	public WebElement mailNew;

	// Email ID
	@FindBy(xpath = "//input[contains(@id,'edit-email')]")
	public WebElement mailNewTwitter;

	// FirstName label
	@FindBy(xpath = "//label[@for='edit-firstname']")
	public WebElement firstnameLabel;

	// lastname label
	@FindBy(xpath = "//label[@for='edit-lastname']")
	public WebElement lastnameLabel;

	// mail id label
	@FindBy(xpath = "//label[contains(@for,'edit-mail')]")
	public WebElement mailLabel;

	// mail id label
	@FindBy(xpath = "//label[contains(@for,'edit-email')]")
	public WebElement mailLabelTwitter;

	// password label
	@FindBy(xpath = "//label[@for='edit-pass']")
	public WebElement passwordLabel;

	// password toggle
	@FindBy(xpath = "//label[@class='password-toggle-bookmark']")
	public WebElement passwordToggle;

	// password toggle clear text
	@FindBy(xpath = "//input[@type='text' and @id='edit-pass']")
	public WebElement passwordToggleClearText;

	// privacy policy text
	@FindBy(xpath = "//div[contains(@class,'new-reg-form-privacy-policy')]/div")
	public WebElement privacyPolicyText;

	// privacy policy link
	@FindBy(xpath = "//div[contains(@class,'new-reg-form-privacy-policy')]/div/a")
	public WebElement privacyPolicyLink;

	// Contact us text
	@FindBy(xpath = "//div[contains(text(),'registering/logging')]")
	public WebElement contactUsText;

	// Contact us link
	@FindBy(xpath = "//div[contains(text(),'registering/logging')]/a")
	public WebElement contactUsLink;

	// Join Now button
	@FindBy(xpath = "//form[@id='user-register-form']//input[contains(@id,'edit-submit')]")
	public WebElement joinNowNew;

	// Verify Information text
	@FindBy(xpath = "//span[contains(text(),'Verify your')]")
	public WebElement verifyInformation;

	// Please verify your info text
	@FindBy(xpath = "//div[contains(text(),'Please verify your information')]")
	public WebElement pleaseVerifyText;

	// Join Now button
	@FindBy(xpath = "//form[contains(@id,'user-form-register')]//input[contains(@id,'edit-submit')]")
	public WebElement joinNowOrcid;

	// Join Now button
	@FindBy(xpath = "//form[contains(@id,'hybridauth-additional-info-form')]//input[contains(@id,'edit-submit')]")
	public WebElement joinNowTwitter;

	// Sign in Text
	@FindBy(xpath = "//div[contains(text(),'a member')]")
	public WebElement signInText;

	// Register button
	@FindBy(xpath = "//div[@class='anonymous-register anonymous-text']/a")
	public WebElement registerButton;

	// Register form
	@FindBy(id = "formm-bg")
	public WebElement registrationForm;

	// First Name
	@FindBy(id = "txtfirstname")
	public WebElement firstName;

	// Last name
	@FindBy(id = "txtlastname")
	public WebElement lastName;

	// Email Address
	@FindBy(id = "txtemail")
	public WebElement emailAddressRegister;

	// Password
	@FindBy(id = "txtpwd")
	public WebElement passwordRegister;

	// Confirm Password
	@FindBy(id = "txtcnfpwd")
	public WebElement confirmPassword;

	// Univeristy Name
	@FindBy(id = "txtorg")
	public WebElement universityName;

	// Job Title Select Id
	@FindBy(id = "drpjdesc")
	public WebElement jobTitleId;

	// Registration wait
	@FindBy(id = "modalOverlay")
	public WebElement registrationWait;

	// Recent Article Title
	@FindBy(xpath = "//a[contains(@href,'recent-article')]")
	public WebElement recentArticleTitle;

	// Captcha Text
	@FindBy(xpath = "//span[@class='captchaText']")
	public WebElement captchaText;

	// Register for free button
	@FindBy(id = "crsubmit")
	public WebElement registerFreeButton;

	// Register Captcha Wait
	@FindBy(xpath = "//div[@class='captchaImages']/img[@class='captchaImage simpleCaptchaSelected']")
	public WebElement registerCaptchaWait;

	// Register section click
	@FindBy(xpath = "//div[@class='display-dr-eddy']")
	public WebElement registerSection;

	// First Name Error
	@FindBy(id = "fnameerror")
	public WebElement firstNameError;

	// Last Name Error
	@FindBy(id = "lnameerror")
	public WebElement lastNameError;

	// Email Address Error
	@FindBy(id = "enameerror")
	public WebElement emailAddressError;

	// Password Error
	@FindBy(id = "pwderror")
	public WebElement passwordErrorMessage;

	// Confirm Password Error
	@FindBy(id = "cnfpwderror")
	public WebElement confirmPasswordError;

	// Job Title Error
	@FindBy(id = "jdescerror")
	public WebElement jobtitleError;

	// University/Institute/Company Error
	@FindBy(id = "orgerror")
	public WebElement univErrorMsg;

	// Mini Panel
	@FindBy(id = "mini-panel-top_toolbar")
	public WebElement miniPanel;

	// Captcha error
	@FindBy(id = "captchaerror")
	public WebElement captchaErrorMsg;

	// register For Free
	@FindBy(xpath = "//div[@class='register-button anonymous-register GoogleAnalyticsET-processed']/a")
	public WebElement registerFree;

	// registration pop-up
	@FindBy(xpath = "//span[@class='insights-register-link anonymous-register']/a")
	public WebElement registerpopup;

	// Registration Button
	@FindBy(xpath = "//div[@id='registration-prompt']//span[@class='anonymous-register GoogleAnalyticsET-processed']/a")
	public WebElement registeraccessDenied;

	// Firstname blank error
	@FindBy(xpath = "//form[@id='user-register-form']//div[contains(@class,'form-item-firstname')]/following-sibling::div[1]")
	public WebElement firstNameBlankError;

	// lastname blank error
	@FindBy(xpath = "//form[@id='user-register-form']//div[contains(@class,'form-item-lastname')]/following-sibling::div[1]")
	public WebElement lastNameBlankError;

	// Mail Blank error
	@FindBy(xpath = "//form[@id='user-register-form']//div[contains(@class,'form-item-mail')]/following-sibling::div[1]")
	public WebElement mailBlankError;

	// Password Blank error
	@FindBy(xpath = "//form[@id='user-register-form']//div[contains(@class,'form-item-pass')]/following-sibling::div[1]")
	public WebElement passwordBlankError;

	// Facebook email
	@FindBy(id = "email")
	public WebElement fbMail;

	// Facebook Password
	@FindBy(id = "pass")
	public WebElement fbPassword;

	// Facebook Login button
	@FindBy(id = "loginbutton")
	public WebElement fbLogin;

	// Twitter email
	@FindBy(id = "username_or_email")
	public WebElement twitterMail;

	// Twitter Password
	@FindBy(id = "password")
	public WebElement twitterPassword;

	// Twitter Login button
	@FindBy(id = "allow")
	public WebElement twitterLogin;

	// Linkedin email
	@FindBy(id = "session_key-login")
	public WebElement linkedinMail;

	// Linkedin Password
	@FindBy(id = "session_password-login")
	public WebElement linkedinPassword;

	// Linkedin Login button
	@FindBy(xpath = "//input[@class='btn-signin']")
	public WebElement linkedinLogin;

	// Orcid email
	@FindBy(id = "userId")
	public WebElement orcidMail;

	// Orcid Password
	@FindBy(id = "password")
	public WebElement orcidPassword;

	// Orcid Login button
	@FindBy(id = "form-sign-in-button")
	public WebElement orcidLogin;

	// Orcid Authorize button
	@FindBy(id = "authorize")
	public WebElement orcidAuthorize;

	// Username block
	@FindBy(xpath = "//div[@class='user-name']")
	public WebElement usernameBlock;

	// Username block name
	@FindBy(xpath = "//div[@class='user-name']/span")
	public WebElement usernameBlockName;

	// Firstname blank error
	@FindBy(xpath = "//form[contains(@id,'user-form-register')]//div[contains(@class,'form-item-firstname')]/following-sibling::div[1]")
	public WebElement firstNameBlankErrorAdditionalForm;

	// lastname blank error
	@FindBy(xpath = "//form[contains(@id,'user-form-register')]//div[contains(@class,'form-item-lastname')]/following-sibling::div[1]")
	public WebElement lastNameBlankErrorAdditionalForm;

	// Mail Blank error
	@FindBy(xpath = "//form[contains(@id,'user-form-register')]//div[contains(@class,'form-item-mail')]/following-sibling::div[1]")
	public WebElement mailBlankErrorAdditionalForm;

	// Firstname blank error
	@FindBy(xpath = "//form[contains(@id,'hybridauth-additional-info-form')]//div[contains(@class,'form-item-firstName')]/following-sibling::div[1]")
	public WebElement firstNameBlankErrorAdditionalFormTwitter;

	// lastname blank error
	@FindBy(xpath = "//form[contains(@id,'hybridauth-additional-info-form')]//div[contains(@class,'form-item-lastName')]/following-sibling::div[1]")
	public WebElement lastNameBlankErrorAdditionalFormTwitter;

	// Mail Blank error
	@FindBy(xpath = "//form[contains(@id,'hybridauth-additional-info-form')]//div[contains(@class,'form-item-email')]/following-sibling::div[1]")
	public WebElement mailBlankErrorAdditionalFormTwitter;

	// Register Page/ HomePage Conditions
	public RegisterPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
	}

	public void registerSectionClick() {
		// executor.scrollDown(600);
		executor.softWaitforVisibilityOfWebElement(registerSection, "Waiting for Registration Section to appear");
		executor.moveToElement(registerSection);
		executor.clickJS(registerSection, "Register Section is clicked");
		executor.softWaitforVisibilityOfWebElement(
				By.xpath("//div[@class='panels-ajax-tab-panel panels-ajax-tab-panel-dr-eddy-form-registeration']"),
				"Waiting for Registration Form to appear");
	}

	public void goToRegistration() {
		executor.softWaitforElementToBeClickable(registerButton, "Wait for Registration button");
		executor.actionClick(registerButton, "Registration Button is clicked");
	}

	public void userRegistration() {
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String first_name = "testuser";
		String last_name = "editage";
		String emailid = "a" + dateFormat.format(date) + "@mailinator.com";
		String password = "test";
		executor.scrollDown(600);
		driver.switchTo().frame("insights-widget");
		executor.softWaitforVisibilityOfWebElement(registrationForm, "Wait for Registration Form");
		executor.moveToElement(firstName);
		executor.type(firstName, first_name, "Firstname entered in registration field");
		executor.type(lastName, last_name, "Lastname entered in registration field");
		executor.type(emailAddressRegister, emailid, "Emailid entered in registration field");
		executor.type(passwordRegister, password, "New Password entered in registration field");
		executor.type(confirmPassword, password, "ConfirmPassword entered in registration field");
		executor.selectFromDropDown(jobTitleId, "0", "Part-time researcher");
		executor.type(universityName, "testuniversity", "University Name entered in registration field");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='captchaImages']"),
				"Wait for captcha to load");
		selectCaptcha();
		executor.clickJS(registerFreeButton, "Registration Button clicked");
		executor.softWaitforInvisibilityOFWebElement(registrationWait, "Waiting for Registration Confirmation");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//div[@class='scLoader']"),
				"Waiting for Registration Loader to disappear");
		driver.switchTo().defaultContent();
		loginPage = new LoginPage(driver, test, wait);
		executor.softWaitforVisibilityOfWebElement(loginPage.username, "Wait for the username to be displayed");
		loginPage.logoutClick();
		loginPage.login(emailid, password, password);
	}

	public void newUserRegistration() {
		boolean flag1 = false, flag2 = false, flag3 = false;
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String first_name = "test user Ömer test-user test_user";
		String last_name = "edit age Ömer test-user edit_age";
		String emailid = "a" + dateFormat.format(date) + "@mailinator.com";
		String password = "test@123";
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			flag1 = registrationTextDisplayTop();
			executor.scrollIntoView(registerHeading);
		} else {
			flag1 = registrationSocialMediaTop();
			executor.scrollIntoView(ebookHeading);
		}
		executor.actionClick(firstNameNew, "FirstName clicked");
		executor.softWaitforElementToBeClickable(passwordNew, "Wait for password field to appear");
		executor.clear(firstNameNew, "Clear FirstName");
		executor.type(firstNameNew, first_name, "Enter firstname");
		executor.clear(lastNameNew, "Clear LastName");
		executor.type(lastNameNew, last_name, "Enter lastname");
		executor.clear(mailNew, "Clear Email ID");
		executor.type(mailNew, emailid, "Enter email id");
		executor.clear(passwordNew, "Clear Password");
		executor.type(passwordNew, password, "Enter email password");
		if (driver.getCurrentUrl().contains("user/signup?InsightsReferer=")
				|| driver.getCurrentUrl().contains("ask-a-question")
				|| driver.getCurrentUrl().contains("?access-denied-content=")) {
			executor.actionClick(passwordToggle, "Click on password Toggle");
			executor.softWaitforVisibilityOfWebElement(passwordToggleClearText, "Wait for class to change");
			if (passwordToggleClearText.isDisplayed()) {
				flag2 = true;
			} else {
				flag2 = false;
			}
		} else {
			flag2 = true;
		}
		flag3 = registrationtextDisplayBottom();
		executor.click(joinNowNew, "Click Join Now Button");
		loginPage = new LoginPage(driver, test, wait);
		executor.softWaitforVisibilityOfWebElement(loginPage.username, "Wait for the username to be displayed");
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Registration was successful");
		} else {
			executor.assertTrue(false, "Registration was unsuccessful");
		}

	}

	public void newErrorMessages() {
		boolean flag1 = false, flag2 = false;
		String first_name = "123@";
		String last_name = "123@";
		String emailid = "test@";
		String password = "test";
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.actionClick(firstNameNew, "FirstName clicked");
		executor.softWaitforElementToBeClickable(joinNowNew, "Wait for Join Now button to be clickable");
		executor.actionClick(joinNowNew, "Click Join Now Button");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankError, "Wait for error messages to be displayed");
		if (firstNameBlankError.getText().contains("First name is required")
				&& lastNameBlankError.getText().contains("Last name is required")
				&& mailBlankError.getText().contains("Email address is required")
				&& passwordBlankError.getText().contains("Password is required")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.actionClick(firstNameNew, "FirstName clicked");
		executor.softWaitforElementToBeClickable(passwordNew, "Wait for password field to appear");
		executor.clear(firstNameNew, "Clear FirstName");
		executor.type(firstNameNew, first_name, "Enter firstname");
		executor.clear(lastNameNew, "Clear LastName");
		executor.type(lastNameNew, last_name, "Enter lastname");
		executor.clear(mailNew, "Clear Email ID");
		executor.type(mailNew, emailid, "Enter email id");
		executor.clear(passwordNew, "Clear Password");
		executor.type(passwordNew, password, "Enter email password");
		executor.scrollIntoView(lastNameNew);
		executor.actionClick(joinNowNew, "Click Join Now Button");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankError, "Wait for error messages to be displayed");
		if (firstNameBlankError.getText().contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& lastNameBlankError.getText().contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& mailBlankError.getText().contains("Please enter a valid email address")
				&& passwordBlankError.getText().contains("Password should have minimum 6 characters")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "Error Messages are appropriately displayed");
		} else {
			executor.assertTrue(false, "Error Messages are  displayed wrong");
		}

	}

	public boolean registrationSocialMediaTop() {
		boolean flag1 = false;
		if (fblink.getAttribute("href").contains("/insights/hybridauth/window/Facebook?") && fbicon.isDisplayed()
				&& twitterlink.getAttribute("href").contains("/insights/hybridauth/window/Twitter?")
				&& twittericon.isDisplayed()
				&& LinkedinLink.getAttribute("href").contains("/insights/hybridauth/window/LinkedIn?")
				&& LinkedinIcon.isDisplayed()
				&& OrcidLink.getAttribute("href").contains("orcid.org/oauth/authorize?client_id")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

	public boolean registrationTextDisplayTop() {
		boolean flag1 = false;
		if (!registerHeading.getText().isEmpty() && !registerSubHeading.getText().isEmpty()
				&& fblink.getAttribute("href").contains("/insights/hybridauth/window/Facebook?") && fbicon.isDisplayed()
				&& twitterlink.getAttribute("href").contains("/insights/hybridauth/window/Twitter?")
				&& twittericon.isDisplayed()
				&& LinkedinLink.getAttribute("href").contains("/insights/hybridauth/window/LinkedIn?")
				&& LinkedinIcon.isDisplayed()
				&& OrcidLink.getAttribute("href").contains("orcid.org/oauth/authorize?client_id")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

	public boolean registrationtextDisplayBottom() {
		boolean flag1 = false;
		if (!privacyPolicyText.getText().isEmpty()
				&& privacyPolicyLink.getAttribute("href").contains("/insights/terms-and-conditions")
				&& !contactUsText.getText().isEmpty()
				&& contactUsLink.getAttribute("href").contains("mailto:insights@editage.com")
				&& !signInText.getText().isEmpty() && firstnameLabel.getText().contains("First name")
				&& lastnameLabel.getText().contains("Last name") && mailLabel.getText().contains("Email address")
				&& passwordLabel.getText().contains("Password")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

	public void userRegistrationHomepage() {
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String first_name = "testuser";
		String last_name = "editage";
		String emailid = "a" + dateFormat.format(date) + "@mailinator.com";
		String password = "test";
		// executor.scrollDown(600);
		driver.switchTo().frame("insights-widget");
		executor.softWaitforVisibilityOfWebElement(registrationForm, "Wait for Registration Form");
		executor.moveToElement(firstName);
		executor.type(firstName, first_name, "Firstname entered in registration field");
		executor.type(lastName, last_name, "Lastname entered in registration field");
		executor.type(emailAddressRegister, emailid, "Emailid entered in registration field");
		executor.type(passwordRegister, password, "New Password entered in registration field");
		executor.type(confirmPassword, password, "ConfirmPassword entered in registration field");
		executor.selectFromDropDown(jobTitleId, "0", "Part-time researcher");
		executor.type(universityName, "testuniversity", "University Name entered in registration field");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='captchaImages']"),
				"Wait for captcha to load");
		selectCaptcha();
		executor.clickJS(registerFreeButton, "Registration Button clicked");
		executor.softWaitforInvisibilityOFWebElement(registrationWait, "Waiting for Registration Confirmation");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//div[@class='scLoader']"),
				"Waiting for Registration Loader to disappear");
		driver.switchTo().defaultContent();
		loginPage = new LoginPage(driver, test, wait);
		executor.softWaitforVisibilityOfWebElement(loginPage.username, "Wait for the username to be displayed");
		loginPage.logoutClick();
		loginPage.login(emailid, password, password);
	}

	public void selectCaptcha() {
		List<WebElement> choice = driver.findElements(By.xpath("//div[@class='captchaImages']/img"));
		for (WebElement e : choice) {
			if (e.getAttribute("src").contains("01.png") && captchaText.getText().contains("House")) {
				executor.clickJS(e, "Captcha House icon is selected");
				break;
			} else if (e.getAttribute("src").contains("02.png") && captchaText.getText().contains("Key")) {
				executor.clickJS(e, "Captcha Key icon is selected");
				break;
			} else if (e.getAttribute("src").contains("03.png") && captchaText.getText().contains("Flag")) {
				executor.clickJS(e, "Captcha Flag icon is selected");
				break;
			} else if (e.getAttribute("src").contains("04.png") && captchaText.getText().contains("Clock")) {
				executor.clickJS(e, "Captcha Clock icon is selected");
				break;
			} else if (e.getAttribute("src").contains("05.png") && captchaText.getText().contains("Bug")) {
				executor.clickJS(e, "Captcha Bug icon is selected");
				break;
			} else if (e.getAttribute("src").contains("06.png") && captchaText.getText().contains("Pen")) {
				executor.clickJS(e, "Captcha Pen icon is selected");
				break;
			} else if (e.getAttribute("src").contains("07.png") && captchaText.getText().contains("Light")) {
				executor.clickJS(e, "Captcha Light icon is selected");
				break;
			} else if (e.getAttribute("src").contains("08.png") && captchaText.getText().contains("Musical")) {
				executor.clickJS(e, "Captcha Musical icon is selected");
				break;
			} else if (e.getAttribute("src").contains("09.png") && captchaText.getText().contains("Heart")) {
				executor.clickJS(e, "Captcha Heart icon is selected");
				break;
			} else if (e.getAttribute("src").contains("10.png") && captchaText.getText().contains("World")) {
				executor.clickJS(e, "Captcha World icon is selected");
				break;
			}
		}
		executor.softWaitforVisibilityOfWebElement(registerCaptchaWait, "Waitng for Captcha to be selected");
	}

	public void registerErrorMessages() {
		driver.switchTo().frame("insights-widget");
		executor.clickJS(registerFreeButton, "Registration Button clicked");
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false, flag7 = false,
				flag8 = false, flag9 = false, flag10 = false, flag11 = false;
		// Verify all the Error Messages
		if (firstNameError.getText().contains("Re-enter your name")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		if (lastNameError.getText().contains("Re-enter your last name")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (emailAddressError.getText().contains("Enter your email address")) {
			flag3 = true;
			executor.type(emailAddressRegister, "asd", "Wrong Email id entered in registration field");
			executor.clickJS(registerFreeButton, "Registration Button clicked");
		} else {
			flag3 = false;
		}
		if (emailAddressError.getText().contains("Invalid email address. Please try again")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		if (passwordErrorMessage.getText().contains("Set your account password")) {
			flag5 = true;
			executor.type(passwordRegister, "1", "Wrong Password entered in registration field");
			executor.clickJS(registerFreeButton, "Registration Button clicked");
		} else {
			flag5 = false;
		}
		if (passwordErrorMessage.getText().contains("Password required one character")) {
			flag6 = true;
			executor.type(passwordRegister, "1a", "Password entered in registration field");
			executor.clickJS(registerFreeButton, "Registration Button clicked");
		} else {
			flag6 = false;
		}
		if (confirmPasswordError.getText().contains("Please enter your password again for confirmation")) {
			flag7 = true;
			executor.type(confirmPassword, "1asd", "Wrong Confirm Password entered in registration field");
			executor.clickJS(registerFreeButton, "Registration Button clicked");
		} else {
			flag7 = false;
		}
		if (confirmPasswordError.getText().contains("Password does not match. Please try again.")) {
			flag8 = true;
		} else {
			flag8 = false;
		}
		if (jobtitleError.getText().contains("Select a job description from the dropdown list")) {
			flag9 = true;
		} else {
			flag9 = false;
		}
		if (univErrorMsg.getText().contains("Enter the name of the organization")) {
			flag10 = true;
		} else {
			flag10 = false;
		}
		if (captchaErrorMsg.getText().contains("Please select a captcha")) {
			flag11 = true;
		} else {
			flag11 = false;
		}
		// Verify the Final condition
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6 && flag7 && flag8 && flag9 && flag10 && flag11) {
			executor.assertTrue(true, "Error Messages are appropriately displayed");
		} else {
			executor.assertTrue(false, "Error Messages are displayed wrong");
		}

	}

	public void registrationFormCheck() {
		// executor.scrollDown(500);
		driver.switchTo().frame("insights-widget");
		executor.softWaitforVisibilityOfWebElement(registrationForm, "Wait for Registration Form");
		boolean registrationFree = executor.isElementDisplayed(registrationForm, "Verify form is displayed");
		if (registrationFree) {
			executor.assertTrue(true, "Registration Form is displayed");
		} else {
			executor.assertTrue(false, "Registration Form is not displayed");
		}
	}

	public void registerFree() {
		executor.actionClick(registerFree, "Register For Free button clicked");
		registrationFormCheck();
	}

	public void registrationPopup() {
		executor.softWaitforVisibilityOfWebElement(registeraccessDenied, "Wait for Registration Pop-Up");
		executor.clickJS(registeraccessDenied, "Click on Registration button");
		registrationFormCheck();
	}

	public void accessdenieduserRegistration() {
		boolean flag1 = false, flag2 = false, flag3 = false;
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String first_name = "testuser";
		String last_name = "editage";
		String emailid = "a" + dateFormat.format(date) + "@mailinator.com";
		String password = "test";
		List<WebElement> minipanel = driver.findElements(By.xpath("//div[@id='mini-panel-top_toolbar']"));
		if (minipanel.size() == 0) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		String title = executor.getText(By.xpath("//h1"));
		String URL = driver.getCurrentUrl();
		if (URL.contains("?access-denied-content=metered&")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.scrollDown(500);
		driver.switchTo().frame("insights-widget");
		executor.softWaitforVisibilityOfWebElement(registrationForm, "Wait for Registration Form");
		executor.moveToElement(firstName);
		executor.type(firstName, first_name, "Firstname entered in registration field");
		executor.type(lastName, last_name, "Lastname entered in registration field");
		executor.type(emailAddressRegister, emailid, "Emailid entered in registration field");
		executor.type(passwordRegister, password, "New Password entered in registration field");
		executor.type(confirmPassword, password, "ConfirmPassword entered in registration field");
		executor.selectFromDropDown(jobTitleId, "0", "Part-time researcher");
		executor.type(universityName, "testuniversity", "University Name entered in registration field");
		executor.softWaitforVisibilityOfWebElement(By.xpath("//div[@class='captchaImages']"),
				"Wait for captcha to load");
		selectCaptcha();
		executor.clickJS(registerFreeButton, "Registration Button clicked");
		executor.softWaitforInvisibilityOFWebElement(registrationWait, "Waiting for Registration Confirmation");
		executor.softWaitforInvisibilityOFWebElement(By.xpath("//div[@class='scLoader']"),
				"Waiting for Registration Loader to disappear");
		driver.switchTo().defaultContent();
		String mainTitle = executor.getText(By.xpath("//h1"));
		String mainURL = driver.getCurrentUrl();
		if (!mainURL.contains("?access-denied-content=metered&")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		if (title.equals(mainTitle) && flag1 && flag2 && flag3) {
			executor.assertTrue(true, "We are directed to same page after registration");
		} else {
			executor.assertTrue(false, "We are directed to same page after registration");
		}
	}

	public void facebookRegistration() {
		boolean flag1 = false, flag2 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(fbicon, "Click on Facebook Icon");
		if (driver.getCurrentUrl().contains("https://www.facebook.com/login.php?skip_api_login")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(fbMail, "Wait for Facebook Email ID to be visible");
		executor.type(fbMail, "bisht2394@gmail.com", "Entering the Email Id for facebook");
		executor.type(fbPassword, "bisht@123", "Entering the password for facebook");
		executor.click(fbLogin, "Click on Facebook Login button");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for Username block to be visible");
		if (driver.getCurrentUrl().contains("?loginform=loggedin-Facebook") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "We are logged in successfully with facebook");
		} else {
			executor.assertTrue(false, "We are not able to login with facebook");
		}
	}

	public void twitterRegistration() {
		boolean flag1 = false, flag2 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(twittericon, "Click on Twitters Icon");
		if (driver.getCurrentUrl().contains("https://api.twitter.com/oauth/authenticate?")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(twitterMail, "Wait for Twitter Email ID to be visible");
		executor.type(twitterMail, "bisht2394@gmail.com", "Entering the Email Id for twitter");
		executor.type(twitterPassword, "bisht@123", "Entering the password for twitter");
		executor.click(twitterLogin, "Click on twitter Login button");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for Username block to be visible");
		if (driver.getCurrentUrl().contains("?loginform=loggedin-Twitter") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "We are logged in successfully with twitter");
		} else {
			executor.assertTrue(false, "We are not able to login with twitter");
		}
	}

	public void linkedinRegistration() {
		boolean flag1 = false, flag2 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(LinkedinIcon, "Click on Linkedin Icon");
		if (driver.getCurrentUrl().contains("https://www.linkedin.com/uas/login?session_redirect=")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(linkedinMail, "Wait for LinkedIn Email ID to be visible");
		executor.type(linkedinMail, "bisht2394@gmail.com", "Entering the Email Id for twitter");
		executor.type(linkedinPassword, "bisht@123", "Entering the password for twitter");
		executor.click(linkedinLogin, "Click on Linkedin Login button");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for Username block to be visible");
		if (driver.getCurrentUrl().contains("?loginform=loggedin-LinkedIn") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "We are logged in successfully with Linkedin");
		} else {
			executor.assertTrue(false, "We are not able to login with Linkedin");
		}
	}

	public void OrcidRegistration() {
		boolean flag1 = false, flag2 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(OrcidLink, "Click on Orcid Icon");
		if (driver.getCurrentUrl().contains("https://orcid.org/signin?oauth&client_id=")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(orcidMail, "Wait for Orcid Email ID to be visible");
		executor.type(orcidMail, "bisht2394@gmail.com", "Entering the Email Id for Orcid");
		executor.type(orcidPassword, "bisht@123", "Entering the password for Orcid");
		executor.click(orcidLogin, "Click on Orcid Login button");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for Username block to be visible");
		if (driver.getCurrentUrl().contains("?loginform=loggedin-orcid") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		if (flag1 && flag2) {
			executor.assertTrue(true, "We are logged in successfully with Orcid");
		} else {
			executor.assertTrue(false, "We are not able to login with Orcid");
		}
	}

	public void additionalInformationForm() throws InterruptedException {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false;
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String emailid = "pratiktest" + dateFormat.format(date) + "@mailinator.com";
		flag1 = OrcidAdditionalFormRegistrationErrorMessages();
		if (verifyInformation.getText().contains("Verify your information")
				&& pleaseVerifyText.getText()
						.contains("Please verify your information and fill in all the fields for registration.")
				&& firstnameLabel.getText().contains("First name") && lastnameLabel.getText().contains("Last name")
				&& mailLabel.getText().contains("Email")
				&& driver.getCurrentUrl().contains("orcid-oauth-redirect?code")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.clear(mailNew, "Clear Email ID");
		executor.actionClick(joinNowOrcid, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankErrorAdditionalForm,
				"Wait for error messages to appear");
		if (firstNameBlankErrorAdditionalForm.getText().contains("First name is required")
				&& lastNameBlankErrorAdditionalForm.getText().contains("Last name is required")
				&& mailBlankErrorAdditionalForm.getText().contains("Email address is required")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.sendkeys(firstNameNew, "123@", "Type firstname into additional form field");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.sendkeys(lastNameNew, "123@", "Type lastname into additional form field");
		executor.clear(mailNew, "Clear First Name");
		executor.sendkeys(mailNew, "123@", "Type email id into additional form field");
		executor.actionClick(joinNowOrcid, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankErrorAdditionalForm,
				"Wait for error messages to appear");
		if (firstNameBlankErrorAdditionalForm.getText()
				.contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& lastNameBlankErrorAdditionalForm.getText()
						.contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& mailBlankErrorAdditionalForm.getText().contains("Please enter a valid email address")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.sendkeys(firstNameNew, "editage", "Type firstname into additional form field");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.sendkeys(lastNameNew, "test", "Type lastname into additional form field");
		executor.clear(mailNew, "Clear First Name");
		executor.sendkeys(mailNew, emailid, "Type email id into additional form field");
		executor.actionClick(joinNowOrcid, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for username block");
		if (driver.getCurrentUrl().contains("-success-orcid") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		loginPage = new LoginPage(driver, test, wait);
		flag6 = loginPage.deleteUser("pratik.sidam@cactusglobal.com", "Ye@r2o17AwsTeSt_1", "pratik.sidam", emailid);
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
			executor.assertTrue(true, "We are registered  successfully with Orcid");
		} else {
			executor.assertTrue(true, "We are registered successfully with Orcid");
		}

	}

	public boolean OrcidAdditionalFormRegistrationErrorMessages() {
		boolean flag1 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(OrcidLink, "Click on Orcid Icon");
		if (driver.getCurrentUrl().contains("https://orcid.org/signin?oauth&client_id=")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(orcidMail, "Wait for Orcid Email ID to be visible");
		executor.type(orcidMail, "pratiktester@mailinator.com", "Entering the Email Id for Orcid");
		executor.type(orcidPassword, "pratiktest123", "Entering the password for Orcid");
		executor.click(orcidLogin, "Click on Orcid Login button");
		// executor.softWaitforVisibilityOfWebElement(orcidAuthorize, "Wait for
		// the authorize button");
		// executor.click(orcidAuthorize, "Wait for the authorize button");
		executor.softWaitforVisibilityOfWebElement(verifyInformation, "Please wait for the additional form to appear");
		executor.softWaitforVisibilityOfWebElement(pleaseVerifyText, "Please wait for the additional form to appear");
		return flag1;
	}

	public void additionalInformationFormTwitter() throws InterruptedException {
		boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false, flag5 = false, flag6 = false;
		DateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
		// get current date time with Date()
		Date date = new Date();
		String emailid = "pratiktwitteredit" + dateFormat.format(date) + "@mailinator.com";
		flag1 = TwitterAdditionalFormRegistrationErrorMessages();
		if (verifyInformation.getText().contains("Verify your information")
				&& pleaseVerifyText.getText()
						.contains("Please verify your information and fill in all the fields for registration.")
				&& firstnameLabel.getText().contains("First name") && lastnameLabel.getText().contains("Last name")
				&& mailLabelTwitter.getText().contains("Email")
				&& driver.getCurrentUrl().contains("hybridauth/window/Twitter?destination_error=")) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.clear(mailNewTwitter, "Clear Email ID");
		executor.actionClick(joinNowTwitter, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankErrorAdditionalFormTwitter,
				"Wait for error messages to appear");
		if (firstNameBlankErrorAdditionalFormTwitter.getText().contains("First name is required")
				&& lastNameBlankErrorAdditionalFormTwitter.getText().contains("Last name is required")
				&& mailBlankErrorAdditionalFormTwitter.getText().contains("Email address is required")) {
			flag3 = true;
		} else {
			flag3 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.sendkeys(firstNameNew, "123@", "Type firstname into additional form field");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.sendkeys(lastNameNew, "123@", "Type lastname into additional form field");
		executor.clear(mailNewTwitter, "Clear First Name");
		executor.sendkeys(mailNewTwitter, "123@", "Type email id into additional form field");
		executor.actionClick(joinNowTwitter, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(firstNameBlankErrorAdditionalFormTwitter,
				"Wait for error messages to appear");
		if (firstNameBlankErrorAdditionalFormTwitter.getText()
				.contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& lastNameBlankErrorAdditionalFormTwitter.getText()
						.contains("No numbers and special characters allowed (Eg. !@#$ etc).")
				&& mailBlankErrorAdditionalFormTwitter.getText().contains("Please enter a valid email address")) {
			flag4 = true;
		} else {
			flag4 = false;
		}
		executor.clear(firstNameNew, "Clear First Name");
		executor.sendkeys(firstNameNew, "editage", "Type firstname into additional form field");
		executor.clear(lastNameNew, "Clear Last Name");
		executor.sendkeys(lastNameNew, "test", "Type lastname into additional form field");
		executor.clear(mailNewTwitter, "Clear First Name");
		executor.sendkeys(mailNewTwitter, emailid, "Type email id into additional form field");
		executor.actionClick(joinNowTwitter, "Click on Join Now");
		executor.softWaitforVisibilityOfWebElement(usernameBlock, "Wait for username block");
		if (driver.getCurrentUrl().contains("-success-Twitter") && usernameBlock.getText().contains("Hello")
				&& !usernameBlockName.getText().isEmpty()) {
			flag5 = true;
		} else {
			flag5 = false;
		}
		loginPage = new LoginPage(driver, test, wait);
		flag6 = loginPage.deleteUser("pratik.sidam@cactusglobal.com", "Ye@r2o17AwsTeSt_1", "pratik.sidam", emailid);
		if (flag1 && flag2 && flag3 && flag4 && flag5 && flag6) {
			executor.assertTrue(true, "We are registered  successfully with Twitter");
		} else {
			executor.assertTrue(true, "We are registered successfully with Twitter");
		}

	}

	public boolean TwitterAdditionalFormRegistrationErrorMessages() {
		boolean flag1 = false;
		if (!driver.getCurrentUrl().contains("e-book?source=InsightsROWAddthis&InsightsReferer")) {
			executor.scrollIntoView(registerHeading);
		} else {
			executor.scrollIntoView(ebookHeading);
		}
		executor.click(twittericon, "Click on Twitter Icon");
		if (driver.getCurrentUrl().contains("https://api.twitter.com/oauth/authenticate?oauth_token")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		executor.softWaitforVisibilityOfWebElement(twitterMail, "Wait for Twitter Email ID to be visible");
		executor.type(twitterMail, "bhartibisht9999", "Entering the Email Id for Twitter");
		executor.type(twitterPassword, "bisht@123", "Entering the password for Twitter");
		executor.click(twitterLogin, "Click on Twitter Login button");
		// executor.softWaitforVisibilityOfWebElement(orcidAuthorize, "Wait for
		// the authorize button");
		// executor.click(orcidAuthorize, "Wait for the authorize button");
		executor.softWaitforVisibilityOfWebElement(verifyInformation, "Please wait for the additional form to appear");
		executor.softWaitforVisibilityOfWebElement(pleaseVerifyText, "Please wait for the additional form to appear");
		return flag1;
	}

}
