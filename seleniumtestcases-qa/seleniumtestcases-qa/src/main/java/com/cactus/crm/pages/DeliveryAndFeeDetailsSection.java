package com.cactus.crm.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class DeliveryAndFeeDetailsSection extends AddEnquiryPage {
	WebElement enquiry_type;
	WebElement job_unit_count;
	WebElement recommend_tat;
	WebElement plan_priority;
	WebElement billing_unit_count;
	WebElement rate;
	WebElement recalculate;
	WebElement delivery_date_time;
	@FindBy(xpath = "//div[@class='flt-block']//button[@id='close-tat']")
	WebElement tatCloseButton;

	@FindBy(xpath = "//div[@class='flt-block']//button[@id='select-tat']")
	WebElement tatSelectButton;

	@FindBy(xpath = ".//input[@id='delivery_date_time']")
	WebElement deliveryDateTime;

	@FindBy(xpath = ".//*[@id='pat']")
	WebElement priceAfterTax;

	@FindBy(xpath = "//*[@id='block-delivery-box']//div[contains(@class,'dg-datetimepicker-icon')]")
	WebElement dateButtonDelivery;

	@FindBys(value = {
			@FindBy(xpath = "//*[@id='block-delivery-box']//div[contains(@class,'two-month-datepicker')]//table[@class='table-condensed']//tbody//tr//td[@class='day rightDate']") })
	List<WebElement> listDatesDelivery;

	WebElement pricing_type_per_unit;
	WebElement pricing_type_flat;

	By byProceedDateButton = By.xpath("//*[normalize-space(.)='Proceed']");
	By byActive=By.xpath("//*[contains(@class='active')]");

	public DeliveryAndFeeDetailsSection(WebDriver driver, WebDriverWait wait, ExtentTest test) {
		super(driver, wait, test);
		PageFactory.initElements(driver, this);
		executor.softWaitforVisibilityOfWebElement(enquiry_type, "Wait until enquiry_type is displayed");
		executor.softWaitforCondition(ExpectedConditions.invisibilityOfElementLocated(getEditageLoader()),
				"Invisibility of spinner");
	}

	public void enterDeliveryAndFeeDetails(Map<String, String> testData) {
		selectJobDeliveredBy(testData.get("JobToBeDeliveredBy"));
		executor.selectFromDropDown(enquiry_type, "visibleText", testData.get("EnquiryType"));
		String enquiryType = testData.get("EnquiryType");

		executor.type(job_unit_count, testData.get("JobUnitCount"), "Enter Job Count");

		executor.click(recommend_tat, "Click on Recommend Button");
		executor.softWaitforVisibilityOfWebElement(tatCloseButton, "Wait for Close button");
		executor.softWaitforElementToBeClickable(tatCloseButton, "Waitf or Close Button");
		executor.actionClick(tatCloseButton, "tatCloseButton");

		executor.softWaitforInvisibilityOFWebElement(tatCloseButton, "Wait for invisibility of Close Button");
		enterDeliveryDateTime(dateButtonDelivery, listDatesDelivery);
		executor.sendkeys(plan_priority, testData.get("PlanNativeName"), "Enter Plan");

		selectPricingType(testData.get("PricingType"));

		executor.sendkeys(billing_unit_count, testData.get("BillingUnitCount"), "Entered Billing Unit Count : ");
		if (enquiryType.equalsIgnoreCase("Quality re-edit") || enquiryType.equalsIgnoreCase("Valid MRE")
				|| enquiryType.equalsIgnoreCase("Sample")) {
			if (!testData.get("Rate").equals("0")) {
				testData.put("Rate", "0");
			}
		}
		executor.sendkeys(rate, testData.get("Rate"), "Enter Rate");
		executor.sendkeys(rate, Keys.TAB, "SendKeys Tab");
		executor.sendkeys(recalculate, Keys.ENTER, "SendKeys Enter");
		executor.softWaitforElementToBeClickable(recalculate, "Wait for CalculateButton to be clickable");
		/*executor.moveToElement(recalculate);
		executor.scrollDown();
		executor.pause(1);*/
		executor.actionClick(recalculate, "Click on CalculateButton");

		executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");

		testData.put("deliveryDateTime", deliveryDateTime.getAttribute("value"));
		executor.softWaitforInvisibilityOFWebElement(getCrmloader(), "Invisibility of CRM Loader");
		executor.softWaitforCondition(ExpectedConditions.attributeToBeNotEmpty(priceAfterTax, "innerHTML"), "priceAfterTax is not empty");
		testData.put("finalPrice", priceAfterTax.getText());
	}

	public void selectJobDeliveredBy(String value) {
		By byXpath = By.xpath("//div[@id='block-delivery-box']//label[contains(.,'" + value + "')]");
		executor.click(driver.findElement(byXpath), "Click on :" + value);
	}

	public void enterDeliveryDateTime(WebElement dateButton, List<WebElement> liDates) {
		String actualDateValue = delivery_date_time.getAttribute("value");
		String expDateValue = "30/10/2017 00:00";
		executor.softWaitforElementToBeClickable(delivery_date_time, "Wait for delivery_date_time");
		executor.sendkeys(delivery_date_time, expDateValue, "Data send" + expDateValue);

		actualDateValue = delivery_date_time.getAttribute("value");

		if (actualDateValue.equalsIgnoreCase("")) {
			executor.softWaitforElementToBeClickable(dateButton, "wait for Date");
			executor.actionClick(dateButton, "DateButton");
			executor.softWaitforVisibilityOfWebElement(byProceedDateButton, "Click on Proceed Date Button");
			executor.mouseHover(dateButton);
			int elNo = liDates.size() - 1;
			executor.softWaitforElementToBeClickable(liDates.get(elNo), "wait for particular Date");
			WebElement el = liDates.get(elNo);
			executor.moveToElement(el);
			executor.click(el, "Select Date");
			executor.softWaitforCondition(ExpectedConditions.stalenessOf(el), "element is selected");
			executor.softWaitforVisibilityOfWebElement(byActive, "Wait for byActive element");

			if (executor.isElementPresent(byProceedDateButton)) {
				executor.softWaitforElementToBeClickable(byProceedDateButton,
						"Element to be clickable byProceedDateButton");
				executor.actionClick(byProceedDateButton, "Click on Proceed Date Button");
			}

		}

	}

	public void selectPricingType(String value) {
		if (value.toLowerCase().contains("flat")) {
			executor.actionClick(pricing_type_flat, "pricingTypeFlat");
		} else
			executor.actionClick(pricing_type_per_unit, "pricingTypePerUnit");
	}

}
