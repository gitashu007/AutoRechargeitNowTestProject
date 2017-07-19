package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class RegistrationTest extends TestCore{
	@Test(priority=0)
	public void testRegistrationWithBlankFields(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter name"), "Expected validation doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter mobile no."), "Expected validation doesn't appears");
		registerPage.enterMobileNo(registerPage._mobile);
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter a valid email id"), "Expected validation doesn't appears");
		registerPage.enterEmailId(registerPage._email);
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter password"), "Expected validation doesn't appears");
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please retype password"), "Expected validation doesn't appears");
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please accept terms of usage to proceed"), "Expected validation doesn't appears");
	}
	@Test(priority=1)
	public void testregisteration_WithInvalidMobNo(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo("9899");
		registerPage.enterEmailId(registerPage._email);
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter valid mobile no."), "Expected validation doesn't appears");
	}
	
	@Test(priority=2)
	public void testregisteration_WithInvalidEmailId(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo(registerPage._mobile);
		registerPage.enterEmailId("abc123@");
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter a valid email id"), "Expected validation doesn't appears");
	}
	@Test(priority=3)
	public void testregisteration_WithLessThan6CharPassword(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo(registerPage._mobile);
		registerPage.enterEmailId(registerPage._email);
		registerPage.enterPassword("12");
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter password between 6 to 12 characters"), "Expected validation doesn't appears");
	}
	
	@Test(priority=4)
	public void testregisteration_WithDiffInputPwdAndConfirmPwd(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo(registerPage._mobile);
		registerPage.enterEmailId(registerPage._email);
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.enterConfirmPassword("111111");
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(registerPage.isValidationPresent("your passwords do not match. please retry"), "Expected validation doesn't appears");
	}
	
	@Test(priority=5)
	public void testRegistrationWithValidDetails(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo(registerPage._mobile);
		registerPage.enterEmailId(registerPage._email);
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "User is not registered yet");
		registerPage.clickLogoutButton();
	}

}
