package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(name="search_text")
	private WebElement Searchtxt;
	
	@FindAll({@FindBy(name="search_field"),@FindBy(id="bas_searchfield")})
	private WebElement LeadDropdown;
	
	@FindBy(name="submit")
	private WebElement Searchbtn;
	
	@FindBy(partialLinkText = "Advanced")
	private WebElement AdvancedSearch;
	
	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement CreateLead;

	public WebElement getSearchtxt() {
		return Searchtxt;
	}

	public WebElement getLeadDropdown() {
		return LeadDropdown;
	}

	public WebElement getSearchbtn() {
		return Searchbtn;
	}

	public WebElement getAdvancedSearch() {
		return AdvancedSearch;
	}

	public WebElement getCreateLead() {
		return CreateLead;
	}

	
	public void createLeads() {
		CreateLead.click();
	}
	
	public void searchOrg(String OrgName) {
		Searchtxt.sendKeys(OrgName);
	}
	
	
	public void searchButton() {
		Searchbtn.click();
	}
}
