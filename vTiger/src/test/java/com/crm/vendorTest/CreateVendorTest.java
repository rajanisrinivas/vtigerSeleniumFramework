package com.crm.vendorTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.crm.baseTest.BaseClass;
import com.crm.generic.webdriverUtility.UtilityClassObject;
import com.crm.objectRepository.CreateVendorPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.VendorInfoPage;
import com.crm.objectRepository.VendorPage;

public class CreateVendorTest extends BaseClass {

	@Test(groups = { "smokeTest" })
	// @Test(groups = {"smokeTest"}, retryAnalyzer = com.crm.generic.listenerUtility.RetryListenerImpClass.class)
	public void createVendorTest() throws Throwable {

		// read data from excel
		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");
		String VENDORNAME = e.getDataFromExcel("Vendor", 1, 2) + j.getRandomNum();

		UtilityClassObject.getTest().log(Status.INFO, "click on more and navigate to vendor page");

		HomePage h = new HomePage(driver);
		h.moveToMoreAndClickOn(h.getVendorLink());

		UtilityClassObject.getTest().log(Status.INFO, "navigate to create vendor page");
		VendorPage vp = new VendorPage(driver);
		Thread.sleep(2000);
		vp.getCreateVendorImg().click();

		UtilityClassObject.getTest().log(Status.INFO, "create vendor " + VENDORNAME);
		CreateVendorPage cvp = new CreateVendorPage(driver);
		cvp.createVendor(VENDORNAME);

		VendorInfoPage vip = new VendorInfoPage(driver);
		String vendorNameInfo = vip.getVendorName().getText();
		Assert.assertEquals(vendorNameInfo, VENDORNAME + "O");
	}
}
