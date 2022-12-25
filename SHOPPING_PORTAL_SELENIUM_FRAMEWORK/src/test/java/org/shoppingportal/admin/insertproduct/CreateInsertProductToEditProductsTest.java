package org.shoppingportal.admin.insertproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class CreateInsertProductToEditProductsTest extends BaseClass{
	@Test
	public void createInsertProductToEditProductsTest() {
		
				String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
				String actualProductName=adminCommonPage.clickOnInSertProduct().insertProductDetails(excelUtility, WebDriverUtility, "Product1")
				.clickOnMAnageProduct().clickOnEdit(expectedProductName)
				.getActualProductName();
			
				soft.assertTrue(actualProductName.equals(expectedProductName));
				soft.assertAll();
				
				Reporter.log("Test case Pass", true);
				adminCommonPage.clickOnLogout();

	}

}
