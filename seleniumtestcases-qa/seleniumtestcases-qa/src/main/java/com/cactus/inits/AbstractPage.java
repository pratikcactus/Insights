package com.cactus.inits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cactus.executor.Executioner;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AbstractPage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	private Executioner executor;
	
	@FindBy(xpath = ".//*[contains(@class,'jobs-header-status')]")
	WebElement status;
	
	By editageloader=By.xpath(".//*[@id='status' and @style='display: block;']");
	
	By crmLoader=By.xpath(".//*[@id='preloader' and @style='display: block;']");
	By noCRMLoader=By.xpath(".//*[@id='preloader' and @style='display: none;']");
	By error404=By.xpath("//title[.='404 Not Found']");
	By phpDebugger=By.xpath(".//*[@class='phpdebugbar-close-btn']");
	By modalHeader=By.xpath(".//*[@class='modal-header']");
	By loader = By.xpath("//*[@class='result-loader-inner']");
	
	public AbstractPage(WebDriver driver,WebDriverWait wait,ExtentTest test) {
		this.driver = driver;
		this.wait=wait;
		this.executor = new Executioner(driver, test, wait);
		if(executor.isElementPresent(error404)){
			executor.addStatus(LogStatus.ERROR, "This is not  the Base Page error 404 exists");
			throw new IllegalStateException("This is not  the Base Page error 404 exists");
		}
		PageFactory.initElements(driver, this);
	}
	
	public By getEditageLoader() {
		return editageloader;
	}
	
	public By getCrmloader() {
		return crmLoader;
	}
	
	public By getError404() {
		return error404;
	}
	
	public By getPhpDebugger() {
		return phpDebugger;
	}
	
	public By getModalHeader() {
		return modalHeader;
	}
	
	public By getLoader() {
		return loader;
	}

	public WebElement getStatus() {
		return status;
	}
	
	public By getNoCRMLoader() {
		return noCRMLoader;
	}
}
