package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunityLink;
	
	@FindBy(linkText = "Products")
	private WebElement productLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketLink;
	
	@FindBy(xpath = "//a[contains(text(),'More')]")
	private WebElement moreLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement vendorLink;
	
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminImg;

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutLnk;

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOpportunityLink() {
		return opportunityLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getTroubleTicketLink() {
		return troubleTicketLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getVendorLink() {
		return vendorLink;
	}

	public void logoutFromApp() {
		Actions act = new Actions(driver);
		act.moveToElement(adminImg).perform();
		WebDriverUtility w=new WebDriverUtility();
		w.waitForElementToBeClickable(driver, signOutLnk);
		act.moveToElement(signOutLnk).click().perform();
	}
	
	public void moveToMoreAndClickOn(WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		act.moveToElement(element).click().perform();
	}

}
