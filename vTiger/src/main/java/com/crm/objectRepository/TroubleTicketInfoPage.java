package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketInfoPage {
	
	public TroubleTicketInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Title")
	private WebElement ticketTitle;
	
	@FindBy(id = "dtlview_Priority")
	private WebElement ticketPriority;
	
	@FindBy(id = "dtlview_Severity")
	private WebElement ticketSeverity;

	@FindBy(id = "dtlview_Assigned To")
	private WebElement ticketAssignedTo;
	
	@FindBy(id = "dtlview_Product Name")
	private WebElement ticketProductName;
	
	public WebElement getTicketTitle() {
		return ticketTitle;
	}

	public WebElement getTicketPriority() {
		return ticketPriority;
	}

	public WebElement getTicketSeverity() {
		return ticketSeverity;
	}

	public WebElement getTicketAssignedTo() {
		return ticketAssignedTo;
	}

	public WebElement getTicketProductName() {
		return ticketProductName;
	}
	
	
}
