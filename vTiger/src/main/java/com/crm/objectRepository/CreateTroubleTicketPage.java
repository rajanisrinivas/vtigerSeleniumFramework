package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateTroubleTicketPage {

	WebDriver driver=null;
	
	public CreateTroubleTicketPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "ticket_title")
	private WebElement ticketTitleTxtFld;
	
	@FindBy(name = "ticketpriorities")
	private WebElement ticketPriorityDropDown;
	
	@FindBy(name = "ticketseverities")
	private WebElement ticketSeverityDropDown;
	
	@FindBy(xpath  = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//input[@value=\"T\"]")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement groupDropDown;

	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img")
	private WebElement selectProductImg;
	
	public WebElement getTicketTitleTxtFld() {
		return ticketTitleTxtFld;
	}

	public WebElement getTicketPriorityDropDown() {
		return ticketPriorityDropDown;
	}

	public WebElement getTicketSeverityDropDown() {
		return ticketSeverityDropDown;
	}
	
	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getGroupDropDown() {
		return groupDropDown;
	}
	
	public WebElement getSelectProductImg() {
		return selectProductImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createTroubleTicketWithPriorityAndSeverity(String title, String priority, String severity) {
		ticketTitleTxtFld.sendKeys(title);
		WebDriverUtility w=new WebDriverUtility();
		w.select(ticketPriorityDropDown, priority);
		w.select(ticketSeverityDropDown, severity);
		saveBtn.click();
	}
	
	public void createTroubleTicketWithAssignedTo(String title, String assignedTo) {
		
		WebDriverUtility w=new WebDriverUtility();
		ticketTitleTxtFld.sendKeys(title);
		groupRadioBtn.click();
		w.select(groupDropDown, assignedTo);
		saveBtn.click();
	}
	
public void createTroubleTicketWithProduct(String title, String product) throws Throwable {
		
		WebDriverUtility w=new WebDriverUtility();
		ticketTitleTxtFld.sendKeys(title);

		selectProductImg.click();

		Thread.sleep(4000);
		// switch to product window
		w.switchToWindowOnURL(driver, "module=Products");

		SearchProductWindow spw = new SearchProductWindow(driver);
		spw.searchProduct(product);
		driver.findElement(By.xpath("//a[text()='" + product + "']")).click();

		// switch to helpdesk window
		w.switchToWindowOnURL(driver, "module=HelpDesk");

		saveBtn.click();	}
	
	
}
