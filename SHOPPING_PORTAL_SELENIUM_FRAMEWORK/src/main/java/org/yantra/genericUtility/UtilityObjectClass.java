package org.yantra.genericUtility;

import org.openqa.selenium.WebDriver;

public class UtilityObjectClass {
	
	private UtilityObjectClass() {
		
	}

	private static UtilityObjectClass classvar;
	
	
	public static UtilityObjectClass getInstance() {
		if(classvar==null) {
			classvar=new UtilityObjectClass();
		}
		return classvar;	
	}
	
	private WebDriver driver;


	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	
	
	
	
}
