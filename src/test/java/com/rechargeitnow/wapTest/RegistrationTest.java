package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class RegistrationTest extends TestCore{
	@Test(priority=0)
	public void testRegistrationWithValidDetails(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
		homePage.clickLoginButton();
		
		LoginPageWap loginPage = new LoginPageWap(driver);
		loginPage.clickRegisterButton();
		
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isRegisterFormAppears(), "Registration form doesn't appears");
		registerPage.enterName(config.getProperty("Name"));
		registerPage.enterMobileNo();
		registerPage.enterEmailId();
		registerPage.enterPassword(config.getProperty("Reg_Password"));
		registerPage.enterConfirmPassword(config.getProperty("Reg_Password"));
		registerPage.selectTermsCheckbox();
		registerPage.clickRegisterSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "User is not registered yet");
		registerPage.clickLogoutButton();
	}

}
