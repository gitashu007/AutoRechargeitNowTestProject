package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.HomePageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class HomePageWap extends BaseClass{

	public HomePageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickLoginButton(){
		waitForElementDisplayed(By.xpath(HomePageWapObject.loginButton_xpath));
		driver.findElement(By.xpath(HomePageWapObject.loginButton_xpath)).click();
		log("click on [Login] tab",ILogLevel.METHOD);
	}
	
	public void clickLuckyDrawCrossIcon(){
		waitForElementDisplayed(By.xpath(HomePageWapObject.luckyDrawCrossIcon_Xpath));
		boolean luckyBanner = isElementPresent(By.xpath(HomePageWapObject.luckyDrawCrossIcon_Xpath));
		if(luckyBanner){
			 driver.findElement(By.xpath(HomePageWapObject.luckyDrawCrossIcon_Xpath)).click();
			 log("click on [X] icon of lucky draw", ILogLevel.METHOD);
		}
		
	}
	
	

}
