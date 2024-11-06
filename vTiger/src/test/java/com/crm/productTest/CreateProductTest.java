package com.crm.productTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.baseTest.BaseClass;
import com.crm.objectRepository.CreateProductPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.ProductInfoPage;
import com.crm.objectRepository.ProductPage;

public class CreateProductTest extends BaseClass {

	@Test(groups = {"regressionTest"})
	public void createProductWithCategoryTest() throws Throwable {

		// read data from excel file
		String PRODUCT = e.getDataFromExcel("Product", 1, 2) + j.getRandomNum();
		String CATEGORY = e.getDataFromExcel("Product", 1, 3);

		// create new product
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();

		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductImg().click();

		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.createProduct(PRODUCT, CATEGORY);

		// verify product name
		ProductInfoPage pip = new ProductInfoPage(driver);
		String productNameInfo = pip.getProdName().getText();
		Assert.assertEquals(productNameInfo, PRODUCT);

		// verify product category
		String prodCategoryInfo = pip.getProdCategory().getText();
		softAssert.assertEquals(prodCategoryInfo, CATEGORY);
		softAssert.assertAll();

	}
}
