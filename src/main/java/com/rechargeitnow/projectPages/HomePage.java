package com.rechargeitnow.projectPages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class HomePage extends BaseClass{

	public HomePage(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void typeMobileNumber(String _mobileNumber){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/mob_NumberET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/mob_NumberET")).sendKeys(_mobileNumber);
		log("Enter the [Mobile Number]",ILogLevel.METHOD);
	}

	public void selectOperator(){
		waitForElementDisplayed(By.className("android.widget.TextView"));
		List<WebElement> alllist =driver.findElements(By.className("android.widget.TextView"));
		alllist.get(0).click();
		pause(2);
		List<WebElement> alllist1 =driver.findElements(By.id("android:id/text1"));
		alllist.get(2).click();
		log("Select the [Operator]",ILogLevel.METHOD);
	}

	public void clickProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/proceddbutton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/proceddbutton")).click();
		log("Click on [Proceed] button",ILogLevel.METHOD);
	}

	public void typeRechargeAmount(String _amount){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/mySelectedRCAmountET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/mySelectedRCAmountET")).sendKeys(_amount);;
		log("Enter the [Recharge Amount]",ILogLevel.METHOD);
	}

	public void clickAmountProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/planscreen_ProceedButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/planscreen_ProceedButton")).click();
		log("Click on [Proceed] button",ILogLevel.METHOD);
	}

	public void selectPaymentMethod(){
		waitForElementDisplayed(By.name("Select Payment Type"));
		driver.findElement(By.name("Select Payment Type")).click();
		
		waitForElementDisplayed(By.name("Debit Card"));
		driver.findElement(By.name("Debit Card")).click();
		log("Select [Payment Type]",ILogLevel.METHOD);
	}

	public void selectBankCardOption(){
		waitForElementDisplayed(By.name("Select Option"));
		driver.findElement(By.name("Select Option")).click();
		
		waitForElementDisplayed(By.name("Rupay Debit Card"));
		driver.findElement(By.name("Rupay Debit Card")).click();
		log("Select the [Bank/Card option]",ILogLevel.METHOD);
	}
	
	public void selectServiceProvider(){
		waitForElementDisplayed(By.name("Select Service Provider"));
		driver.findElement(By.name("Select Service Provider")).click();
		
		waitForElementDisplayed(By.name("Videocon D2H"));
		driver.findElement(By.name("Rupay Debit Card")).click();
		log("Select the [Service Provider]",ILogLevel.METHOD);
	}

	public void clickPaymentProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/payment_SubmitButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/payment_SubmitButton")).click();
		log("Click on [Proceed] button",ILogLevel.METHOD);
	}
	
	public void clickCouponProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/partnerDiscountCouponProceedButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/partnerDiscountCouponProceedButton")).click();
		log("Click on [Proceed] button",ILogLevel.METHOD);
	}

	public void switchToWebview(){
		
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/webview01"));
		String webview = driver.getPageSource();
		System.out.println(webview);
		/*TouchAction touch = new TouchAction(driver);
		Set<String> contextNames = driver.getContextHandles();
		for (String contextName : contextNames) {
			System.out.println(contextName);
			if (contextName.contains("WEBVIEW")){
				driver.context(contextName);
			}
		}*/
	}

	public void clickHomeIcon(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/imageView4"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/imageView4")).click();
		log("Click on [Home] icon",ILogLevel.METHOD);
	}

	public void clickDTHTab(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/textView2"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/textView2")).click();
		log("Click on [DTH] tab",ILogLevel.METHOD);
	}

	public void typeCustomerID(String _custId){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/mob_typeET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/mob_typeET")).sendKeys(_custId);
		log("Enter the [Customer ID] tab",ILogLevel.METHOD);
	}

	public void clickDTHProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/proceddbutton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/proceddbutton")).click();
		log("Click [Proceed] button",ILogLevel.METHOD);
	}

	public void clickConfirmPopup(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/ok_popup_Btn"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/ok_popup_Btn")).click();
		log("Click [Proceed] button on popup",ILogLevel.METHOD);
	}

	public void typeDTHRechargeAmount(String _amount){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/mySelectedRCAmountET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/mySelectedRCAmountET")).sendKeys(_amount);
		log("Enter the [amount]",ILogLevel.METHOD);
	}

	public void clickAmountDTH_ProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/planscreen_ProceedButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/planscreen_ProceedButton")).click();
		log("click [Proceed] button",ILogLevel.METHOD);
	}

}
