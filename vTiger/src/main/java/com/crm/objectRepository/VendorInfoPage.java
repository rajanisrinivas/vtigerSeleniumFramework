package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfoPage {
	
	public VendorInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Vendor Name")
	private WebElement vendorName;
	
	public WebElement getVendorName() {
		return vendorName;
	}
}
