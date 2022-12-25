package org.shoppingportal.admin.logout;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Orange {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		String userName=driver.findElement(By.xpath("//p[.='Username : Admin']")).getText();
		String password=driver.findElement(By.xpath("//p[.='Password : admin123']")).getText();
		System.out.println(userName);
		System.out.println(password);
		String[]s=userName.split(":");
		String[]p=password.split(":");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(s[1].trim());
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(p[1].trim());
		driver.findElement(By.xpath("//button[@type='submit']")).click();



		int n=10;
		String [] [] str=new String [n] [9];
		Thread.sleep(5000);
		for (int j = 0; j < n; j++) {


			for (int i = 1; i < 9; i++) {
				WebElement elements = driver.findElement(By.xpath("//div[@class='oxd-table orangehrm-employee-list']/div[@class='oxd-table-body']/div["+(j+1)+"]/div[@class='oxd-table-row oxd-table-row--with-border oxd-table-row--clickable']/div["+(i+1)+"]/div"));
				str [j] [i]=elements.getText();	
			}

			
		}

		System.out.println(str);

		for (int i = 0; i < n; i++) {

			for (int j = 1; j < 9; j++) {


				System.out.print(str[i][j]+" ");

			}
			System.out.println();

		}

	}

}
