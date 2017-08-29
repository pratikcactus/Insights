package com.cactus.insights.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.inits.Config;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class ResetPasswordPage {//extends AbstractPage 
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;

	@FindBy(xpath = "//a[@class='welcomeClientClass']")
	WebElement WelcomeUserNameMenu;
	@FindBy(xpath = ".//*[@id='password-strength']")
	WebElement NewPassword;
	@FindBy(xpath = ".//*[@id='password-match']")
	WebElement ReTypeNewPassword;
	@FindBy(xpath = ".//*[@id='btnResetpass']")
	WebElement SaveNewPasswordButton;
	
	
	By loadingSavePasswordButton=By.xpath(".//*[@id='btnResetpass' and @class='reset-btn loading-btn']");
	
	@FindBy(xpath = ".//*[@id='pass-info']")
	WebElement passwordInfo;

	By loader=By.xpath(".//*[@id='status' and @style='display: block;']");

	public ResetPasswordPage(WebDriver driver, ExtentTest test,WebDriverWait wait) {
		
		this.driver = driver;
		this.wait=wait;
		this.test = test;
		executor = new Executioner(driver, test,wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(WelcomeUserNameMenu, "Wait until WelcomeUserNameMenu element is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getLoader()),
				"Invisibility of spinner");
		/*if (!Config.SERVICE_PAGE_TITLE.toLowerCase().equals(driver.getTitle().trim().toLowerCase())) {
			throw new IllegalStateException("This is not  the Check Services Page");
		}
		*/
		if (!driver.getTitle().trim().toLowerCase().contains(Config.SERVICE_PAGE_TITLE.toLowerCase())) {
			throw new IllegalStateException("This is not  the  Reset Password Page");
		}
	}
	
	public By getLoader() {
		return loader;
	}

	public CompleteYourProfilePage resetPassword(String newPassword){
		executor.type(NewPassword, newPassword, "Enter New Password:"+newPassword);
		executor.type(ReTypeNewPassword, newPassword, "REtype New Password:"+newPassword);
		executor.softWaitforVisibilityOfWebElement(passwordInfo, "Wait for Password Message:"+passwordInfo.getText());
		executor.click(SaveNewPasswordButton, "Click on Save Password");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(loadingSavePasswordButton), "Invisibilty of loader on button");
		return new CompleteYourProfilePage(driver, test, wait);
	}

}
