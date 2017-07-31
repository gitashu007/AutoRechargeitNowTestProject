package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.MobileRechargeAmountPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;
import com.rechargeitnow.pages.TestCore;

import io.appium.java_client.AppiumDriver;

public class MobileRechargeAmountPageWap extends BaseClass{

	public MobileRechargeAmountPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isMobileNumberCorrect(String expectedNumber){
		waitForElementDisplayed(By.xpath(MobileRechargeAmountPageWapObject.mobileNumberText_Xpath));;
		String actualNumber = driver.findElement(By.xpath(MobileRechargeAmountPageWapObject.mobileNumberText_Xpath)).getText();
		if(actualNumber.equals(expectedNumber)){
			return true;
		}return false;
	}

	public void enterRechargeAmount(String _amount){
		waitForElementDisplayed(By.id(MobileRechargeAmountPageWapObject.rechargeAmountField_Id));
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.rechargeAmountField_Id)).sendKeys(_amount);
		log("enter [recharge amount]", ILogLevel.METHOD);
	}

	public void clickProceedButton(){
		waitForElementDisplayed(By.xpath(MobileRechargeAmountPageWapObject.proceedButton_Xpath));
		driver.findElement(By.xpath(MobileRechargeAmountPageWapObject.proceedButton_Xpath)).click();
		log("click on [proceed] button", ILogLevel.METHOD);
	}

	public void applyCouponCode(String _couponNo, String _couponAmount, String _couponCode){
		waitForElementDisplayed(By.id(MobileRechargeAmountPageWapObject.rechargeCouponCheckbox_Id));
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.rechargeCouponCheckbox_Id)).click();

		waitForElementDisplayed(By.id(MobileRechargeAmountPageWapObject.couponNoIdField_Id));
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.couponNoIdField_Id)).sendKeys(_couponNo);
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.couponAmountField_Id)).sendKeys(_couponAmount);
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.couponCodeField_Id)).sendKeys(_couponCode);
		log("Enter ["+_couponNo+"-"+_couponAmount+"-"+_couponCode+"]", ILogLevel.METHOD);
	}

	public void clickYesRadioButton(){
		waitForElementDisplayed(By.id(MobileRechargeAmountPageWapObject.yesRadioButton_Id));
		driver.findElement(By.id(MobileRechargeAmountPageWapObject.yesRadioButton_Id)).click();
		log("click on [Yes] radio button",ILogLevel.METHOD);
	}

	public void clickOKButton(){
		waitForElementDisplayed(By.xpath(MobileRechargeAmountPageWapObject.okButton_Xpath));
		boolean okButton = isElementPresent(By.xpath(MobileRechargeAmountPageWapObject.okButton_Xpath));
		if(okButton){
			driver.findElement(By.xpath(MobileRechargeAmountPageWapObject.okButton_Xpath)).click();
			log("click on [ok] button",ILogLevel.METHOD);
		}
	}
	public boolean isMultiDTHNumberCorrect(String _selectedOperator){
		waitForElementDisplayed(By.xpath(MobileRechargeAmountPageWapObject.mobileNumberText_Xpath));;
		String actualNumber = driver.findElement(By.xpath(MobileRechargeAmountPageWapObject.mobileNumberText_Xpath)).getText();
		if(_selectedOperator.equals("tata sky")){
			if(actualNumber.equals(getConfigPropertiesElement("TataSky_Number"))){
				return true;
			}return false;
		}
		else if(_selectedOperator.equals("dishtv")){
			if(actualNumber.equals(getConfigPropertiesElement("Dishtv_Number"))){
				return true;
			}return false;
		}
		else if(_selectedOperator.equals("sun direct")){
			if(actualNumber.equals(getConfigPropertiesElement("SunDirect_Number"))){
				return true;
			}return false;
		}
		else if(_selectedOperator.equals("reliance digital tv")){
			if(actualNumber.equals(getConfigPropertiesElement("RelianceDigitaltv_Number"))){
				return true;
			}return false;
		}
		else if(_selectedOperator.equals("airtel digital tv")){
			if(actualNumber.equals(getConfigPropertiesElement("AirtelDigitaltv_Number"))){
				return true;
			}return false;
		}
		else if(_selectedOperator.equals("videocon d2h")){
			if(actualNumber.equals(getConfigPropertiesElement("VideoconD2H_Number"))){
				return true;
			}return false;
		}
		return true;
	}

}
