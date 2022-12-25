package org.shoppingportal.admin.logout;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) throws InterruptedException {
		
		
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.w3schools.com/mysql/trymysql.asp?filename=trysql_select_all");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//button[@class='ws-btn']")).click();
		int n=10;
		String [] [] str=new String [n] [7];
	//	Actions a=new Actions(driver);
	//	a.moveToElement(null).clickAndHold().build().perform();
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.id("iframeResultSQL"));
		
		driver.switchTo().frame(ele);
		for (int j = 0; j < n; j++) {
			
			
			for (int i = 0; i < 7; i++) {
				WebElement elements = driver.findElement(By.xpath("//table[@class='w3-table-all notranslate']/tbody/tr["+(j+2)+"]/td["+(i+1)+"]"));
				str [j] [i]=elements.getText();
				//System.out.print(elements.getText()+"   ");	
			}
			//System.out.println();
		}

		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < 7; j++) {
			
				System.out.print(str[i][j]+" ");
			}
			System.out.println();
			
		}
		driver.quit();
	
	}

}
