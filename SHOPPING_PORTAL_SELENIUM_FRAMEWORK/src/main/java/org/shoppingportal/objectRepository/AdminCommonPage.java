package org.shoppingportal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminCommonPage {

	WebDriver driver;
	
	public AdminCommonPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[contains(text(),' Product ')]")
	private WebElement insertProduct;
	@FindBy(xpath="//a[contains(text(),'Products ')]")
	private WebElement manageProduct;
	@FindBy(xpath="//a[contains(text(),'Login ')]")
	private WebElement userLoginLog;
	@FindBy(xpath="//a[contains(.,'Logout')]/i")
	private WebElement logout;
	
	
	//business libary
	public InsertProductPage clickOnInSertProduct(){
		insertProduct.click();
		return new InsertProductPage(driver);
	}
	
	
	public ManageProduct clickOnMAnageProduct(){
		manageProduct.click();
		return new ManageProduct(driver);
	}
	public void clickOnUserLoginLogProduct(){
		userLoginLog.click();
	}
	public void clickOnLogout(){
		logout.click();
	}

}
