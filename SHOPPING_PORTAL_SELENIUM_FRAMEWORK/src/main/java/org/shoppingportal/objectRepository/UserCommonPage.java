package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserCommonPage {

	WebDriver driver;
	
public	UserCommonPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
private String categories="//a[contains(.,'%s') and @class='dropdown-toggle']";

@FindBy(xpath="//a[contains(.,'Login')]")
private WebElement loginBtn;

@FindBy(xpath="//a/h2")
private WebElement appHomeLink;

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
public void clickOnCategories(String replaceData) {
	convertDynamicXathToElement(categories,replaceData).click();
}
	
public void clickOnLogin() {
	loginBtn.click();
}
public void clickOnAppHome() {
	appHomeLink.click();
}

}
