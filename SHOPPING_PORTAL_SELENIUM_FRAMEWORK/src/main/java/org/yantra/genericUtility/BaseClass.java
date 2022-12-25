package org.yantra.genericUtility;

import org.shoppingportal.objectRepository.AdminCommonPage;
import org.shoppingportal.objectRepository.AdminSigninPage;
import org.shoppingportal.objectRepository.CartPage;
import org.shoppingportal.objectRepository.EditProductPage;
import org.shoppingportal.objectRepository.InsertProductPage;
import org.shoppingportal.objectRepository.ManageProduct;
import org.shoppingportal.objectRepository.OrderHistoryPage;
import org.shoppingportal.objectRepository.PaymentPage;
import org.shoppingportal.objectRepository.ProductDetailsPage;
import org.shoppingportal.objectRepository.UserCategoryPage;
import org.shoppingportal.objectRepository.UserCommonPage;
import org.shoppingportal.objectRepository.UserLoginPage;
import org.shoppingportal.objectRepository.UserSubCategoryPage;
import org.shoppingportal.objectRepository.WishListPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseClass extends InstanceClass {
	

	@BeforeSuite
	public void suiteSetup() {
	

	}
	@Parameters("BROWSER")
	@BeforeClass
	public void classSetup(String BROWSER) {
		System.out.println("congifig before class -"+Thread.currentThread().getId());
		
		//creating object for Utility class
				WebDriverUtility=new WebDriverUtility();
				excelUtility=new ExcelUtility();
				fileUtility=new FileUtility();
				javaUtility=new JavaUtility();
				js=new JavaScriptExeUtility();
				soft=new SoftAssert();
	
		
		//Fetching data from excel
		excelUtility.intializeExcel(IConstants.EXCELFILEPATH);
		fileUtility.intializePropertyFile(IConstants.PROPERTYFILEPATH);
		adminurl=fileUtility.getDataFromProperty("adminurl");
		userurl=fileUtility.getDataFromProperty("userurl");
		adminusername=fileUtility.getDataFromProperty("adminusername");
		adminpassword=fileUtility.getDataFromProperty("adminpassword");
		
		userusername=fileUtility.getDataFromProperty("userusername");
		userpassword=fileUtility.getDataFromProperty("userpassword");
		
		//browser=fileUtility.getDataFromProperty("browser");
		to=fileUtility.getDataFromProperty("timeout");
		timeouts = javaUtility.convertStringToLong(to);
		//fetching data from excel
		
	
		
		//driver=WebDriverUtility.selelctWebdriver(browser);
		driver=WebDriverUtility.selelctWebdriver(BROWSER);
		
		
	//	UtilityObjectClass.getInstance().setDriver(driver);
		WebDriverUtility.sendUrl(adminurl);
		WebDriverUtility.maximizeDriver();
		WebDriverUtility.waitImplicitly(timeouts);
		//pom class object creation 
		adminSigninPage =new AdminSigninPage(driver);
		adminCommonPage=new AdminCommonPage(driver);
		userCommonPage=new UserCommonPage(driver);
		userCategoryPage=new UserCategoryPage(driver);
		userSubCategoryPage=new UserSubCategoryPage(driver);
		productDetailsPage=new ProductDetailsPage(driver);
		wishListPage=new WishListPage(driver);
		userLoginPage=new UserLoginPage(driver);
		insertProductPage=new InsertProductPage(driver);
		manageProduct=new ManageProduct(driver);
		editProductPage=new EditProductPage(driver);
		paymentPage=new PaymentPage(driver);
		orderHistoryPage=new OrderHistoryPage(driver);
		cartPage =new CartPage(driver);
		js.webDriverToJavaScriptEx(driver);
		
	}
	@BeforeMethod
	public void methodSetup() {
		System.out.println("congifig before method -"+Thread.currentThread().getId());
		adminSigninPage.performSignin(adminusername, adminpassword);
	}
	@AfterMethod
	public void methodTearDown() {
		System.out.println("congifig after method -"+Thread.currentThread().getId());
		
	}
	@AfterClass
	public void classTearDown() {
		System.out.println("congifig after class -"+Thread.currentThread().getId());
		WebDriverUtility.closeBrowser();
	}
	
	@AfterSuite
	public void suiteTearDown() {
	
		excelUtility.closeWorkbook();
		
	}
	

}
