package org.shoppingportal.objectRepository;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.yantra.genericUtility.ExcelUtility;
import org.yantra.genericUtility.IConstants;
import org.yantra.genericUtility.WebDriverUtility;

public class InsertProductPage {
	WebDriver driver;
	
	public InsertProductPage(WebDriver driver) {
		this.driver=driver;
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
	
	@FindBy(xpath="//input[@id='productimage1']")
	private WebElement productImage1;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement  productImage2;
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement  productImage3;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement  clickInsert;
	//business libary
	/**
	 * this method return category element
	 * @return
	 */
	public WebElement getCategoryElement(){
		return	category;
	}
	
	/**
	 * this method return subcategory element
	 * @return
	 */
	public WebElement getSubCategoryElement(){
		return	subCategory;
	}
	/**
	 * this method return Product Availability element
	 * @return
	 */
	public WebElement getproductAvailabilityElement(){
		return	productAvailability;
	}
	
	
	/**
	 * this method id used fill details in insert page
	 * @param pName
	 * @param pCompany
	 * @param pPriceBfrDis
	 * @param pPriceAfrDis
	 * @param pDescription
	 * @param pShippingCharge
	 */
	public void fillAllDetails(String pName,String pCompany,String pPriceBfrDis,String pPriceAfrDis,String pDescription,String pShippingCharge){
		productName.sendKeys(pName);
		productCompanyName.sendKeys(pCompany);
		productPriceBeforeDiscount.sendKeys(pPriceBfrDis);
		productPriceAfterDiscount.sendKeys(pPriceAfrDis);
		productDescription.sendKeys(pDescription);
		productShippingCharge.sendKeys(pShippingCharge);
	}
	/**
	 * 
	 * @param pathImg1
	 * @param pathImg2
	 * @param pathImg3
	 */
	public void insertAllImage(String pathImg1,String pathImg2,String pathImg3){
		productImage1.sendKeys(pathImg1);
		productImage2.sendKeys(pathImg2);
		productImage3.sendKeys(pathImg3);
		
	}
	/**
	 * this method is used to click on Insert
	 */
	public void clickOnInsert() {
		clickInsert.click();
	}
	/**
	 * this method add the product from fetching data from the Excel
	 * @param excelUtility
	 * @param webDriverUtility
	 * @param sheetName
	 * @return 
	 */
	public AdminCommonPage insertProductDetails(ExcelUtility excelUtility,WebDriverUtility webDriverUtility, String sheetName) {
		
		ArrayList<String> arrayList=new ArrayList<>();
		
		for (int i = 1; i <=excelUtility.getLastRowValue(sheetName); i++) {
			
			arrayList.add(excelUtility.getExcelData(sheetName, i, 1));
		}
		
		webDriverUtility.selectDropDown(arrayList.get(0), category);
		webDriverUtility.selectDropDown(arrayList.get(1), subCategory);
		
		productName.sendKeys(arrayList.get(2));
		productCompanyName.sendKeys(arrayList.get(3));
		productPriceBeforeDiscount.sendKeys(arrayList.get(4));
		productPriceAfterDiscount.sendKeys(arrayList.get(5));
		productDescription.sendKeys(arrayList.get(6));
		productShippingCharge.sendKeys(arrayList.get(7));
		
		webDriverUtility.selectDropDown(arrayList.get(8), productAvailability);
		
		productImage1.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(9));
		productImage2.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(10));
		productImage3.sendKeys(IConstants.ABSOLUTEPATH+arrayList.get(11));
		
		clickInsert.click();
		
		return new AdminCommonPage(driver);
	}
	
	
	
	
	
}
