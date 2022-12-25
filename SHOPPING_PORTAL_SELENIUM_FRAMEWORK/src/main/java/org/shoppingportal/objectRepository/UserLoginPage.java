package org.shoppingportal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	
	public UserLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='exampleInputEmail1']")
	private WebElement emailTextField;
	@FindBy(xpath="//input[@id='exampleInputPassword1']")
	private WebElement passwordTextField;
	@FindBy(xpath="//button[.='Login']")
	private WebElement logininBtn;
	
	
	//business libary
	/**
	 * this method is used to perform login
	 * @param username
	 * @param password
	 */
	public void performLoginin(String username,String password){
		emailTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		logininBtn.click();
	}

}
