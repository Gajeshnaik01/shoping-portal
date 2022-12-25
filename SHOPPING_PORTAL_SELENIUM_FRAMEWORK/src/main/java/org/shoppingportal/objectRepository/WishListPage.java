package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
WebDriver driver;
	
	public	WishListPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private String productInWishlist="//a[.='%s']";
	
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
	
	public String getProductNameInWishlist(String replaceData) {
		return	convertDynamicXathToElement(productInWishlist,replaceData).getText();
		}
}
