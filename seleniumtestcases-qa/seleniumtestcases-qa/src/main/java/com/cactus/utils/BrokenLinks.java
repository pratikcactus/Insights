/**
 * 
 */
package com.cactus.utils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author swapnil.raut
 *
 */
public class BrokenLinks {
	Executioner executor;
	WebDriver driver;
	private ExtentTest test;
	
	public BrokenLinks(WebDriver driver, WebDriverWait wait,ExtentTest test) {
		this.driver = driver;
		this.executor = new Executioner(driver, test);
		this.test=test;
	}

	public List<WebElement> findAllLinks(WebDriver driver) {
		List<WebElement> elementList = new ArrayList<WebElement>();
		elementList = driver.findElements(By.tagName("a"));
		elementList.addAll(driver.findElements(By.tagName("img")));
		List<WebElement> finalList = new ArrayList<WebElement>();
		for (WebElement element : elementList) {
			if (element.getAttribute("href") != null) {
				finalList.add(element);
			}
		}
		return finalList;
	}

	public String isLinkBroken(URL url) throws Exception {
		int responseCode = 0;
		String responseMessage = "";
		try {
			APIUtil apiUtil = new APIUtil();

			HttpResponse response = apiUtil.callURL(url.toString());
			responseCode = response.getStatusLine().getStatusCode();

			responseMessage = response.getStatusLine().getReasonPhrase();

			if (responseCode == 200 && responseMessage.equalsIgnoreCase("OK")) {
				return "UnBroken";
			} else {
				return "Broken" + " " + responseCode + " " + responseMessage;
			}
		} catch (Exception exp) {
			return "Broken" + " " + responseCode + " " + responseMessage;
		}
	}

	public void verifyLinks(List<WebElement> elementList) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		for (WebElement element : elementList) {

			String href = element.getAttribute("href");
			// String style = element.getAttribute("style");

			try {
				if (href.equalsIgnoreCase("")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL is Blank");
					js.executeScript("arguments[0].style='style'", element);
				} else{
					String link=element.getAttribute("href");
					if(isLinkBroken(new URL(link)).equalsIgnoreCase("UnBroken")){
						executor.reportsLog("URL: " + link, LogStatus.PASS, "");
					}else{
						js.executeScript("arguments[0].style.border='5px solid red'", element);
						executor.addStatus(LogStatus.FAIL, "URL: " + link);
						js.executeScript("arguments[0].style='style'", element);
					}
					
				}
				
		
				/*if (href.equalsIgnoreCase("")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL is Blank");
					js.executeScript("arguments[0].style='style'", element);
				} else if (!(isLinkBroken(new URL(element.getAttribute("href")))).equalsIgnoreCase("UnBroken")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL: " + element.getAttribute("href"));
					js.executeScript("arguments[0].style='style'", element);
				} else {
					executor.addStatus(LogStatus.PASS, "URL: " + element.getAttribute("href"));
				}*/
			} catch (Exception exp) {
				js.executeScript("arguments[0].style.border='3px solid red'", element);
				executor.addStatus(LogStatus.FAIL, "URL: " + element.getAttribute("href"));
				js.executeScript("arguments[0].style='style'", element);
			}
		}
	}
	
	public void verifyLink(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;

			String href = element.getAttribute("href");
			// String style = element.getAttribute("style");

			try {
				if (href.equalsIgnoreCase("")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL is Blank");
					js.executeScript("arguments[0].style='style'", element);
				} else{
					String link=element.getAttribute("href");
					if(isLinkBroken(new URL(link)).equalsIgnoreCase("UnBroken")){
						executor.addStatus(LogStatus.PASS, "URL: " + link);
					}else{
						js.executeScript("arguments[0].style.border='5px solid red'", element);
						executor.addStatus(LogStatus.FAIL, "URL: " + link);
						js.executeScript("arguments[0].style='style'", element);
					}
					
				}
				
		
				/*if (href.equalsIgnoreCase("")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL is Blank");
					js.executeScript("arguments[0].style='style'", element);
				} else if (!(isLinkBroken(new URL(element.getAttribute("href")))).equalsIgnoreCase("UnBroken")) {
					js.executeScript("arguments[0].style.border='5px solid red'", element);
					executor.addStatus(LogStatus.FAIL, "URL: " + element.getAttribute("href"));
					js.executeScript("arguments[0].style='style'", element);
				} else {
					executor.addStatus(LogStatus.PASS, "URL: " + element.getAttribute("href"));
				}*/
			} catch (Exception exp) {
				js.executeScript("arguments[0].style.border='3px solid red'", element);
				executor.addStatus(LogStatus.FAIL, "URL: " + element.getAttribute("href"));
				js.executeScript("arguments[0].style='style'", element);
			}
		}

	
}
