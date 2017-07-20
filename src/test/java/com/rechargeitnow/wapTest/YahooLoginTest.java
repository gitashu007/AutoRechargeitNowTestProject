package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class YahooLoginTest extends TestCore{
	@Test(priority=0)
	public void testYahooLogin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickYahooLoginIcon();
        loginPage.enterYahooEmail(config.getProperty("Yahoo_EmailId"));
        loginPage.clickYahooNextButton();
        loginPage.enterYahooPassword(config.getProperty("Yahoo_Password"));
        loginPage.clickYahooSignInButton();
        loginPage.clickYahooAgreeButton();
        RegistrationPageWap registerPage = new RegistrationPageWap(driver);
        loginPage.enterMobileNoFB(registerPage._mobile);
        loginPage.clickRegisterSubmitButtonFB();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
	}

}
