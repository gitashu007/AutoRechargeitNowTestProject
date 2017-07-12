package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.rechargeitnow.pageObject.LandingPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class LandingPageWap extends BaseClass{

	public LandingPageWap(AppiumDriver driver) {
		super(driver);
	}

	public void clickRechargeTypeButton(String _rechargeType){
		waitForElementDisplayed(By.xpath("//span[contains(text(), '"+_rechargeType+"')]"));
		driver.findElement(By.xpath("//span[contains(text(), '"+_rechargeType+"')]")).click();
		log("click on ["+_rechargeType+"] button", ILogLevel.METHOD);
	}
	public void clickDataRechargeTypeButton(){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.dataRechargetypeButton_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.dataRechargetypeButton_Xpath)).click();
		log("click on [data] recharge type button",ILogLevel.METHOD);
	}
	
	public void enterMobileNumber(String _mobileNumber){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.mobileNumberField_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.mobileNumberField_Xpath)).sendKeys(_mobileNumber);
		log("enter [Mobile Number]", ILogLevel.METHOD);
	}
	
	public void enterMobileNumberData(String _mobileNumber){
			waitForElementDisplayed(By.id(LandingPageWapObject.mobileNumberFieldData_Id));
			driver.findElement(By.id(LandingPageWapObject.mobileNumberFieldData_Id)).sendKeys(_mobileNumber);
			log("enter [Mobile Number]", ILogLevel.METHOD);
		}
	
	public void clickSubmitButton2(){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.submitButton_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.submitButton_Xpath)).click();
		log("click on [Submit] button", ILogLevel.METHOD);
	}
	public void clickSubmitButtonData2(){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.submitButtonData2_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.submitButtonData2_Xpath)).click();
		log("click on [Submit] button", ILogLevel.METHOD);
	}

	public void selectConfirmNumberRadioButton(){
		pause(2);
		waitForElementDisplayed(By.xpath(LandingPageWapObject.confirmNumberRadioButton_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.confirmNumberRadioButton_Xpath)).click();
		log("click on [Yes] button", ILogLevel.METHOD);
	}

	public void selectOperator(String _operator){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.selectOperatorDropdown_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.selectOperatorDropdown_Xpath)).click();

		waitForElementDisplayed(By.xpath("//div[contains(text(), '"+_operator+"')]"));
		driver.findElement(By.xpath("//div[contains(text(), '"+_operator+"')]")).click();
		log("Select [Operator]", ILogLevel.METHOD);
	}
	public void selectOperatorData(String _operator){
		waitForElementDisplayed(By.cssSelector(LandingPageWapObject.selectOperatorDropdownData_Css));
		driver.findElement(By.cssSelector(LandingPageWapObject.selectOperatorDropdownData_Css)).click();

		waitForElementDisplayed(By.xpath("//div[contains(text(), '"+_operator+"')]"));
		driver.findElement(By.xpath("//div[contains(text(), '"+_operator+"')]")).click();
		log("Select [Operator] for data recharge", ILogLevel.METHOD);
	}

	public void selectCircle(String _option){
		waitForElementDisplayed(By.id(LandingPageWapObject.selectCircleDropdown_Id));
		WebElement element = driver.findElement(By.id(LandingPageWapObject.selectCircleDropdown_Id));
		Select select = new Select(element);
		select.selectByVisibleText(_option);
		log("select [circle] option", ILogLevel.METHOD);
	}
	
	public void selectDataCircle(String _option){
		pause(3);
		waitForElementDisplayed(By.xpath(LandingPageWapObject.circleDropdownData_Xpath));
		WebElement element = driver.findElement(By.xpath(LandingPageWapObject.circleDropdownData_Xpath));
		Select select = new Select(element);
		select.selectByVisibleText(_option);
		log("select [circle] option", ILogLevel.METHOD);
	}

	public void clickSubmitButton3(){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.submitButton3_Xpath));
		driver.findElement(By.xpath(LandingPageWapObject.submitButton3_Xpath)).click();
		log("click on [Submit] button", ILogLevel.METHOD);
	}
	
	public void clickSubmitButtonData(){
		waitForElementDisplayed(By.xpath(LandingPageWapObject.submitButtonData_xpath));
		driver.findElement(By.xpath(LandingPageWapObject.submitButtonData_xpath)).click();
		log("click on [Submit] button", ILogLevel.METHOD);
	}

}
