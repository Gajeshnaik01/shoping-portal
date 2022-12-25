package org.shoppingportal.admin.manageproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class EditProductToManageProduct extends BaseClass {
	@Test
	public void editProductToManageProduct() {

		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
		String updatedProductName=excelUtility.getExcelData("Product2", 3, 1);

		adminCommonPage.clickOnMAnageProduct();
		manageProduct.clickOnEdit(expectedProductName);
		editProductPage.editProductDetails(excelUtility, WebDriverUtility, "Product2");
		adminCommonPage.clickOnMAnageProduct();
		String actualProductName = manageProduct.getActualProductname(updatedProductName);
		
		soft.assertTrue(actualProductName.equals(updatedProductName));
		soft.assertAll();
		Reporter.log("Test case Pass", true);
		adminCommonPage.clickOnLogout();
	}

}
