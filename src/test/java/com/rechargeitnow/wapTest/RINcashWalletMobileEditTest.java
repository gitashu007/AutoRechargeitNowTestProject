package com.rechargeitnow.wapTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.rechargeitnow.pages.TestCore;
import com.rechargeitnow.projectPages.EditWalletDetailsPageWap;
import com.rechargeitnow.projectPages.HomePageWap;
import com.rechargeitnow.projectPages.LoginPageWap;
import com.rechargeitnow.projectPages.MyAccountPageWap;
import com.rechargeitnow.projectPages.RINcashTransactionPageWap;
import com.rechargeitnow.projectPages.RegistrationPageWap;

public class RINcashWalletMobileEditTest extends TestCore {
	@Test(priority=0)
	public void testRINcashMobileEdit_WithBlankMobileNo(){
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
			myAccountPage.clickRINcashWalletButton();
			
			RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
			Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
			rincashPage.clickEditDetailsButton();
			
			EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
			editWalletPage.clickEditMobileNoTab();
			editWalletPage.enterPinNumber(config.getProperty("RIN_Pin"));
			editWalletPage.clickProceedButton();
			Assert.assertTrue(editWalletPage.verifyMobileNoValidation("please enter new mobile no. you want to register"), "Expected validation message doesn't appears");			
			rincashPage.switchParentWindow1();
			myAccountPage.clickLogoutIcon();
			
	}
	@Test(priority=1)
	public void testRINcashMobileEdit_WithBlankPinNo(){
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
			myAccountPage.clickRINcashWalletButton();
			
			RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
			Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
			rincashPage.clickEditDetailsButton();
			
			EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
			editWalletPage.clickEditMobileNoTab();
			editWalletPage.enterNewMobileNo();
			editWalletPage.clickProceedButton();
			Assert.assertTrue(editWalletPage.verifyMobileNoValidation("please enter pin"), "Expected validation message doesn't appears");		
			rincashPage.switchParentWindow1();
			myAccountPage.clickLogoutIcon();
	}
	@Test(priority=2)
	public void testRINcashMobileEdit_WithCurrentMobileNo(){
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
			myAccountPage.clickRINcashWalletButton();
			
			RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
			Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
			rincashPage.clickEditDetailsButton();
			
			EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
			editWalletPage.clickEditMobileNoTab();
			editWalletPage.enterDuplicateMobileNo();
			editWalletPage.enterPinNumber(config.getProperty("RIN_Pin"));
			editWalletPage.clickProceedButton();
			Assert.assertTrue(editWalletPage.verifyMobileNoValidation("current mobile no. and new mobile no. can not be same"), "Expected validation message doesn't appears");		
			rincashPage.switchParentWindow1();
			myAccountPage.clickLogoutIcon();
	}
	@Test(priority=3)
	public void testRINcashMobileEdit_WithExistingMobileNo(){
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
			myAccountPage.clickRINcashWalletButton();
			
			RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
			Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
			rincashPage.clickEditDetailsButton();
			
			EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
			editWalletPage.clickEditMobileNoTab();
			editWalletPage.enterMobileNo("7982269123");
			editWalletPage.enterPinNumber(config.getProperty("RIN_Pin"));
			editWalletPage.clickProceedButton();
			Assert.assertTrue(editWalletPage.verifyEditMobileValidation("wallet is already activated on this mobile no. please try with another number"), "Expected validation message doesn't appears");		
			rincashPage.switchParentWindow1();
			myAccountPage.clickLogoutIcon();
	}
	@Test(priority=4)
	public void testRINcashMobileEdit_WithInvalidPin(){
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
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditMobileNoTab();
		editWalletPage.enterNewMobileNo();
		editWalletPage.enterPinNumber("1111");
		editWalletPage.clickProceedButton();
		Assert.assertTrue(editWalletPage.verifyEditMobileValidation("pin does not match. please retry"), "Expected validation message doesn't appears");		
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=5)
	public void testRINcashMobileEdit_WithLessThan10DigitMobNo(){
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
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditMobileNoTab();
		editWalletPage.enterMobileNo("9015");
		editWalletPage.enterPinNumber(config.getProperty("RIN_Pin"));
		editWalletPage.clickProceedButton();
		Assert.assertTrue(editWalletPage.verifyMobileNoValidation("new mobile no. should be 10 digit"), "Expected validation message doesn't appears");		
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}
	@Test(priority=6)
	public void testRINCashMobileEdit_WithValidInputs(){
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
		myAccountPage.clickRINcashWalletButton();
		
		RINcashTransactionPageWap rincashPage = new RINcashTransactionPageWap(driver);
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.clickEditDetailsButton();
		
		EditWalletDetailsPageWap editWalletPage = new EditWalletDetailsPageWap(driver);
		editWalletPage.clickEditMobileNoTab();
		editWalletPage.enterNewMobileNo();
		editWalletPage.enterPinNumber(config.getProperty("RIN_Pin"));
		editWalletPage.clickProceedButton();
		Assert.assertTrue(rincashPage.isRINcashWalletPageOpened(), "RINcash page is not opened");
		rincashPage.switchParentWindow1();
		myAccountPage.clickLogoutIcon();
	}

}
