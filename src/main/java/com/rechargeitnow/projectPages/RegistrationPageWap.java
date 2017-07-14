package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.RegistrationPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class RegistrationPageWap extends BaseClass {

	public RegistrationPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	String _mobile = "9899"+AutogenerateNumber(6);
	String _email = "rinuser"+AutogenerateNumber(5)+"@mailinator.com";
	
	public boolean isRegisterFormAppears(){
		waitForElementDisplayed(By.xpath(RegistrationPageWapObject.registerTab_Xpath));
		boolean register = isElementPresent(By.xpath(RegistrationPageWapObject.registerTab_Xpath));
		if(register){
			return true;
		}return false;
	}
	
	public void enterName(String _name){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.nameField_Id));
		driver.findElement(By.id(RegistrationPageWapObject.nameField_Id)).sendKeys(_name);
		log("enter [Name]",ILogLevel.METHOD);
	}
	
	public void enterMobileNo(){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.mobileNoField_Id));
		driver.findElement(By.id(RegistrationPageWapObject.mobileNoField_Id)).sendKeys(_mobile);
		log("enter [Mobile]",ILogLevel.METHOD);
	}
	
	
	public void enterEmailId(){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.emailField_Id));
		driver.findElement(By.id(RegistrationPageWapObject.emailField_Id)).sendKeys(_email);
		log("enter [email]",ILogLevel.METHOD);
	}
	
	public void enterPassword(String _pass){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.passwordField_Id));
		driver.findElement(By.id(RegistrationPageWapObject.passwordField_Id)).sendKeys(_pass);
		log("enter [password]",ILogLevel.METHOD);
	}
	
	public void enterConfirmPassword(String _pass){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.confirmPassword_Id));
		driver.findElement(By.id(RegistrationPageWapObject.confirmPassword_Id)).sendKeys(_pass);
		log("enter [Confirm password]",ILogLevel.METHOD);
	}
	
	public void selectTermsCheckbox(){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.termsCheckbox_Id));
		driver.findElement(By.id(RegistrationPageWapObject.termsCheckbox_Id)).click();
		log("click on [terms] checkbox",ILogLevel.METHOD);
	}
	
	public void clickRegisterSubmitButton(){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.submitButton_Id));
		driver.findElement(By.id(RegistrationPageWapObject.submitButton_Id)).click();
		log("click on [Submit] button",ILogLevel.METHOD);
	}
	

}
