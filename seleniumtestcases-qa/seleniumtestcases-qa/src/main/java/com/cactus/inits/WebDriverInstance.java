package com.cactus.inits;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cactus.executor.Executioner;
import com.cactus.utils.Util;

public class WebDriverInstance {
	private Executioner executor;
	private Util util;

	String PROXY = "localhost:8080";

	public WebDriverInstance() {
		util = Util.getInstance();
		executor = new Executioner();
	}

	public WebDriver setDriver(String targetBrowser, String host, String port, String useProxy, String os) {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		setSystemPath(targetBrowser, os);
		if (targetBrowser.toLowerCase().contains("chrome")) {
			capabilities = getChromeCapabilities(capabilities);
		} else if (targetBrowser.toLowerCase().contains("firefox")) {
			capabilities = getFirefoxCapabilities(capabilities);
		} else if (targetBrowser.toLowerCase().contains("htmlunit")||targetBrowser.toLowerCase().contains("headless")) {
			capabilities = getHtmlUnitCapabilities(capabilities);
		} else if (targetBrowser.toLowerCase().contains("ie")) {
			capabilities = getIECapabilities(capabilities);
		}

		if (useProxy.equalsIgnoreCase("true")) {
			setProxy(capabilities);
		}

		if (os.toLowerCase().contains("windows")) {
			capabilities.setCapability("platform", Platform.WINDOWS);
		} else if (os.toLowerCase().contains("linux")) {
			capabilities.setCapability("platform", Platform.LINUX);
		} else if (os.toLowerCase().contains("mac")) {
			capabilities.setCapability("platform", Platform.MAC);
		}

		WebDriver driver = executor.openBrowser(host, port, capabilities);
		
		System.out.println("Step : info : Driver settings done");
		return driver;
	}

	public DesiredCapabilities getChromeCapabilities(DesiredCapabilities capabilities) {
		capabilities = DesiredCapabilities.chrome();

		capabilities.setBrowserName("chrome");
		return capabilities;
	}

	public DesiredCapabilities getFirefoxCapabilities(DesiredCapabilities capabilities) {
		capabilities = DesiredCapabilities.firefox();

		capabilities.setBrowserName("firefox");
		// capabilities.setCapability("marionette", true);

		// currently for version 47.0.1 marionette =false;
		capabilities.setCapability("firefox_binary",
				util.getRootPath() + "/src/main/resources/firefox/win64/firefox-sdk/bin/firefox.exe");

		capabilities.setCapability("marionette", false);
		return capabilities;
	}

	public DesiredCapabilities getIECapabilities(DesiredCapabilities capabilities) {
		capabilities = DesiredCapabilities.internetExplorer();

		capabilities.setBrowserName("internet explorer");
		//capabilities.setCapability("requireWindowFocus", true);
		//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//capabilities.setCapability("nativeEvents", false);
		//capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("ignoreZoomSetting", true);
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		//capabilities.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, true); 
		//capabilities.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
		//capabilities.setCapability("unexpectedAlertBehaviour", "accept");
		capabilities.setCapability("ignoreProtectedModeSettings", true);
		//capabilities.setCapability("disable-popup-blocking", true);
		capabilities.setCapability("enablePersistentHover", false);
		
		return capabilities;
	}

	public DesiredCapabilities getHtmlUnitCapabilities(DesiredCapabilities capabilities) {
		capabilities = DesiredCapabilities.htmlUnit();
		capabilities.setJavascriptEnabled(true);
		//capabilities.setVersion("firefox");
		capabilities.setBrowserName("htmlunit");
		return capabilities;

	}

	protected void setProxy(DesiredCapabilities capabilities) {
		org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		proxy.setHttpProxy(PROXY).setFtpProxy(PROXY).setSslProxy(PROXY);
		capabilities.setCapability(CapabilityType.PROXY, proxy);

	}

	public void setSystemPath(String browser, String os) {
		String rootPath = util.getRootPath() + util.getResourcePath();
		String extension = "";

		if (os.equalsIgnoreCase("windows")) {
			extension = ".exe";
		}
	

		if (browser.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", rootPath + "geckodriver" + extension);
		} else if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", rootPath + "chromedriver" + extension);
		} else if (browser.contains("ie")) {
			System.setProperty("webdriver.ie.driver", rootPath + "iedriver" + extension);
		}

	}

}
