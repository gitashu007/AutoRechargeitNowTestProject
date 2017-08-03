package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.rechargeitnow.pageObject.MobileRechargeAmountPageWapObject;
import com.rechargeitnow.pageObject.PaymentPageWapObject;
import com.rechargeitnow.pageObject.SummaryPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;
import com.rechargeitnow.pages.TestCore;

import io.appium.java_client.AppiumDriver;

public class PaymentPageWap extends BaseClass {

	public PaymentPageWap(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String payableAmount = " ";
	String payableAmountScen6 = " ";
	String payableAmountData = " ";
	
	public boolean isRechargeAmountCorrect(){
		waitForElementDisplayed(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath));
		String expectedNumber = TestCore.config.getProperty("Recharge_Amount");
		String actualNumber = driver.findElement(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath)).getText();
		if(actualNumber.equals(expectedNumber)){
			return true;
		}return false;

	}
	public boolean isMultiRechargeAmountCorrect(){
		waitForElementDisplayed(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath));
		String expectedNumber = TestCore.config.getProperty("MultiRecharge_Amount");
		String actualNumber = driver.findElement(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath)).getText();
		if(actualNumber.equals(expectedNumber)){
			return true;
		}return false;

	}

	public void clickPDCCheckBox(){
		pause(2);
		waitForElementDisplayed(By.cssSelector(PaymentPageWapObject.PDCCheckbox_Css));
		driver.findElement(By.cssSelector(PaymentPageWapObject.PDCCheckbox_Css)).click();
		log("click on [PDC] checkbox", ILogLevel.METHOD);
	}

	public void clickProceedButton(){
		waitForElementDisplayed(By.id(PaymentPageWapObject.proceedButton_Id));
		boolean proceed = isElementPresent(By.id(PaymentPageWapObject.proceedButton_Id));
		if(proceed){
			driver.findElement(By.id(PaymentPageWapObject.proceedButton_Id)).click();
			log("click on [proceed] button", ILogLevel.METHOD);
		}
	}

	public void clickPDCProceedButton(){
		waitForElementDisplayed(By.xpath(PaymentPageWapObject.proceedPDCButton_Xpath));
		boolean proceed = isElementPresent(By.xpath(PaymentPageWapObject.proceedPDCButton_Xpath));
		if(proceed){
			driver.findElement(By.xpath(PaymentPageWapObject.proceedPDCButton_Xpath)).click();
			log("click on [proceed] button", ILogLevel.METHOD);
		}
	}
	public void clickProceedButtonWithPDC(){
		waitForElementDisplayed(By.xpath(PaymentPageWapObject.proceedWithPdcButton_Xpath));
		boolean proceed2 = isElementPresent(By.xpath(PaymentPageWapObject.proceedWithPdcButton_Xpath));
		if(proceed2){
			driver.findElement(By.xpath(PaymentPageWapObject.proceedWithPdcButton_Xpath)).click();
			log("click on [proceed] button", ILogLevel.METHOD);
		}
		}
		
	
	public boolean isRechargeAmountExpected(String expectedAmount){
		waitForElementDisplayed(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath));
		String payableAmount = driver.findElement(By.xpath(PaymentPageWapObject.netPayableAmount_Xpath)).getText();
		if(payableAmount.equals(expectedAmount)){
			return true;
		}return false;

	}
	
	public void enterRINcashAmount(String _RINcash){
		waitForElementDisplayed(By.id(PaymentPageWapObject.RINcashField_Id));
		driver.findElement(By.id(PaymentPageWapObject.RINcashField_Id)).sendKeys(_RINcash);
		log("enter [RINcash] amount", ILogLevel.METHOD);
	}
	
	public void enterRINPin(String _RINPin){
		waitForElementDisplayed(By.id(PaymentPageWapObject.RINPinField_Id));
		driver.findElement(By.id(PaymentPageWapObject.RINPinField_Id)).sendKeys(_RINPin);
		log("enter [RINPin]", ILogLevel.METHOD);
	}
	
	public void applyPromoCode(String _promoCode){
		waitForElementDisplayed(By.id(PaymentPageWapObject.promoField_Id));
		driver.findElement(By.id(PaymentPageWapObject.promoField_Id)).sendKeys(_promoCode);
		log("enter [promo] code", ILogLevel.METHOD);
		
		driver.findElement(By.linkText(PaymentPageWapObject.applyLink_LinkText)).click();
		log("click on [apply] link", ILogLevel.METHOD);
	}
	
	public boolean isConfirmationAppears(){
		waitForElementDisplayed(By.id(PaymentPageWapObject.confirmText_Xpath));
		boolean confirmMsg = isElementPresent(By.xpath(PaymentPageWapObject.confirmText_Xpath));
		if(confirmMsg){
			return true;
		}return false;
	}
	
	
	public boolean isPayableAmountPaymentPagePresent(String _expectedPayableAmount){
		waitForElementDisplayed(By.id(PaymentPageWapObject.summaryPayableAmountText_Xpath));
		 payableAmount = driver.findElement(By.xpath(PaymentPageWapObject.summaryPayableAmountText_Xpath)).getText();
		 if(payableAmount.contains(_expectedPayableAmount)){
			 return true;
		 }return false;
	}
	
	public boolean isPayableAmountPaymentScen6(String _expectedPayableAmount){
		waitForElementDisplayed(By.id(PaymentPageWapObject.summaryPayableAmountTextScen6_xpath));
		 payableAmountScen6 = driver.findElement(By.xpath(PaymentPageWapObject.summaryPayableAmountTextScen6_xpath)).getText();
		 if(payableAmountScen6.contains(_expectedPayableAmount)){
			 return true;
		 }return false;
	}
	
	public boolean isPayableAmountPaymentData2(String _expectedPayableAmount){
		waitForElementDisplayed(By.id(PaymentPageWapObject.payableAmountTextData_Xpath));
		 String payableAmountData2 = driver.findElement(By.xpath(PaymentPageWapObject.payableAmountTextData_Xpath)).getText();
		 if(payableAmountData2.contains(_expectedPayableAmount)){
			 return true;
		 }return false;
	}
	
	public boolean isPayableAmountPaymentData(String _expectedPayableAmount){
		waitForElementDisplayed(By.id(SummaryPageWapObject.PDCAmountText_Xpath));
		 payableAmountData = driver.findElement(By.xpath(SummaryPageWapObject.PDCAmountText_Xpath)).getText();
		 if(payableAmountData.contains(_expectedPayableAmount)){
			 return true;
		 }return false;
	}
	
	
	
	public boolean isNetPayableAmountExpected(){
		waitForElementDisplayed(By.id(PaymentPageWapObject.netPayableAmount_Id));
		String netPayableSummary= driver.findElement(By.id(PaymentPageWapObject.netPayableAmount_Id)).getText();
		if(netPayableSummary.equals(payableAmount)){
			return true;
		}return true;
	}
	
	
	



}
