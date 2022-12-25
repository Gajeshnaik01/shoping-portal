package org.shoppingportal.admin.insertproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class CreateInsertProductToCartTest extends BaseClass {
	@Test
	public  void createInsertProductToCartTest( ) {
		
		String expectedCategory=excelUtility.getExcelData("Product1", 1, 1);
		String expectedSubCategory=excelUtility.getExcelData("Product1", 2, 1);
		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
	
		adminCommonPage.clickOnInSertProduct().insertProductDetails(excelUtility, WebDriverUtility, "Product1");
		adminCommonPage.clickOnLogout();

		WebDriverUtility.sendUrl(userurl);

		userCommonPage.clickOnCategories(expectedCategory);
		userCategoryPage.clickOnSubCategories(expectedSubCategory);

		
		js.scrollToElement(userSubCategoryPage.getProductElement(expectedProductName));

		userSubCategoryPage.clickOnProduct(expectedProductName);
		productDetailsPage.clickOnAddCart();

		WebDriverUtility.acceptAlertPopUp();

		String actualProductNameInCart=cartPage.getProductNameInCart(expectedProductName);
		
		soft.assertTrue(actualProductNameInCart.equalsIgnoreCase(expectedProductName));
		soft.assertAll();
		Reporter.log("Test case Pass", true);
	
	}

}
