package org.shoppingportal.admin.logout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Icc {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.t20worldcup.com/");
		driver.findElement(By.xpath("//a[contains(text(),'ICC RANKINGS')]")).click();
		Set<String> win = driver.getWindowHandles();
		for (String w : win) {
			driver.switchTo().window(w);
			if(driver.getCurrentUrl().contains("ihttps://www.icc-cricket.com/rankings/mens/overview")) {
				break;
			}
		}
		
		  WebElement element = driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']/descendant::button[contains(text(),'Rankings')]"));
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	
		driver.findElement(By.xpath("//div[@class='main-navigation__header u-hide-desktop']/descendant::button[contains(.,'Men')]/following-sibling::ul/descendant::li[contains(.,'Player')]/preceding-sibling::li[contains(.,'Team')]/a")).click();
		List<WebElement> name = driver.findElements(By.xpath("//span[@class='u-hide-phablet']"));
		List<WebElement> rate = driver.findElements(By.xpath("//td[@class='table-body__cell u-text-right rating' or @class='rankings-block__banner--rating u-text-right']"));
		
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < name.size(); i++) {
			
			String country = name.get(i).getText();
			String rating = rate.get(i).getText();
			
			list.add(country+" "+rating);
			
		}
		
		for (String string : list) {
			System.out.println(string);
		}
		
		driver.quit();
	}

}
