package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement createContactImg;
	

	@FindBy(id="bas_searchfield")
	private WebElement OrgDropDown;
	
	
	public WebElement getOrgDropDown() {
		return OrgDropDown;
	}

	@FindBy(xpath = "//img[@title=\"Create Contact...\"]")
	private WebElement createContactimg3;
	
	
	public WebElement getCreateContactimg3() {
		return createContactimg3;
	}


	public WebElement getCreateContactImg() {
		return createContactImg;
	}
	
	
}
