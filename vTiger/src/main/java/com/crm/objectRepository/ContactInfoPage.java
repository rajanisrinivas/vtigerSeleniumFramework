package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {

	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement contactHeader;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement lastname;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']/a")
	private WebElement orgName;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement supportStartDate;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement supportEndDate;
	

	public WebElement getContactHeader() {
		return contactHeader;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
	}
		
	
}
