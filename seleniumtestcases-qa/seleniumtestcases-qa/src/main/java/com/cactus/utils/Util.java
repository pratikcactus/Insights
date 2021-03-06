package com.cactus.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cactus.inits.Config;

public class Util {
	private static Util instance;

	private Util() {
	}

	public static Util getInstance() {
		if (instance == null) {
			instance = new Util();
		}
		return instance;
	}

	public synchronized String takeScreenshot(WebDriver driver, String pageName) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			Calendar calendar = Calendar.getInstance();
			String ssFolderPath = "/" + calendar.get(Calendar.YEAR) + "/"
					+ (calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())) + "/"
					+ calendar.get(Calendar.DATE) + "/";
			String fileName = getRootPath() + "/screenshots/screenshot" + ssFolderPath + System.currentTimeMillis()
					+ pageName + ".png";

			File file = new File(fileName);

			FileUtils.copyFile(srcFile, file);

			String fileAbsolutePath = file.getAbsolutePath();
			
			if (fileAbsolutePath.contains("jenkins")) {
				return getJenkinsScreenShotPath(fileAbsolutePath);
			}

			return fileAbsolutePath;
		} catch (Exception e) {
			// Reporter.log("Exception in taking screenshot");
		}
		return null;
	}
	

	public synchronized String takeScreenshot(WebDriver driver) {
		try {
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			Calendar calendar = Calendar.getInstance();
			String ssFolderPath = "/" + calendar.get(Calendar.YEAR) + "/"
					+ (calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault())) + "/"
					+ calendar.get(Calendar.DATE) + "/";
			String fileName = getRootPath() + "/screenshots/screenshot" + ssFolderPath + System.currentTimeMillis()
					+ ".png";

			File file = new File(fileName);

			FileUtils.copyFile(srcFile, file);

			String fileAbsolutePath = file.getAbsolutePath();
			
			if (fileAbsolutePath.contains("jenkins")) {
				return getJenkinsScreenShotPath(fileAbsolutePath);
			}
			
			return fileAbsolutePath;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String getJenkinsScreenShotPath(String completePath) {
		String ip = "http://" + Config.ip + ":8080/job/";
		String workspace = getJenkinsWorkSpaceName(completePath);
		String path=completePath.split("screenshots")[1];
		return ip + workspace + "/ws/screenshots/" +path;
	}

	public String getFileName(String completePath) {
		return completePath.substring(completePath.lastIndexOf(File.separator) + 1, completePath.length());
	}

	public String getJenkinsWorkSpaceName(String completePath) {
		int len = "workspace".length();
		String strPath = completePath.substring(completePath.lastIndexOf("workspace") + len + 1, completePath.length());

		return strPath.substring(0, strPath.indexOf(File.separator));

	}

	public String getResourcePath() {
		return "/src/main/resources/";
	}

	public String getFilePath(String fileName) {
		String rootPath = getRootPath();
		String fileDir = rootPath + getResourcePath() + fileName;

		return fileDir;

	}

	public String getOS() {
		return System.getProperty("os.name");
	}

	public String getRootPath() {
		return System.getProperty("user.dir");
	}

	public String getNewEmailId() {
		return "test" + RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@mailinator.com";
	}

	public long getCurrentTimeStamp() {
		return System.currentTimeMillis();

	}

	public String getNewEmailIdWithTimeStamp() {
		return "test" + getCurrentTimeStamp() + "@mailinator.com";
	}

	public String getRandomStringValueUpto5Chars() {
		return RandomStringUtils.randomAlphabetic(5).toUpperCase();
	}

	public String getResourceName(String value) {
		String[] str = value.split("/");
		return str[0].toString();
	}

	public String getResourceId(String value) {
		String[] str = value.split("/");
		return str[1].toString();
	}

	public String getMachineIp() {
		InetAddress IP = null;
		try {
			IP = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		String ip = IP.getHostAddress();
		System.out.println("IP of my system is := " + ip);
		return ip;
	}

	public String getFileAbolutePath(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file.getAbsolutePath();
	}

	public Map<String, String> getValuesFromConfigInMap(String fileName) {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Properties prop = new Properties();
		Map<String, String> map = new HashMap<String, String>();
		try {
			prop.load(fileInput);
			map.putAll(prop.entrySet().stream()
					.collect(Collectors.toMap(e -> e.getKey().toString(), e -> e.getValue().toString())));

		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;
	}
	
	public String getTestURL(Map<String, String> config) {
		String env = config.get("ENVIRONMENT");
		String market = config.get("Market");
		String URL="";
		if(env.equalsIgnoreCase("Staging") && market.equalsIgnoreCase("ROW")){
			URL = "https://" + "editageStaging" + ":" + "Editage@!nsights" + "@" + "ei.editage.com/insights/";
		}else if(env.equalsIgnoreCase("Staging") && market.equalsIgnoreCase("CN")){
			URL = "http://ei.editage.cn/insights";
		}else if(env.equalsIgnoreCase("Staging") && market.equalsIgnoreCase("JP")){
			URL = "http://ei.editage.jp/insights";
		}else if(env.equalsIgnoreCase("Staging") && market.equalsIgnoreCase("KR")){
			URL = "http://ei.editage.co.kr/insights";
		}else if(env.equalsIgnoreCase("Live") && market.equalsIgnoreCase("ROW")){
			URL = "https://www.editage.com/insights";
		}else if(env.equalsIgnoreCase("Live") && market.equalsIgnoreCase("CN")){
			URL = "http://www.editage.cn/insights";
		}else if(env.equalsIgnoreCase("Live") && market.equalsIgnoreCase("JP")){
			URL = "http://www.editage.jp/insights";
		}else if(env.equalsIgnoreCase("Live") && market.equalsIgnoreCase("KR")){
			URL = "http://www.editage.co.kr/insights";
		}
		return URL;
	}
	
	public String isLinkBroken(URL url) throws Exception {
		String response = "";
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			response = connection.getResponseMessage();
			connection.disconnect();
			return response;
		} catch (Exception exp) {
			return exp.getMessage();
		}

	}
	
	public boolean imageChecker(WebElement image, WebDriver driver){
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", image);
		 return ImagePresent;
	
	}
	
	public boolean imagesListChecks(List<WebElement> images, WebDriver driver){
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", images);
		 return ImagePresent;
	
	}


}
