package org.shoppingportal.admin.logout;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		//option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@aria-label,'Oct 18')]/div")).click();
		driver.findElement(By.xpath("//span[text()='RETURN']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@aria-label,'Nov 20')]/div")).click();
		
		driver.findElement(By.xpath("//a[.='Search']")).click();
		driver.findElement(By.xpath("//p[text()='Popular Filters']/following-sibling::div/descendant::span[@title='IndiGo']")).click();
		driver.findElement(By.xpath("//button[text()='Book Now']")).click();
		driver.findElement(By.xpath("//span[text()='RETURN']/ancestor::div[@class='multifareContentLeft']/following-sibling::div/descendant::p[.='Flexi Plus']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		Set<String> win = driver.getWindowHandles();
		for (String string : win) {
			driver.switchTo().window(string);
			if(driver.getCurrentUrl().contains("flight/reviewDetails")) {
				break;
			}
		}
		driver.findElement(By.xpath("//span[.='Base Fare']")).click();
		
	driver.quit();
	}

}
