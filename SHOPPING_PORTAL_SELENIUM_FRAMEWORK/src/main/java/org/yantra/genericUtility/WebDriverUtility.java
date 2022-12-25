package org.yantra.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * this class has reuseable method
 * @author gajes
 *
 */
public class WebDriverUtility {
	WebDriver driver;
	/**
	 * this method is used to intialize the webdriver
	 * @return
	 */
	public final WebDriver selelctWebdriver(String browser) {

		switch (browser) {
		case "chrome":WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();

		break;
		case "firefox":WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();

		break;
		case "ie":WebDriverManager.iedriver().setup();
		driver=new InternetExplorerDriver();

		break;

		default:System.out.println("browser name not present in property file");
		break;	
		}
		return driver;
	}
	
	public void sendUrl(String url) {
		driver.get(url);
	}
	
	

	/**
	 * this method is used to implicitly wait
	 * @param timeOut
	 */
	public void waitImplicitly( long timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	/**
	 * this method is used maximize the browser
	 */
	public void maximizeDriver() {
		driver.manage().window().maximize();
	}
	/**
	 * this method is used close the browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * this method is used to handle popup
	 */
	public void acceptAlertPopUp() {
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to handle popup
	 */
	public void dismissAlertPopUp() {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method is used to handle popup
	 * @param key
	 */
	public void sendkeysToAlertPopUp(String key) {
		driver.switchTo().alert().sendKeys(key);
	}
/**
 * this method is used to select the DropDown by Index
 * @param element
 * @param index
 */
	public void selectToDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to select the DropDown by ByValue
	 * @param element
	 * @param value
	 */
	public void selectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to select the DropDown by VisibleText
	 * @param text
	 * @param element
	 */
	public void selectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * this method is used to deselect the DropDown by Index
	 * @param element
	 * @param index
	 */
	public void deSelectDropDown(WebElement element,int index) {
		Select s=new Select(element);
		 s.deselectByIndex(index);
	}
	/**
	 * this method is used to deselect the DropDown by ByValue
	 * @param element
	 * @param value
	 */
	public void deSelectDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.deselectByValue(value);
	}
	/**
	 * this method is used to deselect the DropDown by VisibleText
	 * @param text
	 * @param element
	 */
	public void deSelectDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.deselectByVisibleText(text);
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
	
}
