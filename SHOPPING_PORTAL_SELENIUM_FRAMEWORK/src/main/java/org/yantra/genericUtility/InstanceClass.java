package org.yantra.genericUtility;

import org.openqa.selenium.WebDriver;
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
import org.testng.asserts.SoftAssert;

public class InstanceClass {

	public WebDriver driver;
	public WebDriverUtility WebDriverUtility;
	public ExcelUtility excelUtility;
	public FileUtility fileUtility;
	public JavaUtility javaUtility;
	public JavaScriptExeUtility js;
	public SoftAssert soft;
	
	public String adminurl;
	public String userurl;
	public String adminusername;
	public String adminpassword;
	public String userusername;
	public String userpassword;
	public String browser;
	public String to;
	public long timeouts;
	
	
	public AdminSigninPage adminSigninPage;
	public AdminCommonPage adminCommonPage;
	public UserCommonPage userCommonPage;
	public UserCategoryPage userCategoryPage;
	public UserSubCategoryPage userSubCategoryPage;
	public ProductDetailsPage productDetailsPage;
	public WishListPage wishListPage;
	public UserLoginPage userLoginPage;
	public InsertProductPage insertProductPage;
	public ManageProduct manageProduct;
	public CartPage cartPage;
	public EditProductPage editProductPage;
	public PaymentPage paymentPage;
	public OrderHistoryPage orderHistoryPage;
}
