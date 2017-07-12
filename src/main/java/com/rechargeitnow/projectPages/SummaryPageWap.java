package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.rechargeitnow.pageObject.PaymentPageWapObject;
import com.rechargeitnow.pageObject.SummaryPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class SummaryPageWap extends BaseClass {

	public SummaryPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void selectPaymentOption(String _paymentMethod, String _bankOption){
		//waitForElementDisplayed(By.xpath(SummaryPageWapObject.paymentOptionText_Xpath));
		boolean paymentOption = isElementPresent(By.xpath(SummaryPageWapObject.paymentOptionText_Xpath));
		if(paymentOption){
			driver.findElement(By.xpath("//span[contains(text(), '"+_paymentMethod+"')]")).click();
			pause(3);
			waitForElementDisplayed(By.id("bankOpDetailsList"));
			WebElement selectBank = driver.findElement(By.id("bankOpDetailsList"));
			Select select = new Select(selectBank);
			select.selectByVisibleText(_bankOption);
			log("select ["+_bankOption+"] from dropdown", ILogLevel.METHOD);
		}
	}
	
	public boolean verifyNetPayableAmount(String _expectedAmount){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.netPayableAmount_Xpath));
		String amount = driver.findElement(By.xpath(SummaryPageWapObject.netPayableAmount_Xpath)).getText();
		if(amount.contains(_expectedAmount)){
			return true;
		}return false;
	}
	
	public void clickProceedSummaryButton(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.proceedSummaryButton_Xpath));
		driver.findElement(By.xpath(SummaryPageWapObject.proceedSummaryButton_Xpath)).click();
		log("click on [Proceed] button", ILogLevel.METHOD);
	}
	public boolean isAppliedPromoDisplayed(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.promoDiscount_Xpath));
		String promo = driver.findElement(By.xpath(SummaryPageWapObject.promoDiscount_Xpath)).getText();
		if(promo.contains("1")){
			return true;
		}return false;
	}
	
	public boolean isPromoApplied(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.discountAmountText_Xpath));
		String promo = driver.findElement(By.xpath(SummaryPageWapObject.discountAmountText_Xpath)).getText();
		if(promo.contains("1")){
			return true;
		}return false;
	}
	
	public boolean isRINcashAppliedPDC(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.discountAmountText_Xpath));
		String promo = driver.findElement(By.xpath(SummaryPageWapObject.discountAmountText_Xpath)).getText();
		if(promo.contains("1")){
			return true;
		}return false;
	}
	
	public boolean isappliedRINcashDisplayed(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.RINcashPoint_xpath));
		boolean RINcash = isElementPresent(By.xpath(SummaryPageWapObject.RINcashPoint_xpath));
		if(RINcash){
			return true;
		}return false;
	}
	
	public boolean isappliedRINcashDisplayedData(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.RINcashAmountText_Xpath));
		boolean RINcash = isElementPresent(By.xpath(SummaryPageWapObject.RINcashAmountText_Xpath));
		if(RINcash){
			return true;
		}return false;
	}
	
	public boolean isPDCapplied(){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.PDCAmountText_Xpath));
		String PDCAmount = driver.findElement(By.xpath(SummaryPageWapObject.PDCAmountText_Xpath)).getText();
		if(PDCAmount.contains("10")){
			return true;
		}return false;
	}
	
	public boolean isRINcashApplied(String _rincash){
		waitForElementDisplayed(By.xpath(SummaryPageWapObject.PDCAmountText_Xpath));
		String netPayableSummary= driver.findElement(By.xpath(SummaryPageWapObject.PDCAmountText_Xpath)).getText();
		if(netPayableSummary.contains(_rincash)){
			return true;
		}return true;
	}
	

}
