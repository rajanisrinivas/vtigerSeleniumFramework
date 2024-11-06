package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {


	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement orgHeader;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgName;
	
	@FindBy(id = "dtlview_Phone")
	private WebElement orgPhone;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement orgIndustry;
	
	@FindBy(id = "dtlview_Type")
	private WebElement orgTypeTxt;
	
	public WebElement getOrgIndustry() {
		return orgIndustry;
	}

	public WebElement getOrgType() {
		return orgTypeTxt;
	}
	
	public WebElement getOrgHeaderInfo() {
		return orgHeader;
	}
	
	public WebElement getOrgName() {
		return orgName;
	}
	
	public WebElement getOrgPhone() {
		return orgPhone;
	}
}
