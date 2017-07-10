package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;

public class LoginTest extends TestCore{
	
	@Test(priority = 0)
	public void testLogin(){
		LoginPageWap loginPage = new LoginPageWap(driver);
		
		//homePage.clickLoginButton();
		loginPage.enterEmailId(config.getProperty("emailId"));
		loginPage.enterPassword(config.getProperty("password"));
		loginPage.clickSubmitButton();
		Assert.assertTrue(loginPage.isLoggedinPageOpen(), "Verification of [logout] button is failed");
 	}

}
