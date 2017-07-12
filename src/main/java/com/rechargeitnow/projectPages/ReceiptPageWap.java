package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.PaymentGatewayPageObject;
import com.rechargeitnow.pageObject.ReceiptPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class ReceiptPageWap extends BaseClass {

	public ReceiptPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isFailedConfirmationPresent(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.confirmationMessageText_Xpath));
		boolean receipt = isElementPresent(By.xpath(ReceiptPageWapObject.confirmationMessageText_Xpath));
		if(receipt){
			return true;
		}return false;
	}
	
	public void clickStartAgainButton(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.startAgainButton_Xpath));
		driver.findElement(By.xpath(ReceiptPageWapObject.startAgainButton_Xpath)).click();
		log("click on [Start Again] button", ILogLevel.METHOD);
	}
	
	public void clickHereToStopLink(){
		waitForElementDisplayed(By.linkText(ReceiptPageWapObject.clickHereToStopLink_LinkText));
		driver.findElement(By.linkText(ReceiptPageWapObject.clickHereToStopLink_LinkText)).click();
		log("click on [click here to stop] link", ILogLevel.METHOD);
	}
	
	public boolean isOrderIdPresent(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.orderIdText_Xpath));
		boolean orederId = isElementPresent(By.xpath(ReceiptPageWapObject.orderIdText_Xpath));
		if(orederId){
			return true;
		}return false;
	}
	
	public boolean isMobileNoSame(String _rechargeMobNo){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.receiptMobileNo_Xpath));
		String receiptMobileNo = driver.findElement(By.xpath(ReceiptPageWapObject.receiptMobileNo_Xpath)).getText();
		if(receiptMobileNo.equals(_rechargeMobNo)){
			return true;
			
		}return false;
	}
	
	public boolean isRechargeAmountSame(String _rechargeAmount){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.receiptRechargeAmount_Xpath));
		String receiptRechargeAmount = driver.findElement(By.xpath(ReceiptPageWapObject.receiptRechargeAmount_Xpath)).getText();
		if(receiptRechargeAmount.equals(_rechargeAmount)){
			return true;
			
		}return false;
	}
	
	public boolean verifyCouponValue(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.CouponValueText_Xpath));
		String receiptCouponValue = driver.findElement(By.xpath(ReceiptPageWapObject.CouponValueText_Xpath)).getText();
		if(receiptCouponValue.equals("10")){
			return true;
			
		}return false;
	}
	
	public boolean isOrderIdPresentScen1(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.orderIdTextScen1_Xpath));
		boolean orederId = isElementPresent(By.xpath(ReceiptPageWapObject.orderIdTextScen1_Xpath));
		if(orederId){
			return true;
		}return false;
	}
	
	public boolean isMobileNoSameScen1(String _rechargeMobNo){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.receiptMobileNoScen1_Xpath));
		String receiptMobileNo = driver.findElement(By.xpath(ReceiptPageWapObject.receiptMobileNoScen1_Xpath)).getText();
		if(receiptMobileNo.equals(_rechargeMobNo)){
			return true;
			
		}return false;
	}
	
	public boolean isRechargeAmountSameScen1(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.receiptRechargeAmountScen1_Xpath));
		boolean receiptRechargeAmount = isElementPresent(By.xpath(ReceiptPageWapObject.receiptRechargeAmountScen1_Xpath));
		if(receiptRechargeAmount){
			return true;
			
		}return false;
	}
	
	public void clickRINLogo(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.RINLogo_Xpath));
		driver.findElement(By.xpath(ReceiptPageWapObject.RINLogo_Xpath)).click();
		log("click on [RIN Logo] link ", ILogLevel.METHOD);
	}
	
	public boolean isRINcashPointDisplayed(String _appliedRINcash){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.RINcashPointText_Xpath));
		String RINcash_Point = driver.findElement(By.xpath(ReceiptPageWapObject.RINcashPointText_Xpath)).getText();
		if(RINcash_Point.equals(_appliedRINcash)){
			return true;
		}return false;
	}
	
	public boolean isPromoDiscountDisplayed(String _appliedPromoAmount){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.promoDiscountText_Xpath));
		String promoDiscount = driver.findElement(By.xpath(ReceiptPageWapObject.promoDiscountText_Xpath)).getText();
		if(promoDiscount.equals(_appliedPromoAmount)){
			return true;
		}return false;
	}
	
	public boolean verifyReceiptCouponValue(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.couponValueText_Xpath2));
		String receiptCouponValue = driver.findElement(By.xpath(ReceiptPageWapObject.couponValueText_Xpath2)).getText();
		if(receiptCouponValue.equals("10")){
			return true;
		}return false;
	}
	
	public boolean verifyReceiptCouponValueLoc2(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.couponvalueTextLoc2_Xpath));
		String receiptCouponValue = driver.findElement(By.xpath(ReceiptPageWapObject.couponvalueTextLoc2_Xpath)).getText();
		if(receiptCouponValue.equals("10")){
			return true;
		}return false;
	}
	
	public boolean verifyReceiptCouponValueLoc3(){
		waitForElementDisplayed(By.xpath(ReceiptPageWapObject.couponValueTextLoc3_Xpath));
		String receiptCouponValue = driver.findElement(By.xpath(ReceiptPageWapObject.couponValueTextLoc3_Xpath)).getText();
		if(receiptCouponValue.contains("10")){
			return true;
		}return false;
	}
	
	

}
