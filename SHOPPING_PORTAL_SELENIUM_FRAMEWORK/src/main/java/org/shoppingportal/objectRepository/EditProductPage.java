package org.shoppingportal.objectRepository;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.WebDriverUtility;

public class EditProductPage {

	public EditProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement category;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subCategory;
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productName;
	
	@FindBy(xpath="//input[@name='productCompany']")
	private WebElement productCompanyName;
	
	@FindBy(xpath="//input[@name='productpricebd']")
	private WebElement productPriceBeforeDiscount;
	
	@FindBy(xpath="//input[@name='productprice']")
	private WebElement productPriceAfterDiscount;
	
	@FindBy(xpath="//textarea[@name='productDescription']")
	private WebElement productDescription;
	
	@FindBy(xpath="//input[@name='productShippingcharge']")
	private WebElement productShippingCharge;
	
	@FindBy(xpath="//select[@id='productAvailability']")
	private WebElement productAvailability;
	
	@FindBy(xpath="//label[.='Product Image1']/following-sibling::div/a")
	private WebElement productImage1;
	
	@FindBy(xpath="//label[.='Product Image2']/following-sibling::div/a")
	private WebElement  productImage2;
	
	@FindBy(xpath="//label[.='Product Image3']/following-sibling::div/a")
	private WebElement  productImage3;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement  clickInsert;
	
	@FindBy(xpath="//input[@id='productimage1']")
	private WebElement  UpdateProductImage1;
	
	@FindBy(xpath="//input[@id='productimage2']")
	private WebElement  UpdateProductImage2;
	
	@FindBy(xpath="//input[@id='productimage3']")
	private WebElement  UpdateProductImage3;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement  UpdateBtn;
	
	
	
	
	
	public void changeImage(String pathImg1,String pathImg2,String pathImg3) {
		productImage1.click();
		UpdateProductImage1.sendKeys(pathImg1);
		UpdateBtn.click();
		productImage2.click();
		UpdateProductImage2.sendKeys(pathImg2);
		UpdateBtn.click();
		productImage3.click();
		UpdateProductImage3.sendKeys(pathImg3);
		UpdateBtn.click();
	}
	
	public String getActualProductName() {
		return productName.getAttribute("value");
		
	}
	public void updateProduct() {
		clickInsert.click();
		
	}
public void editProductDetails(ExcelUtility excelUtility,WebDriverUtility webDriverUtility, String sheetName) {
		
		ArrayList<String> arrayList=new ArrayList<>();
		
		for (int i = 1; i <=excelUtility.getLastRowValue(sheetName); i++) {
			
			arrayList.add(excelUtility.getExcelData(sheetName, i, 1));
		}
		
		webDriverUtility.selectDropDown(arrayList.get(0), category);
		webDriverUtility.selectDropDown(arrayList.get(1), subCategory);
		productName.clear();
		productName.sendKeys(arrayList.get(2));
		productCompanyName.clear();
		productCompanyName.sendKeys(arrayList.get(3));
		productPriceBeforeDiscount.clear();
		productPriceBeforeDiscount.sendKeys(arrayList.get(4));
		productPriceAfterDiscount.clear();
		productPriceAfterDiscount.sendKeys(arrayList.get(5));
		productDescription.clear();
		productDescription.sendKeys(arrayList.get(6));
		productShippingCharge.clear();
		productShippingCharge.sendKeys(arrayList.get(7));
		webDriverUtility.selectDropDown(arrayList.get(8), productAvailability);
		productImage1.click();
		UpdateProductImage1.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(9));
		UpdateBtn.click();
		webDriverUtility.goBack();
		webDriverUtility.goBack();
		productImage2.click();
		UpdateProductImage2.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(10));
		UpdateBtn.click();
		webDriverUtility.goBack();
		webDriverUtility.goBack();
		productImage3.click();
		UpdateProductImage3.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(11));
		UpdateBtn.click();
		webDriverUtility.goBack();
		webDriverUtility.goBack();
		clickInsert.click();

	}
	
}
