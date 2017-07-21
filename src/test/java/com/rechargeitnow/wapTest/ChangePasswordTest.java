package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.ChangePasswordPageWap;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MyAccountPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class ChangePasswordTest extends TestCore{
	@Test(priority=0)
	public void testChangePassword_WithValidInput(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickChangePasswordTab();
		
		ChangePasswordPageWap changePasswordPage = new ChangePasswordPageWap(driver);
		changePasswordPage.enterOldPassword(config.getProperty("password"));
		changePasswordPage.enterNewPassword("654321");
		changePasswordPage.enterConfirmPassword("654321");
		changePasswordPage.clickSubmitButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("password changed successfully"), "Expected message doesn't appears");
		changePasswordPage.enterOldPassword("654321");
		changePasswordPage.enterNewPassword(config.getProperty("password"));
		changePasswordPage.enterConfirmPassword(config.getProperty("password"));
		changePasswordPage.clickSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("password changed successfully"), "Expected message doesn't appears");
	}
	@Test(priority=1)
	public void testChangePassword_WithBlankInputs(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickChangePasswordTab();
		
		ChangePasswordPageWap changePasswordPage = new ChangePasswordPageWap(driver);
		changePasswordPage.clickSubmitButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("please enter password"), "Expected message doesn't appears");
		changePasswordPage.enterOldPassword(config.getProperty("password"));
		changePasswordPage.clickSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter new password"), "Expected message doesn't appears");
		changePasswordPage.enterNewPassword("654321");
		changePasswordPage.clickSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please retype password"), "Expected message doesn't appears");
	}
	@Test(priority=2)
	public void testChangePassword_WithSameInputsAllField(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickChangePasswordTab();
		
		ChangePasswordPageWap changePasswordPage = new ChangePasswordPageWap(driver);
		changePasswordPage.enterOldPassword(config.getProperty("password"));
		changePasswordPage.enterNewPassword(config.getProperty("password"));
		changePasswordPage.enterConfirmPassword(config.getProperty("password"));
		changePasswordPage.clickSubmitButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("new password must be different from old password"), "Expected message doesn't appears");
		
	}
	@Test(priority=3)
	public void testChangePassword_WithInvalidOldPassword(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickChangePasswordTab();
		
		ChangePasswordPageWap changePasswordPage = new ChangePasswordPageWap(driver);
		changePasswordPage.enterOldPassword("654321");
		changePasswordPage.enterNewPassword(config.getProperty("password"));
		changePasswordPage.enterConfirmPassword(config.getProperty("password"));
		changePasswordPage.clickSubmitButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("please enter valid password"), "Expected message doesn't appears");
		
	}
	@Test(priority=4)
	public void testChangePassword_WithDiffNewAndConfirmPassword(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();

		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
		
		homePage.clickMyAccountButton();
		MyAccountPageWap myAccountPage = new MyAccountPageWap(driver);
		myAccountPage.clickChangePasswordTab();
		
		ChangePasswordPageWap changePasswordPage = new ChangePasswordPageWap(driver);
		changePasswordPage.enterOldPassword(config.getProperty("password"));
		changePasswordPage.enterNewPassword("654321");
		changePasswordPage.enterConfirmPassword(config.getProperty("password"));
		changePasswordPage.clickSubmitButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("your passwords do not match. please retry"), "Expected message doesn't appears");
		
	}

}
