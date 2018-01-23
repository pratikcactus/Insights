package com.cactus.insights.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

public class FooterPage {
	private final WebDriver driver;
	private WebDriverWait wait;
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private LoginPage loginPage;

	
	public FooterPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver, wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();
		PageFactory.initElements(driver, this);
	}

	// Facebook
	@FindBy(xpath = "//a[@class='fb']")
	public WebElement fbicon;

	// Twitter
	@FindBy(xpath = "//a[@class='tw']")
	public WebElement twittericon;

	// GooglePlus
	@FindBy(xpath = "//a[@class='gg']")
	public WebElement ggicon;

	// Youtube
	@FindBy(xpath = "//a[@class='yt']")
	public WebElement yticon;

	// Footer Headings
		@FindBy(xpath = "//div[@id='mini-panel-footer_top']//h2")
		public List<WebElement> footerheadings;
	
	public boolean footerLinks() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2=false;
		String message = "OK";
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@id='mini-panel-footer_top']//a"));

		for (WebElement element : elementList) {
			// String newmessage = isLinkBroken(new
			// URL(element.getAttribute("href")));
			if (!util.isLinkBroken(new URL(element.getAttribute("href"))).equalsIgnoreCase("Not Found") && !util.isLinkBroken(new URL(element.getAttribute("href"))).equalsIgnoreCase("Internal Server Error")) {
				flag1 = true;
			} else {
				flag1=false;
				break;
			}

		}
		if (flag1) {
			flag2=true;
		} else {
			flag2=false;
		}
		return flag2;

	}
	
	public void footerLinksCheck() throws MalformedURLException, Exception{
		boolean flag1=false;
		flag1=footerLinks();
		if(flag1){
			executor.assertTrue(true, "Footer Links are opening successfully");
		}else{
			executor.assertTrue(false, "Footer Links are broken");
		}
	}
	

	public boolean aboutUs() throws MalformedURLException, Exception {
		boolean flag1 = false,flag2=false;
		String message = "";
		List<WebElement> elementList = driver.findElements(By.xpath("//div[@id='mini-panel-footer_top']//a"));

		for (WebElement element : elementList) {
			// String newmessage = isLinkBroken(new
			// URL(element.getAttribute("href")));
			if (element.getAttribute("href").contains("/insights/about-us")) {
				flag1 = true;
				message = util.isLinkBroken(new URL(element.getAttribute("href")));
				break;
			} else {
				flag1 = false;
			}

		}
		if (flag1 && message.equals("OK")) {
			flag2=true;
		} else {
			flag2=false;
		}
		return flag2;

	}
	
	public void aboutUsLink() throws MalformedURLException, Exception{
		boolean flag1=false;
		flag1=aboutUs();
		if(flag1){
			executor.assertTrue(true, "About Us link present and is opening successfully");
		}else{
			executor.assertTrue(false, "About Us link is not present and is broken ");
		}
	}
	
	public boolean socialMediaCheck() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2=false, flag3=false, flag4=false, flag5=false;
		String message ="OK";
			if (fbicon.getAttribute("href").contains("facebook") && util.isLinkBroken(new URL(fbicon.getAttribute("href"))).equals(message)) {
				flag1 = true;
			} else {
				flag1=false;;
			}
			if (twittericon.getAttribute("href").contains("twitter") && util.isLinkBroken(new URL(twittericon.getAttribute("href"))).equals(message)) {
				flag2 = true;
			} else {
				flag2=false;;
			}
			if (ggicon.getAttribute("href").contains("plus.google.com") && util.isLinkBroken(new URL(ggicon.getAttribute("href"))).equals(message)) {
				flag3 = true;
			} else {
				flag3=false;;
			}
			if (yticon.getAttribute("href").contains("youtube") && util.isLinkBroken(new URL(yticon.getAttribute("href"))).equals(message)) {
				flag4 = true;
			} else {
				flag4=false;;
			}

		if (flag1 && flag2 && flag3 && flag4) {
			flag5=true;
		} else {
			flag5=false;
		}
		return flag5;
	}
	
	public void socialMediaIcons() throws MalformedURLException, Exception{
		boolean flag1=false;
		flag1=socialMediaCheck();
		if(flag1){
			executor.assertTrue(true, "Social Media links are present and are opening successfully");
		}else{
			executor.assertTrue(false, "Social Media links are not present and are broken ");
		}
	}
	
	public boolean footerHeadingCheck(){
		boolean flag1=false;
		List<String> list = Arrays.asList("Editage Insights", "Publication Support Services", "About Us", "Quality", "English Editing Services",
				"Our Expertise", "Subscribe", "Connect with US", "Editage Insights Global");
		List<String> sortList = new ArrayList<String>();
		for (WebElement we : footerheadings) {
			sortList.add(we.getText());
		}
		if (list.equals(sortList)) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		return flag1;
	}

}