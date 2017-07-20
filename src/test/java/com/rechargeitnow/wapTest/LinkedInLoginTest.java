package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;

public class LinkedInLoginTest extends TestCore{
	@Test(priority=0)
	public void testLinkedInLogin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickLinkedInIcon();
        loginPage.enterLinkedInEmail(config.getProperty("LinkedIn_EmailId"));
        loginPage.enterLinkedInPassword(config.getProperty("LinkedIn_Password"));
        loginPage.clickLinkedInAllowAccessButton();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
	}

}
