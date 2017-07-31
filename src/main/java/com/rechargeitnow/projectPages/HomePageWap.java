package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.HomePageWapObject;
import com.rechargeitnow.pageObject.MyAccountPageWapObject;
import com.rechargeitnow.pageObject.ReceiptPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;
import com.rechargeitnow.pages.TestCore;

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
	public void getUrl(){
		driver.get(TestCore.config.getProperty("site_url"));
	}
	public void clickLuckyDrawCrossIcon2(){
		pause(55);
		boolean luckyBanner = isElementPresent(By.xpath(HomePageWapObject.luckyDrawCrossIcon_Xpath));
		if(luckyBanner){
			 driver.findElement(By.xpath(HomePageWapObject.luckyDrawCrossIcon_Xpath)).click();
			 log("click on [close] icon of download app banner", ILogLevel.METHOD);
		}
	}
	public void getPageSource(){
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	
	public void clickRINLogo(){
		pause(3);
		boolean logo1 = isElementPresent(By.xpath(HomePageWapObject.RINLogo_Xpath));
		boolean logo2 = isElementPresent(By.xpath(HomePageWapObject.logoLink_Xpath));
		boolean logo3 = isElementPresent(By.xpath(HomePageWapObject.logoLink_Xpath2));
		if(logo1){
			driver.findElement(By.xpath(HomePageWapObject.RINLogo_Xpath)).click();
			log("click on [RIN Logo] link ", ILogLevel.METHOD);
		}
		else if(logo2){
			driver.findElement(By.xpath(HomePageWapObject.logoLink_Xpath)).click();
			log("click on [RIN Logo] link ", ILogLevel.METHOD);
		}
		else if(logo3){
			driver.findElement(By.xpath(HomePageWapObject.logoLink_Xpath2)).click();
			log("click on [RIN Logo] link ", ILogLevel.METHOD);
		}
	}
	public void clickMyAccountButton(){
		waitForElementDisplayed(By.linkText(HomePageWapObject.myAccountButton_LinkText));
		driver.findElement(By.linkText(HomePageWapObject.myAccountButton_LinkText)).click();
		log("click on [my account] button", ILogLevel.METHOD);
	}
	
	

}
