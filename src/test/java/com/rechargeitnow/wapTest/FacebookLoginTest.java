package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class FacebookLoginTest extends TestCore{
	@Test(priority=0)
	public void testFaceBookLogin_WithValidInputs(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickFacebookIcon();
        Assert.assertTrue(loginPage.isFacebookPageOpened(), "Facebook page isn't opened");
        loginPage.enterFBEmail(config.getProperty("FB_EmailId"));
        loginPage.enterFBPassword(config.getProperty("FB_Password"));
        loginPage.clickFBLoginButton();
        loginPage.clickFBContinueButton();
        RegistrationPageWap registerPage = new RegistrationPageWap(driver);
        loginPage.enterEmailIdFB(loginPage.FB_EmailId);
        loginPage.enterMobileNoFB(registerPage._mobile);
        loginPage.clickRegisterSubmitButtonFB();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
        registerPage.clickLogoutButton();
	}

}
