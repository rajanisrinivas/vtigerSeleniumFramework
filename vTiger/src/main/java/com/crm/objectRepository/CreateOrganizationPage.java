package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {


	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameTxtFld;

	@FindBy(id = "phone")
	private WebElement orgPhoneTxtFld;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getOrgNameTxtFld() {
		return orgNameTxtFld;
	}

	public WebElement getOrgPhoneTxtFld() {
		return orgPhoneTxtFld;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createOrg(String orgName) {
		orgNameTxtFld.sendKeys(orgName);
		saveBtn.click();
	}

	public void createOrg(String orgName, String phoneNo) {
		orgNameTxtFld.sendKeys(orgName);
		orgPhoneTxtFld.sendKeys(phoneNo);
		saveBtn.click();
	}

	public void createOrg(String orgName, String industry, String type) {
		orgNameTxtFld.sendKeys(orgName);
		industryDropDown.sendKeys(industry);
		typeDropDown.sendKeys(type);
		saveBtn.click();
	}

}
