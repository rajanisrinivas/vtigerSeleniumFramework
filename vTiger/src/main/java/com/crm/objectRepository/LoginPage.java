package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver=null;
	
	//initialization
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this); // this - LoginPage
	}
	
	@FindBy(name="user_name")
	private WebElement userTxtFld; 
	
	@FindBy(name="user_password")
	private WebElement passwordTxtFld; 
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	public WebElement getUserTxtFld() {
		return userTxtFld;
	}

	public WebElement getPasswordTxtFld() {
		return passwordTxtFld;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	} 
	
	public void loginToApp(String URL, String username,String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(URL);
		userTxtFld.sendKeys(username);
		passwordTxtFld.sendKeys(password);
		loginBtn.click();
	}

}
