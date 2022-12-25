package org.shoppingportal.admin.insertproduct;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.yantra.genericUtility.BaseClass;


public class CreateInsertProductToWishlist extends BaseClass{


	@Test
	public  void createInsertProductToWishlist() {
		
				String expectedCategory=excelUtility.getExcelData("Product1", 1, 1);
				String expectedSubCategory=excelUtility.getExcelData("Product1", 2, 1);
				String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
				
				
				adminCommonPage.clickOnInSertProduct().insertProductDetails(excelUtility, WebDriverUtility, "Product1");
				adminCommonPage.clickOnLogout();
				
				WebDriverUtility.sendUrl(userurl);
				userCommonPage.clickOnLogin();
				userLoginPage.performLoginin(userusername,userpassword);
				userCommonPage.clickOnAppHome();
				
				userCommonPage.clickOnCategories(expectedCategory);
				userCategoryPage.clickOnSubCategories(expectedSubCategory);
				js.webDriverToJavaScriptEx(driver);
				js.scrollToElement(userSubCategoryPage.getProductElement(expectedProductName));
				userSubCategoryPage.clickOnProduct(expectedProductName);
				
				productDetailsPage.clickOnWishList();
			
				String actualProductName=wishListPage.getProductNameInWishlist(expectedProductName);
			
				soft.assertTrue(actualProductName.equals(expectedProductName));
				soft.assertAll();
				Reporter.log("Test case Pass", true);
			
				
	}

}
