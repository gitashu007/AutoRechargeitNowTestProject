package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;

import com.rechargeitnow.pageObject.LoginPageWapObject;
import com.rechargeitnow.pageObject.RegistrationPageWapObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;

public class LoginPageWap extends BaseClass{

	public LoginPageWap(AppiumDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public String FB_EmailId = "fbrinuser"+AutogenerateNumber(4)+"@mailinator.com";
	
	public void enterEmailId(String _email){
		waitForElementDisplayed(By.id(LoginPageWapObject.emailIdField_Id));
		driver.findElement(By.id(LoginPageWapObject.emailIdField_Id)).sendKeys(_email);
		log("enter [registered email]", ILogLevel.METHOD);
	}
	
	public void clearEmailField(){
		waitForElementDisplayed(By.id(LoginPageWapObject.emailIdField_Id));
		driver.findElement(By.id(LoginPageWapObject.emailIdField_Id)).clear();
	}
	
	public void clearPasswordField(){
		waitForElementDisplayed(By.id(LoginPageWapObject.passwordField_Id));
		driver.findElement(By.id(LoginPageWapObject.passwordField_Id)).clear();
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
	
	public boolean isValidationAppears(String expectedError){
		waitForElementDisplayed(By.id(LoginPageWapObject.errorMessage_Id));
		String actualError = driver.findElement(By.id(LoginPageWapObject.errorMessage_Id)).getText();
		if(actualError.contains(expectedError)){
			return true;
		}return false;
	}
	
	public void clickRegisterButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.registerButton_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.registerButton_Xpath)).click();
		log("click on [register] button", ILogLevel.METHOD);
	}
	
	public void clickFacebookIcon(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.facebookIcon_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.facebookIcon_Xpath)).click();
		log("click on [Facebook] icon", ILogLevel.METHOD);
	}
	public boolean isFacebookPageOpened(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.facebookLogo_Xpath));
		boolean fbLogo = isElementPresent(By.xpath(LoginPageWapObject.facebookLogo_Xpath));
		if(fbLogo){
			return true;
		}return false;
	}
	public void enterFBEmail(String _fbEmail){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.fbEmailIdField_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.fbEmailIdField_Xpath)).sendKeys(_fbEmail);
		log("enter [Facebook Email]", ILogLevel.METHOD);
	}
	public void clickFBContinueButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.fbContinueButton_Xpath));
		boolean continueButton = isElementPresent(By.xpath(LoginPageWapObject.fbContinueButton_Xpath));
		if(continueButton){
		driver.findElement(By.xpath(LoginPageWapObject.fbContinueButton_Xpath)).click();
		log("click [continue] button", ILogLevel.METHOD);
		}
	}
	
	public void enterFBPassword(String _fbPass){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.fbPasswordField_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.fbPasswordField_Xpath)).sendKeys(_fbPass);
		log("enter [Facebook Password]", ILogLevel.METHOD);
	}
	public void clickFBLoginButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.fbLoginButton_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.fbLoginButton_Xpath)).click();
		log("click on [FB LoginButton]", ILogLevel.METHOD);
		pause(5);
	}
	
	public void enterEmailIdFB(String _email){
		waitForElementDisplayed(By.id(LoginPageWapObject.emailIdField_Id));
		boolean emailField = isElementPresent(By.id(LoginPageWapObject.emailIdField_Id));
		if(emailField){
		driver.findElement(By.id(LoginPageWapObject.emailIdField_Id)).sendKeys(_email);
		log("enter [registered email]", ILogLevel.METHOD);
		}
	}
	
	public void enterMobileNoFB(String _regMobile){
		boolean mobileField = isElementPresent(By.id(RegistrationPageWapObject.mobileNoField_Id));
		if(mobileField){
		driver.findElement(By.id(RegistrationPageWapObject.mobileNoField_Id)).sendKeys(_regMobile);
		log("enter [Mobile]",ILogLevel.METHOD);
		}
	}
	
	public void clickRegisterSubmitButtonFB(){
		waitForElementDisplayed(By.id(RegistrationPageWapObject.submitButton_Id));
		boolean submit = isElementPresent(By.id(RegistrationPageWapObject.submitButton_Id));
		if(submit){
		driver.findElement(By.id(RegistrationPageWapObject.submitButton_Id)).click();
		log("click on [Submit] button",ILogLevel.METHOD);
		}
	}
	
	public void clickGooglePlusIcon(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.gPlusIcon_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.gPlusIcon_Xpath)).click();
		log("click on [G+] icon",ILogLevel.METHOD);
	}
	public void enterGPlusEmail(String _gPlusEmail){
		waitForElementDisplayed(By.id(LoginPageWapObject.gPlusEmailField_Id));
		driver.findElement(By.id(LoginPageWapObject.gPlusEmailField_Id)).sendKeys(_gPlusEmail);
		log("enter [G+ Email]",ILogLevel.METHOD);
	}
	public void enterGPlusPassword(String _gPlusPass){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.gPlusPasswordField_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.gPlusPasswordField_Xpath)).sendKeys(_gPlusPass);
		log("enter [G+ Email]",ILogLevel.METHOD);
	}
	public void clickGPlusNextButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.gPlusNextButton_Id));
		driver.findElement(By.xpath(LoginPageWapObject.gPlusNextButton_Id)).click();
		log("click on [Next] button",ILogLevel.METHOD);
	}
	public void clickYahooLoginIcon(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.yahooIcon_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.yahooIcon_Xpath)).click();
		log("click on [Yahoo] icon",ILogLevel.METHOD);
	}
	public void enterYahooEmail(String _yahooEmail){
		waitForElementDisplayed(By.id(LoginPageWapObject.yahooEmailIdField_Id));
		driver.findElement(By.id(LoginPageWapObject.yahooEmailIdField_Id)).sendKeys(_yahooEmail);
		log("enter [Yahoo Email]",ILogLevel.METHOD);
	}
	public void enterYahooPassword(String _yahooPass){
		waitForElementDisplayed(By.id(LoginPageWapObject.yahooPasswordField_Id));
		driver.findElement(By.id(LoginPageWapObject.yahooPasswordField_Id)).sendKeys(_yahooPass);
		log("enter [Yahoo Password]",ILogLevel.METHOD);
	}
	public void clickYahooNextButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.yahooNextButton_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.yahooNextButton_Xpath)).click();
		log("click on [Next] button",ILogLevel.METHOD);
	}
	public void clickYahooSignInButton(){
		waitForElementDisplayed(By.id(LoginPageWapObject.yahooSignInButton_Id));
		driver.findElement(By.id(LoginPageWapObject.yahooSignInButton_Id)).click();
		log("click on [SignIn] button",ILogLevel.METHOD);
	}
	public void clickYahooAgreeButton(){
		waitForElementDisplayed(By.id(LoginPageWapObject.yahooAgreeButton_Id));
		boolean agree = isElementPresent(By.id(LoginPageWapObject.yahooAgreeButton_Id));
		if(agree){
			driver.findElement(By.id(LoginPageWapObject.yahooAgreeButton_Id)).click();
			log("click on [Agree] button",ILogLevel.METHOD);
		}
	}
	public void clickLinkedInIcon(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.linkedInIcon_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.linkedInIcon_Xpath)).click();
		log("click on [LinkedIn] button",ILogLevel.METHOD);
	}
	public void enterLinkedInEmail(String _linkedInEmail){
		waitForElementDisplayed(By.id(LoginPageWapObject.linkedInEmailIdField_Id));
		driver.findElement(By.id(LoginPageWapObject.linkedInEmailIdField_Id)).sendKeys(_linkedInEmail);
		log("enter [LinkedIn Email]",ILogLevel.METHOD);
	}
	
	public void enterLinkedInPassword(String _linkedInPassword){
		waitForElementDisplayed(By.id(LoginPageWapObject.linkedInPasswordField_Id));
		driver.findElement(By.id(LoginPageWapObject.linkedInPasswordField_Id)).sendKeys(_linkedInPassword);
		log("enter [LinkedIn Password]",ILogLevel.METHOD);
	}
	public void clickLinkedInAllowAccessButton(){
		waitForElementDisplayed(By.xpath(LoginPageWapObject.linkedInAllowAccessButton_Xpath));
		driver.findElement(By.xpath(LoginPageWapObject.linkedInAllowAccessButton_Xpath)).click();
		log("click on [LinkedIn Allow Access] button",ILogLevel.METHOD);
	}

}
