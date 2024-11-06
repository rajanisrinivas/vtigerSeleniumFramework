package com.crm.generic.webdriverUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.sourceforge.tess4j.Tesseract;

public class WebDriverUtility {

	// Implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	// explicit wait
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// explicit wait
		public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

	// launch browser
	public WebDriver launchBrowser(String browser) {
		WebDriver driver = null;

		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
		} 
		return driver;
	}

	// switch window based by URL
	public void switchToWindowOnURL(WebDriver driver, String partialUrl) {
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> iterate1 = allWin1.iterator();
		while (iterate1.hasNext()) {
			String win = iterate1.next();
			driver.switchTo().window(win);

			String winUrl = driver.getCurrentUrl();
			if (winUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	// switch window based by title
	public void switchToWindowOnTitle(WebDriver driver, String partialTitle) {
		Set<String> allWin1 = driver.getWindowHandles();
		Iterator<String> iterate1 = allWin1.iterator();
		while (iterate1.hasNext()) {
			String win = iterate1.next();
			driver.switchTo().window(win);

			String winUrl = driver.getTitle();
			if (winUrl.contains(partialTitle)) {
				break;
			}
		}
	}

	// switch to frame by index
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// switch to frame by name
	public void switchToFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	// switch to frame by WebElement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// switch to alert and accept
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// switch to alert and dismiss
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// send value to alert
	public void EnterValueToAlertAndAccept(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);// pass input
		driver.switchTo().alert().accept();
	}

	// select by visible text
	public void select(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}

	// select by value
	public void selectFromValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	// select by index
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// mouse over
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	// mouse over and click
	public void mouseOverAndClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).click().perform();
	}

	// mouse click
	public void mouseClickOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	// double click
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	// drag and drop
	public void dragAndDrop(WebDriver driver, WebElement drag, WebElement drop) {
		Actions act = new Actions(driver);
		act.clickAndHold(drag).release(drop).perform();
		// or
		// act.dragAndDrop(drag, drop).perform();
	}

	// mouse right click(context click)
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	// taking screenshot
	public void takepageScreenshot(WebDriver driver, String filePathWithName) throws Throwable {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(filePathWithName);
		FileUtils.copyFile(src, dest);
	}

	// captcha
	public String readAndEnterCaptcha(WebElement captchaImg) throws Throwable {
		TakesScreenshot cimg = (TakesScreenshot) captchaImg;
		File src = cimg.getScreenshotAs(OutputType.FILE);
		File dest = new File("./CaptchaImg.png");
		FileUtils.copyFile(src, dest);

		Tesseract tess = new Tesseract();
		tess.setDatapath("C:\\Users\\Rajani\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
		String capTxt = tess.doOCR(dest); // identifies the characters from image and converts to string
		String captchaTxt = capTxt.replace(" ", "");
		// sometimes there will be spaces in the captcha text which cannot be handled,
		// so have to remove spaces
		return captchaTxt;
	}

	// scroll to element
	public void scrollToElement(WebDriver driver, WebElement element) throws Throwable {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy("+element.getRect().getX()+","+element.getLocation().getY()+")");
		js.executeScript("arguments[0].scrollIntoView()", element);

		Thread.sleep(2000);
		element.click();
	}

	// disable notification
	public WebDriver disableNotificationForChrome() {
		ChromeOptions cOpt = new ChromeOptions();
		cOpt.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(cOpt);
		return driver;
	}

	// close browser
	public void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	// maximize browser
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// minimize browser
	public void minimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	// refresh page
	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	// forwardPage
	public void forwardPage(WebDriver driver) {
		driver.navigate().forward();
	}

	// previousPage
	public void previousPage(WebDriver driver) {
		driver.navigate().back();
	}

}
