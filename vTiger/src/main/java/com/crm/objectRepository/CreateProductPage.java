package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateProductPage {
	

	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productname")
	private WebElement prodNameTxtFld;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(name = "productcategory")
	private WebElement categoryDropDown;
	
	public WebElement getProdNameTxtFld() {
		return prodNameTxtFld;
	}
	
	public WebElement getCategoryDropDown() {
		return categoryDropDown;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createProduct(String productName) {
		prodNameTxtFld.sendKeys(productName);
		saveBtn.click();
	}
	
	public void createProduct(String productName, String category) {
		prodNameTxtFld.sendKeys(productName);
		WebDriverUtility w= new WebDriverUtility();
		w.select(categoryDropDown, category);
		saveBtn.click();
	}

}
