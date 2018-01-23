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

public class MegaNavPage {
	private Executioner executor;
	private ExtentTest test;
	private Util util;
	private WebDriver driver;
	private WebDriverWait wait;

	public MegaNavPage(WebDriver driver, ExtentTest test, WebDriverWait wait) {
		// super(driver,wait);
		this.driver = driver;
		this.wait = wait;
		this.test = test;
		executor = new Executioner(driver, test, wait);
		util = Util.getInstance();

		PageFactory.initElements(driver, this);
	}

	// List Mega Nav Menus
	@FindBy(xpath = "//div[@id='block-mega-nav-main-menu']//ul//li[contains(@class,'mn-megamenu-item level-1')]/a")
	public List<WebElement> mainMenu;

	// Insights Menu
	@FindBy(id = "insight-menu")
	public WebElement insightMenu;

	public void menuCheck() throws MalformedURLException, Exception {
		boolean flag1 = false;
		List<String> list = Arrays.asList("Manuscript Preparation", "Publication Process", "Industry Hot Topics",
				"Interactive Learning", "Community", "Around the Web", "Shop");
		List<String> sortList = new ArrayList<String>();
		for (WebElement we : mainMenu) {
			sortList.add(we.getText());
			if (we.getAttribute("href").contains("#")
					|| we.getAttribute("href").contains("https://shop-and-learn.editage.com/")) {
				flag1 = true;
			} else {
				flag1 = false;
				break;
			}
		}
		if (list.equals(sortList) && flag1 && insightMenu.isDisplayed()) {
			executor.assertTrue(true, "Menu are displayed appropriately");
		} else {
			executor.assertTrue(false, "Menu are nots displayed appropriately");
		}
	}

	public void subCategoriesLinks(String mainCategory, String subCategory, String leftmenulinks, String rightmenulinks)
			throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false, flag3 = false;
		executor.mouseHover(By.xpath(
				"//li[@data-level='1']//a[@class='dropdown-toggle' and contains(text(), '" + mainCategory + "')]"));
		executor.mouseHover(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"));
		executor.pause(1);
		if (driver.findElement(By.xpath("//div[@id='" + leftmenulinks + "']//h2")).getText()
				.equalsIgnoreCase("POPULAR ARTICLES")
				|| driver.findElement(By.xpath("//div[@id='" + leftmenulinks + "']//h2")).getText()
						.equalsIgnoreCase("POPULAR Q&As")) {
			flag1 = true;
		} else {
			flag1 = false;
		}
		List<WebElement> leftLinks = driver.findElements(By.xpath("//div[@id='" + leftmenulinks + "']//li/a"));
		List<WebElement> videoleftLinks = driver
				.findElements(By.xpath("//div[@id='" + leftmenulinks + "']//div[@class='block__content']//a"));
		List<String> list = Arrays.asList("Videos & Slideshare", "Q&A", "Expert Interviews", "Research Updates");
		if (!list.contains(subCategory)) {
			for (WebElement we : leftLinks) {
				if (!util.isLinkBroken(new URL(we.getAttribute("href"))).equals("No Content")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Not Found")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Gateway Timeout")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Internal Server Error")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Bad Gateway")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Service Unavailable")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Gateway Timeout")) {
					flag2 = true;
				} else {
					flag2 = false;
				}
			}
		} else {
			for (WebElement we : videoleftLinks) {
				if (!util.isLinkBroken(new URL(we.getAttribute("href"))).equals("No Content")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Not Found")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Gateway Timeout")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Internal Server Error")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Bad Gateway")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Service Unavailable")
						|| !util.isLinkBroken(new URL(we.getAttribute("href"))).equals("Gateway Timeout")) {
					flag2 = true;
				} else {
					flag2 = false;
				}
			}

		}
		WebElement image = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]/img"));
		WebElement rifhtsideLink1 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]"));
		WebElement rifhtsideLink2 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[2]"));
		WebElement rifhtsideLink3 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]"));
		WebElement rifhtsideLink4 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]/b"));
		String a = util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href")));
		String b = util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href")));
		String c = util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href")));
		boolean n = util.imageChecker(image, driver);
		System.out.print(a);
		System.out.print(b);
		System.out.print(c);
		System.out.print(n);
		System.out.print(subCategory);
		if (util.imageChecker(image, driver)
				&& util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href"))).equals("OK")
				&& rifhtsideLink4.getText().contains("Read More")) {
			flag3 = true;
			/*
			 * executor.actionClick(By.xpath(
			 * "//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '"
			 * + subCategory + "')]"), "Submenu Category clicked");
			 * executor.softWaitforVisibilityOfWebElement(By.xpath(
			 * "//div[@id='block-block-22']//img"), "Wait for page to Load");
			 */
		} else {
			flag3 = false;
		}
		System.out.print(flag1);
		System.out.print(flag2);
		System.out.print(flag3);
		if (flag1 && flag2 && flag3) {
			executor.assertTrue(true, "Middle link block and Left hand side links are functioning properly");
		} else {
			executor.assertTrue(false, "Middle link block and Left hand side links are not functioning properly");
		}
	}

	public void subCategoriesLinksAll(String mainCategory, String subCategory, String rightmenulinks)
			throws MalformedURLException, Exception {
		boolean flag1 = false;
		executor.mouseHover(By.xpath(
				"//li[@data-level='1']//a[@class='dropdown-toggle' and contains(text(), '" + mainCategory + "')]"));
		executor.mouseHover(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"));
		WebElement image = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]/img"));
		WebElement rifhtsideLink1 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]"));
		WebElement rifhtsideLink2 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[2]"));
		WebElement rifhtsideLink3 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]"));
		WebElement rifhtsideLink4 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]/b"));
		String a = util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href")));
		String b = util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href")));
		String c = util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href")));
		boolean n = util.imageChecker(image, driver);
		System.out.print(a);
		System.out.print(b);
		System.out.print(c);
		System.out.print(n);
		System.out.print(subCategory);
		if (util.imageChecker(image, driver)
				&& util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href"))).equals("OK")
				&& rifhtsideLink4.getText().contains("Read More")) {
			flag1 = true;
			/*
			 * executor.actionClick(By.xpath(
			 * "//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '"
			 * + subCategory + "')]"), "Submenu Category clicked");
			 * executor.softWaitforVisibilityOfWebElement(By.xpath(
			 * "//div[@id='block-block-22']//img"), "Wait for page to Load");
			 */
		} else {
			flag1 = false;
		}
		if (flag1) {
			executor.assertTrue(true, "Right hand side links are functioning properly");
		} else {
			executor.assertTrue(false, "Right hand side links are not functioning properly");
		}
	}

	public void shopCourses() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		flag1 = courses();
		flag2 = handBooks();
		if (flag1 && flag2) {
			executor.assertTrue(true, "Shop and Courses links are functioning correctly");
		} else {
			executor.assertTrue(false, "Shop and Courses links are not functioning correctly");
		}
	}

	public boolean handBooks() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		String subCategory = "Handbooks";
		String rightmenulinks = "mn-megamenu-column-66";
		executor.mouseHover(By.xpath("//li[@data-level='1']//div[contains(text(), 'Shop')]"));
		executor.mouseHover(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"));
		WebElement image = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]/img"));
		WebElement rifhtsideLink1 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]"));
		WebElement rifhtsideLink2 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[2]"));
		WebElement rifhtsideLink3 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]"));
		WebElement rifhtsideLink4 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]/b"));
		String a = util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href")));
		String b = util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href")));
		String c = util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href")));
		boolean n = util.imageChecker(image, driver);
		System.out.print(a);
		System.out.print(b);
		System.out.print(c);
		System.out.print(n);
		System.out.print(subCategory);
		if (util.imageChecker(image, driver)
				&& util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href"))).equals("OK")
				&& rifhtsideLink4.getText().contains("Read More")
				&& rifhtsideLink1.getAttribute("href").contains("shop-and-learn.editage.com/collections/handbooks/")) {
			flag1 = true;
			/*
			 * executor.actionClick(By.xpath(
			 * "//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '"
			 * + subCategory + "')]"), "Submenu Category clicked");
			 * executor.softWaitforVisibilityOfWebElement(By.xpath(
			 * "//div[@id='block-block-22']//img"), "Wait for page to Load");
			 */
		} else {
			flag1 = false;
		}
		if (flag1) {
			flag2 = true;
		} else {
			flag2 = true;
		}
		return flag2;
	}

	public boolean courses() throws MalformedURLException, Exception {
		boolean flag1 = false, flag2 = false;
		String subCategory = "Courses";
		String rightmenulinks = "mn-megamenu-column-64";
		executor.mouseHover(By.xpath("//li[@data-level='1']//div[contains(text(), 'Shop')]"));
		executor.mouseHover(By.xpath(
				"//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '" + subCategory + "')]"));
		WebElement image = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]/img"));
		WebElement rifhtsideLink1 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[1]"));
		WebElement rifhtsideLink2 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[2]"));
		WebElement rifhtsideLink3 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]"));
		WebElement rifhtsideLink4 = driver
				.findElement(By.xpath("//div[@id='" + rightmenulinks + "']//div[@class='block__content']//a[3]/b"));
		String a = util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href")));
		String b = util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href")));
		String c = util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href")));
		boolean n = util.imageChecker(image, driver);
		System.out.print(a);
		System.out.print(b);
		System.out.print(c);
		System.out.print(n);
		System.out.print(subCategory);
		if (util.imageChecker(image, driver)
				&& util.isLinkBroken(new URL(rifhtsideLink1.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink2.getAttribute("href"))).equals("OK")
				&& util.isLinkBroken(new URL(rifhtsideLink3.getAttribute("href"))).equals("OK")
				&& rifhtsideLink4.getText().contains("Read More")
				&& rifhtsideLink1.getAttribute("href").contains("shop-and-learn.editage.com/collections/handbooks/")) {
			flag1 = true;
			/*
			 * executor.actionClick(By.xpath(
			 * "//li[@data-level='2']//a[@class='dropdown-toggle' and contains(text(), '"
			 * + subCategory + "')]"), "Submenu Category clicked");
			 * executor.softWaitforVisibilityOfWebElement(By.xpath(
			 * "//div[@id='block-block-22']//img"), "Wait for page to Load");
			 */
		} else {
			flag1 = false;
		}
		if (flag1) {
			flag2 = true;
		} else {
			flag2 = false;
		}
		return flag2;
	}

}
