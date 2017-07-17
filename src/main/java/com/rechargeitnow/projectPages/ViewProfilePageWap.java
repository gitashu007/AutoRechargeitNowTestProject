package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.rechargeitnow.pageObject.ViewProfilePageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class ViewProfilePageWap extends BaseClass{

	public ViewProfilePageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean isViewEditPageOpened(){
		waitForElementDisplayed(By.xpath(ViewProfilePageWapObject.personalDetailsText_Xpath));
		boolean personal = isElementPresent(By.xpath(ViewProfilePageWapObject.personalDetailsText_Xpath));
		if(personal){
			return true;
		}return false;
	}

	public void clickEditLink(){
		waitForElementDisplayed(By.xpath(ViewProfilePageWapObject.editButton_Xpath));
		driver.findElement(By.xpath(ViewProfilePageWapObject.editButton_Xpath)).click();
		log("click on [Edit] link",ILogLevel.METHOD);
	}

	public void enterFirstName(String _firstName){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.firstNameField_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.firstNameField_Id)).clear();
		driver.findElement(By.id(ViewProfilePageWapObject.firstNameField_Id)).sendKeys(_firstName);
		log("enter [First Name] link",ILogLevel.METHOD);

	}

	public void enterLastName(String _lastName){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.lastNameField_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.lastNameField_Id)).clear();
		driver.findElement(By.id(ViewProfilePageWapObject.lastNameField_Id)).sendKeys(_lastName);;
		log("enter [Last Name] link",ILogLevel.METHOD);
	}

	public void selectGender(String _gender){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.genderField_Id));
		WebElement element = driver.findElement(By.id(ViewProfilePageWapObject.genderField_Id));
		Select select = new Select(element);
		select.selectByVisibleText(_gender);
		log("Select ["+_gender+"] as gender",ILogLevel.METHOD);
	}

	public void enterAge(String _age){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.dobField_Id));
		WebElement element = driver.findElement(By.id(ViewProfilePageWapObject.dobField_Id));
		Select select = new Select(element);
		select.selectByVisibleText(_age);
		log("Select ["+_age+"] in Age field",ILogLevel.METHOD);
	}
	
    String _mobile = "9890"+AutogenerateNumber(6);
	public void enterMobileNumber(){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.mobileNoField_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.mobileNoField_Id)).clear();
		driver.findElement(By.id(ViewProfilePageWapObject.mobileNoField_Id)).sendKeys(_mobile);;
		log("enter [Mobile Number]",ILogLevel.METHOD);
	}
	
	public boolean isMobileNumberChanged(){
		waitForElementDisplayed(By.xpath(ViewProfilePageWapObject.editedMobileNumber_Xpath));
		String actualMobileNumber = driver.findElement(By.xpath(ViewProfilePageWapObject.editedMobileNumber_Xpath)).getText();
		if(actualMobileNumber.equals(_mobile)){
			return true;
		}return false;
	}

	public void enterAddress(String _address){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.addressField_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.addressField_Id)).clear();
		driver.findElement(By.id(ViewProfilePageWapObject.addressField_Id)).sendKeys(_address);
		log("enter [address]",ILogLevel.METHOD);
	}

	public void enterPincode(String _pin){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.pinNumber_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.pinNumber_Id)).clear();
		driver.findElement(By.id(ViewProfilePageWapObject.pinNumber_Id)).sendKeys(_pin);
		log("enter on [Pin Number]",ILogLevel.METHOD);
	}
	public void clickTermsCheckbox(){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.termsCheckbox_Id));
		driver.findElement(By.id(ViewProfilePageWapObject.termsCheckbox_Id)).click();
		log("Select [Terms] link",ILogLevel.METHOD);
	}
	public void clickSaveChangesButton(){
		waitForElementDisplayed(By.id(ViewProfilePageWapObject.saveChangesButton_id));
		driver.findElement(By.id(ViewProfilePageWapObject.saveChangesButton_id)).click();
		log("click on [Save Changes] button",ILogLevel.METHOD);
	}


}
