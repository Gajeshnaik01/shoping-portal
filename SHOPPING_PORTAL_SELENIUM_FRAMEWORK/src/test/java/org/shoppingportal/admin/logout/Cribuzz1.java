package org.shoppingportal.admin.logout;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cribuzz1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.xpath("//a[text()='RSA vs IND - IND Won']")).click();
		driver.findElement(By.xpath("//a[text()='Scorecard']")).click();
		List<WebElement> name = driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-hdr-rw' and contains(.,'South Africa Innings') ]/following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']/descendant::a[@class='cb-text-link']"));
		List<WebElement> run =driver.findElements(By.xpath("//div[@class='cb-col cb-col-100 cb-scrd-hdr-rw' and contains(.,'South Africa Innings') ]/following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-8 text-right text-bold']"));
		int x=name.size();
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		for (int i = 0; i < x; i++) {
			String s=name.get(i).getText();
			int n=Integer.parseInt(run.get(i).getText());
			map.put(s, n);
		}
		Collection<Integer> value = map.values();
		List<Integer> list=new ArrayList<Integer>(value);
		Collections.sort(list);
		int n=(int) list.get(list.size()-1);
		
	 Set<Entry<String, Integer>> set = map.entrySet();
	 for (Entry<String, Integer> entry : set) {
		
	}
		for (Entry<String, Integer> entry : set) {
			
			if(entry.getValue()==n) {
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			
		}
		driver.quit();
		

	}

}
