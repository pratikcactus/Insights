package com.cactus.executor;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.cactus.reporter.ExtentReporter;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Executioner {

	private WebDriver driver;
	private Util util;
	private WebDriverWait wait;

	private ExtentReporter reporter;
	private ExtentTest test;

	private boolean takePassScreenshotFlag = false;
	private boolean printConsoleLogFlag = true;
	private boolean testNGLogFlag = false;
	private boolean extentLogFlag = true;

	private boolean ieBrowserFlag = false;

	public Executioner(WebDriver driver, ExtentTest test) {
		util = Util.getInstance();
		reporter = ExtentReporter.getInstance();
		this.driver = driver;
		this.test = test;
	}

	public Executioner(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		util = Util.getInstance();
		reporter = ExtentReporter.getInstance();
		this.driver = driver;
		this.test = test;
		this.wait = wait;
	}
	
	public Executioner() {
		util = Util.getInstance();
		reporter = ExtentReporter.getInstance();
		test = reporter.getTest();
	}

	public void setTakePassSreenshot(boolean takePassScreenshotFlag) {
		this.takePassScreenshotFlag = takePassScreenshotFlag;
	}

	public void setConsoleLogFlag(boolean printConsoleLogFlag) {
		this.printConsoleLogFlag = printConsoleLogFlag;
	}

	public void setTestNGLogFlag(boolean testNGLogFlag) {
		this.testNGLogFlag = testNGLogFlag;
	}

	public void setExtentLogFlag(boolean extentLogFlag) {
		this.extentLogFlag = extentLogFlag;
	}

	private void addStep(String step, LogStatus status, String screenshot) {
		if (screenshot.length() > 0) {
			test.log(status, step, "<a href='" + screenshot + "' target='_blank'>screenshot</a>");
		} else {
			test.log(status, step, "");
		}
	}

	private String passScreenShot() {
		return (takePassScreenshotFlag == true) ? util.takeScreenshot(driver) : "";
	}

	private String passScreenShot(String pageName) {
		return (takePassScreenshotFlag == true) ? util.takeScreenshot(driver, pageName) : "";
	}

	private String screenShot() {
		return util.takeScreenshot(driver);
	}

	private String screenShot(String pageName) {
		return util.takeScreenshot(driver, pageName);
	}

	public void setIEBrowserFlag(boolean ieBrowserFlag) {
		this.ieBrowserFlag = ieBrowserFlag;
	}

	public boolean getIEBrowserFlag() {
		return ieBrowserFlag;
	}

	private void reportsLog(String data, LogStatus status, String screenshot) {
		if (printConsoleLogFlag == true)
			printConsoleStep(data, status);

		if (testNGLogFlag == true)
			log(data);

		if (extentLogFlag == true)
			addStep(data, status, screenshot);
	}

	public void printConsoleStep(String data, LogStatus status) {
		if (status.equals(LogStatus.FAIL)) {
			System.err.println("Step : " + status + " : " + data);
		} else {
			System.out.println("Step : " + status + " : " + data);
		}
	}

	public WebDriver openBrowser(String host, String port, DesiredCapabilities capabilities) {
		driver = null;
		String data = "Start Browser: ";
		try {
			driver = new RemoteWebDriver(new URL("http://" + host + ":" + port + "/wd/hub"), capabilities);
			reportsLog(data, LogStatus.INFO, "");

			return driver;
		} catch (MalformedURLException e) {
			data = "Unable to Open browser, Please make sure Grid hub is running on url : http://" + host + ":" + port;

			reportsLog(data, LogStatus.FAIL, screenShot());
			Assert.fail(data);

			return null;
		}

	}

	public WebDriver setDriver(String targetBrowser, String host, String port) {
		DesiredCapabilities capabilities = null;

		if (targetBrowser.contains("chrome") || targetBrowser.equalsIgnoreCase("chrome")) {
			capabilities = DesiredCapabilities.chrome();
			System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver.exe");
			capabilities.setBrowserName("chrome");

			driver = openBrowser(host, port, capabilities);
		}
		return driver;
	}

	public DesiredCapabilities getChromeCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver.exe");
		capabilities.setBrowserName("chrome");
		return capabilities;
	}

	public DesiredCapabilities getFirefoxCapabilities() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver.exe");
		capabilities.setBrowserName("firefox");
		return capabilities;

	}

	public void navigateToURL(String url) {
		String data = "Navigate to URL: " + url;
		try {
			driver.get(url);
			reportsLog(data, LogStatus.PASS, passScreenShot());
			driver.manage().window().maximize();
		} catch (Exception e) {
			data = "Unable To navigate to URL: " + url;
			reportsLog(data, LogStatus.FAIL, screenShot());
		}
	}

	public void refresh() {
		String data = "Refresh Page";
		try {
			driver.navigate().refresh();
			reportsLog(data, LogStatus.PASS, passScreenShot());
		} catch (Exception e) {
			data = "Unable To Refresh Page";
			reportsLog(data, LogStatus.WARNING, screenShot());
		}
	}

	public void advanceClick(String typeOfClick, WebElement e, String data) {
		if (ieBrowserFlag == true || typeOfClick.equalsIgnoreCase("js")) {
			clickJS(e, data);
		} else if (typeOfClick.toLowerCase().contains("action")) {
			actionClick(e, data);
		} else {
			click(e, data);
		}

	}

	public void advanceClick(String typeOfClick, By byValue, String data) {
		if (ieBrowserFlag == true || typeOfClick.equalsIgnoreCase("js")) {
			clickJS(byValue, data);
		} else if (typeOfClick.toLowerCase().contains("action")) {
			actionClick(byValue, data);
		} else {
			click(byValue, data);
		}

	}

	public void click(WebElement e, String data) {
		String pageName = getCallerName();
		try {
			if (ieBrowserFlag == true) {
				clickJS(e, data);
			} else
				e.click();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void click(By byValue, String data) {
		String pageName = getCallerName();
		try {
			WebElement e = driver.findElement(byValue);
			if (ieBrowserFlag == true) {
				clickJS(e, data);
			} else
				e.click();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void clickJS(WebElement e, String data) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", e);
		reportsLog(data, LogStatus.INFO, "");
	}

	public void clickJS(By byValue, String data) {
		WebElement e = driver.findElement(byValue);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", e);
		reportsLog(data, LogStatus.INFO, "");
	}

	public Executioner softWaitforCondition(ExpectedCondition<Boolean> condition, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(condition);
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public void softWaitCondition(ExpectedCondition<Boolean> condition, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(condition);

		} catch (Exception e) {
			reportsLog(data, LogStatus.INFO, passScreenShot());
		}

	}

	public Executioner softWaitforInvisibilityOFWebElement(By byValue, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(byValue));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public Executioner softWaitforInvisibilityOFWebElement(List<WebElement> liWEs, String data) {
		data = "Waiting for condition: " + data;
		try {

			wait.until(ExpectedConditions.invisibilityOfAllElements(liWEs));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public Executioner softWaitforInvisibilityOFWebElement(WebElement el, String data) {
		data = "Waiting for condition: " + data;
		try {
			List<WebElement> liWBs = new ArrayList<WebElement>();
			liWBs.add(el);
			wait.until(ExpectedConditions.invisibilityOfAllElements(liWBs));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public Executioner clear(WebElement e, String elementName) {
		String pageName = getCallerName();
		String data = "clear text of element: " + elementName;
		try {
			e.clear();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
		return this;
	}

	public void sendkeys(WebElement e, String text, String data) {
		String pageName = getCallerName();
		data = "Sent text: " + text + " to element : " + data;
		try {
			e.sendKeys(text);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void sendkeys(By identifier, String text, String data) {
		WebElement e = driver.findElement(identifier);
		String pageName = getCallerName();
		data = "Sent text: " + text + " to element : " + data;
		try {
			e.sendKeys(text);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void sendkeys(WebElement e, Keys keys, String data) {
		String pageName = getCallerName();
		data = "Sent Keys: " + keys + " to element : " + data;
		try {

			e.sendKeys(keys);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void sendkeys(By identifier, Keys keys, String data) {
		WebElement e = driver.findElement(identifier);
		String pageName = getCallerName();
		data = "Sent Keys: " + keys + " to element : " + data;
		try {

			e.sendKeys(keys);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void fileUploadBySendkeys(WebElement e, String filePath, String data) {
		String pageName = getCallerName();
		data = "Sent filePath to element : " + data;
		try {
			e.sendKeys(filePath);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
	}

	public void type(WebElement e, String text, String data) {
		String pageName = getCallerName();
		try {
			e.clear();
			e.sendKeys(text);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
	}

	public void type(By identifier, String text, String data) {
		String pageName = getCallerName();
		WebElement e = driver.findElement(identifier);
		try {
			e.clear();
			e.sendKeys(text);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
	}

	public boolean isElementExist(WebElement e) {
		try {
			return e.getTagName() != null;
		} catch (Exception exp) {
			return false;
		}
	}

	public boolean isElementPresent(By identifier) {
		int len = driver.findElements(identifier).size();
		if (len == 0)
			return false;
		else
			return true;

	}

	public void actionClick(WebElement e, String data) {
		try {
			if (ieBrowserFlag == true) {
				clickJS(e, data);
			} else
				new Actions(driver).moveToElement(e).click(e).build().perform();
			reportsLog(data, LogStatus.PASS, passScreenShot());
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot());
		}
	}

	public void actionDoubleClick(WebElement e, String data) {
		try {
			new Actions(driver).moveToElement(e).doubleClick(e).build().perform();
			reportsLog(data, LogStatus.PASS, passScreenShot());
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot());
		}
	}

	public void actionClickWithOutSS(WebElement e, String data) {
		try {
			new Actions(driver).moveToElement(e).click(e).build().perform();
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, "");
		}
	}

	public void actionClick(By identifier, String data) {
		String pageName = getCallerName();
		WebElement e = driver.findElement(identifier);
		try {
			if (ieBrowserFlag == true) {
				clickJS(e, data);
			} else
				new Actions(driver).moveToElement(e).click(e).build().perform();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
	}

	public void doubleClick(WebElement e, String data) {
		String pageName = getCallerName();
		try {
			new Actions(driver).moveToElement(e).doubleClick().build().perform();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exp) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}
	}

	public void closeBrowser() {
		String data = "Close browser";
		try {
			driver.close();
			reportsLog(data, LogStatus.INFO, "");
		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot());
			Assert.fail("Unable to close browser. it may have died");
		}
	}

	public void quitBrowser() {
		String data = "Quit browser";
		try {
			driver.close();
			driver.quit();
			reportsLog(data, LogStatus.INFO, "");
		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot());
			Assert.fail("Unable to close browser. it may have died");
		}
	}

	public Executioner addStatus(LogStatus status, String data) {
		String pageName = getCallerName();
		reportsLog(data, status, screenShot(pageName));
		return this;
	}

	public void waitForPageLoadJS() {
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return js.executeScript("return document.readyState").toString().equals("complete");
			}
		});
	}

	public void assertTrue(boolean flag, String data) {
		String pageName = getCallerName();
		try {
			Assert.assertTrue(flag);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			Assert.fail("expected true found :" + flag);
		}
	}

	public void assertEquals(Object actual, Object expected, String message) {
		String pageName = getCallerName();
		String data = message + " actual : " + actual + " expected :" + expected;
		try {
			Assert.assertEquals(actual, expected, message);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			Assert.fail("Assertion failed " + actual + " is not equals " + expected);
		}
	}

	public Executioner verifyTrue(boolean flag, String data) {
		String pageName = getCallerName();
		try {
			Assert.assertTrue(flag);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return this;
		} catch (AssertionError exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			return this;
		}
	}

	public Executioner verifyEquals(Object actual, Object expected, String message) {
		String pageName = getCallerName();
		String data = message + " actual : " + actual + " expected :" + expected;
		try {
			Assert.assertEquals(actual, expected, message);
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return this;
		} catch (AssertionError exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			return this;
		}
	}

	public String getTitle() {
		String pageName = getCallerName();
		String data = "Get title";
		try {
			String title = driver.getTitle();
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return title;
		} catch (Exception exception) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			Assert.fail("uanble to get page title");
			return null;
		}
	}

	public void selectFromDropDown(WebElement element, String typeOfSelection, String valueToBeSelected) {
		String pageName = getCallerName();
		String data = "Select from Drop Down:" + valueToBeSelected;

		try {
			if (typeOfSelection.toLowerCase().contains("value")) {
				new Select(element).selectByValue(valueToBeSelected);
			} else if (typeOfSelection.toLowerCase().contains("index")) {
				new Select(element).selectByIndex(Integer.parseInt(valueToBeSelected));
			} else {
				new Select(element).selectByVisibleText(valueToBeSelected);
			}

			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public boolean checkValueAndSelectDropDown(WebElement element, String typeOfSelection, String valueToBeSelected) {
		String pageName = getCallerName();
		String data = "Select from Drop Down:" + valueToBeSelected;

		List<WebElement> liWebElements = new Select(element).getOptions();

		boolean flag = false;
		for (WebElement e : liWebElements) {
			flag = e.getText().equalsIgnoreCase(valueToBeSelected);
			if (flag) {
				break;
			}
		}

		if (flag) {
			try {
				if (typeOfSelection.toLowerCase().contains("value")) {
					new Select(element).selectByValue(valueToBeSelected);
				} else if (typeOfSelection.toLowerCase().contains("index")) {
					new Select(element).selectByIndex(Integer.parseInt(valueToBeSelected));
				} else {
					new Select(element).selectByVisibleText(valueToBeSelected);
				}

				reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

			} catch (Exception e) {
				reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			}
			return true;
		} else {
			return false;
		}

	}

	public void selectFromDropDown(By identifier, String typeOfSelection, String valueToBeSelected) {
		WebElement element = driver.findElement(identifier);
		String pageName = getCallerName();
		String data = "Select from Drop Down:" + valueToBeSelected;

		try {
			if (typeOfSelection.toLowerCase().contains("value")) {
				new Select(element).selectByValue(valueToBeSelected);
			} else if (typeOfSelection.toLowerCase().contains("index")) {
				new Select(element).selectByIndex(Integer.parseInt(valueToBeSelected));
			} else {
				new Select(element).selectByVisibleText(valueToBeSelected);
			}

			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void selectFromDropDownByAttribute(WebElement element, String attribute, String valueToBeSelected) {
		String pageName = getCallerName();
		String data = "Select from Drop Down:" + valueToBeSelected;
		try {
			List<WebElement> options = new Select(element).getOptions();

			for (WebElement e : options) {
				String value = e.getAttribute(attribute);
				if (valueToBeSelected.equalsIgnoreCase(value)) {
					new Select(element).selectByVisibleText(value);
					break;
				}
			}

			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void selectFromDropDownByAttribute(By identifier, String attribute, String valueToBeSelected) {
		WebElement element = driver.findElement(identifier);
		String pageName = getCallerName();
		String data = "Select from Drop Down:" + valueToBeSelected;
		try {
			List<WebElement> options = new Select(element).getOptions();

			for (WebElement e : options) {
				String value = e.getAttribute(attribute);
				if (valueToBeSelected.equalsIgnoreCase(value)) {
					new Select(element).selectByVisibleText(value);
					break;
				}
			}

			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));

		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
		}

	}

	public void mouseHover(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void mouseHoverJS(WebElement element) {
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );" + "element.dispatchEvent(mouseEventObj);";

		// Then JavascriptExecutor class is used to execute the script to
		// trigger the dispatched event.
		((JavascriptExecutor) driver).executeScript(strJavaScript, element);

	}

	public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void moveToElement(By identifier) {
		WebElement element = driver.findElement(identifier);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public boolean isElementDisplayed(WebElement element, String data) {
		String pageName = getCallerName();
		data = "Element displayed:" + data;
		try {
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return element.isDisplayed();
		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			return false;
		}
	}

	public boolean isElementDisplayed(By identifier, String data) {
		String pageName = getCallerName();
		WebElement element = driver.findElement(identifier);
		data = "Element displayed:" + data;
		try {
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return element.isDisplayed();
		} catch (Exception e) {
			reportsLog(data, LogStatus.FAIL, screenShot(pageName));
			return false;
		}
	}

	public boolean warningIfElementDisplayed(WebElement element, String data) {
		String pageName = getCallerName();
		data = "Element displayed:" + data;
		try {
			reportsLog(data, LogStatus.PASS, passScreenShot(pageName));
			return element.isDisplayed();
		} catch (Exception e) {
			reportsLog(data, LogStatus.WARNING, screenShot(pageName));
			return false;
		}
	}

	public Executioner softWaitforVisibilityOfWebElement(WebElement el, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(ExpectedConditions.visibilityOf(el));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}
	}

	public Executioner softWaitforVisibilityOfWebElement(By identifier, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}
	}

	public Executioner softWaitforElementToBeClickable(WebElement el, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(el));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public Executioner softWaitforElementToBeClickable(By identifier, String data) {
		data = "Waiting for condition: " + data;
		try {
			wait.until(ExpectedConditions.elementToBeClickable(identifier));
			reportsLog(data, LogStatus.PASS, passScreenShot());
			return this;
		} catch (Exception e) {
			// Reporter.log("wait timeout for condition", 0, false);
			reportsLog(data, LogStatus.WARNING, screenShot());
			return this;

		}

	}

	public boolean isAlertPresent() {
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());

			if (alert == null) {
				return false;
			} else
				return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void moveToAlertAndAccept() {
		try {
			Alert alert = driver.switchTo().alert();
			String alerttext = alert.getText();
			alert.accept();
			reportsLog("alert----:" + alerttext, LogStatus.PASS, passScreenShot());

		} catch (Exception e) {
			reportsLog("alert----:", LogStatus.FAIL, screenShot());
		}
	}

	public void acceptUnhandledAlert() {
		try {
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String text = alert.getText();
			alert.accept();
			reportsLog("alert----:" + text, LogStatus.PASS, passScreenShot());

		} catch (Exception e) {
			reportsLog("alert----:", LogStatus.FAIL, screenShot());
		}
	}

	public String getCallerName() {
		String pageName = "";
		String callerClassName = Thread.currentThread().getStackTrace()[3].getClassName();
		if (callerClassName.contains("pages")) {
			String[] arrTemp = callerClassName.split(".pages.");
			pageName = arrTemp[1];
		}
		return pageName;
	}

	public String getCurrentWindowHandle() {
		return driver.getWindowHandle();
	}

	public String findAndSwitchToNewWindow(String currentWindowHandle) {
		Set<String> windows = driver.getWindowHandles();
		String windowHandle = null;
		for (String window : windows) {
			if (!window.contains(currentWindowHandle)) {
				driver.switchTo().window(window);
				return window;
			}
		}
		return windowHandle;

	}

	public void clickOnCheckBox(String identifer, String identifierValue, String value, String data) {
		By byXpath = By.xpath(".//*[@" + identifer + "='" + identifierValue
				+ "']//div[@class='checkbox']//label[contains(.,'" + value + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(byXpath));
		click(driver.findElement(byXpath), data);

	}

	public void clickOnRadioBox(String identifer, String identifierValue, String value, String data) {
		By byXpath = By.xpath(".//*[@" + identifer + "='" + identifierValue
				+ "']//div[@class='radio']//label[contains(.,'" + value + "')]");
		wait.until(ExpectedConditions.elementToBeClickable(byXpath));
		click(driver.findElement(byXpath), data);
	}

	public void clickOnRequestedElement(String identifer, String identifierValue, String value, String data) {
		By byXpath = By.xpath(".//*[contains(@" + identifer + ",'" + identifierValue + "')]//label[contains(text(),'"
				+ value + "')]/input");
		wait.until(ExpectedConditions.elementToBeClickable(byXpath));
		moveToElement(byXpath);
		click(byXpath, data);

	}

	public String getAttributeValue(By identifier, String attribute) {

		return driver.findElement(identifier).getAttribute(attribute);

	}

	public void selectInDropDown(String id, String data) {
		By byXpath = By.xpath(".//select[@id='" + id + "']");
		actionClick(driver.findElement(byXpath), data);
		By byXpathOption = By.xpath(".//select[@id='" + id + "']/option[contains(.,'" + data + "')]");
		click(driver.findElement(byXpathOption), data);

	}

	public void logCase(String msg) {
		Reporter.log("<strong> <h3 style=\"color:DarkViolet\"> " + msg + "</h3> </strong>");
	}

	public void logStep(String msg) {
		Reporter.log("<strong>" + msg + "</strong></br>");
	}

	public void log(String msg) {

		Reporter.log("<br>" + msg + "</br>");
	}

	public void logStatus(LogStatus status) {
		switch (status) {
		case PASS:
			log("<font color=#009900><b>--Passed</b></font>");
			break;
		case FAIL:
			log("<font color=#FF0000><b>--Failed</b></font>");
			break;
		case WARNING:
			log("<font color=#FFFF00><b>--Warning</b></font>");
			break;
		default:
			break;
		}
	}

	public WebElement getWebElement(By identifier) {
		return driver.findElement(identifier);

	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-500)", "");
	}

	public void scrollToHorizontal(WebElement element) {
		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = element;
		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 50;
		for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {

			// this causes a gradual drag of the scroll bar, 10 units at a
			// time
			dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
					.moveByOffset(numberOfPixelsToDragTheScrollbarDown, 0).release().perform();
		}
	}

	public void scrollToVertical(WebElement element) {
		Actions dragger = new Actions(driver);
		WebElement draggablePartOfScrollbar = element;
		// drag downwards
		int numberOfPixelsToDragTheScrollbarDown = 50;
		for (int i = 10; i < 500; i = i + numberOfPixelsToDragTheScrollbarDown) {
			try {
				// this causes a gradual drag of the scroll bar, 10 units at a
				// time
				dragger.moveToElement(draggablePartOfScrollbar).clickAndHold()
						.moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release().perform();
				// Thread.sleep(1000L);
			} catch (Exception e1) {
			}
		}
	}

	public String openSeperateBlankWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		String myHandle = "";
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.open();");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equalsIgnoreCase(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				myHandle = windowHandle;
				break;
			}
		}
		return myHandle;
	}

	public String findAndSwitchToAvailableWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			driver.switchTo().window(windowHandle);
			reportsLog("Current Window", LogStatus.INFO, screenShot());
			return windowHandle;
		}
		return "";
	}

	public void testStatus(int status) {
		if (status != 1) {
			reportsLog("Error occured", LogStatus.FAIL, screenShot());
		}

	}

	public void setAttributeValueJS(WebElement el, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", el);

	}

	public void setAttributeValueJS(By byValue, String value) {
		WebElement el = driver.findElement(byValue);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + value + "')", el);

	}

	public void pause(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException interruptedException) {
		}
	}

	public boolean isWebElementVisible(WebElement w) {
		Dimension weD = w.getSize();
		Point weP = w.getLocation();
		Dimension d = driver.manage().window().getSize();

		int x = d.getWidth();
		int y = d.getHeight();
		int x2 = weD.getWidth() + weP.getX();
		int y2 = weD.getHeight() + weP.getY();

		return x2 <= x && y2 <= y;
	}
	
	public String getText(By by){
		return driver.findElement(by).getText();	
	}

}
