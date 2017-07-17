package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;

public class LoginTest extends TestCore{
	
	@Test(priority = 0)
	public void testLoginWithInvalidEmail(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId("abc123@");
		loginPage.enterPassword("123456");
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isValidationAppears("please enter a valid email id"), "No validation is displayed");
	}
	@Test(priority = 1)
	public void testLoginWithInvalidPassword(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword("testing");
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isValidationAppears("invalid email or password"), "No validation is displayed");
	}
	@Test(priority=2)
	public void testLoginWithUnregisteredEmail(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId("abc123@mailinator.com");
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isValidationAppears("invalid email or password"), "No validation is displayed");
	}
	@Test(priority = 3)
	public void testLoginWithBlankEmail(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clearEmailField();
		loginPage.enterPassword("testing");
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isValidationAppears("please enter a valid email id"), "No validation is displayed");
	}
	@Test(priority = 4)
	public void testLoginWithBlankPassword(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.clearPasswordField();
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isValidationAppears("please enter password"), "No validation is displayed");
	}
	
	@Test(priority = 5)
	public void testLogin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
 	}

}
