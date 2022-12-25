package org.shoppingportal.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageProduct {
	WebDriver driver;
	public ManageProduct(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@name='DataTables_Table_0_length']")
	private WebElement selectEntries;
	@FindBy(xpath="//input[@aria-controls='DataTables_Table_0']")
	private WebElement searchProdct;
	@FindBy(xpath="//table/tbody/tr[1]/td[2]")
	private WebElement findProduct;
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/following-sibling::td/a/i[@class='icon-edit']")
	private WebElement  editProduct;
	@FindBy(xpath="//table/tbody/tr[1]/td[2]/following-sibling::td/a/i[@class='icon-remove-sign']")
	private WebElement  deleteProduct;
	//business libary
	public String getActualProductname(String productName){
		searchProdct.sendKeys(productName);
		return findProduct.getText();
	}
	
	public EditProductPage clickOnEdit(String productName){
		searchProdct.sendKeys(productName);
		editProduct.click();
		return new EditProductPage(driver);
	}

	
}
