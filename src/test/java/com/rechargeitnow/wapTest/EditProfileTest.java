package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MyAccountPageWap;
import com.rechargeitnow.projectPages.ViewProfilePageWap;

public class EditProfileTest extends TestCore {
	
	@Test(priority=0)
	public void testEditProfileWithValidInputs(){
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
		myAccountPage.clickEditProfileButton();
		myAccountPage.enterPasswordEditProfile(config.getProperty("password"));
		
		ViewProfilePageWap viewProfilePage = new ViewProfilePageWap(driver);
		Assert.assertTrue(viewProfilePage.isViewEditPageOpened(), "View/edit link is not clicked");
		viewProfilePage.clickEditLink();
		viewProfilePage.enterFirstName(config.getProperty("First_Name"));
		viewProfilePage.enterLastName(config.getProperty("Last_Name"));
		viewProfilePage.selectGender(config.getProperty("Gender"));
		viewProfilePage.enterAge(config.getProperty("Age"));
		viewProfilePage.enterMobileNumber();
		viewProfilePage.enterAddress(config.getProperty("Address"));
		viewProfilePage.enterPincode(config.getProperty("Pin_Number"));
		//viewProfilePage.clickTermsCheckbox();
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(viewProfilePage.isMobileNumberChanged(), "Edited mobile verification is failed");
	}

}
