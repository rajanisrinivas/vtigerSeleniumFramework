package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateContactPage {

	WebDriver driver=null;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastnameTxtFld;

	@FindBy(xpath = "//input[@name=\"account_name\"]/following-sibling::img")
	private WebElement selectOrgImg;

	@FindBy(name = "support_start_date")
	private WebElement supportStartDateFld;
	
	@FindBy(name = "support_end_date")
	private WebElement supportEndDateFld;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getLastnameTxtFld() {
		return lastnameTxtFld;
	}

	public WebElement getSelectOrgImg() {
		return selectOrgImg;
	}

	public WebElement getSupportStartDateFld() {
		return supportStartDateFld;
	}

	public WebElement getSupportEndDateFld() {
		return supportEndDateFld;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void createContact(String lastName) {
		lastnameTxtFld.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactWithOrg(String lastName, String orgName) throws Throwable {
		lastnameTxtFld.sendKeys(lastName);
		selectOrgImg.click();

		Thread.sleep(3000);
		// switch to child window
		WebDriverUtility w=new WebDriverUtility();
		w.switchToWindowOnURL(driver, "module=Accounts");

		SearchOrgWindow sow = new SearchOrgWindow(driver);
		sow.searchOrganization(orgName);
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		w.switchToWindowOnURL(driver, "module=Contacts");

		saveBtn.click();

	}
	
	public void createContactWithSupportDate(String lastName,String startDate,String endDate) {
		lastnameTxtFld.sendKeys(lastName);
		supportStartDateFld.clear();
		supportStartDateFld.sendKeys(startDate);
		supportEndDateFld.clear();
		supportEndDateFld.sendKeys(endDate);
		saveBtn.click();

	}
}
