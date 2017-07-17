package com.rechargeitnow.projectPages;

import java.util.ArrayList;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.RINcashTransactionPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class RINcashTransactionPageWap extends BaseClass{

	public RINcashTransactionPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isRINcashWalletPageOpened(){
		switchChildWindow();
		waitForElementDisplayed(By.xpath(RINcashTransactionPageWapObject.RINcashText_Xpath));
		boolean rinText= isElementPresent(By.xpath(RINcashTransactionPageWapObject.RINcashText_Xpath));
		if(rinText){
			return true;
		}return false;

	}
	public void clickEditDetailsButton(){
		waitForElementDisplayed(By.xpath(RINcashTransactionPageWapObject.editDetailsButton_Xpath));
		driver.findElement(By.xpath(RINcashTransactionPageWapObject.editDetailsButton_Xpath)).click();
		log("click on [edit details] button", ILogLevel.METHOD);
	}
	public void switchParentWindow1(){
		switchParentWindow();
	}
	

}
