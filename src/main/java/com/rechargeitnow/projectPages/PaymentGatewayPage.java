package com.rechargeitnow.projectPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.rechargeitnow.pageObject.PaymentGatewayPageObject;
import com.rechargeitnow.pages.BaseClass;
import com.rechargeitnow.pages.ILogLevel;
import com.rechargeitnow.pages.TestCore;

import io.appium.java_client.AppiumDriver;

public class PaymentGatewayPage extends BaseClass {

	public PaymentGatewayPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickRINUrl(){
		pause(2);
		waitForElementDisplayed(By.linkText(PaymentGatewayPageObject.rinUrl_LinkText));
		driver.findElement(By.linkText(PaymentGatewayPageObject.rinUrl_LinkText)).click();
		log("click on [www.rechargeitnow.com] link to fail transaction", ILogLevel.METHOD);
	}
	public void getPageSource(){
		String source = driver.getPageSource();
		System.out.println(source);

	}
	public void clickUseNewCard(){
		waitForElementDisplayed(By.linkText(PaymentGatewayPageObject.useNewCardLink_LinkText));
		boolean useNewCard = isElementPresent(By.linkText(PaymentGatewayPageObject.useNewCardLink_LinkText));
		if(useNewCard){
			driver.findElement(By.linkText(PaymentGatewayPageObject.useNewCardLink_LinkText)).click();
			log("click on [Use New Card] link",ILogLevel.METHOD);
		}
	}
	

}
