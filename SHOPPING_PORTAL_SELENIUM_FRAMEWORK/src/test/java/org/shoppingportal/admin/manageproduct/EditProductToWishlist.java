package org.shoppingportal.admin.manageproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;

public class EditProductToWishlist extends BaseClass{
	@Test
	public void editProductToWishlist() {

		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
		String updatedCategory=excelUtility.getExcelData("Product2", 1, 1);
		String updatedSubCategory=excelUtility.getExcelData("Product2", 2, 1);
		String updatedProductName=excelUtility.getExcelData("Product2", 3, 1);

		adminCommonPage.clickOnMAnageProduct();
		manageProduct.clickOnEdit(expectedProductName);
		editProductPage.editProductDetails(excelUtility, WebDriverUtility, "Product2");
		adminCommonPage.clickOnLogout();

		WebDriverUtility.sendUrl(userurl);
		userCommonPage.clickOnLogin();
		userLoginPage.performLoginin(userusername,userpassword);
		userCommonPage.clickOnAppHome();

		userCommonPage.clickOnCategories(updatedCategory);
		userCategoryPage.clickOnSubCategories(updatedSubCategory);
		
		js.scrollToElement(userSubCategoryPage.getProductElement(updatedProductName));

		userSubCategoryPage.clickOnProduct(updatedProductName);
		
		
		productDetailsPage.clickOnWishList();
		
		
		String actualProductNameInCart=wishListPage.getProductNameInWishlist(updatedProductName);
		

		soft.assertTrue(actualProductNameInCart.equalsIgnoreCase(updatedProductName));
		soft.assertAll();
		Reporter.log("Test case Pass", true);
	}

}
