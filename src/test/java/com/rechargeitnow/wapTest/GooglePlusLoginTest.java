package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;

public class GooglePlusLoginTest extends TestCore{
	@Test(priority=0)
	public void testGooglePlusLogin(){
		HomePageWap homePage = new HomePageWap(driver);
		homePage.clickLuckyDrawCrossIcon();
        homePage.clickLoginButton();
        
        LoginPageWap loginPage = new LoginPageWap(driver);
        loginPage.clickGooglePlusIcon();
        loginPage.enterGPlusEmail(config.getProperty("G+_EmailId"));
        loginPage.clickGPlusNextButton();
        loginPage.enterGPlusPassword(config.getProperty("G+_Password"));
        loginPage.clickGPlusNextButton();
        Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
	}

}
