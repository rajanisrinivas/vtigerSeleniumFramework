package com.crm.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.webdriverUtility.WebDriverUtility;

public class CreateOpportunityPage {
	
	WebDriver driver=null;
	
	public CreateOpportunityPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "potentialname")
	private WebElement oppNameTxtFld;

	@FindBy(xpath = "//input[@id='related_to_display']/following-sibling::img")
	private WebElement selectOrgImg;
	
	@FindBy(name = "opportunity_type")
	private WebElement oppTypeDropDown;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement saveBtn;

	public WebElement getOppNameTxtFld() {
		return oppNameTxtFld;
	}

	public WebElement getSelectOrgImg() {
		return selectOrgImg;
	}
	
	public WebElement getOppTypeDropDown() {
		return oppTypeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createOpportunityWithOrg(String oppName, String orgName) throws Throwable {
		oppNameTxtFld.sendKeys(oppName);
		selectOrgImg.click();

		Thread.sleep(3000);
		// switch to child window
		WebDriverUtility w=new WebDriverUtility();
		w.switchToWindowOnURL(driver, "module=Accounts");

		SearchOrgWindow sow = new SearchOrgWindow(driver);
		sow.searchOrganization(orgName);
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		w.switchToWindowOnURL(driver, "module=Potentials");

		saveBtn.click();
	}
	
	public void createOpportunityWithType(String oppName, String orgName, String type) throws Throwable {
		oppNameTxtFld.sendKeys(oppName);
		selectOrgImg.click();

		Thread.sleep(3000);
		// switch to child window
		WebDriverUtility w=new WebDriverUtility();
		w.switchToWindowOnURL(driver, "module=Accounts");

		SearchOrgWindow sow = new SearchOrgWindow(driver);
		sow.searchOrganization(orgName);
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		w.switchToWindowOnURL(driver, "module=Potentials");

		w.select(oppTypeDropDown, type);
		saveBtn.click();
	}
}
