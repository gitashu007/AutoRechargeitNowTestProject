package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class FacebookLoginTest extends TestCore{
	@Test(priority=0)
	public void testFaceBookLogin_WithValidInput(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickFacebookIcon();
        Assert.assertTrue(loginPage.isFacebookPageOpened(), "Facebook page isn't opened");
        loginPage.enterFBEmail(config.getProperty("FB_EmailId"));
        loginPage.enterFBPassword(config.getProperty("FB_Password"));
        loginPage.clickFBLoginButton();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
	}
	@Test(priority=1)
	public void testFacebookLogin_WithFBAccountNoEmail(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickFacebookIcon();
        Assert.assertTrue(loginPage.isFacebookPageOpened(), "Facebook page isn't opened");
        loginPage.enterFBEmail("7982269123");
        loginPage.enterFBPassword("testing123");
        loginPage.clickFBLoginButton();
        RegistrationPageWap registerPage = new RegistrationPageWap(driver);
        loginPage.enterEmailIdFB(loginPage.FB_EmailId);
        loginPage.enterMobileNoFB(registerPage._mobile);
        loginPage.clickRegisterSubmitButtonFB();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
        
	}

}
