package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.EditWalletDetailsPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class EditWalletDetailsPageWap extends BaseClass{
	public EditWalletDetailsPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	String _newMobileNo = "9015"+AutogenerateNumber(6);
	String currentMobileNumber= " ";
	public void clickEditMobileNoTab(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.editMobileNoTab_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.editMobileNoTab_Xpath)).click();
		log("click on [Edit Mobile No.] button", ILogLevel.METHOD);
	}
	public void clickEditPinNoTab(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.editPinTab_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.editPinTab_Xpath)).click();
		log("click on [Edit Pin No.] button", ILogLevel.METHOD);
	}
	
	public void enterNewMobileNo(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.currentMobileNumberText_Xpath));
		currentMobileNumber = driver.findElement(By.xpath(EditWalletDetailsPageWapObject.currentMobileNumberText_Xpath)).getText();
		System.out.println("Current Mobile No. is "+currentMobileNumber);
		
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(_newMobileNo);
		log("enter [New Mobile Number]", ILogLevel.METHOD);
	}
	public void enterOldMobileNo(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(currentMobileNumber);
		log("enter [old Mobile Number]", ILogLevel.METHOD);
	}
	public void enterPinNumber(String _pin){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.pinNumberField_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.pinNumberField_Xpath)).sendKeys(_pin);
		log("enter [Pin Number]", ILogLevel.METHOD);
	}
	
	public void clickProceedButton(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.proceedButton_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.proceedButton_Xpath)).click();
		log("click on [Proceed] button", ILogLevel.METHOD);
	}
	public void enterOldPin(String _pinNumber){
		waitForElementDisplayed(By.id(EditWalletDetailsPageWapObject.oldPinField_Id));
		driver.findElement(By.id(EditWalletDetailsPageWapObject.oldPinField_Id)).sendKeys(_pinNumber);
		log("enter[Pin]", ILogLevel.METHOD);
	}
	public void enterNewPin(String _newPin){
		waitForElementDisplayed(By.id(EditWalletDetailsPageWapObject.newPinField_Id));
		driver.findElement(By.id(EditWalletDetailsPageWapObject.newPinField_Id)).sendKeys(_newPin);
		log("enter[New Pin]", ILogLevel.METHOD);
	}
	public void enterConfirmPin(String _newPin){
		waitForElementDisplayed(By.id(EditWalletDetailsPageWapObject.confirmPin_Id));
		driver.findElement(By.id(EditWalletDetailsPageWapObject.confirmPin_Id)).sendKeys(_newPin);
		log("enter [re-enter Pin]", ILogLevel.METHOD);
	}
	public void clickPinProceedButton(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.pinProceedButton_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.pinProceedButton_Xpath)).click();
		log("click on [proceed] button to change pin", ILogLevel.METHOD);
	}
	public boolean isPinChanged(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.confirmPinText_Xpath));
		boolean confirmText = isElementPresent(By.xpath(EditWalletDetailsPageWapObject.confirmPinText_Xpath));
		if(confirmText){
			return true;
		}return false;
	}
	public void clickOKButton(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.confirmOKButton_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.confirmOKButton_Xpath)).click();
		log("click on [OK] button", ILogLevel.METHOD);
	}

}
