package org.shoppingportal.admin.insertproduct;

import org.openqa.selenium.WebDriver;
import org.shoppingportal.objectRepository.AdminCommonPage;
import org.shoppingportal.objectRepository.AdminSigninPage;
import org.shoppingportal.objectRepository.CartPage;
import org.shoppingportal.objectRepository.ProductDetailsPage;
import org.shoppingportal.objectRepository.UserCategoryPage;
import org.shoppingportal.objectRepository.UserCommonPage;
import org.shoppingportal.objectRepository.UserSubCategoryPage;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.JavaScriptExeUtility;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebDriverUtility;

public class CreateInsertProductToCartTest2 {

	public static void main(String[] args) {
		//creating object for Utility class
		WebDriverUtility WebDriverUtility=new WebDriverUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		FileUtility fileUtility=new FileUtility();
		JavaUtility javaUtility=new JavaUtility();
		JavaScriptExeUtility js=new JavaScriptExeUtility();


		//Fetching data from excel
		fileUtility.intializePropertyFile(IConstants.PROPERTYFILEPATH);
		String adminurl=fileUtility.getDataFromProperty("adminurl");
		String userurl=fileUtility.getDataFromProperty("userurl");
		String adminusername=fileUtility.getDataFromProperty("adminusername");
		String adminpassword=fileUtility.getDataFromProperty("adminpassword");
		String browser=fileUtility.getDataFromProperty("browser");
		String to=fileUtility.getDataFromProperty("timeout");
		long timeouts = javaUtility.convertStringToLong(to);
		//fetching data from excel
		excelUtility.intializeExcel(IConstants.EXCELFILEPATH);
		String expectedCategory=excelUtility.getExcelData("Product1", 1, 1);
		String expectedSubCategory=excelUtility.getExcelData("Product1", 2, 1);
		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
		//setting up driver
		WebDriver driver=WebDriverUtility.selelctWebdriver(browser);
		WebDriverUtility.sendUrl(adminurl);
		WebDriverUtility.maximizeDriver();
		WebDriverUtility.waitImplicitly(timeouts);
		//pom class object creation 
		AdminSigninPage adminSigninPage =new AdminSigninPage(driver);
		AdminCommonPage adminCommonPage=new AdminCommonPage(driver);
		UserCommonPage userCommonPage=new UserCommonPage(driver);
		UserCategoryPage userCategoryPage=new UserCategoryPage(driver);
		UserSubCategoryPage userSubCategoryPage=new UserSubCategoryPage(driver);
		ProductDetailsPage productDetailsPage=new ProductDetailsPage(driver);
		CartPage cartPage =new CartPage(driver);

		adminSigninPage.performSignin(adminusername, adminpassword)
		.clickOnInSertProduct().insertProductDetails(excelUtility, WebDriverUtility, "Product1");
		adminCommonPage.clickOnLogout();

		WebDriverUtility.sendUrl(userurl);

		userCommonPage.clickOnCategories(expectedCategory);
		userCategoryPage.clickOnSubCategories(expectedSubCategory);

		js.webDriverToJavaScriptEx(driver);
		js.scrollToElement(userSubCategoryPage.getProductElement(expectedProductName));

		userSubCategoryPage.clickOnProduct(expectedProductName);
		productDetailsPage.clickOnAddCart();

		WebDriverUtility.acceptAlertPopUp();

		String actualProductNameInCart=cartPage.getProductNameInCart(expectedProductName);
		if(actualProductNameInCart.equalsIgnoreCase(expectedProductName)) {
			javaUtility.printStatement("Test case Pass");
		}
		else {
			javaUtility.printStatement("Test case Fail");
		}
		excelUtility.closeWorkbook();
		WebDriverUtility.closeBrowser();
	}

}
