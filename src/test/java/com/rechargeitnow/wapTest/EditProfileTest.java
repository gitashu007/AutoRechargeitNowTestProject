package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MyAccountPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;
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
		viewProfilePage.enterMobileNumber(viewProfilePage._mobile);
		viewProfilePage.enterAddress(config.getProperty("Address"));
		viewProfilePage.enterPincode(config.getProperty("Pin_Number"));
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(viewProfilePage.isMobileNumberChanged(), "Edited mobile verification is failed");
	}
	
	@Test(priority=1)
	public void testEditProfile_WithBlankInputFields(){
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
		viewProfilePage.clearFirstNameField();
		viewProfilePage.clickSaveChangesButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("please enter first name"),"Expected message doesn't appears");
		viewProfilePage.enterFirstName(config.getProperty("First_Name"));
		viewProfilePage.clearLastNameField();
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter last name"),"Expected message doesn't appears");
		viewProfilePage.enterLastName(config.getProperty("Last_Name"));
		viewProfilePage.clearMobNoField();
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter mobile number"),"Expected message doesn't appears");
		viewProfilePage.enterMobileNumber(viewProfilePage._mobile);
		viewProfilePage.clearAddressField();
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter address"),"Expected message doesn't appears");
		viewProfilePage.enterAddress(config.getProperty("Address"));
		viewProfilePage.clearPinNoField();
		viewProfilePage.clickSaveChangesButton();
		Assert.assertTrue(registerPage.isValidationPresent("please enter pincode"),"Expected message doesn't appears");
	}
	@Test(priority=2)
	public void testtestEditProfile_WithMobileNoLessThan10(){
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
		viewProfilePage.enterMobileNumber("9015");
		viewProfilePage.clickSaveChangesButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("number should be 10 digit"),"Expected message doesn't appears");
	}
	@Test(priority=3)
	public void testtestEditProfile_WithPinLessThan6(){
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
		viewProfilePage.enterPincode("122");
		viewProfilePage.clickSaveChangesButton();
		RegistrationPageWap registerPage = new RegistrationPageWap(driver);
		Assert.assertTrue(registerPage.isValidationPresent("please enter valid pincode"),"Expected message doesn't appears");
	}

}
