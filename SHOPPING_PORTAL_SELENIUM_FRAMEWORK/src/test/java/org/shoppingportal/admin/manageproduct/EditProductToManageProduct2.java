package org.shoppingportal.admin.manageproduct;

import org.openqa.selenium.WebDriver;
import org.shoppingportal.objectRepository.AdminCommonPage;
import org.shoppingportal.objectRepository.AdminSigninPage;
import org.shoppingportal.objectRepository.EditProductPage;
import org.shoppingportal.objectRepository.ManageProduct;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.FileUtility;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.JavaUtility;
import org.yantra.genericUtility.WebDriverUtility;

public class EditProductToManageProduct2 {

	public static void main(String[] args) {
		WebDriverUtility WebDriverUtility=new WebDriverUtility();
		ExcelUtility excelUtility=new ExcelUtility();
		FileUtility fileUtility=new FileUtility();
		JavaUtility javaUtility=new JavaUtility();
		
		//Fetching data from excel
		fileUtility.intializePropertyFile(IConstants.PROPERTYFILEPATH);
		String adminurl=fileUtility.getDataFromProperty("adminurl");
		String adminusername=fileUtility.getDataFromProperty("adminusername");
		String adminpassword=fileUtility.getDataFromProperty("adminpassword");
		String browser=fileUtility.getDataFromProperty("browser");
		String to=fileUtility.getDataFromProperty("timeout");
		long timeouts = javaUtility.convertStringToLong(to);
		//fetching data from excel
		excelUtility.intializeExcel(IConstants.EXCELFILEPATH);

		String expectedProductName=excelUtility.getExcelData("Product1", 3, 1);
		String updatedProductName=excelUtility.getExcelData("Product2", 3, 1);

		//setting up driver
		WebDriver driver=WebDriverUtility.selelctWebdriver(browser);
		WebDriverUtility.sendUrl(adminurl);
		WebDriverUtility.maximizeDriver();
		WebDriverUtility.waitImplicitly(timeouts);
		//pom class object creation 
		AdminSigninPage adminSigninPage =new AdminSigninPage(driver);
		AdminCommonPage adminCommonPage=new AdminCommonPage(driver);
		EditProductPage editProductPage=new EditProductPage(driver);
		ManageProduct manageProduct=new ManageProduct(driver);
		
		adminSigninPage.performSignin(adminusername, adminpassword);
		adminCommonPage.clickOnMAnageProduct();
		manageProduct.clickOnEdit(expectedProductName);
		editProductPage.editProductDetails(excelUtility, WebDriverUtility, "Product2");
		adminCommonPage.clickOnMAnageProduct();
		
		
		
		
		String actualProductName = manageProduct.getActualProductname(updatedProductName);
		if(actualProductName.equals(updatedProductName)) {
			javaUtility.printStatement("Test case Pass");
		}
		else {
			javaUtility.printStatement("Test case Fail");
		}
		//close
		adminCommonPage.clickOnLogout();
		excelUtility.closeWorkbook();
		WebDriverUtility.closeBrowser();
	}

}
