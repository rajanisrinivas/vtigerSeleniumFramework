package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductWindow {
	
	public SearchProductWindow(WebDriver driver) {
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
	
	public void searchProduct(String prodName) {
		searchTxtFld.sendKeys(prodName);
		searchBtn.click();
	}
}
