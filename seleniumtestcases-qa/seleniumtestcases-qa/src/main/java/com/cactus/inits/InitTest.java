package com.cactus.inits;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.cactus.executor.Executioner;
import com.cactus.reporter.ExtentReporter;
import com.cactus.utils.DatabaseUtil;
import com.cactus.utils.Util;
import com.relevantcodes.extentreports.ExtentTest;

public class InitTest {
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected static ExtentReporter eReporter;
	protected static Util util;
	protected static DatabaseUtil dbUtil;

	protected ExtentTest test;
	protected ExtentTest testClass;

	protected Executioner executor;

	protected String typeOfTest;
	protected static Map<String, String> configMap;
	protected String testURL = "";
	
	private boolean hipChatNotificationFlag=true;

	@BeforeSuite
	public void preConfigue() {
		util = Util.getInstance();
		Config.ip = util.getMachineIp();

		eReporter = ExtentReporter.getInstance();

		configMap = util.getValuesFromConfigInMap("config.properties");
		dbUtil = DatabaseUtil.getInstance();

	}

	@BeforeClass
	public void beforeClass() {
		testClass = eReporter.startTest(getClass().getSimpleName());
	}

	@Parameters({ "host", "port", "browser", "browserVersion", "useProxy", "testType", "market", "os" })
	@BeforeMethod
	public void setUp(@Optional("localhost") String host, @Optional("4444") String port,
			@Optional("test") String browser, @Optional("40.0") String browserVersion,
			@Optional("false") String useProxy, @Optional("CRM") String testType, @Optional("ENG") String market,
			@Optional("WINDOWS") String os, @Optional Method method)
			throws IOException {

		test = eReporter.startTest(method.getName());
		testClass.appendChild(test);
		eReporter.setTest(test);

		if (browser.equalsIgnoreCase("test")) {
			browser = configMap.get("Browser");
		}

		executor = new Executioner();
		
		if (browser.equalsIgnoreCase("ie")) {
			executor.setIEBrowserFlag(true);
		}
		System.out.println(executor.getIEBrowserFlag());
		this.driver = new WebDriverInstance().setDriver(browser, host, port, useProxy, os.toUpperCase());

		wait = new WebDriverWait(driver, 60);
		executor = new Executioner(driver, test, wait);
		if (browser.equalsIgnoreCase("ie")) {
			executor.setIEBrowserFlag(true);
		}
		System.out.println(executor.getIEBrowserFlag());

		setHipChatNotificationsFlag(true);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) {
		ITestResult result = Reporter.getCurrentTestResult();
		executor.testStatus(result.getStatus());

		executor.closeBrowser();
		eReporter.endTest(test);
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		eReporter.endTest(testClass);
	}

	@AfterSuite(alwaysRun = true)
	public void postConfigure() {
		eReporter.endReporter();
	}
	
	public static Map<String, String> getConfigMap() {
		return configMap;
	}
	
	public boolean getHipChatNotificationsFlag(){
		return hipChatNotificationFlag;
	}
	
	public void setHipChatNotificationsFlag(boolean flag){
		hipChatNotificationFlag=flag;
	}
}
