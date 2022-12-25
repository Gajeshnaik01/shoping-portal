package org.shoppingportal.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

	WebDriver driver;

	public	OrderHistoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	private String productDetail="//table[@class='table table-bordered']/tbody/tr/td[3]/h4/a[contains(.,'%s')]";
	
	private WebElement convertDynamicXathToElement(String xpath,String replaceData) {
		xpath=String.format(xpath, replaceData);
		return driver.findElement(By.xpath(xpath));
	}

	public String getProductDetail(String replaceData) {
		return convertDynamicXathToElement(productDetail,replaceData).getText();
	}


}
