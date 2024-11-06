package com.crm.baseTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.crm.generic.databaseUtility.DatabaseUtility;
import com.crm.generic.fileUtility.ExcelUtility;
import com.crm.generic.fileUtility.FileUtility;
import com.crm.generic.webdriverUtility.JavaUtility;
import com.crm.generic.webdriverUtility.UtilityClassObject;
import com.crm.generic.webdriverUtility.WebDriverUtility;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

/**
 * @author Rajani
 */
public class BaseClass {

	// Object initialization
	public FileUtility f = new FileUtility();
	public ExcelUtility e = new ExcelUtility();
	public WebDriverUtility w = new WebDriverUtility();
	public JavaUtility j = new JavaUtility();
	public DatabaseUtility d = new DatabaseUtility();
	public SoftAssert softAssert=new SoftAssert();

	public  WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBeforeSuite() {
		d.getDBConnection();
		System.out.println("---Connected to Database---");

	}
	
	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAfterSuite() throws Throwable {
		d.closeDBConnection();
		System.out.println("---Closed Database Connection---");
		
	}
	
  //cross-browser testing before-class
	@Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBeforeClass(@Optional("Chrome") String BROWSER) throws Throwable {
		driver = w.launchBrowser(BROWSER);
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		System.out.println("---" + BROWSER + " Browser Launched---");
	}
/*	
	//cross-browser testing after-class
	@Parameters("BROWSER")
	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAfterClass(String BROWSER) {
		driver.quit();
		System.out.println("---" + BROWSER + " Browser Closed---");

	}
*/	
/*	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBeforeClass() throws Throwable {
		String BROWSER = f.getDataFromPropertyFile("browser");
		driver = w.launchBrowser(BROWSER);
		System.out.println("---Browser Launched---");
	}
*/	
	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAfterClass() {
		driver.quit();
		System.out.println("---Browser Closed---");

	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBeforeMethod() throws Throwable {
		String URL = f.getDataFromPropertyFile("url");
		String USERNAME = f.getDataFromPropertyFile("username");
		String PASSWORD = f.getDataFromPropertyFile("password");
		LoginPage l = new LoginPage(driver);
		l.loginToApp(URL, USERNAME, PASSWORD);
		System.out.println("---Logged-in to App---");

	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAfterMethod() {
		HomePage hp = new HomePage(driver);
		hp.logoutFromApp();
		System.out.println("---Logged-out from App---");

	}

}
