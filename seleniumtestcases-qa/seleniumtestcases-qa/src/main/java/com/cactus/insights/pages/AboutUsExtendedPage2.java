/**
 * 
 */
package com.cactus.insights.pages;

import java.util.List;

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
public class AboutUsExtendedPage2 {
	private WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private AboutUsPage aboutUsPage;
	
	
	@FindBy(css = ".panels-ajax-tab li.list-6 a")
	WebElement becomeAnAmbassador_lnk;
	
	@FindBy(xpath = "//h2[text()='Become an Ambassador']")
	WebElement becomeAmbassadorHeading;

	@FindBy(css = "p.cag-text-a")
	List<WebElement> publicationPracticesTexts;

	@FindBy(xpath="//div[@class='cag-text-b']")
	WebElement middlePageText;

	@FindBy(xpath="//h4[@class='cag-heading-h4']//span")
	List<WebElement> pageListElements;

	@FindBy(xpath="//h3")
	List<WebElement> middlepageHeadings;

	@FindBy(xpath="//div[@class='cag-text-d']")
	WebElement bottomPageText;

	@FindBy(xpath="//ol[@class='cag-text-list']//li")
	List<WebElement> botttomListTexts;
	
	@FindBy(css = ".panels-ajax-tab li.list-7 a")
	WebElement ourStory_lnk;
	
	@FindBy(css="#panels-ajax-tab-container-aboutus h2")
	WebElement ourStoryHeading;
	
	@FindBy(css=".os-text-a")
	List<WebElement> ourStoryParagraph1;
	
	@FindBy(css=".os-text-list li")
	List<WebElement> challengesPrespectiveRecommendations;
	
	@FindBy(css=".os-box-lft")
	WebElement athorsWereSeeking;
	
	@FindBy(css=".os-box-rgt")
	WebElement authorsEducatedAbout;
	
	@FindBy(xpath = "//h2[@class='heading-h2']")
	public WebElement contactUsHeading;


	@FindBy(xpath = "//h3[text()='Drop us a line!']")
	public WebElement contactMiddlePageText;


	@FindBy(xpath = "//form[@id='webform-client-form-1132']//label")
	public List<WebElement> contactListElements;

	@FindBy(xpath="//form[@id='webform-client-form-1132']//input[@type='checkbox']")
	public List<WebElement> contactCheckBoxes;


	@FindBy(xpath="//form[@id='webform-client-form-1132']//textarea")
	public WebElement contactTexArea;
	
	@FindBy(css= "#edit-submitted-first-name")
	WebElement firstNameTxtBox;
	
	@FindBy(css="#edit-submitted-last-name")
	WebElement lastNameTxtBox;
	
	@FindBy(css="#edit-mollom-captcha")
	WebElement captchaTextBox ;
	

	@FindBy(css="img[alt='Type the characters you see in this picture.']")
	public WebElement captchaImage;

	@FindBy(xpath="//input[@class='webform-submit button-primary form-submit']")
	public WebElement submitButton;
	
	@FindBy(css = ".panels-ajax-tab li a[href='/insights/about-us/contact-us']")
	WebElement contactUs_lnk;
	
	@FindBy(css="div.messages--error")
	WebElement errorMessage;
	
	@FindBy(css="div.messages--error li")
	List<WebElement> errorMessageList;
	

	public AboutUsExtendedPage2(WebDriver driver, ExtentTest test,WebDriverWait wait){
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
		
	}
	
	public void verifybecomeAnAmbassador(){
		clickOnBecomeAnAmbassador();
		verifyAmbassadorPage();
		}
	public void verifyOurStory(){
		clickOnOurStory();
		verifyOurStoryPage();
		}
	
	public void verifyContactUs(){
		clickOnContactUs();
		verifyContactUsPage();
		}


	private void clickOnBecomeAnAmbassador() {
		executor.softWaitforVisibilityOfWebElement(becomeAnAmbassador_lnk,"Wait for element becomeAnAmbassador_lnk");
		executor.actionClick(becomeAnAmbassador_lnk, "click becomeAnAmbassador_lnk");
		executor.softWaitforVisibilityOfWebElement(becomeAmbassadorHeading, "wait for assertion of this page");
		executor.assertTrue(becomeAmbassadorHeading.getText().contains("Become an Ambassador"), "assertion for 'Become an Ambassador' page'");
	}

	private void verifyAmbassadorPage() {
		executor.softWaitforVisibilityOfWebElement(becomeAmbassadorHeading, "wait for becomeAmbassadorHeading");
		executor.verifyTrue(becomeAmbassadorHeading.isDisplayed(), "verify becomeAmbassadorHeading"+becomeAmbassadorHeading.getText());
		
		for(WebElement publicationPracticesText: publicationPracticesTexts){
		executor.softWaitforVisibilityOfWebElement(publicationPracticesText, "wait for publicationPracticesText");
		executor.verifyTrue(publicationPracticesText.isDisplayed(), "verify publicationPracticesText"+publicationPracticesText.getText());
		}
		executor.softWaitforVisibilityOfWebElement(middlePageText, "wait for ");
		executor.verifyTrue(middlePageText.isDisplayed(), "verify middlePageText"+middlePageText.getText());
		
		for(WebElement pageListElement: pageListElements){
			executor.softWaitforVisibilityOfWebElement(pageListElement, "wait for pageListElement");
			executor.verifyTrue(pageListElement.isDisplayed(), "verify pageListElement"+pageListElement.getText());
			}
		for(WebElement middlepageHeading: middlepageHeadings){
			executor.softWaitforVisibilityOfWebElement(middlepageHeading, "wait for middlepageHeading");
			executor.verifyTrue(middlepageHeading.isDisplayed(), "verify middlepageHeading"+middlepageHeading.getText());
			}
		executor.softWaitforVisibilityOfWebElement(bottomPageText, "wait for bottomPageText");
		executor.verifyTrue(bottomPageText.isDisplayed(), "verify bottomPageText"+bottomPageText.getText());
		
		for(WebElement botttomListText : botttomListTexts){
		executor.softWaitforVisibilityOfWebElement(botttomListText, "wait for bottomPageText");
		executor.verifyTrue(botttomListText.isDisplayed(), "verify botttomListText"+botttomListText.getText());
		}
		
	}

	private void clickOnOurStory() {
		executor.softWaitforVisibilityOfWebElement(ourStory_lnk,"Wait for element ourStory_lnk");
		executor.actionClick(ourStory_lnk, "click ourStory_lnk");
		executor.softWaitforVisibilityOfWebElement(ourStoryHeading, "wait for assertion of this page");
		executor.assertTrue(ourStoryHeading.getText().contains("Our Story"), "assertion for 'Our Story' page");
	}
	
	private void verifyOurStoryPage() {
	
		executor.softWaitforVisibilityOfWebElement(ourStoryHeading, "wait for ourStoryHeading");
		executor.verifyTrue(ourStoryHeading.isDisplayed(), "verify ourStoryHeading"+ourStoryHeading.getText());
		
		for(WebElement ourStoryPragraph : ourStoryParagraph1){
			executor.softWaitforVisibilityOfWebElement(ourStoryPragraph, "wait for ourStoryPragraph");
			executor.verifyTrue(ourStoryPragraph.isDisplayed(), "verify ourStoryPragraph"+ourStoryPragraph.getText());
		}
		
		for(WebElement challengePrespectiveRecommendation : challengesPrespectiveRecommendations){
			executor.softWaitforVisibilityOfWebElement(challengePrespectiveRecommendation, "wait for challengePrespectiveRecommendation");
			executor.verifyTrue(challengePrespectiveRecommendation.isDisplayed(), "verify ourStoryPragraph"+challengePrespectiveRecommendation.getText());
		}
	
		executor.softWaitforVisibilityOfWebElement(athorsWereSeeking, "wait for athorsWereSeeking");
		executor.verifyTrue(athorsWereSeeking.isDisplayed(), "verify athorsWereSeeking"+athorsWereSeeking.getText());
		
		executor.softWaitforVisibilityOfWebElement(authorsEducatedAbout, "wait for authorsEducatedAbout");
		executor.verifyTrue(authorsEducatedAbout.isDisplayed(), "verify authorsEducatedAbout"+authorsEducatedAbout.getText());
	}
	

	private void clickOnContactUs() {
		try {
			executor.scrollToElement(contactUs_lnk);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.softWaitforVisibilityOfWebElement(contactUs_lnk,"Wait for element contactUs_lnk");
		executor.clickJS(contactUs_lnk, "click contactUs_lnk");
		executor.softWaitforVisibilityOfWebElement(contactUsHeading, "wait for assertion of this page");
		executor.assertTrue(contactUsHeading.getText().contains("Contact Us"), "assertion for 'Contact Us' page");
	}

	private void verifyContactUsPage() {

		executor.softWaitforVisibilityOfWebElement(contactUsHeading, "wait for contactUsHeading");
		executor.verifyTrue(contactUsHeading.isDisplayed(), "verify "+contactUsHeading.getText());
		
		executor.softWaitforVisibilityOfWebElement(contactMiddlePageText, "wait for contactMiddlePageText;");
		executor.verifyTrue(contactMiddlePageText.isDisplayed(), "verify "+contactMiddlePageText.getText());
		
		for (WebElement contactListElement : contactListElements){
		executor.softWaitforVisibilityOfWebElement(contactListElement, "wait for contactListElement");
		executor.verifyTrue(contactListElement.isDisplayed(), "verify "+contactListElement.getText());
		}
		for(WebElement contactCheckBox : contactCheckBoxes){
		executor.softWaitforVisibilityOfWebElement(contactCheckBox, "wait for contactCheckBox");
		executor.verifyTrue(contactCheckBox.isDisplayed(), "verify "+contactCheckBox.getAttribute("value"));
		}

		executor.softWaitforVisibilityOfWebElement(firstNameTxtBox, "wait for firstNameTxtBox");
		executor.verifyTrue(firstNameTxtBox.isDisplayed(), "verify firstNameTxtBox"+firstNameTxtBox.getAttribute("name"));

		executor.softWaitforVisibilityOfWebElement(lastNameTxtBox, "wait for lastNameTxtBox");
		executor.verifyTrue(lastNameTxtBox.isDisplayed(), "verify lastNameTxtBox"+lastNameTxtBox.getAttribute("name"));

		executor.softWaitforVisibilityOfWebElement(captchaTextBox, "wait for captchaTextBox");
		executor.verifyTrue(captchaTextBox.isDisplayed(), "verify captchaTextBox"+captchaTextBox.getAttribute("name"));
		
		executor.softWaitforVisibilityOfWebElement(captchaImage, "wait for captchaImage");
		executor.verifyTrue(captchaImage.isDisplayed(), "verify captchaImage");
		
		executor.softWaitforVisibilityOfWebElement(submitButton, "wait for submitButton;");
		executor.verifyTrue(submitButton.isDisplayed(), "verify submitButton;");
		executor.scrollIntoView(submitButton);
		executor.clickJS(submitButton, "click on submit botton");
		
		executor.softWaitforVisibilityOfWebElement(errorMessage,"Wait for error message to be visible");
		
		for(WebElement errorMsg:errorMessageList){
			executor.softWaitforVisibilityOfWebElement(errorMsg, "wait for errorMsg");
			executor.verifyTrue(errorMsg.isDisplayed(), "verify errormessage from list"+errorMsg.getText());
			}
		
	}
}
