package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
WebDriver driver;
	
	public	ProductDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private String productDetail="//h1[.='%s']";
	
	@FindBy(xpath="//a[.=' ADD TO CART']")
	private WebElement addCartBtn;
	
	@FindBy(xpath="//a[@class='btn btn-primary']/i[@class='fa fa-heart']")
	private WebElement WishlistBtn;
	
	
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
	/**
	 * 
	 * @param replaceData
	 * @return
	 */
	public String getProductName(String replaceData) {
		return	convertDynamicXathToElement(productDetail,replaceData).getText();
		}
	
	public void clickOnAddCart() {
			addCartBtn.click();
		}
	public void clickOnWishList() {
		WishlistBtn.click();
	}
}
