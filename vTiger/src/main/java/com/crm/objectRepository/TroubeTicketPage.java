package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubeTicketPage {
	
	public TroubeTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Ticket...']")
	private WebElement createTicketImg;

	public WebElement getCreateTicketImg() {
		return createTicketImg;
	}
	
	
}
