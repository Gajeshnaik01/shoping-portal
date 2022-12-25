package org.shoppingportal.admin.logout;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.setPageLoadStrategy(PageLoadStrategy.EAGER);
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		WebDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//div[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//div[text()='SAMSUNG']/preceding-sibling::div[@class='_24_Dny']")).click();
		String s=driver.findElement(By.xpath("//span[@class='_2tDckM']")).getText();
		String[] str = s.split(" ");
		
		int n=Integer.parseInt(str[6]);
		System.out.println(n);
		int m=0;
		while(true) {
			Thread.sleep(2000);
			List<WebElement> all = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
			System.out.println(all.size());
			m=m+all.size();
			
			System.out.println(m);
			try{
				
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				
			}
			catch(Exception e) {
				
				break;	
			}
		
			
		}
		if(m==n) {
			System.out.println("matched");
			
		}
		else {
			System.out.println("not matched");
		}
		
	
	}

}
