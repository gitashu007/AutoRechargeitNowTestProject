package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.event.IDBVersionChangeEvent;
import com.rechargeitnow.pageObject.ChangePasswordPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class ChangePasswordPageWap extends BaseClass{

	public ChangePasswordPageWap(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public void enterOldPassword(String _oldPass){
		waitForElementDisplayed(By.id(ChangePasswordPageWapObject.oldPasswordField_Id));
		driver.findElement(By.id(ChangePasswordPageWapObject.oldPasswordField_Id)).sendKeys(_oldPass);
		log("enter [Old Password]",ILogLevel.METHOD);
	}
	public void enterNewPassword(String _newPass){
		waitForElementDisplayed(By.id(ChangePasswordPageWapObject.newPasswordField_Id));
		driver.findElement(By.id(ChangePasswordPageWapObject.newPasswordField_Id)).sendKeys(_newPass);
		log("enter [New Password]",ILogLevel.METHOD);
	}
	public void enterConfirmPassword(String _confirmPass){
		waitForElementDisplayed(By.id(ChangePasswordPageWapObject.confirmPasswordField_Id));
		driver.findElement(By.id(ChangePasswordPageWapObject.confirmPasswordField_Id)).sendKeys(_confirmPass);
		log("enter [confirm Password]",ILogLevel.METHOD);
	}
	public void clickSubmitButton(){
		waitForElementDisplayed(By.className(ChangePasswordPageWapObject.changePassSubmitButton_ClassName));
		driver.findElement(By.className(ChangePasswordPageWapObject.changePassSubmitButton_ClassName)).click();
		log("click on [Submit] button",ILogLevel.METHOD);
	}

}
