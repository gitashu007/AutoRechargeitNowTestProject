package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class LoginPage extends BaseClass{

	public LoginPage(AppiumDriver driver) {
		super(driver);
		
	}
	
	public void clickTermsCheckbox(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/checkBox1"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/checkBox1")).click();
		log("Click on [Terms] checkbox", ILogLevel.METHOD);
	}
	
	public void clickProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/Terms_n_Usage_ProceedBtn"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/Terms_n_Usage_ProceedBtn")).click();
		log("Click on [Proceed] button", ILogLevel.METHOD);
	}
	
	public void clickRechargeItNowUserButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/rinLoginButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/rinLoginButton")).click();
		log("Click on [RechargeItNow User] button", ILogLevel.METHOD);
	}
	
	public void typeEmail(String _email){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/loginPage_UserNameET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/loginPage_UserNameET")).sendKeys(_email);
		log("Enter the [Email Id] ", ILogLevel.METHOD);
	}
	
	public void typePassword(String _pass){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/loginPage_PasswordET"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/loginPage_PasswordET")).sendKeys(_pass);
		log("Enter the [Password] ", ILogLevel.METHOD);
	}
	
	public void clickLoginProceedButton(){
		waitForElementDisplayed(By.id("com.olr.rechargeitnow:id/loginpageProceedButton"));
		driver.findElement(By.id("com.olr.rechargeitnow:id/loginpageProceedButton")).click();
		log("Click on [Proceed] button ", ILogLevel.METHOD);
	}
	
	public boolean isMobileTabPresent(){
		String mobileText = driver.findElement(By.id("com.olr.rechargeitnow:id/textView1")).getText();
		if(mobileText.equals("mobile")){
			return true;
		}return false;
	}
	
	public void closeKeyboard(){
		driver.navigate().back();
	}
	public void ConfirmPopup(){
		waitForElementDisplayed(By.id("android:id/button1"));
		driver.findElement(By.id("android:id/button1")).click();
		log("Click on [Yes] on popup ", ILogLevel.METHOD);
	}
	

}