package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchOrgWindow {
	
	public SearchOrgWindow(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchTxtFld;
	
	@FindBy(name = "search")
	private WebElement searchBtn;

	public WebElement getSearchTxtFld() {
		return searchTxtFld;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void searchOrganization(String orgName) {
		searchTxtFld.sendKeys(orgName);
		searchBtn.click();
	}
}
