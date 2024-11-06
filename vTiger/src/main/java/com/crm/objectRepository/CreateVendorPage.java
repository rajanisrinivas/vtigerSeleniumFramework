package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVendorPage {
	public CreateVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "vendorname")
	private WebElement vendorNameTxtFld;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getVendorNameTxtFld() {
		return vendorNameTxtFld;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createVendor(String vendorName) {
		vendorNameTxtFld.sendKeys(vendorName);
		saveBtn.click();
	}
}
