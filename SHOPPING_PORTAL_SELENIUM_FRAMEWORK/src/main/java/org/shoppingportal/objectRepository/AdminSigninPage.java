package org.shoppingportal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminSigninPage {
	WebDriver driver;
	public AdminSigninPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='inputEmail']")
	private WebElement userNameTextField;
	@FindBy(xpath="//input[@id='inputPassword']")
	private WebElement passwordTextField;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement signinBtn;
	
	
	//business libary
	/**
	 * this method is used to perform signin
	 * @param username
	 * @param password
	 * @return 
	 */
	public AdminCommonPage performSignin(String username,String password){
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		signinBtn.click();
		return new AdminCommonPage(driver);
	}

}
