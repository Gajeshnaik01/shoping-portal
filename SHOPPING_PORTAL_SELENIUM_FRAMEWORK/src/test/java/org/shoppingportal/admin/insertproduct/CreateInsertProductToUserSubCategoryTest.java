package org.shoppingportal.admin.insertproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class CreateInsertProductToUserSubCategoryTest extends BaseClass {
	@Test
	public void createInsertProductToUserSubCategoryTest() {
		
		String expectedCategory=excelUtility.getExcelData("Product1", 1, 1);
		String expectedSubCategory=excelUtility.getExcelData("Product1", 2, 1);
		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
		//setting up driver
		
		adminCommonPage.clickOnInSertProduct().insertProductDetails(excelUtility, WebDriverUtility, "Product1");
		adminCommonPage.clickOnLogout();
		
		WebDriverUtility.sendUrl(userurl);
		
		userCommonPage.clickOnCategories(expectedCategory);
		userCategoryPage.clickOnSubCategories(expectedSubCategory);
		
		js.scrollToElement(userSubCategoryPage.getProductElement(expectedProductName));
		String actualProductName=userSubCategoryPage.getProductName(expectedProductName);

		
		soft.assertTrue(actualProductName.equals(expectedProductName));
		soft.assertAll();
		Reporter.log("Test case Pass", true);
		
	}

}
