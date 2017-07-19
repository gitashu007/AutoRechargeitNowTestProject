package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.rechargeitnow.pageObject.EditWalletDetailsPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;
import com.rechargeitnow.pages.TestCore;

import io.appium.java_client.AppiumDriver;

public class EditWalletDetailsPageWap extends BaseClass{
	public EditWalletDetailsPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	String expectedNumber = TestCore.config.getProperty("New_MobileNo");
	String randomMobileNo = "9015"+AutogenerateNumber(6);

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
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.currentMobNo_Xpath));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String actualOldNumber = (String) jse.executeScript("return arguments[0].value;",driver.findElement(By.xpath(EditWalletDetailsPageWapObject.currentMobNo_Xpath)));
		if(actualOldNumber.trim().equals(expectedNumber.trim())){
			driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(randomMobileNo);
			log("New Mobile Number is equal to current mobile no. So, random number['"+randomMobileNo+"'] is entered", ILogLevel.METHOD);
		}
		else{
			driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(expectedNumber);
			log("enter ['"+expectedNumber+"']", ILogLevel.METHOD);
		}

	}
	public void enterDuplicateMobileNo(){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.currentMobNo_Xpath));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String actualOldNumber = (String) jse.executeScript("return arguments[0].value;",driver.findElement(By.xpath(EditWalletDetailsPageWapObject.currentMobNo_Xpath)));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(actualOldNumber);
		log("enter [duplicate] mobile no.", ILogLevel.METHOD);
	}
	public void enterMobileNo(String _mobNo){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.currentMobNo_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(_mobNo);
		log("enter [Existing] mobile no", ILogLevel.METHOD);
	}
	public void enterOldMobileNo(String currentMobileNo){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath));
		driver.findElement(By.xpath(EditWalletDetailsPageWapObject.newMobileNoField_Xpath)).sendKeys(currentMobileNo);
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
	public boolean verifyMobileNoValidation(String _expectedMessage){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.validationText_Xpath));
		String errorMessage = driver.findElement(By.xpath(EditWalletDetailsPageWapObject.validationText_Xpath)).getText();
		if(errorMessage.equals(_expectedMessage)){
			return true;
		}return false;
	}
	public boolean verifyEditMobileValidation(String _expectedMessage){
		waitForElementDisplayed(By.id(EditWalletDetailsPageWapObject.editMobValidationText_Id));
		String errorMessage = driver.findElement(By.id(EditWalletDetailsPageWapObject.editMobValidationText_Id)).getText();
		if(errorMessage.equals(_expectedMessage)){
			return true;
		}return false;
	}
	public boolean verifyPinValidation(String _expectedMessage){
		waitForElementDisplayed(By.xpath(EditWalletDetailsPageWapObject.pinValidation_Xpath));
		String errorMessage = driver.findElement(By.xpath(EditWalletDetailsPageWapObject.pinValidation_Xpath)).getText();
		if(errorMessage.equals(_expectedMessage)){
			return true;
		}return false;
	}
	
	public boolean verifyEditPinValidation(String _expectedMessage){
		waitForElementDisplayed(By.id(EditWalletDetailsPageWapObject.pinValidationMessageUp_Id));
		String errorMessage = driver.findElement(By.id(EditWalletDetailsPageWapObject.pinValidationMessageUp_Id)).getText();
		if(errorMessage.equals(_expectedMessage)){
			return true;
		}return false;
	}

}
