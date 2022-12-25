package org.shoppingportal.admin.insertproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class CreateInsertProductToManageProductsTest extends BaseClass {
	@Test
	public  void createInsertProductToManageProductsTest() {
		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);

		adminCommonPage.clickOnInSertProduct();
		insertProductPage.insertProductDetails(excelUtility, WebDriverUtility, "Product1");
		//validating
		adminCommonPage.clickOnMAnageProduct();
		String actualProductName = manageProduct.getActualProductname(expectedProductName);
		soft.assertTrue(actualProductName.equals(expectedProductName));
		soft.assertAll();
		Reporter.log("Test case Pass", true);
		adminCommonPage.clickOnLogout();
		
	}

}
	