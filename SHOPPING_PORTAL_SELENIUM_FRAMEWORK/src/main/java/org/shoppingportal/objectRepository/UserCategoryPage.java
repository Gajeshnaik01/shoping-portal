package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserCategoryPage {

WebDriver driver;
	
	public	UserCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	private String subCategories="//a[contains(.,'%s') and @class='dropdown-toggle']";
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
		 */
		public void clickOnSubCategories(String replaceData) {
			convertDynamicXathToElement(subCategories,replaceData).click();
		}
}
