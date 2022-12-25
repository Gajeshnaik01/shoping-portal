package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;
	
	public	CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@name='ordersubmit']")
	private WebElement checkOutBtn;
	
	private String productInCart="//h4/a[.='%s']";
	
	/**
	 * 
	 * @param xpath
	 * @param replaceData
	 * @return
	 */
	private WebElement convertDynamicXathToElement(String xpath,String replaceData) {
		xpath=String.format(xpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}
	
	public String getProductNameInCart(String replaceData) {
		return	convertDynamicXathToElement(productInCart,replaceData).getText();
		}
	
	public WebElement getcheckOutBtn() {
		return checkOutBtn;
		}
	
	public void clickCheckOutBtn() {
		 checkOutBtn.click();
		}
	
}
