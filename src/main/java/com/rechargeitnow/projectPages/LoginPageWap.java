package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.LoginPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class LoginPageWap extends BaseClass{

	public LoginPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void enterEmailId(String _email){
		waitForElementDisplayed(By.id(LoginPageWapObject.emailIdField_Id));
		driver.findElement(By.id(LoginPageWapObject.emailIdField_Id)).sendKeys(_email);
		log("enter [registered email]", ILogLevel.METHOD);
	}
	
	public void enterPassword(String _pass){
		waitForElementDisplayed(By.id(LoginPageWapObject.passwordField_Id));
		driver.findElement(By.id(LoginPageWapObject.passwordField_Id)).sendKeys(_pass);
		log("enter [password]", ILogLevel.METHOD);
	}
	
	public void clickSubmitButton(){
		pause(2);
		waitForElementDisplayed(By.xpath(LoginPageWapObject.submitButton_xpath));
		driver.findElement(By.xpath(LoginPageWapObject.submitButton_xpath)).click();
		log("click on [submit] button", ILogLevel.METHOD);
	}
	
	public boolean isLoggedinPageOpen(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.logoutButtonField_xpath));
		boolean logoutButton= isElementPresent(By.xpath(LoginPageWapObject.logoutButtonField_xpath));
		if(logoutButton){
			return true;
		}
		return false;
		
	}

}
