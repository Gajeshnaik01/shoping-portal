package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserSubCategoryPage {
	WebDriver driver;
	
	public	UserSubCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private String productLink="//a[text()='%s']";
	
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
	
	public WebElement getProductElement(String replaceData) {
		return convertDynamicXathToElement(productLink,replaceData);
	}
	public void clickOnProduct(String replaceData) {
		convertDynamicXathToElement(productLink,replaceData).click();
	}
	public String getProductName(String replaceData) {
	return	convertDynamicXathToElement(productLink,replaceData).getText();
	}
}
