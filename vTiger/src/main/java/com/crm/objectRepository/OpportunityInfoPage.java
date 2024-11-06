package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	
	public OpportunityInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "dtlview_Opportunity Name")
	private WebElement oppName;
	
	@FindBy(xpath = "//a[@title='Organizations']")
	private WebElement orgName;
	
	@FindBy(id = "dtlview_Type")
	private WebElement oppType;

	public WebElement getOppName() {
		return oppName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getOppType() {
		return oppType;
	}
	
		
}
