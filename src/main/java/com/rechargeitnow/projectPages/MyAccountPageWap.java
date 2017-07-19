package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.LoginPageWapObject;
import com.rechargeitnow.pageObject.MyAccountPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class MyAccountPageWap extends BaseClass{

	public MyAccountPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickEditProfileButton(){
		waitForElementDisplayed(By.linkText(MyAccountPageWapObject.viewEditProfileButton_LinkText));
		driver.findElement(By.linkText(MyAccountPageWapObject.viewEditProfileButton_LinkText)).click();
		log("click on [view/edit profile] button",ILogLevel.METHOD);
	}
	
	public void enterPasswordEditProfile(String _pass){
		waitForElementDisplayed(By.id(LoginPageWapObject.passwordField_Id));
		boolean password = isElementPresent(By.id(LoginPageWapObject.passwordField_Id));
		if(password){
			driver.findElement(By.id(LoginPageWapObject.passwordField_Id)).sendKeys(_pass);
			driver.findElement(By.id(MyAccountPageWapObject.continueButton_Id)).click();
			log("enter [password]",ILogLevel.METHOD);
		}
	}
	
	public void clickRINcashWalletButton(){
		waitForElementDisplayed(By.xpath(MyAccountPageWapObject.RINcashWalletButton_Xpath));
		driver.findElement(By.xpath(MyAccountPageWapObject.RINcashWalletButton_Xpath)).click();
		log("click on [RINcash Wallet] button", ILogLevel.METHOD);
	}
	
	public void clickLogoutIcon(){
		waitForElementDisplayed(By.xpath(MyAccountPageWapObject.logoutIcon_Xpath));
		driver.findElement(By.xpath(MyAccountPageWapObject.logoutIcon_Xpath)).click();
		log("click on [logout] icon",ILogLevel.METHOD);
	}

}
