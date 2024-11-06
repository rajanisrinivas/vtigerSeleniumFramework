package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {


	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Product Name")
	private WebElement prodName;
		
	@FindBy(id = "dtlview_Product Category")
	private WebElement prodCategory;
	
	public WebElement getProdName() {
		return prodName;
	}
	
	public WebElement getProdCategory() {
		return prodCategory;
	}
	
}
