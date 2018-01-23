/**
 * 
 */
package com.cactus.insights.actions;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.cactus.insights.pages.AboutUsPage;
import com.cactus.insights.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * @author swapnil.raut
 *
 */
public class AboutUsActions {
	private WebDriver driver;
	private WebDriverWait wait;
	private ExtentTest test;
	private Executioner executor;
	private LoginPage loginPage;
	private AboutUsPage aboutUsPage; 
	
	public AboutUsActions(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		PageFactory.initElements(driver, this);
	}
	
	public void AboutUs() throws MalformedURLException, Exception{
		loginPage = new LoginPage(driver, test, wait);
		loginPage.bannerWait();
		aboutUsPage = new AboutUsPage(driver, test, wait);
		aboutUsPage.clickAboutUsLink();
	}

}

